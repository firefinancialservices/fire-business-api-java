package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AccountListResponse;

public class AccountListRequest implements Request<AccountListRequest, AccountListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(AccountListRequest.class);

	public String getEndpoint() {
		return "accounts";
	}
	
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }
	   
	public Class<AccountListResponse> getResponseClass() {
		return AccountListResponse.class;
	}
	

}
