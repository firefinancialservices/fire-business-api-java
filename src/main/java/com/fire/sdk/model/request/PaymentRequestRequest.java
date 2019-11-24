package com.fire.sdk.model.request;

import com.fire.sdk.FireException;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.PaymentRequestListResponse;
import com.fire.sdk.model.response.PaymentRequestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentRequestRequest implements Request<PaymentRequestRequest, PaymentRequestResponse> {
	private static final Logger logger = LoggerFactory.getLogger(PaymentRequestRequest.class);
    private String code;

    public String getCode() {
        return code;
    }

    public PaymentRequestRequest setCode(String code) {
        this.code = code;
        return this;
    }

    @Override
    public String getEndpoint() {
        if (getCode() == null) {
            throw new FireException("You must setCode() first!");
        }
		return "paymentrequests/" + getCode();
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override 
	public Class<PaymentRequestResponse> getResponseClass() {
		return PaymentRequestResponse.class;
	}

    @Override
    public Object getBody() {
        return null;
    }


}
