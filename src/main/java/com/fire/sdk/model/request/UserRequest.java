package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.UserResponse;

public class UserRequest implements Request<UserRequest, UserResponse> {
	private static final Logger logger = LoggerFactory.getLogger(UserRequest.class);
	private Long userId;
	
    @Override
    public String getEndpoint() {
        return "users/" + getUserId();
    }

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<UserResponse> getResponseClass() {
		return UserResponse.class;
	}
	
   
    public Long getUserId() {
        return userId;
    }

    public UserRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
        


}
