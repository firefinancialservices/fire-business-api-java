package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.FireException;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AccountResponse;

public class AccountRequest implements Request<AccountRequest, AccountResponse> {
	private static final Logger logger = LoggerFactory.getLogger(AccountRequest.class);

	public Long accountId;
	

    @Override
	public String getEndpoint() {
	    if (getAccountId() == null) {
	        throw new FireException("You must setAccountId() first!");
	    }
		return "accounts/" + getAccountId();
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<AccountResponse> getResponseClass() {
		return AccountResponse.class;
	}

    public Long getAccountId() {
        return accountId;
    }

    public AccountRequest setAccountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
