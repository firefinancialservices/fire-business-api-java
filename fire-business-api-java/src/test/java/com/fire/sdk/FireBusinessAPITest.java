package com.fire.sdk;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.model.Credentials;
import com.fire.sdk.model.request.AccountListRequest;
import com.fire.sdk.model.request.AccountRequest;
import com.fire.sdk.model.request.AccountTransactionListRequest;
import com.fire.sdk.model.response.AccountListResponse;
import com.fire.sdk.model.response.AccountResponse;
import com.fire.sdk.model.response.AccountTransactionListResponse;

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
		FireBusinessAPI api = new FireBusinessAPI().initialise(credentials);  
		
		AccountListResponse accountList = api.send(new AccountListRequest());
		Long accountId = accountList.getAccounts().get(0).getIcan();
		AccountResponse account = api.send(new AccountRequest().setAccountId(accountId));
		
        logger.info("Account details: {}, {} / {}", account.getName(), account.getCbic(), account.getCiban());
		
        AccountTransactionListResponse transactions = api.send(new AccountTransactionListRequest().setAccountId(accountId).setOffset(4).setLimit(2));
        logger.info("Transaction 0 details: {}", transactions.getTransactions().get(0).getType());
        
		
	}
}
