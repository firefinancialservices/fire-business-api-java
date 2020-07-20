package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.BankTransferBatchItem;
import com.fire.sdk.model.BatchItem;
import com.fire.sdk.model.Response;

public class BatchListItemsResponse implements Response<BatchListItemsResponse> {
	public ArrayList<BankTransferBatchItem> items;

    public ArrayList<BankTransferBatchItem> getItems() {
        return items;
    }

    public BatchListItemsResponse setItems(ArrayList<BankTransferBatchItem> items) {
        this.items = items;
        return this;
    }
	
	

}
