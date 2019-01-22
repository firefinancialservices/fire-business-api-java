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
    public Transaction setTxnId(long txnId) {
        this.txnId = txnId;
        return this;
    }
    public long getRefId() {
        return refId;
    }
    public Transaction setRefId(long refId) {
        this.refId = refId;
        return this;
    }
    public long getIcan() {
        return ican;
    }
    public Transaction setIcan(long ican) {
        this.ican = ican;
        return this;
    }
    public RelatedParty getRelatedParty() {
        return relatedParty;
    }
    public Transaction setRelatedParty(RelatedParty relatedParty) {
        this.relatedParty = relatedParty;
        return this;
    }
    public Currency getCurrency() {
        return currency;
    }
    public Transaction setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }
    public long getAmountBeforeCharges() {
        return amountBeforeCharges;
    }
    public Transaction setAmountBeforeCharges(long amountBeforeCharges) {
        this.amountBeforeCharges = amountBeforeCharges;
        return this;
    }
    public long getAmountAfterCharges() {
        return amountAfterCharges;
    }
    public Transaction setAmountAfterCharges(long amountAfterCharges) {
        this.amountAfterCharges = amountAfterCharges;
        return this;
    }
    public long getBalance() {
        return balance;
    }
    public Transaction setBalance(long balance) {
        this.balance = balance;
        return this;
    }
    public String getMyRef() {
        return myRef;
    }
    public Transaction setMyRef(String myRef) {
        this.myRef = myRef;
        return this;
    }
    public Date getDate() {
        return date;
    }
    public Transaction setDate(Date date) {
        this.date = date;
        return this;
    }
    public String getType() {
        return type;
    }
    public Transaction setType(String type) {
        this.type = type;
        return this;
    }
    public Card getCard() {
        return card;
    }
    public Transaction setCard(Card card) {
        this.card = card;
        return this;
    }
    public long getFeeAmount() {
        return feeAmount;
    }
    public Transaction setFeeAmount(long feeAmount) {
        this.feeAmount = feeAmount;
        return this;
    }
    public long getTaxAmount() {
        return taxAmount;
    }
    public Transaction setTaxAmount(long taxAmount) {
        this.taxAmount = taxAmount;
        return this;
    }
    
    
}
