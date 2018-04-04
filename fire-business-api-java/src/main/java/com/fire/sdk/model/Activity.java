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
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
    
    

}
