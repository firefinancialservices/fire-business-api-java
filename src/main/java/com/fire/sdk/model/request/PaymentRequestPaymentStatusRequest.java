package com.fire.sdk.model.request;

import com.fire.sdk.FireException;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.PaymentRequestPaymentStatusResponse;
import com.fire.sdk.model.response.PaymentRequestResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentRequestPaymentStatusRequest implements Request<PaymentRequestPaymentStatusRequest, PaymentRequestPaymentStatusResponse> {
	private static final Logger logger = LoggerFactory.getLogger(PaymentRequestPaymentStatusRequest.class);
    private String paymentUuid;

    public String getPaymentUuid() {
        return paymentUuid;
    }

    public PaymentRequestPaymentStatusRequest setPaymentUuid(String paymentUuid) {
        this.paymentUuid = paymentUuid;
        return this;
    }

    @Override
    public String getEndpoint() {
        if (getPaymentUuid() == null) {
            throw new FireException("You must setPaymentUuid() first!");
        }
		return "payments/" + getPaymentUuid();
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override 
	public Class<PaymentRequestPaymentStatusResponse> getResponseClass() {
		return PaymentRequestPaymentStatusResponse.class;
	}

    @Override
    public Object getBody() {
        return null;
    }


}
