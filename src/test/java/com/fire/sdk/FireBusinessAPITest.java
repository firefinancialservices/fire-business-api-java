package com.fire.sdk;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Properties;

import com.fire.sdk.model.InternalTransfer;
import com.fire.sdk.model.OrderDetails;
import com.fire.sdk.model.PaymentRequest;
import com.fire.sdk.model.PaymentRequestPayment;
import com.fire.sdk.model.request.PaymentRequestListRequest;
import com.fire.sdk.model.request.PaymentRequestNewRequest;
import com.fire.sdk.model.request.PaymentRequestPaymentNewRequest;
import com.fire.sdk.model.response.PaymentRequestListResponse;
import com.fire.sdk.model.response.PaymentRequestNewResponse;
import com.fire.sdk.model.response.PaymentRequestPaymentNewResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpConfiguration;
import com.fire.sdk.model.BankTransfer;
import com.fire.sdk.model.BankTransfer.PayeeType;
import com.fire.sdk.model.Batch;
import com.fire.sdk.model.Credentials;
import com.fire.sdk.model.request.AccountTransactionListRequest;
import com.fire.sdk.model.request.AccountTransactionListRequest.TransactionTypes;
import com.fire.sdk.model.request.BatchAddItemRequest;
import com.fire.sdk.model.request.BatchNewRequest;
import com.fire.sdk.model.request.BatchSubmitRequest;
import com.fire.sdk.model.response.AccountTransactionListResponse;
import com.fire.sdk.model.response.BatchAddItemResponse;
import com.fire.sdk.model.response.BatchNewResponse;

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

//		api.send(new AccountRequest().setAccountId(2150l));
//		api.send(new AccountActionsRequest().setAccountId(5532l).setAlias("Second Account"));
		
		//CardListResponse cardList = api.send(new CardListRequest());
		//api.send(new CardActionsRequest().setCardId(2645l).unblock());
		
//		PayeeListResponse payeeList = api.send(new PayeeListRequest());
//
// 		PaymentRequestListResponse paymentRequestListResponse = api.send(new PaymentRequestListRequest());

//		PaymentRequest paymentRequest = new PaymentRequest()
//				.setIcanTo(1520l) // 1519 - EUR, 1520 - GBP
//				.setAmount(10l)
//				.setCurrency("GBP")
//				.setType("PARTY_TO_PARTY")
//				.setDescription("Testing the API")
//				.setMyRef("Test")
//				.setMaxNumberCustomerPayments(1)
//				.setMaxNumberPayments(1)
//				.setReturnUrl("https://forgerock.foursevensix.com/shelterapi/callback")
//				.setOrderDetails(new OrderDetails()
//					.setOrderId("orderid123")
//				)
//				;
//		PaymentRequestNewResponse paymentRequestNewResponse = api.send(new PaymentRequestNewRequest().setPaymentRequest(paymentRequest));
//


		HashMap<String, String> aspsps = new HashMap<>();
		aspsps.put("Allied Irish Bank (GB) - Personal","ff8ab34b-9646-497c-8932-82e93765146d");
		aspsps.put("Allied Irish Bank (GB) - Business","86f6979f-d4cb-4df8-b609-f7db3a65a203");
		aspsps.put("Bank of Scotland - Personal","48410f57-28f5-4038-9f3b-ce61b7a59fed");
		aspsps.put("Bank of Scotland - Business","48410f57-28f5-4038-9f3b-ce61b7a59fee");
		aspsps.put("Barclays - Personal","105cbaf1-8a49-4c99-8205-928ea4014d9f");
		aspsps.put("Barclays - Corporate","105cbaf1-8a49-4c99-8205-928ea4014d9d");
		aspsps.put("Barclays - PingIt","105cbaf1-8a49-4c99-8205-928ea4014d9e");
		aspsps.put("First Direct","c6cd209c-a123-47ec-b80d-4f2407375870");
		aspsps.put("First Trust - Corporate","f27d106b-eefd-4a6a-9de7-98f10200abf1");
		aspsps.put("First Trust - Personal","822fdba9-4732-423b-9cb7-9f56a7648c32");
		aspsps.put("Halifax","1c1c2a05-35b1-4cad-bd68-e0f17346c03a");
		aspsps.put("HSBC - Personal","7fdf76d0-c1a2-4e6a-9fe1-a1240feff318");
		aspsps.put("HSBC - Business","7fdf76d0-c1a2-4e6a-9fe1-a1240feff317");
		aspsps.put("Lloyds Bank - Personal","fc18e51a-e517-4b97-a188-b230359c53bf");
		aspsps.put("Lloyds Bank - Business","fc18e51a-e517-4b97-a188-b230359c53be");
		aspsps.put("M&S Bank","6445b420-0e7d-4b16-9a1f-aa70e5454a1a");
		aspsps.put("Natwest - Personal","1731af71-1f87-466d-82ea-d974a92d2004");
		aspsps.put("Natwest - Business","1731af71-1f87-466d-82ea-d974a92d2002");
		aspsps.put("Nationwide Building Society","7774e08f-a363-42a7-b588-8656fb7b31b2");
		aspsps.put("Royal Bank of Scotland - Personal","1340a173-ac14-41ed-935a-e6e4fbb2daa0");
		aspsps.put("Royal Bank of Scotland - Business","1340a173-ac14-41ed-935a-e6e4fbb2daa9");
		aspsps.put("Santander","eed326d3-546e-4ce8-aa1c-142c1cd69e1e");
		aspsps.put("Ulster Bank (NI) - Personal","ff5ad722-360f-4a32-833b-bea6c3578a95");
		aspsps.put("Ulster Bank (NI) - Business","ff5ad722-360f-4a32-833b-bea6c3578a94");
		aspsps.put("Revolut","36888efe-9e2b-453e-a46f-97c9a17a6953");
		aspsps.put("Monzo","f6ffa766-2903-4867-a4ed-8a863fa59759");
		aspsps.put("Mettle","0137c4c4-208c-4c0f-a7d1-aa45f1557431");
		aspsps.put("Allied Irish Bank - Personal","ff8ab34b-9646-497c-8932-82e937651460");
		aspsps.put("Ulster Bank (Ireland) - Personal","92431fe7-88af-494a-9bfb-2ec9d6336dd5");
		aspsps.put("Ulster Bank (Ireland) - Business","92431fe7-88af-494a-9bfb-2ec9d6336dd4");
		aspsps.put("Permanent TSB","ff8ab34b-9646-497c-8932-82e937651450");


		PaymentRequestPaymentNewResponse paymentRequestPaymentNewResponse = api.send(new PaymentRequestPaymentNewRequest()
				.setPaymentRequestCode("hnejan93") // hnejan93 - EUR // wppkqwhc - GBP
				.setPaymentRequestPayment(new PaymentRequestPayment().setAspspUuid("1731af71-1f87-466d-82ea-d974a92d2004"))
		);

		
