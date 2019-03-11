package com.fire.sdk.model.request;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.FireException;
import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.CardTransactionListResponse;

public class CardTransactionListRequest implements Request<CardTransactionListRequest, CardTransactionListResponse> {
	private static final Logger logger = LoggerFactory.getLogger(CardTransactionListRequest.class);

	private Long cardId;
    private int limit;
    private int offset;
    

    @Override
    public String getEndpoint() {
        ArrayList<String> queryStrings = new ArrayList<String>();
        String queryString = "";
        
        if (getCardId() == null) {
            throw new FireException("You must setCardId() first!");
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

        return "me/cards/" + getCardId() + "/transactions" + queryString;
        
    }

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.GET;
    }

    @Override
	public Class<CardTransactionListResponse> getResponseClass() {
		return CardTransactionListResponse.class;
	}
	
    public Long getCardId() {
        return cardId;
    }
    
    public CardTransactionListRequest setCardId(Long cardId) {
        this.cardId = cardId;
        return this;
    }

    public int getLimit() {
        return limit;
    }

    public CardTransactionListRequest setLimit(int limit) {
        this.limit = limit;
        return this;
    }

    public int getOffset() {
        return offset;
    }

    public CardTransactionListRequest setOffset(int offset) {
        this.offset = offset;
        return this;
    }

    @Override
    public Object getBody() {
        // TODO Auto-generated method stub
        return null;
    }
        


}
