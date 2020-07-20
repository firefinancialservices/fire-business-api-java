package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Batch;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.BatchListItemsResponse;

import java.util.ArrayList;

public class BatchListItemsRequest implements Request<BatchListItemsRequest, BatchListItemsResponse> {
	private static final Logger logger = LoggerFactory.getLogger(BatchListItemsRequest.class);

    private int limit;
    private int offset;
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

    public int getLimit() {
        return limit;
    }

    public BatchListItemsRequest setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public BatchListItemsRequest setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    @Override
    public String getEndpoint() {
        ArrayList<String> queryStrings = new ArrayList<String>();
        String queryString = "";

        if (getLimit() != 0) {
            queryStrings.add("limit=" + getLimit());
        }

        if (getOffset() != 0) {
            queryStrings.add("offset=" + getOffset());
        }

        if (queryStrings.size() > 0) {
            StringBuilder sb = new StringBuilder(128);
            int end = 0;
            for (Object s : queryStrings.toArray()) {
                sb.append(s);
                end = sb.length();
                sb.append("&");
            }
            queryString = "?" + sb.substring(0, end);
        }

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
		
		return endpoint + queryString;
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
