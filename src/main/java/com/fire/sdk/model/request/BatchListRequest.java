package com.fire.sdk.model.request;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Batch.BatchStatus;
import com.fire.sdk.model.Batch.BatchType;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.BatchListResponse;
import com.fire.sdk.utils.Utils;

public class BatchListRequest implements Request<BatchListRequest, BatchListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(BatchListRequest.class);

    private int limit;
    private int offset;
    private BatchStatus[] batchStatuses;
    private BatchType[] batchTypes;
    
    
    @Override
	public String getEndpoint() {
        ArrayList<String> queryStrings = new ArrayList<String>();
        String queryString = "";
        
        if (getBatchStatuses() != null) {
            queryStrings.add("batchStatuses=" + Utils.enumJoin(getBatchStatuses(), ","));
        }
        
        if (getBatchTypes() != null) {
            queryStrings.add("batchTypes=" + Utils.enumJoin(getBatchTypes(),  ","));
        }
        
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
        
        
		return "batches" + queryString;
	}

    
    public BatchStatus[] getBatchStatuses() {
        return batchStatuses;
    }

    /**
     * Set the statuses of batches you want returned. 
     * 
     * The following batch types exist: 
     * <ul>
     * <li>OPEN
     * <li>PENDING_APPROVAL
     * <li>PENDING_PARENT_BATCH_APPROVAL - the bank transfer batch is waiting for a batch of payees to be approved. 
     * <li>COMPLETE
     * <li>CANCELLED
     * <li>REJECTED
     * </ul>
     * 
     * @param batchStatuses a String[] array containing the batch statuses to return.
     * @return the batch list request object for chaining
     */
    public BatchListRequest setBatchStatuses(BatchStatus[] batchStatuses) {
        this.batchStatuses = batchStatuses;
        return this;
    }

    public BatchType[] getBatchTypes() {
        return batchTypes;
    }

    /**
     * Set the types of batches you want returned. 
     * 
     * The following batch types exist: 
     * <ul>
     * <li>INTERNAL_TRANSFER
     * <li>BANK_TRANSFER
     * <li>NEW_PAYEE
     * </ul>
     * 
     * @param batchTypes a String[] array containing the batch types to return.
     * @return the batch list request object for chaining
     */
    public BatchListRequest setBatchTypes(BatchType[] batchTypes) {
        this.batchTypes = batchTypes;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public BatchListRequest setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public BatchListRequest setOffset(int offset) {
        this.offset = offset;
        return this;
    }
    
    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<BatchListResponse> getResponseClass() {
		return BatchListResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
