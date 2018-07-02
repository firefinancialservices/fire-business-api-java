package com.fire.sdk.http;

import java.io.Closeable;
import java.io.IOException;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.FireException;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.Response;
import com.google.gson.Gson;

/**
 * HTTP Utils class for dealing with HTTP and actual message sending.
 * 
 * @author owenobyrne
 */
public class HttpUtils {

    private final static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * Get a default HttpClient based on the HttpConfiguration object. If required the defaults can 
     * be altered to meet the requirements of the SDK user. The default client does not use connection 
     * pooling and does not reuse connections. Timeouts for connection and socket are taken from the 
     * {@link HttpConfiguration} object.
     * 
     * @param httpConfiguration
     * @return CloseableHttpClient
     */
    public static CloseableHttpClient getDefaultClient(HttpConfiguration httpConfiguration) {

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(httpConfiguration.getTimeout())
                .setSocketTimeout(httpConfiguration.getTimeout()).build();

        HttpClientConnectionManager connectionManager = new BasicHttpClientConnectionManager();
        ConnectionReuseStrategy connectionResuseStrategy = new NoConnectionReuseStrategy();

        logger.debug("Creating HttpClient with simple no pooling/no connection reuse default settings.");
        CloseableHttpClient httpClient = HttpClients.custom().setDefaultRequestConfig(requestConfig).setConnectionManager(connectionManager)
                .setConnectionReuseStrategy(connectionResuseStrategy).build();
        return httpClient;
    }

    /**
     * Perform the actual send of the message, according to the HttpConfiguration, and get the response. 
     * This will also check if only HTTPS is allowed, based on the {@link HttpConfiguration}, and will 
     * throw a {@link FireException} if HTTP is used when only HTTPS is allowed. A {@link FireException} 
     * is also thrown if the response from Fire is not success (ie. if it's not 200 status code). 
     * 
     * 
     * @param xml
     * @param httpClient
     * @param httpConfiguration
     * @return the xml response
     */
    public static <T, U extends Response<U>> U sendPostMessage(Request<T, U> request, String accessToken, HttpClient httpClient, HttpConfiguration httpConfiguration) {
        Gson gson = new Gson();
        HttpPost httpPost = new HttpPost(httpConfiguration.getEndpoint() + "/" + request.getEndpoint());
        httpPost.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        
        if (accessToken != null) {
            httpPost.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        }
        
        HttpResponse httpResponse = null;

        try {
            logger.info("Setting entity in POST message: {}", gson.toJson(request.getBody()));
            httpPost.setEntity(new StringEntity(gson.toJson(request.getBody())));

            logger.info("Executing HTTP Post message to: " + httpPost.getURI());
            httpResponse = httpClient.execute(httpPost);
            
            String jsonResponse = null;
            if (httpResponse.getEntity() != null) {
                jsonResponse = EntityUtils.toString(httpResponse.getEntity());
                logger.info("Converting HTTP entity (the json response) back into a string: {}", jsonResponse);
            }
            
            logger.info("Checking the HTTP response status code.");
            int statusCode = (httpResponse.getStatusLine().getStatusCode());
            if (statusCode != HttpStatus.SC_OK && statusCode != HttpStatus.SC_ACCEPTED && statusCode != HttpStatus.SC_CREATED) {
                throw new FireException("Unexpected http status code [" + statusCode + "]");
            }

            
            
            EntityUtils.consume(httpResponse.getEntity());
            return (U) gson.fromJson(jsonResponse, request.getResponseClass());
            
        } catch (IOException ioe) {
            // Also catches ClientProtocolException (from httpClient.execute()) and UnsupportedEncodingException (from response.getEntity()
            logger.error("Exception communicating with Fire.", ioe.getMessage());
            throw new FireException("Exception communicating with Fire.", ioe);
        } finally {
            // Test if response Closeable
            if (httpResponse instanceof Closeable) {
                try {
                    ((Closeable) httpResponse).close();
                } catch (IOException ioe) {
                    // Ignore
                }
            }
        }
    }
    
