package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.Account;
import com.fire.sdk.model.Batch;
import com.fire.sdk.model.Response;

public class BatchListResponse implements Response<BatchListResponse> {
	public ArrayList<Batch> batchRequests;

    public ArrayList<Batch> getBatches() {
        return batchRequests;
    }

    public BatchListResponse setBatches(ArrayList<Batch> batches) {
        this.batchRequests = batches;
        return this;
    }
	
	

}
