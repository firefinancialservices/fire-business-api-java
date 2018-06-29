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

    public void setIcanFrom(Long icanFrom) {
        this.icanFrom = icanFrom;
    }

    public PayeeType getPayeeType() {
        return payeeType;
    }

    public void setPayeeType(PayeeType payeeType) {
        this.payeeType = payeeType;
    }

    public String getDestNsc() {
        return destNsc;
    }

    public void setDestNsc(String destNsc) {
        this.destNsc = destNsc;
    }

    public String getDestAccountNumber() {
        return destAccountNumber;
    }

    public void setDestAccountNumber(String destAccountNumber) {
        this.destAccountNumber = destAccountNumber;
    }

    public String getDestIban() {
        return destIban;
    }

    public void setDestIban(String destIban) {
        this.destIban = destIban;
    }

    public String getDestAccountHolderName() {
        return destAccountHolderName;
    }

    public void setDestAccountHolderName(String destAccountHolderName) {
        this.destAccountHolderName = destAccountHolderName;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public void setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getMyRef() {
        return myRef;
    }

    public void setMyRef(String myRef) {
        this.myRef = myRef;
    }

    public String getYourRef() {
        return yourRef;
    }

    public void setYourRef(String yourRef) {
        this.yourRef = yourRef;
    }
    
    
}
