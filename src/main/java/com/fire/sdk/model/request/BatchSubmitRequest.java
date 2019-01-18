package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.BatchSubmitResponse;

public class BatchSubmitRequest implements Request<BatchSubmitRequest, BatchSubmitResponse> {
	private static final Logger logger = LoggerFactory.getLogger(BatchSubmitRequest.class);

	private String batchUuid;
	
	public String getBatchUuid() {
        return batchUuid;
    }

    public BatchSubmitRequest setBatchUuid(String batchUuid) {
        this.batchUuid = batchUuid;
        return this;
    }

    public String getEndpoint() {
		return "batches/" + this.batchUuid;
	}
	
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.PUT;
    }
	   
	public Class<BatchSubmitResponse> getResponseClass() {
		return BatchSubmitResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
