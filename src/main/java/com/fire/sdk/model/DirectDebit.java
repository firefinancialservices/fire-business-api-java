package com.fire.sdk.model;

import java.util.Date;

public class DirectDebit {
    private Long amount;
    private Currency currency;
    private Date dateCreated;
    private String directDebitReference;
    private String directDebitUuid;
    private Date lastUpdated;
    private String mandateUuid;
    private String originatorName;
    private String originatorReference;
    private Status status;
    private Long targetIcan;
    private Type type;

    enum Status {
        RECEIVED,COLLECTED,REJECT_REQUESTED,REJECT_READY_FOR_PROCESSING,REJECT_RECORD_IN_PROGRESS,
        REJECT_RECORDED,REJECT_FILE_CREATED,REJECT_FILE_SENT,REJECT_PAID
    }

    enum Type {
        FIRST_COLLECTION,ONGOING_COLLECTION,REPRESENTED_COLLECTION,FINAL_COLLECTION
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDirectDebitReference() {
        return directDebitReference;
    }

    public void setDirectDebitReference(String directDebitReference) {
        this.directDebitReference = directDebitReference;
    }

    public String getDirectDebitUuid() {
        return directDebitUuid;
    }

    public void setDirectDebitUuid(String directDebitUuid) {
        this.directDebitUuid = directDebitUuid;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getMandateUuid() {
        return mandateUuid;
    }

    public void setMandateUuid(String mandateUuid) {
        this.mandateUuid = mandateUuid;
    }

    public String getOriginatorName() {
        return originatorName;
    }

    public void setOriginatorName(String originatorName) {
        this.originatorName = originatorName;
    }

    public String getOriginatorReference() {
        return originatorReference;
    }

    public void setOriginatorReference(String originatorReference) {
        this.originatorReference = originatorReference;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getTargetIcan() {
        return targetIcan;
    }

    public void setTargetIcan(Long targetIcan) {
        this.targetIcan = targetIcan;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    
}
