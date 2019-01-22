package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.Mandate;
import com.fire.sdk.model.Response;

public class MandateListResponse implements Response<MandateListResponse> {
	private long total;
    private ArrayList<Mandate> mandates;
    
    public long getTotal() {
        return total;
    }
    public MandateListResponse setTotal(long total) {
        this.total = total;
        return this;
    }
    public ArrayList<Mandate> getMandates() {
        return mandates;
    }
    public MandateListResponse setMandates(ArrayList<Mandate> mandates) {
        this.mandates = mandates;
        return this;
    }

    

}
