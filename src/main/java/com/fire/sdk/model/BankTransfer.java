package com.fire.sdk.model;

public class BankTransfer extends BatchItem {
    private Long icanFrom;
    private PayeeType payeeType;
    private String destNsc;
    private String destAccountNumber;
    private String destIban;
    private String destAccountHolderName;
    private Long payeeId;
    private Long amount;
    private String myRef;
    private String yourRef;
    
    public static enum PayeeType {
        PAYEE_ID, ACCOUNT_DETAILS
    }

    public Long getIcanFrom() {
        return icanFrom;
    }

    public BankTransfer setIcanFrom(Long icanFrom) {
        this.icanFrom = icanFrom;
        return this;
    }

    public PayeeType getPayeeType() {
        return payeeType;
    }

    public BankTransfer setPayeeType(PayeeType payeeType) {
        this.payeeType = payeeType;
        return this;
    }

    public String getDestNsc() {
        return destNsc;
    }

    public BankTransfer setDestNsc(String destNsc) {
        this.destNsc = destNsc;
        return this;
    }

    public String getDestAccountNumber() {
        return destAccountNumber;
    }

    public BankTransfer setDestAccountNumber(String destAccountNumber) {
        this.destAccountNumber = destAccountNumber;
        return this;
    }

    public String getDestIban() {
        return destIban;
    }

    public BankTransfer setDestIban(String destIban) {
        this.destIban = destIban;
        return this;
    }

    public String getDestAccountHolderName() {
        return destAccountHolderName;
    }

    public BankTransfer setDestAccountHolderName(String destAccountHolderName) {
        this.destAccountHolderName = destAccountHolderName;
        return this;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public BankTransfer setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public BankTransfer setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getMyRef() {
        return myRef;
    }

    public BankTransfer setMyRef(String myRef) {
        this.myRef = myRef;
        return this;
    }

    public String getYourRef() {
        return yourRef;
    }

    public BankTransfer setYourRef(String yourRef) {
        this.yourRef = yourRef;
        return this;
    }
    
    
}
