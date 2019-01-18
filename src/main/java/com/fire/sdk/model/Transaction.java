package com.fire.sdk.model;

import java.util.Date;

public class Transaction {
    private long txnId;
    private long refId;
    private long ican;
    private String type;
    private RelatedParty relatedParty;
    private Card card;
    private Currency currency;
    private long amountBeforeCharges;
    private long feeAmount;
    private long taxAmount;
    private long amountAfterCharges;
    private long balance;
    private String myRef;
    private Date date;
    
    public long getTxnId() {
        return txnId;
    }
    public void setTxnId(long txnId) {
        this.txnId = txnId;
    }
    public long getRefId() {
        return refId;
    }
    public void setRefId(long refId) {
        this.refId = refId;
    }
    public long getIcan() {
        return ican;
    }
    public void setIcan(long ican) {
        this.ican = ican;
    }
    public RelatedParty getRelatedParty() {
        return relatedParty;
    }
    public void setRelatedParty(RelatedParty relatedParty) {
        this.relatedParty = relatedParty;
    }
    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    public long getAmountBeforeCharges() {
        return amountBeforeCharges;
    }
    public void setAmountBeforeCharges(long amountBeforeCharges) {
        this.amountBeforeCharges = amountBeforeCharges;
    }
    public long getAmountAfterCharges() {
        return amountAfterCharges;
    }
    public void setAmountAfterCharges(long amountAfterCharges) {
        this.amountAfterCharges = amountAfterCharges;
    }
    public long getBalance() {
        return balance;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    public String getMyRef() {
        return myRef;
    }
    public void setMyRef(String myRef) {
        this.myRef = myRef;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public long getFeeAmount() {
        return feeAmount;
    }
    public void setFeeAmount(long feeAmount) {
        this.feeAmount = feeAmount;
    }
    public long getTaxAmount() {
        return taxAmount;
    }
    public void setTaxAmount(long taxAmount) {
        this.taxAmount = taxAmount;
    }
    
    
}
