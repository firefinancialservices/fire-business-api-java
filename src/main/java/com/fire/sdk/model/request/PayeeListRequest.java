package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.PayeeListResponse;

public class PayeeListRequest implements Request<PayeeListRequest, PayeeListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(PayeeListRequest.class);

    @Override
	public String getEndpoint() {
		return "fundingsources";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<PayeeListResponse> getResponseClass() {
		return PayeeListResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