//		AccountTransactionListResponse transactions = null;
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            transactions = api.send(new AccountTransactionListRequest().setAccountId(2150l)
//                            .setDateRangeFrom(df.parse("2019-01-01")).setDateRangeTo(df.parse("2019-07-31"))
//                            .setTransactionTypes(new AccountTransactionListRequest.TransactionTypes[] { TransactionTypes.CARD_ECOMMERCE_DEBIT } ));
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
//		    .setType(Batch.BatchType.BANK_TRANSFER)
//		    .setCurrency("EUR")
//		    .setBatchName("SDK test")
//		    .setJobNumber("2019-09-12")
//		);
//
//		BatchNewResponse newBatch = api.send(newBatchRequest);
//		logger.info("New batch ID = {}", newBatch.getBatchUuid());
//
//		String batchUuid = newBatch.getBatchUuid();
//
//		BankTransfer bankTransfer = new BankTransfer()
//        	.setAmount(100L)
//        	.setPayeeType(PayeeType.ACCOUNT_DETAILS)
//        	.setDestAccountHolderName("Owen O Byrne")
//        	.setDestIban("IE41AIBK93338461237358")
//        	.setIcanFrom(2150L)
//        	.setMyRef("2APR36258724_Better Careers Lim_Auxilion Ireland Li")
//        	.setYourRef("From API");

				                
//		InternalTransfer internalTransfer = new InternalTransfer()
//    		.setAmount(100L)
//    		.setIcanFrom(2150L)
//    		.setIcanTo(5532L)
//    		.setRef("Testing Java SDK");
		
//		BatchAddItemResponse newItem = api.send(new BatchAddItemRequest().setBatchUuid(batchUuid).setBatchItem(bankTransfer));
//		BatchAddItemResponse newItem = api.send(new BatchAddItemRequest().setBatchUuid(batchUuid).setBatchItem(internalTransfer));
//		logger.info("New batch item ID = {}", newItem.getBatchItemUuid());
	
//		BatchListItemsResponse items = api.send(new BatchListItemsRequest().setBatchUuid(batchUuid).setBatchType(Batch.BatchType.INTERNAL_TRANSFER));
//		BatchListItemsResponse items = api.send(new BatchListItemsRequest().setBatchUuid(batchUuid).setBatchType(Batch.BatchType.BANK_TRANSFER));
        
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
