package com.fire.sdk.model.request;

import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.FireException;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.request.TransactionListRequest.TransactionTypes;
import com.fire.sdk.model.response.AccountTransactionListResponse;

public class AccountTransactionListRequest implements Request<AccountTransactionListRequest, AccountTransactionListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(AccountTransactionListRequest.class);

	private Long accountId;
    private int limit;
    private int offset;
    private Date dateRangeFrom;
    private Date dateRangeTo;
    private String searchKeyword;
    private TransactionTypes[] transactionTypes;

    public static enum TransactionTypes {
        CARD_POS_CONTACT_DEBIT,
        CARD_POS_CONTACT_CREDIT,
        CARD_POS_CONTACTLESS_DEBIT,
        CARD_POS_CONTACTLESS_CREDIT,
        CARD_ECOMMERCE_DEBIT,
        CARD_ECOMMERCE_CREDIT,
        CARD_ATM_DEBIT,
        CARD_ATM_CREDIT,
        CARD_POS_CONTACT_DEBIT_REVERSAL,
        CARD_POS_CONTACT_CREDIT_REVERSAL,
        CARD_POS_CONTACTLESS_DEBIT_REVERSAL,
        CARD_POS_CONTACTLESS_CREDIT_REVERSAL,
        CARD_ECOMMERCE_DEBIT_REVERSAL,
        CARD_ECOMMERCE_CREDIT_REVERSAL,
        CARD_ATM_DEBIT_REVERSAL,
        CARD_ATM_CREDIT_REVERSAL,
        CARD_MESSAGE_REVERSED_DEBIT,
        CARD_MESSAGE_REVERSED_CREDIT
    }
    

    @Override
    public String getEndpoint() {
        ArrayList<String> queryStrings = new ArrayList<String>();
        String queryString = "";
        
        if (getAccountId() == null) {
            throw new FireException("You must setAccountId() first!");
        }
        
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
        
        if (getSearchKeyword() != null) {
            queryStrings.add("searchKeyword=" + getSearchKeyword());
        }
        
        if (getTransactionTypes() != null) {
            for (TransactionTypes tt : getTransactionTypes()) {
                queryStrings.add("transactionTypes=" + tt.toString());
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
        
        if (getDateRangeFrom() != null || getDateRangeTo() != null) {
            return "accounts/" + getAccountId() + "/transactions/filter" + queryString;
        } else {
            return "accounts/" + getAccountId() + "/transactions" + queryString;
        }
    }

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
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

    public Date getDateRangeFrom() {
        return dateRangeFrom;
    }

    public AccountTransactionListRequest setDateRangeFrom(Date dateRangeFrom) {
        this.dateRangeFrom = dateRangeFrom;
        return this;
    }

    public Date getDateRangeTo() {
        return dateRangeTo;
    }

    public AccountTransactionListRequest setDateRangeTo(Date dateRangeTo) {
        this.dateRangeTo = dateRangeTo;
        return this;
    }
    
    public String getSearchKeyword() {
        return searchKeyword;
    }

    public AccountTransactionListRequest setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
        return this;
    }

    public TransactionTypes[] getTransactionTypes() {
        return transactionTypes;
    }

    public AccountTransactionListRequest setTransactionTypes(TransactionTypes[] transactionTypes) {
        this.transactionTypes = transactionTypes;
        return this;
    }


    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
        


}
