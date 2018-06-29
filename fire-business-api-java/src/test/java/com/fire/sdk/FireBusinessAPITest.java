package com.fire.sdk;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpConfiguration;
import com.fire.sdk.model.Batch;
import com.fire.sdk.model.Credentials;
import com.fire.sdk.model.InternalTransfer;
import com.fire.sdk.model.request.ActivitiesListRequest;
import com.fire.sdk.model.request.BatchAddItemRequest;
import com.fire.sdk.model.request.BatchListItemsRequest;
import com.fire.sdk.model.request.BatchListRequest;
import com.fire.sdk.model.request.BatchSubmitRequest;
import com.fire.sdk.model.response.ActivitiesListResponse;
import com.fire.sdk.model.response.BatchAddItemResponse;
import com.fire.sdk.model.response.BatchListItemsResponse;
import com.fire.sdk.model.response.BatchListResponse;

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
		
		HttpConfiguration config = new HttpConfiguration();
		config.setEndpoint("https://api-preprod.fire.com/business/v1");
		
		FireBusinessAPI api = new FireBusinessAPI(config).initialise(credentials);
		
		ActivitiesListResponse activities = api.send(new ActivitiesListRequest());
        logger.info("activities 0 = {}", activities.getActivities().get(0).getDescription());
        
		BatchListResponse batches = api.send(new BatchListRequest());
		logger.info("Batch 0 = {}", batches.getBatches().get(0).getBatchName());
		

//		BatchNewRequest newBatchRequest = new BatchNewRequest();
//		newBatchRequest.setBatch(new Batch()
//		    .setType(Batch.BatchType.INTERNAL_TRANSFERS)
//		    .setCurrency("EUR")
//		    .setBatchName("Java SDK test")
//		    .setJobNumber("3")
//		    .setCallbackUrl("https://2i7yqo19qv39.runscope.net"));
//		
//		BatchNewResponse newBatch = api.send(newBatchRequest);
//		logger.info("New batch ID = {}", newBatch.getBatchUuid());

		String batchUuid = "baa17a3f-a440-41c4-bd7b-dbb88709380f";
		
//		InternalTransfer internalTransfer = new InternalTransfer();
//		internalTransfer.setAmount(1000L);
//		internalTransfer.setIcanFrom(1472L);
//		internalTransfer.setIcanTo(1555L);
//		internalTransfer.setRef("Testing Java SDK");
//		
//		BatchAddItemResponse newItem = api.send(new BatchAddItemRequest().setBatchUuid(batchUuid).setBatchItem(internalTransfer));
//		logger.info("New batch item ID = {}", newItem.getBatchItemUuid());
//	
		BatchListItemsResponse items = api.send(new BatchListItemsRequest().setBatchUuid(batchUuid).setBatchType(Batch.BatchType.INTERNAL_TRANSFERS));
		
		api.send(new BatchSubmitRequest().setBatchUuid(batchUuid));
		
        
/*		
		
		ActivitiesListResponse activitiesList = api.send(new ActivitiesListRequest());
		logger.info("Activity 0 = {}", activitiesList.getActivities().get(0).getDescription());
		
		AccountListResponse accountList = api.send(new AccountListRequest());
		Long accountId = accountList.getAccounts().get(0).getIcan();
//		AccountResponse account = api.send(new AccountRequest().setAccountId(accountId));
//		
//        logger.info("Account details: {}, {} / {}", account.getName(), account.getCbic(), account.getCiban());
//		
		AccountTransactionListResponse transactions = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			transactions = api.send(new AccountTransactionListRequest()
					.setAccountId(accountId)
					.setDateRangeFrom(df.parse("2017-05-01"))
					.setDateRangeTo(df.parse("2017-06-01"))
					);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        logger.info("Transaction 0 details: {}", transactions.getTransactions().get(0).getType());
        
//        TransactionResponse transaction = api.send(new TransactionRequest().setTransactionId(203162l));
        
	*/	
	}
}
