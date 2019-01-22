package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.FireException;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.MandateResponse;

public class MandateRequest implements Request<MandateRequest, MandateResponse> {
	private static final Logger logger = LoggerFactory.getLogger(MandateRequest.class);

	public String mandateUuid;
	

    @Override
	public String getEndpoint() {
	    if (getMandateUuid() == null) {
	        throw new FireException("You must setMandateUuid() first!");
	    }
		return "mandates/" + getMandateUuid();
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<MandateResponse> getResponseClass() {
		return MandateResponse.class;
	}

    public String getMandateUuid() {
        return mandateUuid;
    }

    public MandateRequest setMandateUuid(String mandateUuid) {
        this.mandateUuid = mandateUuid;
        return this;
    }

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
