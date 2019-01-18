package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AccountListResponse;
import com.fire.sdk.model.response.BatchListResponse;

public class BatchListRequest implements Request<BatchListRequest, BatchListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(BatchListRequest.class);

	public String getEndpoint() {
		return "batches";
	}
	
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }
	   
	public Class<BatchListResponse> getResponseClass() {
		return BatchListResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
