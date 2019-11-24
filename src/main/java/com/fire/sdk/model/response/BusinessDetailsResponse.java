package com.fire.sdk.model.response;

import com.fire.sdk.model.Account;
import com.fire.sdk.model.Response;

import java.util.ArrayList;
import java.util.HashMap;

public class BusinessDetailsResponse implements Response<BusinessDetailsResponse> {
	public HashMap<String, Object> businessProfile;
    public HashMap<String, Object> permissions;
    public HashMap<String, Object> userProfile;

    public HashMap<String, Object> getBusinessProfile() {
        return businessProfile;
    }

    public BusinessDetailsResponse setBusinessProfile(HashMap<String, Object> businessProfile) {
        this.businessProfile = businessProfile;
        return this;
    }

    public HashMap<String, Object> getPermissions() {
        return permissions;
    }

    public BusinessDetailsResponse setPermissions(HashMap<String, Object> permissions) {
        this.permissions = permissions;
        return this;
    }

    public HashMap<String, Object> getUserProfile() {
        return userProfile;
    }

    public BusinessDetailsResponse setUserProfile(HashMap<String, Object> userProfile) {
        this.userProfile = userProfile;
        return this;
    }
}