    /**
     * Perform the actual send of the message, according to the HttpConfiguration, and get the response. 
     * This will also check if only HTTPS is allowed, based on the {@link HttpConfiguration}, and will 
     * throw a {@link FireException} if HTTP is used when only HTTPS is allowed. A {@link FireException} 
     * is also thrown if the response from Fire is not success (ie. if it's not 200 status code). 
     * 
     * 
     * @param xml
     * @param httpClient
     * @param httpConfiguration
     * @return the xml response
     */
    public static <T, U extends Response<U>> U sendPutMessage(Request<T, U> request, String accessToken, HttpClient httpClient, HttpConfiguration httpConfiguration) {
        Gson gson = new Gson();
        HttpPut httpPut = new HttpPut(httpConfiguration.getEndpoint() + "/" + request.getEndpoint());
        httpPut.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        
        if (accessToken != null) {
            httpPut.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        }
        
        HttpResponse httpResponse = null;

        try {
            logger.info("Setting entity in POST message: {}", gson.toJson(request.getBody()));
            httpPut.setEntity(new StringEntity(gson.toJson(request.getBody())));

            logger.info("Executing HTTP Post message to: " + httpPut.getURI());
            httpResponse = httpClient.execute(httpPut);
            
            String jsonResponse = null;
            if (httpResponse.getEntity() != null) {
                jsonResponse = EntityUtils.toString(httpResponse.getEntity());
                logger.info("Converting HTTP entity (the json response) back into a string: {}", jsonResponse);
            }
            
            logger.info("Checking the HTTP response status code.");
            int statusCode = (httpResponse.getStatusLine().getStatusCode());
            if (statusCode != HttpStatus.SC_OK && statusCode != HttpStatus.SC_ACCEPTED && statusCode != HttpStatus.SC_NO_CONTENT && statusCode != HttpStatus.SC_CREATED) {
                throw new FireException("Unexpected http status code [" + statusCode + "]");
            }

            
            
            EntityUtils.consume(httpResponse.getEntity());
            return (U) gson.fromJson(jsonResponse, request.getResponseClass());
            
        } catch (IOException ioe) {
            // Also catches ClientProtocolException (from httpClient.execute()) and UnsupportedEncodingException (from response.getEntity()
            logger.error("Exception communicating with Fire.", ioe.getMessage());
            throw new FireException("Exception communicating with Fire.", ioe);
        } finally {
            // Test if response Closeable
            if (httpResponse instanceof Closeable) {
                try {
                    ((Closeable) httpResponse).close();
                } catch (IOException ioe) {
                    // Ignore
                }
            }
        }
    }
    
    public static <T, U extends Response<U>> U sendGetMessage(Request<T, U> request, String accessToken, HttpClient httpClient, HttpConfiguration httpConfiguration) {
        Gson gson = new Gson();
        HttpGet httpGet = new HttpGet(httpConfiguration.getEndpoint() + "/" + request.getEndpoint());
        httpGet.addHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        
        if (accessToken != null) {
            httpGet.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);
        }
        
        HttpResponse httpResponse = null;

        try {
           
            logger.debug("Executing HTTP Post message to: " + httpGet.getURI());
            httpResponse = httpClient.execute(httpGet);

            logger.debug("Checking the HTTP response status code.");
            int statusCode = (httpResponse.getStatusLine().getStatusCode());
            if (statusCode != HttpStatus.SC_OK && statusCode != HttpStatus.SC_ACCEPTED && statusCode != HttpStatus.SC_CREATED) {
                throw new FireException("Unexpected http status code [" + statusCode + "]");
            }

            String jsonResponse = EntityUtils.toString(httpResponse.getEntity());
            logger.info("Converting HTTP entity (the json response) back into a string: {}", jsonResponse);
            
            EntityUtils.consume(httpResponse.getEntity());
            return (U) gson.fromJson(jsonResponse, request.getResponseClass());
            
        } catch (IOException ioe) {
            // Also catches ClientProtocolException (from httpClient.execute()) and UnsupportedEncodingException (from response.getEntity()
            logger.error("Exception communicating with Fire.", ioe.getMessage());
            throw new FireException("Exception communicating with Fire.", ioe);
        } finally {
            // Test if response Closeable
            if (httpResponse instanceof Closeable) {
                try {
                    ((Closeable) httpResponse).close();
                } catch (IOException ioe) {
                    // Ignore
                }
            }
        }
    }
    
    public enum HttpMethod {
        POST,
        GET,
        DELETE,
        PUT
    }
}
