package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.BankTransfer;
import com.fire.sdk.model.BatchItem;
import com.fire.sdk.model.InternalTransfer;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.BatchAddItemResponse;

public class BatchAddItemRequest implements Request<BatchAddItemRequest, BatchAddItemResponse> {
	private static final Logger logger = LoggerFactory.getLogger(BatchAddItemRequest.class);

	private String batchUuid;
	private BatchItem batchItem;


    public BatchItem getBatchItem() {
        return batchItem;
    }

    public BatchAddItemRequest setBatchItem(BatchItem batchItem) {
        this.batchItem = batchItem;
        return this;
    }

    public BatchAddItemRequest setBatchUuid(String batchUuid) {
        this.batchUuid = batchUuid;
        return this;
    }

    @Override
    public String getEndpoint() {
		String endpoint = "batches/" + this.batchUuid + "/";
		if (batchItem instanceof BankTransfer) {
		    endpoint += "banktransfers";
		} else if (batchItem instanceof InternalTransfer) {
            endpoint += "internaltransfers";
		}
		return endpoint;
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.POST;
    }

    @Override 
	public Class<BatchAddItemResponse> getResponseClass() {
		return BatchAddItemResponse.class;
	}

    @Override
    public BatchItem getBody() {
        return batchItem;
    }


}
