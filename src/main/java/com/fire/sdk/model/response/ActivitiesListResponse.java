package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.Activity;
import com.fire.sdk.model.Response;

public class ActivitiesListResponse implements Response<ActivitiesListResponse> {
	public ArrayList<Activity> activities;

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}

}
