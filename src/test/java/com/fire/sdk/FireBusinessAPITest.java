package com.fire.sdk;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpConfiguration;
import com.fire.sdk.model.Credentials;
import com.fire.sdk.model.request.AccountActionsRequest;
import com.fire.sdk.model.request.CardActionsRequest;

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
		//config.setEndpoint("https://api-preprod.fire.com/business/v1");
		
		FireBusinessAPI api = new FireBusinessAPI(config).initialise(credentials);

		//api.send(new AccountRequest().setAccountId(2150l));
		api.send(new AccountActionsRequest().setAccountId(5532l).setAlias("Second Account"));
		
		//CardListResponse cardList = api.send(new CardListRequest());
		//api.send(new CardActionsRequest().setCardId(2645l).unblock());
		
//		PayeeListResponse payeeList = api.send(new PayeeListRequest());
		
//		AccountTransactionListResponse transactions = null;
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            transactions = api.send(new AccountTransactionListRequest().setAccountId(2150l)
//                            .setDateRangeFrom(df.parse("2019-01-01")).setDateRangeTo(df.parse("2019-05-31")));
//        } catch (ParseException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
		
//		api.send(new CardTransactionListRequest()
//	                  .setCardId(51l)
//	                  .setLimit(25)
//	                  .setOffset(0)
//	                  );
//	
//		UserListResponse users = api.send(new UserListRequest());
//		UserResponse user = api.send(new UserRequest().setUserId(3138l));
//		UserAddressResponse address = api.send(new UserAddressRequest().setUserId(3138l));
//		
//        // Activities
//        
//		ActivitiesListResponse activities = api.send(new ActivitiesListRequest());
//		
//		for (int i=0; i<10; i++) {
//		    logger.info("{}: {}", String.format("%-35s", activities.getActivities().get(i).getType()), activities.getActivities().get(i).getDescription());
//		}
//        
		
		
//		BatchListResponse batches = api.send(new BatchListRequest().setBatchStatuses(new BatchStatus[] { BatchStatus.PENDING_APPROVAL, BatchStatus.PENDING_PARENT_BATCH_APPROVAL }));
//		logger.info("Batch 0 = {}", batches.getBatches().get(0).getBatchName());


//		BatchNewRequest newBatchRequest = new BatchNewRequest();
//		newBatchRequest.setBatch(new Batch()
//		    .setType(Batch.BatchType.INTERNAL_TRANSFER)
//		    .setCurrency("EUR")
//		    .setBatchName("SDK FX test")
//		    .setJobNumber("2019-03-13")
//		    .setCallbackUrl("https://requestbin.foursevensix.com/18t9f6l1")
//		);
//		
//		BatchNewResponse newBatch = api.send(newBatchRequest);
//		logger.info("New batch ID = {}", newBatch.getBatchUuid());
//
//		String batchUuid = newBatch.getBatchUuid();
//		
//		BankTransfer bankTransfer = new BankTransfer()
//        	.setAmount(1000L)
//        	.setPayeeType(PayeeType.ACCOUNT_DETAILS)
//        	.setDestAccountHolderName("Owen O Byrne")
//        	.setDestIban("IE41AIBK93338461237358")
//        	.setIcanFrom(2150L)
//        	.setMyRef("testing API")
//        	.setYourRef("From API");
//
//				                
//		InternalTransfer internalTransfer = new InternalTransfer()
//    		.setAmount(100L)
//    		.setIcanFrom(2150L)
//    		.setIcanTo(5532L)
//    		.setRef("Testing Java SDK");
//		
//		BatchAddItemResponse newItem = api.send(new BatchAddItemRequest().setBatchUuid(batchUuid).setBatchItem(bankTransfer));
//		BatchAddItemResponse newItem = api.send(new BatchAddItemRequest().setBatchUuid(batchUuid).setBatchItem(internalTransfer));
//		logger.info("New batch item ID = {}", newItem.getBatchItemUuid());
//	
//		BatchListItemsResponse items = api.send(new BatchListItemsRequest().setBatchUuid(batchUuid).setBatchType(Batch.BatchType.INTERNAL_TRANSFER));
//		BatchListItemsResponse items = api.send(new BatchListItemsRequest().setBatchUuid(batchUuid).setBatchType(Batch.BatchType.BANK_TRANSFER));
//        
//		api.send(new BatchSubmitRequest().setBatchUuid(batchUuid));
		
    
//		MandateListResponse mandateList = api.send(new MandateListRequest());
//		String mandateUuid = mandateList.getMandates().get(0).getMandateUuid();
//		MandateResponse mandate = api.send(new MandateRequest().setMandateUuid(mandateUuid));
//		DirectDebitListResponse directdebits = api.send(new DirectDebitListRequest().setMandateUuid(mandateUuid));
//		
//			
//		ActivitiesListResponse activitiesList = api.send(new ActivitiesListRequest());
//		logger.info("Activity 0 = {}", activitiesList.getActivities().get(0).getDescription());
//		
//		AccountListResponse accountList = api.send(new AccountListRequest());
//		Long accountId = accountList.getAccounts().get(0).getIcan();
//		AccountResponse account = api.send(new AccountRequest().setAccountId(accountId));
//		
//        logger.info("Account details: {}, {} / {}", account.getName(), account.getCbic(), account.getCiban());
	
//		AccountTransactionListResponse transactions = null;
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			transactions = api.send(new AccountTransactionListRequest()
//					.setAccountId(2150l)
//					.setDateRangeFrom(df.parse("2017-05-01"))
//					.setDateRangeTo(df.parse("2017-06-01"))
//					);
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        logger.info("Transaction 0 details: {}", transactions.getTransactions().get(0).getType());
//        
//        TransactionResponse transaction = api.send(new TransactionRequest().setTransactionId(203162l));
//        

	}
}
