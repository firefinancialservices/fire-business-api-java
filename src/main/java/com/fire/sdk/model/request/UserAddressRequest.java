package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.UserAddressResponse;

public class UserAddressRequest implements Request<UserAddressRequest, UserAddressResponse> {
	private static final Logger logger = LoggerFactory.getLogger(UserAddressRequest.class);
	private Long userId;
	
    @Override
    public String getEndpoint() {
        return "users/" + getUserId() + "/address";
    }

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<UserAddressResponse> getResponseClass() {
		return UserAddressResponse.class;
	}
	
   
    public Long getUserId() {
        return userId;
    }

    public UserAddressRequest setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
        


}
