package com.fire.sdk.model.request;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.DirectDebitListResponse;

public class DirectDebitListRequest implements Request<DirectDebitListRequest, DirectDebitListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(DirectDebitListRequest.class);

    private int limit;
    private int offset;
    private String mandateUuid;
    
	public String getMandateUuid() {
        return mandateUuid;
    }

    public DirectDebitListRequest setMandateUuid(String mandateUuid) {
        this.mandateUuid = mandateUuid;
        return this;
    }

    @Override
    public String getEndpoint() {
	    ArrayList<String> queryStrings = new ArrayList<String>();
        String queryString = "";
        
        if (getMandateUuid() != null) {
            queryStrings.add("mandateUuid=" + getMandateUuid());
        }
        
        if (getOffset() != 0) {
            queryStrings.add("offset=" + getOffset());
        }
        if (getLimit() != 0) {
            queryStrings.add("limit=" + getLimit());
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
        
        return "directdebits" + queryString;

	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<DirectDebitListResponse> getResponseClass() {
		return DirectDebitListResponse.class;
	}

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }

    public int getLimit() {
        return limit;
    }

    public DirectDebitListRequest setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public DirectDebitListRequest setOffset(int offset) {
        this.offset = offset;
        return this;
    }


}
