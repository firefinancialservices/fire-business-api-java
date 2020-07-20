package com.fire.sdk.model;

import java.util.Date;

public class BankTransferBatchItem extends BatchItem {
    private Long icanTo;
    private Long amount;
    private String myRef;
    private String yourRef;
    private String payeeType;
    private Long payeeId;
    private String destIban;
    private String destAccountHolderName;
    private String destAccountNumber;
    private String destNsc;

    public Long getIcanTo() {
        return icanTo;
    }

    public BankTransferBatchItem setIcanTo(Long icanTo) {
        this.icanTo = icanTo;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public BankTransferBatchItem setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getMyRef() {
        return myRef;
    }

    public BankTransferBatchItem setMyRef(String myRef) {
        this.myRef = myRef;
        return this;
    }

    public String getYourRef() {
        return yourRef;
    }

    public BankTransferBatchItem setYourRef(String yourRef) {
        this.yourRef = yourRef;
        return this;
    }

    public String getPayeeType() {
        return payeeType;
    }

    public BankTransferBatchItem setPayeeType(String payeeType) {
        this.payeeType = payeeType;
        return this;
    }

    public Long getPayeeId() {
        return payeeId;
    }

    public BankTransferBatchItem setPayeeId(Long payeeId) {
        this.payeeId = payeeId;
        return this;
    }

    public String getDestIban() {
        return destIban;
    }

    public BankTransferBatchItem setDestIban(String destIban) {
        this.destIban = destIban;
        return this;
    }

    public String getDestAccountHolderName() {
        return destAccountHolderName;
    }

    public BankTransferBatchItem setDestAccountHolderName(String destAccountHolderName) {
        this.destAccountHolderName = destAccountHolderName;
        return this;
    }

    public String getDestAccountNumber() {
        return destAccountNumber;
    }

    public BankTransferBatchItem setDestAccountNumber(String destAccountNumber) {
        this.destAccountNumber = destAccountNumber;
        return this;
    }

    public String getDestNsc() {
        return destNsc;
    }

    public BankTransferBatchItem setDestNsc(String destNsc) {
        this.destNsc = destNsc;
        return this;
    }
}

