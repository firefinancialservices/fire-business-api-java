package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.DirectDebit;
import com.fire.sdk.model.Response;

public class DirectDebitListResponse implements Response<DirectDebitListResponse> {
	private long total;
    private ArrayList<DirectDebit> directdebits;
    
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public ArrayList<DirectDebit> getDirectdebits() {
        return directdebits;
    }
    public void setDirectdebits(ArrayList<DirectDebit> directdebits) {
        this.directdebits = directdebits;
    }


    

}
