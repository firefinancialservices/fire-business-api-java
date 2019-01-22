package com.fire.sdk.model.request;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Credentials;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AccessTokenResponse;

public class AccessTokenRequest implements Request<AccessTokenRequest, AccessTokenResponse> {
	private static final Logger logger = LoggerFactory.getLogger(AccessTokenRequest.class);

	private String clientId;
	private String refreshToken;
	private Long nonce;
	private String grantType;
	private String clientSecret;

    @Override
	public String getEndpoint() {
		return "apps/accesstokens";
	}

    @Override
	public HttpUtils.HttpMethod getMethod() {
	    return HttpUtils.HttpMethod.POST;
	}

    @Override
	public Class<AccessTokenResponse> getResponseClass() {
		return AccessTokenResponse.class;
	}
	
	public String getClientId() {
		return clientId;
	}
	public AccessTokenRequest setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public AccessTokenRequest setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
		return this;
	}
	public Long getNonce() {
		return nonce;
	}
	public AccessTokenRequest setNonce(Long nonce) {
		this.nonce = nonce;
		return this;
	}
	public String getGrantType() {
		return grantType;
	}
	public AccessTokenRequest setGrantType(String grantType) {
		this.grantType = grantType;
		return this;
	}
	public String getClientSecret() {
		return clientSecret;
	}
	public AccessTokenRequest setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
		return this;
	}
	
	public AccessTokenRequest intialise(Credentials credentials) {
		this.clientId = credentials.getClientId();
		this.refreshToken = credentials.getRefreshToken();
		this.grantType = "AccessToken";
		
		this.nonce = System.currentTimeMillis();
		
		this.clientSecret = DigestUtils.sha256Hex(this.nonce + credentials.getClientKey());
		
		logger.debug("Client secret is {}", this.clientSecret);
		
		return this;
		
		
	}

    @Override
    public AccessTokenRequest getBody() {
        // TODO Auto-generated method stub
        return this;
    }
	

}
