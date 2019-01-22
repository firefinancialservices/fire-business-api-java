package com.fire.sdk.model.response;

import java.util.Date;

import com.fire.sdk.model.Permission;
import com.fire.sdk.model.Response;

public class AccessTokenResponse implements Response<AccessTokenResponse> {
	private String businessId;
	private String applicationId;
	private Date expiry;
	private String accessToken;
	private Permission[] permissions;
	public String getBusinessId() {
		return businessId;
	}
	public AccessTokenResponse setBusinessId(String businessId) {
		this.businessId = businessId;
        return this;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public AccessTokenResponse setApplicationId(String applicationId) {
		this.applicationId = applicationId;
        return this;
	}
	public Date getExpiry() {
		return expiry;
	}
	public AccessTokenResponse setExpiry(Date expiry) {
		this.expiry = expiry;
        return this;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public AccessTokenResponse setAccessToken(String accessToken) {
		this.accessToken = accessToken;
        return this;
	}
	public Permission[] getPermissions() {
		return permissions;
	}
	public AccessTokenResponse setPermissions(Permission[] permissions) {
		this.permissions = permissions;
		return this;
	}
	
	

}
