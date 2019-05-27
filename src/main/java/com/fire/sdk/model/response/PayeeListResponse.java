package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.Payee;
import com.fire.sdk.model.Response;

public class PayeeListResponse implements Response<PayeeListResponse> {
	private ArrayList<Payee> fundingSources;

    public ArrayList<Payee> getFundingSources() {
        return fundingSources;
    }

    public PayeeListResponse setFundingSources(ArrayList<Payee> fundingSources) {
        this.fundingSources = fundingSources;
        return this;
    }


	

}
