package com.fire.sdk.model;

import java.util.Date;

public class Mandate {
    private String alias;
    private Currency currency;
    private Date dateCreated;
    private Date lastUpdated;
    private String mandateReference;
    private String mandateUuid;
    private Integer numberOfDirectDebitsCollected;
    private String originatorName;
    private String originatorReference;
    private Status status;
    private Long targetIcan;
    private Long valueOfDirectDebitsCollected;
    
    enum Status {
        ACTIVE, CREATED, REJECT_REQUESTED, REJECT_RECORD_IN_PROGRESS, REJECT_RECORDED, 
        REJECT_FILE_CREATED, REJECT_FILE_SENT, CANCEL_REQUESTED, CANCEL_RECORD_IN_PROGRESS,
        CANCEL_RECORDED, CANCEL_FILE_CREATED, CANCEL_FILE_SENT, COMPLETE, DORMANT
    }

    public String getAlias() {
        return alias;
    }

    public Mandate setAlias(String alias) {
        this.alias = alias;
        return this;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Mandate setCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Mandate setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public Mandate setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public String getMandateReference() {
        return mandateReference;
    }

    public Mandate setMandateReference(String mandateReference) {
        this.mandateReference = mandateReference;
        return this;
    }

    public String getMandateUuid() {
        return mandateUuid;
    }

    public Mandate setMandateUuid(String mandateUuid) {
        this.mandateUuid = mandateUuid;
        return this;
    }

    public Integer getNumberOfDirectDebitsCollected() {
        return numberOfDirectDebitsCollected;
    }

    public Mandate setNumberOfDirectDebitsCollected(Integer numberOfDirectDebitsCollected) {
        this.numberOfDirectDebitsCollected = numberOfDirectDebitsCollected;
        return this;
    }

    public String getOriginatorName() {
        return originatorName;
    }

    public Mandate setOriginatorName(String originatorName) {
        this.originatorName = originatorName;
        return this;
    }

    public String getOriginatorReference() {
        return originatorReference;
    }

    public Mandate setOriginatorReference(String originatorReference) {
        this.originatorReference = originatorReference;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Mandate setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Long getTargetIcan() {
        return targetIcan;
    }

    public Mandate setTargetIcan(Long targetIcan) {
        this.targetIcan = targetIcan;
        return this;
    }

    public Long getValueOfDirectDebitsCollected() {
        return valueOfDirectDebitsCollected;
    }

    public Mandate setValueOfDirectDebitsCollected(Long valueOfDirectDebitsCollected) {
        this.valueOfDirectDebitsCollected = valueOfDirectDebitsCollected;
        return this;
    }
    
    
}
