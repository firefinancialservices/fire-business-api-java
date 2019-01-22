package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AccountListResponse;

public class AccountListRequest implements Request<AccountListRequest, AccountListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(AccountListRequest.class);

    @Override
	public String getEndpoint() {
		return "accounts";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<AccountListResponse> getResponseClass() {
		return AccountListResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
