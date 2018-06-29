package com.fire.sdk.model;


public class InternalTransfer extends BatchItem {
    private Long icanFrom;
    private Long icanTo;
    private Long amount;
    private String ref;
    public Long getIcanFrom() {
        return icanFrom;
    }
    public void setIcanFrom(Long icanFrom) {
        this.icanFrom = icanFrom;
    }
    public Long getIcanTo() {
        return icanTo;
    }
    public void setIcanTo(Long icanTo) {
        this.icanTo = icanTo;
    }
    public Long getAmount() {
        return amount;
    }
    public void setAmount(Long amount) {
        this.amount = amount;
    }
    public String getRef() {
        return ref;
    }
    public void setRef(String ref) {
        this.ref = ref;
    }
    
    
}
