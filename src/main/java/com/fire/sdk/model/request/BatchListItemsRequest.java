package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Batch;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.BatchListItemsResponse;

public class BatchListItemsRequest implements Request<BatchListItemsRequest, BatchListItemsResponse> {
	private static final Logger logger = LoggerFactory.getLogger(BatchListItemsRequest.class);

	private String batchUuid;
	private Batch.BatchType batchType;
	
	public Batch.BatchType getBatchType() {
        return batchType;
    }

    public BatchListItemsRequest setBatchType(Batch.BatchType batchType) {
        this.batchType = batchType;
        return this;
    }

    public String getBatchUuid() {
        return batchUuid;
    }

    public BatchListItemsRequest setBatchUuid(String batchUuid) {
        this.batchUuid = batchUuid;
        return this;
    }

    @Override
    public String getEndpoint() {
		String endpoint = "batches/" + this.batchUuid + "/";
		
		switch(batchType) {
		case BANK_TRANSFER:
		    endpoint += "banktransfers";
		    break;
		    
		case INTERNAL_TRANSFER:
		    endpoint += "internaltransfers";
		    break;
		    
		case NEW_PAYEE:
		    endpoint += "newpayees";
		    break;
		    
		}
		
		return endpoint;
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<BatchListItemsResponse> getResponseClass() {
		return BatchListItemsResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
