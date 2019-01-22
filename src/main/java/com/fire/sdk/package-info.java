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
 */

package com.fire.sdk;