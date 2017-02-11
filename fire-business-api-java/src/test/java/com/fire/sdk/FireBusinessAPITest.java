package com.fire.sdk;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.model.Credentials;
import com.fire.sdk.model.request.AccessTokenRequest;
import com.fire.sdk.model.response.AccessTokenResponse;

public class FireBusinessAPITest {

	private static final Logger logger = LoggerFactory.getLogger(FireBusinessAPITest.class);
	
	public static void main(String[] args) {
		new FireBusinessAPITest();
	}
	
	
	public FireBusinessAPITest() {
		
		Properties prop = new Properties();
		try {
			prop.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Credentials credentials = new Credentials()
				.setClientId(prop.getProperty("clientId"))
				.setClientKey(prop.getProperty("clientKey"))
				.setRefreshToken(prop.getProperty("refreshToken"));
				
		logger.debug("ClientId {}", prop.getProperty("clientId"));
		FireBusinessAPI api = new FireBusinessAPI();
		
		AccessTokenRequest accessToken = new AccessTokenRequest()
				.intialise(credentials);		

		AccessTokenResponse accessTokenResponse = api.send(accessToken);
		logger.debug("AccessToken is {}", accessTokenResponse.getAccessToken());
		
	}
}
