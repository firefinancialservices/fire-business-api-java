package com.fire.sdk.model.request;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fire.sdk.http.HttpUtils;
import com.fire.sdk.model.Request;
import com.fire.sdk.model.response.CardActionsResponse;

public class CardActionsRequest implements Request<CardActionsRequest, CardActionsResponse> {
	private static final Logger logger = LoggerFactory.getLogger(CardActionsRequest.class);
	private long cardId;
	private CardStatus action = null;
	
	public static enum CardStatus {
		BLOCK,
		UNBLOCK
	}
	
	public CardActionsRequest block() {
		this.action = CardStatus.BLOCK;
		return this;
	}
	
	public CardActionsRequest unblock() {
		this.action = CardStatus.UNBLOCK;
		return this;
	}
	
    public long getCardId() {
		return cardId;
	}

	public CardActionsRequest setCardId(long cardId) {
		this.cardId = cardId;
		return this;
	}

	@Override
    public String getEndpoint() {
		if (action == null) {
			logger.error("You must set the action using .block() or .unblock()");
		} else if (action == CardStatus.BLOCK) {
			return "me/cards/" + cardId + "/block";
		} else if (action == CardStatus.UNBLOCK) {
			return "me/cards/" + cardId + "/unblock";
		}
		return "";
	}

    @Override
    public HttpUtils.HttpMethod getMethod() {
        return HttpUtils.HttpMethod.POST;
    }

    @Override 
	public Class<CardActionsResponse> getResponseClass() {
		return CardActionsResponse.class;
	}

    @Override
    public Object getBody() {
        return null;
    }


}
