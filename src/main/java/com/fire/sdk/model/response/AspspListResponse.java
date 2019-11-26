package com.fire.sdk.model.response;

import com.fire.sdk.model.Aspsp;
import com.fire.sdk.model.Response;

import java.util.ArrayList;

public class AspspListResponse implements Response<AspspListResponse> {
	public ArrayList<Aspsp> aspsps;


    public ArrayList<Aspsp> getAspsps() {
        return aspsps;
    }

    public void setAspsps(ArrayList<Aspsp> aspsps) {
        this.aspsps = aspsps;
    }
}
