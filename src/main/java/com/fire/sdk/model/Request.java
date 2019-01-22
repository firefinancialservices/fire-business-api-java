package com.fire.sdk.model;

import com.fire.sdk.http.HttpUtils;

/**
 * Interface to be implemented by all classes which represent Fire requests.
 * 
 * @author owenobyrne
 *
 */
public interface Request<T, U extends Response<U>> {
	String getEndpoint();
	HttpUtils.HttpMethod getMethod();
	Class<U> getResponseClass();
	Object getBody();
}
