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

    public DirectDebit setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public DirectDebit setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public DirectDebit setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public String getDirectDebitReference() {
        return directDebitReference;
    }

    public DirectDebit setDirectDebitReference(String directDebitReference) {
        this.directDebitReference = directDebitReference;
        return this;
    }

    public String getDirectDebitUuid() {
        return directDebitUuid;
    }

    public DirectDebit setDirectDebitUuid(String directDebitUuid) {
        this.directDebitUuid = directDebitUuid;
        return this;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public DirectDebit setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public String getMandateUuid() {
        return mandateUuid;
    }

    public DirectDebit setMandateUuid(String mandateUuid) {
        this.mandateUuid = mandateUuid;
        return this;
    }

    public String getOriginatorName() {
        return originatorName;
    }

    public DirectDebit setOriginatorName(String originatorName) {
        this.originatorName = originatorName;
        return this;
    }

    public String getOriginatorReference() {
        return originatorReference;
    }

    public DirectDebit setOriginatorReference(String originatorReference) {
        this.originatorReference = originatorReference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public DirectDebit setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Long getTargetIcan() {
        return targetIcan;
    }

    public DirectDebit setTargetIcan(Long targetIcan) {
        this.targetIcan = targetIcan;
        return this;
    }

    public Type getType() {
        return type;
    }

    public DirectDebit setType(Type type) {
        this.type = type;
        return this;
    }

    
}
