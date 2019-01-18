package com.fire.sdk.model.request;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.MandateListResponse;

public class MandateListRequest implements Request<MandateListRequest, MandateListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(MandateListRequest.class);

    private int limit;
    private int offset;
    private String[] mandateStatuses;
    
	public String getEndpoint() {
	    ArrayList<String> queryStrings = new ArrayList<String>();
        String queryString = "";
        
        if (getLimit() != 0) {
            queryStrings.add("limit=" + getLimit());
        }
        
        if (getOffset() != 0) {
            queryStrings.add("offset=" + getOffset());
        }
        
        if (getMandateStatuses() != null) {
            for (String ms : getMandateStatuses()) {
                queryStrings.add("statuses=" + ms);
            }
        }
        
        
        if (queryStrings.size() > 0) {
            StringBuilder sb = new StringBuilder(128);
            int end = 0;
            for (Object s : queryStrings.toArray()) {
                sb.append(s);
                end = sb.length();
                sb.append("&");
            }
            queryString = "?" + sb.substring(0, end);
        }
        
        return "mandates" + queryString;

	}
	
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }
	   
	public Class<MandateListResponse> getResponseClass() {
		return MandateListResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public String[] getMandateStatuses() {
        return mandateStatuses;
    }

    public void setMandateStatuses(String[] mandateStatuses) {
        this.mandateStatuses = mandateStatuses;
    }


    
    
	

}
