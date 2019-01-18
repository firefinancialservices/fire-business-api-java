package com.fire.sdk;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpConfiguration;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Credentials;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.Response;
import com.fire.sdk.model.request.AccessTokenRequest;
import com.fire.sdk.model.response.AccessTokenResponse;

public class FireBusinessAPI {
    private static final Logger logger = LoggerFactory.getLogger(FireBusinessAPI.class);
    private String mAccessToken;
    private Credentials mCredentials;

	/**
	 * Logger 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FireBusinessAPI.class);

	/**
	 * HttpClient instance.
	 */
	private HttpClient httpClient;

	/**
	 * HttpConfiguration instance.
	 */
	private HttpConfiguration httpConfiguration;

	/**
	 * Fire client constructor. Will use default HTTP configuration. 
	 */
	public FireBusinessAPI() {
		this.httpConfiguration = new HttpConfiguration();
		this.httpClient = HttpUtils.getDefaultClient(httpConfiguration);
	}

	/**
	 * Fire client constructor. A HttpConfiguration instance can be passed to this 
	 * constructor if a custom implementation is required. 
	 * 
	 * @param httpConfiguration
	 */
	public FireBusinessAPI(HttpConfiguration httpConfiguration) {
		this.httpConfiguration = httpConfiguration;
		this.httpClient = HttpUtils.getDefaultClient(httpConfiguration);
	}

	/**
	 * Fire client constructor. HttpClient and HttpConfiguration instances can be passed to this 
	 * constructor if a custom implementation is required. 
	 * 
	 * @param httpClient	
	 * @param httpConfiguration
	 */
	public FireBusinessAPI	(HttpClient httpClient, HttpConfiguration httpConfiguration) {
		this.httpConfiguration = httpConfiguration;
		this.httpClient = httpClient;
	}


	public HttpClient getHttpClient() {
		return httpClient;
	}

	public FireBusinessAPI setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
		return this;
	}

	public HttpConfiguration getHttpConfiguration() {
		return httpConfiguration;
	}

	public FireBusinessAPI setHttpConfiguration(HttpConfiguration httpConfiguration) {
		this.httpConfiguration = httpConfiguration;
		return this;
	}

	public FireBusinessAPI initialise(Credentials credentials) {
	    this.mCredentials = credentials;
	    
	    AccessTokenRequest accessToken = new AccessTokenRequest().intialise(mCredentials);    
	    AccessTokenResponse accessTokenResponse = this.send(accessToken);
	    this.mAccessToken = accessTokenResponse.getAccessToken();
	    
	    return this;
	    
	}
	
	/**
	 * <p>
	 * Sends the request to Fire. 
	 *  
	 * @param request
	 * @return Response
	 */
	public <T, U extends Response<U>> U send(Request<T, U> request) {
	    U response = null;

		
		if (request.getMethod() == HttpUtils.HttpMethod.POST) {
		    response = HttpUtils.sendPostMessage(request, this.mAccessToken, httpClient, httpConfiguration);
		} else if (request.getMethod() == HttpUtils.HttpMethod.PUT) {
            response = HttpUtils.sendPutMessage(request, this.mAccessToken, httpClient, httpConfiguration);
		} else if (request.getMethod() == HttpUtils.HttpMethod.GET) {
            response = HttpUtils.sendGetMessage(request, this.mAccessToken, httpClient, httpConfiguration);
        } 
		
		return response;
	}
	

}
