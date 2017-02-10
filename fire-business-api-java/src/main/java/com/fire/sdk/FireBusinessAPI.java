package com.fire.sdk;

public class FireBusinessAPI {

	/**
	 * Logger 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FireBusinessAPI.class);

	/**
	 * The shared secret issued by Realex. Used to create the SHA-1 hash in the request and
	 * to verify the validity of the XML response. 
	 */
	private String secret;

	/**
	 * HttpClient instance.
	 */
	private HttpClient httpClient;

	/**
	 * HttpConfiguration instance.
	 */
	private HttpConfiguration httpConfiguration;

	/**
	 * Realex client constructor. Will use default HTTP configuration. 
	 * 
	 * @param secret
	 */
	public FireBusinessAPI(String secret) {
		this.secret = secret;
		this.httpConfiguration = new HttpConfiguration();
		this.httpClient = HttpUtils.getDefaultClient(httpConfiguration);
	}

	/**
	 * Realex client constructor. A HttpConfiguration instance can be passed to this 
	 * constructor if a custom implementation is required. 
	 * 
	 * @param secret
	 * @param httpConfiguration
	 */
	public FireBusinessAPI(String secret, HttpConfiguration httpConfiguration) {
		this.secret = secret;
		this.httpConfiguration = httpConfiguration;
		this.httpClient = HttpUtils.getDefaultClient(httpConfiguration);
	}

	/**
	 * Realex client constructor. HttpClient and HttpConfiguration instances can be passed to this 
	 * constructor if a custom implementation is required. 
	 * 
	 * @param secret
	 * @param httpClient
	 * @param httpConfiguration
	 */
	public FireBusinessAPI	(String secret, HttpClient httpClient, HttpConfiguration httpConfiguration) {
		this.secret = secret;
		this.httpConfiguration = httpConfiguration;
		this.httpClient = httpClient;
	}

}
