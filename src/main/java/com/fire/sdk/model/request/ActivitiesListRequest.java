package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AccountListResponse;
import com.fire.sdk.model.response.ActivitiesListResponse;

public class ActivitiesListRequest implements Request<ActivitiesListRequest, ActivitiesListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(ActivitiesListRequest.class);

	public String getEndpoint() {
		return "activities";
	}
	
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }
	   
	public Class<ActivitiesListResponse> getResponseClass() {
		return ActivitiesListResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
	

}
