package com.fire.sdk.model.request;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.FireException;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.AccountTransactionListResponse;

public class AccountTransactionListRequest implements Request<AccountTransactionListRequest, AccountTransactionListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(AccountTransactionListRequest.class);

	private Long accountId;
    private int limit;
    private int offset;
    
    public String getEndpoint() {
        ArrayList<String> queryStrings = new ArrayList<String>();
        String queryString = "";
        
        if (getAccountId() == null) {
            throw new FireException("You must setAccountId() first!");
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
        
        return "accounts/" + getAccountId() + "/transactions" + queryString;
    }
    
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }
	   
	public Class<AccountTransactionListResponse> getResponseClass() {
		return AccountTransactionListResponse.class;
	}
	
    public Long getAccountId() {
        return accountId;
    }
    
    public AccountTransactionListRequest setAccountId(Long accountId) {
        this.accountId = accountId;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public AccountTransactionListRequest setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public AccountTransactionListRequest setOffset(int offset) {
        this.offset = offset;
        return this;
    }
        


}
