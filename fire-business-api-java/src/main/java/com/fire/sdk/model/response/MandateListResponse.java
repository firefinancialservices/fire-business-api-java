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
    public void setTotal(long total) {
        this.total = total;
    }
    public ArrayList<Mandate> getMandates() {
        return mandates;
    }
    public void setMandates(ArrayList<Mandate> mandates) {
        this.mandates = mandates;
    }

    

}
