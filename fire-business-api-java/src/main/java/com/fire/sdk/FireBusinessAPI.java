package com.fire.sdk;

import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpConfiguration;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Credentials;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.Response;

public class FireBusinessAPI {

	/**
	 * Logger 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FireBusinessAPI.class);

	/**
	 * Credentials for the user
	 */
	private String accessToken;
	
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

	/**
	 * <p>
	 * Sends the request to Fire. Actions:
	 * 
	 * <ol>
	 * <li>Generates any defaults on the request e.g. hash, time stamp order ID.</li>
	 * <li>Marshals request to XML.</li>
	 * <li>Sends request to Realex.</li>
	 * <li>Unmarshals response.</li>
	 * <li>Checks result code (If response is an error then throws {@link RealexServerException}).</li>
	 * <li>Validates response hash (If invalid throws {@link RealexException}).</li>
	 * </ol>
	 * </p>
	 * 
	 * @param request
	 * @return Response
	 */
	public <T, U extends Response<U>> U send(Request<T, U> request) {

		LOGGER.info("Sending JSON request to Realex.");
		//send request to Fire.
		U response = HttpUtils.sendMessage(request, httpClient, httpConfiguration);

		return response;
	}

}
