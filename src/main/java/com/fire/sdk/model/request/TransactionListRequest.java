package com.fire.sdk.model.request;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.TransactionListResponse;

public class TransactionListRequest implements Request<TransactionListRequest, TransactionListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(TransactionListRequest.class);

    private int limit;
    private int offset;
    private Date dateRangeFrom;
    private Date dateRangeTo;

    @Override
    public String getEndpoint() {
        ArrayList<String> queryStrings = new ArrayList<String>();
        String queryString = "";
        
        if (getDateRangeFrom() != null) {
            queryStrings.add("dateRangeFrom=" + getDateRangeFrom().getTime());
        }
        
        if (getDateRangeTo() != null) {
            queryStrings.add("dateRangeTo=" + getDateRangeTo().getTime());
        }
        
        if (getLimit() != 0) {
            queryStrings.add("limit=" + getLimit());
        }
        
        if (getOffset() != 0) {
            queryStrings.add("offset=" + getOffset());
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
        
        if (getDateRangeFrom() != null || getDateRangeTo() != null) {
            return "transactions/filter" + queryString;
        } else {
            return "transactions" + queryString;
        }
    }

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<TransactionListResponse> getResponseClass() {
		return TransactionListResponse.class;
	}
	
    public int getLimit() {
        return limit;
    }

    public TransactionListRequest setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public TransactionListRequest setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    public Date getDateRangeFrom() {
        return dateRangeFrom;
    }

    public TransactionListRequest setDateRangeFrom(Date dateRangeFrom) {
        this.dateRangeFrom = dateRangeFrom;
        return this;
    }

    public Date getDateRangeTo() {
        return dateRangeTo;
    }

    public TransactionListRequest setDateRangeTo(Date dateRangeTo) {
        this.dateRangeTo = dateRangeTo;
        return this;
    }

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
        


}
