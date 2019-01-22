package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.BatchItem;
import com.fire.sdk.model.Response;

public class BatchListItemsResponse implements Response<BatchListItemsResponse> {
	public ArrayList<BatchItem> items;

    public ArrayList<BatchItem> getItems() {
        return items;
    }

    public BatchListItemsResponse setItems(ArrayList<BatchItem> items) {
        this.items = items;
        return this;
    }
	
	

}
