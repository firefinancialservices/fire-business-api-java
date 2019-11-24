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

import java.time.DateTimeException;
import java.time.OffsetDateTime;
import java.util.Date;

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
 * <h2>Accounts</h2>
 * List your accounts:
 * <pre>
 * {@code
 * AccountListResponse accountList = api.send(new AccountListRequest());
 * 
 * Long accountId = accountList.getAccounts().get(0).getIcan();
 * AccountResponse account = api.send(new AccountRequest().setAccountId(accountId));
 *  
 * logger.info("Account details: {}, {} / {}", account.getName(), account.getCbic(), account.getCiban());
 * }
 * </pre>
 * <h2>Transactions</h2>
 * You can list all the transactions for an account:
 * <pre>
 * {@code
 * AccountTransactionListResponse transactions = api.send(
 *  new AccountTransactionListRequest()
 *          .setAccountId(2150l)
 *  );
 *  
 * logger.info("Transaction 0 details: {}", transactions.getTransactions().get(0).getType());   
 * }
 * </pre>
 * Or a single transaction by ID:
 * <pre>
 * {@code
 * TransactionResponse transaction = api.send(new TransactionRequest().setTransactionId(203162l));
 * }
 * </pre>
 * Or filter by date range, keyword or transaction type.
 * <pre>
 * {@code
 * AccountTransactionListResponse transactions = null;
 * DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
 * try {
 *  transactions = api.send(new AccountTransactionListRequest()
 *          .setAccountId(2150l)
 *          .setDateRangeFrom(df.parse("2017-05-01"))
 *          .setDateRangeTo(df.parse("2017-06-01"))
 *          );
 * } catch (ParseException e) {
 *  e.printStackTrace();
 * }
 * logger.info("Transaction 0 details: {}", transactions.getTransactions().get(0).getType());
 * }
 * </pre>
 * <h2>Batches of Payments</h2>
 * List of your batches:
 * <pre>
 * {@code
 * // All batches:
 * BatchListResponse batches = api.send(new BatchListRequest());
 * 
 * // Just the pending batches:
 * BatchListResponse batches = api.send(    new BatchListRequest()
 *      .setBatchStatuses(new BatchStatus[] { BatchStatus.PENDING_APPROVAL, BatchStatus.PENDING_PARENT_BATCH_APPROVAL })
 *  );
 * 
 * logger.info("Batch 0 = {}", batches.getBatches().get(0).getBatchName());
 * }
 * </pre>
 * Create a new batch, add an internal transfer and submit the batch:
 * <pre>
 * {@code
 * // Create the Batch Object
 * Batch internalTransferBatch = new Batch()
 *  .setType(Batch.BatchType.INTERNAL_TRANSFER)
 *  .setCurrency("EUR")
 *  .setBatchName("Java SDK test")
 *  .setJobNumber("2019-01-09")
 *  .setCallbackUrl("https://www.example.com/batch/callback");
 *     
 * // Open this batch in fire.com
 * BatchNewRequest newBatchRequest = new BatchNewRequest().setBatch(internalTransferBatch);
 * BatchNewResponse newBatch = api.send(newBatchRequest);
 * 
 * logger.info("New batch ID = {}", newBatch.getBatchUuid());
 * 
 * // Get the batchUUID
 * String batchUuid = newBatch.getBatchUuid();
 *                    
 * // Create the internal transfer objects  
 * InternalTransfer internalTransfer = new InternalTransfer()
 *  .setAmount(500L)
 *  .setIcanFrom(5532L)
 *  .setIcanTo(2150L)
 *  .setRef("Testing Java SDK");
 *      
 * // Add them to the batch
 * BatchAddItemResponse newItem = api.send(new BatchAddItemRequest()
 *      .setBatchUuid(batchUuid)
 *      .setBatchItem(internalTransfer)
 *  );
 * 
 * // List the items in the batch if required
 * BatchListItemsResponse items = api.send(new BatchListItemsRequest()
 *      .setBatchUuid(batchUuid)
 *      .setBatchType(Batch.BatchType.INTERNAL_TRANSFER)
 *  );
 * logger.info("Batch Items: {}", items.getBatchItems());
 * 
 * // Submit the batch for processing. Internal Transfer are processed immediately.         
 * api.send(new BatchSubmitRequest().setBatchUuid(batchUuid));
 * }
 * </pre>
 * Create a new batch, add external transfers of various types and submit the batch:
 * <pre>
 * {@code
 * // Create the Batch Object
 * Batch internalTransferBatch = new Batch()
 *  .setType(Batch.BatchType.BANK_TRANSFER)
 *  .setCurrency("EUR")
 *  .setBatchName("Java SDK test")
 *  .setJobNumber("2019-01-09")
 *  .setCallbackUrl("https://www.example.com/batch/callback");
 *     
 * // Open this batch in fire.com
 * BatchNewRequest newBatchRequest = new BatchNewRequest().setBatch(internalTransferBatch);
 * BatchNewResponse newBatch = api.send(newBatchRequest);
 * 
 * logger.info("New batch ID = {}", newBatch.getBatchUuid());
 * 
 * // Get the batchUUID
 * String batchUuid = newBatch.getBatchUuid();
 *                    
 * // Create the bank transfer objects (Using account details)
 * BankTransfer bankTransfer = new BankTransfer()
 *  .setAmount(1000L)
 *  .setPayeeType(PayeeType.ACCOUNT_DETAILS)
 *  .setDestAccountHolderName("John Q. Doe")
 *  // GBP Account number and sort code
 *  .setDestAccountNumber("12345678")
 *  .setDestNsc("999999")
 *  // EUR IBAN
 *  .setDestIban("IE99BANK99999999999999")
 *  .setIcanFrom(2150L)
 *  .setMyRef("testing API")
 *  .setYourRef("From API");
 * 
 * // Create the bank transfer objects (Using saved payee details)
 * BankTransfer bankTransfer = new BankTransfer()
 *  .setAmount(1000L)
 *  .setPayeeType(PayeeType.PAYEE_ID)
 *  .setPayeeId(1231234L)
 *  .setIcanFrom(2150L)
 *  .setMyRef("testing API")
 *  .setYourRef("From API");
 *          
 * // Add them to the batch
 * BatchAddItemResponse newItem = api.send(new BatchAddItemRequest()
 *      .setBatchUuid(batchUuid)
 *      .setBatchItem(bankTransfer)
 *  );
 * 
 * // List the items in the batch if required
 * BatchListItemsResponse items = api.send(new BatchListItemsRequest()
 *      .setBatchUuid(batchUuid)
 *      .setBatchType(Batch.BatchType.BANK_TRANSFER)
 *  );
 * logger.info("Batch Items: {}", items.getBatchItems());
 * 
 * // Submit the batch for processing. Bank Transfers require approval before they are processed.         
 * api.send(new BatchSubmitRequest().setBatchUuid(batchUuid));
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
    private Date mAccessTokenExpiry;

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
	    this.mAccessTokenExpiry = accessTokenResponse.getExpiry();

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

	    if (mAccessTokenExpiry != null && new Date().after(mAccessTokenExpiry)) {
	    	initialise(this.mCredentials);
		}
	    
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
