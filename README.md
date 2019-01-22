# fire-business-api-java
A Java SDK for the Fire Business API

![Release Artifacts][Badge-Sonatype]

## Include in your Project
### Maven

```
<dependency>
	<groupId>com.fire</groupId>
	<artifactId>fire-business-api-java</artifactId>
	<version>0.1</version>
</dependency>
```

### Gradle

```
compile "com.fire:fire-business-api-java:0.1"
```

## Usage
Configure the API client with your API Token credentials. 

```java

Credentials credentials = new Credentials()
				.setClientId("<clientId>")
				.setClientKey("<clientKey>")
				.setRefreshToken("<refreshToken>");

FireBusinessAPI api = new FireBusinessAPI().initialise(credentials);
```

Optionally, you can configure the API to use a different endpoint:

```java
HttpConfiguration config = new HttpConfiguration();
config.setEndpoint("https://api-preprod.fire.com/business/v1");
		
FireBusinessAPI api = new FireBusinessAPI(config).initialise(credentials);
```

## Accounts
List your accounts:

```java
AccountListResponse accountList = api.send(new AccountListRequest());

Long accountId = accountList.getAccounts().get(0).getIcan();
AccountResponse account = api.send(new AccountRequest().setAccountId(accountId));
	
logger.info("Account details: {}, {} / {}", account.getName(), account.getCbic(), account.getCiban());
```

## Transactions
You can list all the transactions for an account: 

```java
	
AccountTransactionListResponse transactions = api.send(
	new AccountTransactionListRequest()
			.setAccountId(2150l)
	);
	
logger.info("Transaction 0 details: {}", transactions.getTransactions().get(0).getType());   
```

Or a single transaction by ID: 

```java
TransactionResponse transaction = api.send(new TransactionRequest().setTransactionId(203162l));
```

Or filter by date range, keyword or transaction type. 

```java
AccountTransactionListResponse transactions = null;
DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
try {
	transactions = api.send(new AccountTransactionListRequest()
			.setAccountId(2150l)
			.setDateRangeFrom(df.parse("2017-05-01"))
			.setDateRangeTo(df.parse("2017-06-01"))
			);
} catch (ParseException e) {
	e.printStackTrace();
}
logger.info("Transaction 0 details: {}", transactions.getTransactions().get(0).getType());
```

## Batches of Payments
List of your batches:

```java
// All batches:
BatchListResponse batches = api.send(new BatchListRequest());

// Just the pending batches:
BatchListResponse batches = api.send(	new BatchListRequest()
		.setBatchStatuses(new BatchStatus[] { BatchStatus.PENDING_APPROVAL, BatchStatus.PENDING_PARENT_BATCH_APPROVAL })
	);

logger.info("Batch 0 = {}", batches.getBatches().get(0).getBatchName());
```

Create a new batch, add an internal transfer and submit the batch:
 
```java
// Create the Batch Object
Batch internalTransferBatch = new Batch()
	.setType(Batch.BatchType.INTERNAL_TRANSFER)
	.setCurrency("EUR")
	.setBatchName("Java SDK test")
	.setJobNumber("2019-01-09")
	.setCallbackUrl("https://www.example.com/batch/callback");
    
// Open this batch in fire.com
BatchNewRequest newBatchRequest = new BatchNewRequest().setBatch(internalTransferBatch);
BatchNewResponse newBatch = api.send(newBatchRequest);

logger.info("New batch ID = {}", newBatch.getBatchUuid());

// Get the batchUUID
String batchUuid = newBatch.getBatchUuid();
		              
// Create the internal transfer objects  
InternalTransfer internalTransfer = new InternalTransfer()
	.setAmount(500L)
	.setIcanFrom(5532L)
	.setIcanTo(2150L)
	.setRef("Testing Java SDK");
		
// Add them to the batch
BatchAddItemResponse newItem = api.send(new BatchAddItemRequest()
		.setBatchUuid(batchUuid)
		.setBatchItem(internalTransfer)
	);

// List the items in the batch if required
BatchListItemsResponse items = api.send(new BatchListItemsRequest()
		.setBatchUuid(batchUuid)
		.setBatchType(Batch.BatchType.INTERNAL_TRANSFER)
	);
logger.info("Batch Items: {}", items.getBatchItems());

// Submit the batch for processing. Internal Transfer are processed immediately.         
api.send(new BatchSubmitRequest().setBatchUuid(batchUuid));
```
 
Create a new batch, add external transfers of various types and submit the batch:
 
```java
// Create the Batch Object
Batch internalTransferBatch = new Batch()
	.setType(Batch.BatchType.BANK_TRANSFER)
	.setCurrency("EUR")
	.setBatchName("Java SDK test")
	.setJobNumber("2019-01-09")
	.setCallbackUrl("https://www.example.com/batch/callback");
    
// Open this batch in fire.com
BatchNewRequest newBatchRequest = new BatchNewRequest().setBatch(internalTransferBatch);
BatchNewResponse newBatch = api.send(newBatchRequest);

logger.info("New batch ID = {}", newBatch.getBatchUuid());

// Get the batchUUID
String batchUuid = newBatch.getBatchUuid();
		              
// Create the bank transfer objects (Using account details)
BankTransfer bankTransfer = new BankTransfer()
	.setAmount(1000L)
	.setPayeeType(PayeeType.ACCOUNT_DETAILS)
	.setDestAccountHolderName("John Q. Doe")
	// GBP Account number and sort code
	.setDestAccountNumber("12345678")
	.setDestNsc("999999")
	// EUR IBAN
	.setDestIban("IE99BANK99999999999999")
	.setIcanFrom(2150L)
	.setMyRef("testing API")
	.setYourRef("From API");

// Create the bank transfer objects (Using saved payee details)
BankTransfer bankTransfer = new BankTransfer()
	.setAmount(1000L)
	.setPayeeType(PayeeType.PAYEE_ID)
	.setPayeeId(1231234L)
	.setIcanFrom(2150L)
	.setMyRef("testing API")
	.setYourRef("From API");
			
// Add them to the batch
BatchAddItemResponse newItem = api.send(new BatchAddItemRequest()
		.setBatchUuid(batchUuid)
		.setBatchItem(bankTransfer)
	);

// List the items in the batch if required
BatchListItemsResponse items = api.send(new BatchListItemsRequest()
		.setBatchUuid(batchUuid)
		.setBatchType(Batch.BatchType.BANK_TRANSFER)
	);
logger.info("Batch Items: {}", items.getBatchItems());

// Submit the batch for processing. Bank Transfers require approval before they are processed.         
api.send(new BatchSubmitRequest().setBatchUuid(batchUuid));
```
 
[Badge-Sonatype]: https://img.shields.io/nexus/r/https/oss.sonatype.org/com.fire/fire-business-api-java.svg "Sonatype Releases"

 