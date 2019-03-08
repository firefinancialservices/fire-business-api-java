package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.Card;
import com.fire.sdk.model.Response;

public class CardListResponse implements Response<CardListResponse> {
	public ArrayList<Card> cards;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public CardListResponse setAccounts(ArrayList<Card> cards) {
        this.cards = cards;
        return this;
    }
	
	

}
