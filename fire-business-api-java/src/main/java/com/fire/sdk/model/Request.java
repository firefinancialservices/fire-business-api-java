package com.fire.sdk.model;

/**
 * Interface to be implemented by all classes which represent Fire requests.
 * 
 * @author owenobyrne
 *
 */
public interface Request<T, U extends Response<U>> {
	public String getEndpoint();
	public Class<U> getResponseClass();
}
