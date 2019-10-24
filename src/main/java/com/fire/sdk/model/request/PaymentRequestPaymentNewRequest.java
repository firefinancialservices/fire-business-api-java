package com.fire.sdk.model.request;

import com.fire.sdk.FireException;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.PaymentRequest;
import com.fire.sdk.model.PaymentRequestPayment;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.PaymentRequestNewResponse;
import com.fire.sdk.model.response.PaymentRequestPaymentNewResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PaymentRequestPaymentNewRequest implements Request<PaymentRequestPaymentNewRequest, PaymentRequestPaymentNewResponse> {
	private static final Logger logger = LoggerFactory.getLogger(PaymentRequestPaymentNewRequest.class);

	private PaymentRequestPayment paymentRequestPayment;
	private String paymentRequestCode;

    public String getPaymentRequestCode() {
        return paymentRequestCode;
    }

    public PaymentRequestPaymentNewRequest setPaymentRequestCode(String paymentRequestCode) {
        this.paymentRequestCode = paymentRequestCode;
        return this;
    }

    public PaymentRequestPayment getPaymentRequestPayment() {
        return paymentRequestPayment;
    }

    public PaymentRequestPaymentNewRequest setPaymentRequestPayment(PaymentRequestPayment paymentRequestPayment) {
        this.paymentRequestPayment = paymentRequestPayment;
        return this;
    }

    @Override
    public String getEndpoint() {
		if (getPaymentRequestCode() == null) {
            throw new FireException("You must setPaymentRequestCode() first!");
        }
        return "paymentrequests/" + getPaymentRequestCode() + "/pay";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.POST;
    }

    @Override 
	public Class<PaymentRequestPaymentNewResponse> getResponseClass() {
		return PaymentRequestPaymentNewResponse.class;
	}

    @Override
    public PaymentRequestPayment getBody() {
        return paymentRequestPayment;
    }


}
