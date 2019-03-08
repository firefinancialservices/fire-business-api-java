package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.CardListResponse;

public class CardListRequest implements Request<CardListRequest, CardListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(CardListRequest.class);

    @Override
	public String getEndpoint() {
		return "cards";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<CardListResponse> getResponseClass() {
		return CardListResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
