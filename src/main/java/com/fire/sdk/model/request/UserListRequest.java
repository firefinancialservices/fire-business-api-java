package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.UserListResponse;

public class UserListRequest implements Request<UserListRequest, UserListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(UserListRequest.class);

    @Override
    public String getEndpoint() {
        return "users";
    }

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<UserListResponse> getResponseClass() {
		return UserListResponse.class;
	}
	
   
    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
        


}
