package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.FireException;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.TransactionResponse;

public class TransactionRequest implements Request<TransactionRequest, TransactionResponse> {
	private static final Logger logger = LoggerFactory.getLogger(TransactionRequest.class);

	private Long transactionId;
	
	
	public String getEndpoint() {
	    if (getTransactionId() == null) {
	        throw new FireException("You must setTransactionId() first!");
	    }
		return "transactions/" + getTransactionId();
	}
	
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }
	   
	public Class<TransactionResponse> getResponseClass() {
		return TransactionResponse.class;
	}

    public Long getTransactionId() {
        return transactionId;
    }

    public TransactionRequest setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
        return this;
    }
	

}
