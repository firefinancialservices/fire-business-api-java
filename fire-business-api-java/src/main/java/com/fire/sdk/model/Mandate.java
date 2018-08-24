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

    public void setAlias(String alias) {
        this.alias = alias;
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

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getMandateReference() {
        return mandateReference;
    }

    public void setMandateReference(String mandateReference) {
        this.mandateReference = mandateReference;
    }

    public String getMandateUuid() {
        return mandateUuid;
    }

    public void setMandateUuid(String mandateUuid) {
        this.mandateUuid = mandateUuid;
    }

    public Integer getNumberOfDirectDebitsCollected() {
        return numberOfDirectDebitsCollected;
    }

    public void setNumberOfDirectDebitsCollected(Integer numberOfDirectDebitsCollected) {
        this.numberOfDirectDebitsCollected = numberOfDirectDebitsCollected;
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

    public Long getValueOfDirectDebitsCollected() {
        return valueOfDirectDebitsCollected;
    }

    public void setValueOfDirectDebitsCollected(Long valueOfDirectDebitsCollected) {
        this.valueOfDirectDebitsCollected = valueOfDirectDebitsCollected;
    }
    
    
}
