package com.fire.sdk.model.request;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.PaymentRequest;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.PaymentRequestListResponse;
import com.fire.sdk.model.response.PaymentRequestNewResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentRequestListRequest implements Request<PaymentRequestListRequest, PaymentRequestListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(PaymentRequestListRequest.class);

    @Override
    public String getEndpoint() {
		return "paymentrequests/sent";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override 
	public Class<PaymentRequestListResponse> getResponseClass() {
		return PaymentRequestListResponse.class;
	}

    @Override
    public Object getBody() {
        return null;
    }


}
