package com.fire.sdk.model.request;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AccountListResponse;
import com.fire.sdk.model.response.BusinessDetailsResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BusinessDetailsRequest implements Request<BusinessDetailsRequest, BusinessDetailsResponse> {
	private static final Logger logger = LoggerFactory.getLogger(BusinessDetailsRequest.class);

    @Override
	public String getEndpoint() {
		return "me";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<BusinessDetailsResponse> getResponseClass() {
		return BusinessDetailsResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
