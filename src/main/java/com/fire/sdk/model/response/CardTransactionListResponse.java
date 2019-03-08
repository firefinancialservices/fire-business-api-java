package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.Response;
import com.fire.sdk.model.Transaction;

public class CardTransactionListResponse implements Response<CardTransactionListResponse> {
	private long total;
	private long dateRangeTo;
    private ArrayList<Transaction> transactions;
    
    public long getTotal() {
        return total;
    }
    public CardTransactionListResponse setTotal(long total) {
        this.total = total;
        return this;
    }
    public long getDateRangeTo() {
        return dateRangeTo;
    }
    public CardTransactionListResponse setDateRangeTo(long dateRangeTo) {
        this.dateRangeTo = dateRangeTo;
        return this;
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public CardTransactionListResponse setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
        return this;
    }

    

}
