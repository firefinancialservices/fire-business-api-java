# fire-business-api-java
A Java SDK for the Fire Business API

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
