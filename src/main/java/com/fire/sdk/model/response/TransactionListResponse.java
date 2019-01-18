package com.fire.sdk.model.response;

import java.util.ArrayList;

import com.fire.sdk.model.Response;
import com.fire.sdk.model.Transaction;

public class TransactionListResponse implements Response<TransactionListResponse> {
	private long total;
	private long dateRangeTo;
    private ArrayList<Transaction> transactions;
    
    public long getTotal() {
        return total;
    }
    public void setTotal(long total) {
        this.total = total;
    }
    public long getDateRangeTo() {
        return dateRangeTo;
    }
    public void setDateRangeTo(long dateRangeTo) {
        this.dateRangeTo = dateRangeTo;
    }
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }

    

}
