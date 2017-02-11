package com.fire.sdk.model;

public class Credentials {
	private String clientKey;
	private String clientId;
	private String refreshToken;
	
	public String getClientKey() {
		return clientKey;
	}
	public Credentials setClientKey(String clientKey) {
		this.clientKey = clientKey;
		return this;
	}
	public String getClientId() {
		return clientId;
	}
	public Credentials setClientId(String clientId) {
		this.clientId = clientId;
		return this;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public Credentials setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
		return this;
	}
	
	
	
}
