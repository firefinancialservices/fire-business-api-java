package com.fire.sdk;

import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpConfiguration;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Credentials;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.Response;
import com.fire.sdk.model.request.AccessTokenRequest;
import com.fire.sdk.model.response.AccessTokenResponse;

/**
 * A Java SDK for the Fire Business API.
 * <p>
 * Configure the API client with your API Token credentials.
 * <pre>
 * {@code
 * Credentials credentials = new Credentials()
 *               .setClientId("<clientId>")
 *               .setClientKey("<clientKey>")
 *               .setRefreshToken("<refreshToken>");
 *
 * FireBusinessAPI api = new FireBusinessAPI().initialise(credentials);
 * }
 * </pre>
 * <p>
 * Optionally, you can configure the API to use a different endpoint:
 * <pre>
 * {@code
 * HttpConfiguration config = new HttpConfiguration();
 * config.setEndpoint("https://api-preprod.fire.com/business/v1");
 * FireBusinessAPI api = new FireBusinessAPI(config).initialise(credentials);
 * }
 * </pre>
 * 
 * @author Owen O Byrne
 *
 */

public class FireBusinessAPI {
    private static final Logger logger = LoggerFactory.getLogger(FireBusinessAPI.class);
    private String mAccessToken;
    private Credentials mCredentials;

	/**
	 * Logger 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FireBusinessAPI.class);

	/**
	 * {@link HttpClient} instance.
	 */
	private HttpClient httpClient;

	/**
	 * {@link HttpConfiguration} instance.
	 */
	private HttpConfiguration httpConfiguration;

	/**
	 * Default Fire client constructor. Will use default HTTP configuration. 
	 * 
	 */
	public FireBusinessAPI() {
		this.httpConfiguration = new HttpConfiguration();
		this.httpClient = HttpUtils.getDefaultClient(httpConfiguration);
	}

	/**
	 * Fire client constructor accepting configuration.
	 * A {@link HttpConfiguration} instance can be passed to this 
	 * constructor if a custom implementation is required. 
	 * 
	 * @param httpConfiguration A custom configuration for this API client. 
	 */
	public FireBusinessAPI(HttpConfiguration httpConfiguration) {
		this.httpConfiguration = httpConfiguration;
		this.httpClient = HttpUtils.getDefaultClient(httpConfiguration);
	}

	/**
	 * Fire client constructor accepting configuration and a custom {@link HttpClient}. 
	 * HttpClient and {@link HttpConfiguration} instances can be passed to this 
	 * constructor if a custom implementation is required. 
	 * 
	 * @param httpClient A customised HttpClient for this API client
	 * @param httpConfiguration A custom configuration for this API client.
	 */
	public FireBusinessAPI	(HttpClient httpClient, HttpConfiguration httpConfiguration) {
		this.httpConfiguration = httpConfiguration;
		this.httpClient = httpClient;
	}

	/** 
	 * Returns the {@link HttpClient} used by this API Client
	 * 
	 * @return the HttpClient used. 
	 */
	public HttpClient getHttpClient() {
		return httpClient;
	}

	/** 
	 * Sets a customised {@link HttpClient} after initialisation
	 *  
	 * @param httpClient A customised HttpClient for this API client
	 * @return the configured API client
	 */
	public FireBusinessAPI setHttpClient(HttpClient httpClient) {
		this.httpClient = httpClient;
		return this;
	}

	/** 
     * Returns the {@link HttpConfiguration} used by this API Client
     * 
     * @return the HttpConfiguration used. 
     */
	public HttpConfiguration getHttpConfiguration() {
		return httpConfiguration;
	}

	/** 
     * Sets a customised {@link HttpConfiguration} after initialisation
     *  
     * @param httpConfiguration A customised HttpConfiguration for this API client
     * @return the configured API client
     */
	public FireBusinessAPI setHttpConfiguration(HttpConfiguration httpConfiguration) {
		this.httpConfiguration = httpConfiguration;
		return this;
	}

	/**
	 * Initialise the API Client with Credentials. 
	 * This method performs the OAuth dance to retrieve an Access Token 
	 *
	 * @param credentials the API token credentials from fire.com
	 * @return the API client
	 */
	public FireBusinessAPI initialise(Credentials credentials) {
	    this.mCredentials = credentials;
	    
	    AccessTokenRequest accessToken = new AccessTokenRequest().intialise(mCredentials);    
	    AccessTokenResponse accessTokenResponse = this.send(accessToken);
	    this.mAccessToken = accessTokenResponse.getAccessToken();
	    
	    return this;
	    
	}
	
    /**
     * Sends a request to Fire. 
     *  
     * Used to send a {@link Request} to the Fire Business API, and receive a {@link Response}. 
     * <p>
     * For example:
     * <pre>
     * {@code
     * AccountListResponse accountList = api.send(new AccountListRequest());
     * }
     * </pre>
     * 
     * @param <T> the class of the request object
     * @param <U> the class of the response object
     * @param request an object containing the details of the request.  
     * @return an object containing the response. 
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
