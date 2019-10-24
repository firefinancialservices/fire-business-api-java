package com.fire.sdk.model.request;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.PaymentRequest;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.BatchNewResponse;
import com.fire.sdk.model.response.PaymentRequestNewResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentRequestNewRequest implements Request<PaymentRequestNewRequest, PaymentRequestNewResponse> {
	private static final Logger logger = LoggerFactory.getLogger(PaymentRequestNewRequest.class);

	private PaymentRequest paymentRequest;

    public PaymentRequest getPaymentRequest() {
        return paymentRequest;
    }

    public PaymentRequestNewRequest setPaymentRequest(PaymentRequest paymentRequest) {
        this.paymentRequest = paymentRequest;
        return this;
    }

    @Override
    public String getEndpoint() {
		return "paymentrequests";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.POST;
    }

    @Override 
	public Class<PaymentRequestNewResponse> getResponseClass() {
		return PaymentRequestNewResponse.class;
	}

    @Override
    public PaymentRequest getBody() {
        return paymentRequest;
    }


}
