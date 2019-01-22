package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Batch;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.BatchNewResponse;

public class BatchNewRequest implements Request<BatchNewRequest, BatchNewResponse> {
	private static final Logger logger = LoggerFactory.getLogger(BatchNewRequest.class);

	private Batch batch;
	
	public Batch getBatch() {
        return batch;
    }

    public void setBatch(Batch batch) {
        this.batch = batch;
    }

    @Override
    public String getEndpoint() {
		return "batches";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.POST;
    }

    @Override 
	public Class<BatchNewResponse> getResponseClass() {
		return BatchNewResponse.class;
	}

    @Override
    public Batch getBody() {
        return batch;
    }


}
