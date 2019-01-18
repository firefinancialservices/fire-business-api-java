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
	public void setBusinessId(String businessId) {
		this.businessId = businessId;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	public Date getExpiry() {
		return expiry;
	}
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Permission[] getPermissions() {
		return permissions;
	}
	public void setPermissions(Permission[] permissions) {
		this.permissions = permissions;
	}
	
	

}
