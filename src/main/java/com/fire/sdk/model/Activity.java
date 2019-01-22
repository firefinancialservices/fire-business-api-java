package com.fire.sdk.model;

import java.util.Date;

// {"id":949859,"userId":3138,"type":"BUSINESS_API_APPLICATION_CREATED","description":"A new API application has been created.","dateCreated":"2018-04-03T23:53:00.033Z"}

public class Activity {
	private Long id;
	private Long userId;
	private String type;
	private String description;
    private Date dateCreated;
    
	public Long getId() {
		return id;
	}
	public Activity setId(Long id) {
		this.id = id;
		return this;
	}
	public Long getUserId() {
		return userId;
	}
	public Activity setUserId(Long userId) {
		this.userId = userId;
        return this;
	}
	public String getType() {
		return type;
	}
	public Activity setType(String type) {
		this.type = type;
        return this;
	}
	public String getDescription() {
		return description;
	}
	public Activity setDescription(String description) {
		this.description = description;
        return this;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public Activity setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
        return this;
	}
    
    

}
