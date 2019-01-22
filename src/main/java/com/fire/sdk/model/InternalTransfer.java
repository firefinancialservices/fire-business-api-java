package com.fire.sdk.model;


public class InternalTransfer extends BatchItem {
    private Long icanFrom;
    private Long icanTo;
    private Long amount;
    private String ref;
    public Long getIcanFrom() {
        return icanFrom;
    }
    public InternalTransfer setIcanFrom(Long icanFrom) {
        this.icanFrom = icanFrom;
        return this;
    }
    public Long getIcanTo() {
        return icanTo;
    }
    public InternalTransfer setIcanTo(Long icanTo) {
        this.icanTo = icanTo;
        return this;
    }
    public Long getAmount() {
        return amount;
    }
    public InternalTransfer setAmount(Long amount) {
        this.amount = amount;
        return this;
    }
    public String getRef() {
        return ref;
    }
    public InternalTransfer setRef(String ref) {
        this.ref = ref;
        return this;
    }
    
    
}
