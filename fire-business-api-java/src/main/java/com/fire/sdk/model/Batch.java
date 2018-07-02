package com.fire.sdk.model;

import java.util.Date;

public class Batch {
    
    private String batchUuid;
    private BatchType type;
    private String status;
    private String sourceName;
    private String batchName;
    private String jobNumber;
    private String callbackUrl;
    private String currency; 
    private Integer numberOfItemsSubmitted; 
    private Long valueOfItemsSubmitted; 
    private Integer numberOfItemsFailed;
    private Long valueOfItemsFailed;
    private Integer numberOfItemsSucceeded;
    private Long valueOfItemsSucceeded;
    private Date lastUpdated;
    private Date dateCreated;
    
    public enum BatchType {
        INTERNAL_TRANSFER, BANK_TRANSFER, NEW_PAYEE
    }
    
    public String getBatchUuid() {
        return batchUuid;
    }
    public Batch setBatchUuid(String batchUuid) {
        this.batchUuid = batchUuid;
        return this;
    }

    public BatchType getType() {
        return type;
    }
    public Batch setType(BatchType type) {
        this.type = type;
        return this;
    }
    public String getStatus() {
        return status;
    }
    public Batch setStatus(String status) {
        this.status = status;
        return this;
    }
    public String getSourceName() {
        return sourceName;
    }
    public Batch setSourceName(String sourceName) {
        this.sourceName = sourceName;
        return this;
    }
    public String getBatchName() {
        return batchName;
    }
    public Batch setBatchName(String batchName) {
        this.batchName = batchName;
        return this;
    }
    public String getJobNumber() {
        return jobNumber;
    }
    public Batch setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber;
        return this;
    }
    public String getCallbackUrl() {
        return callbackUrl;
    }
    public Batch setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
        return this;
    }
    public String getCurrency() {
        return currency;
    }
    public Batch setCurrency(String currency) {
        this.currency = currency;
        return this;
    }
    public Integer getNumberOfItemsSubmitted() {
        return numberOfItemsSubmitted;
    }
    public Batch setNumberOfItemsSubmitted(Integer numberOfItemsSubmitted) {
        this.numberOfItemsSubmitted = numberOfItemsSubmitted;
        return this;
    }
    public Long getValueOfItemsSubmitted() {
        return valueOfItemsSubmitted;
    }
    public Batch setValueOfItemsSubmitted(Long valueOfItemsSubmitted) {
        this.valueOfItemsSubmitted = valueOfItemsSubmitted;
        return this;
    }
    public Integer getNumberOfItemsFailed() {
        return numberOfItemsFailed;
    }
    public Batch setNumberOfItemsFailed(Integer numberOfItemsFailed) {
        this.numberOfItemsFailed = numberOfItemsFailed;
        return this;
    }
    public Long getValueOfItemsFailed() {
        return valueOfItemsFailed;
    }
    public Batch setValueOfItemsFailed(Long valueOfItemsFailed) {
        this.valueOfItemsFailed = valueOfItemsFailed;
        return this;
    }
    public Integer getNumberOfItemsSucceeded() {
        return numberOfItemsSucceeded;
    }
    public Batch setNumberOfItemsSucceeded(Integer numberOfItemsSucceeded) {
        this.numberOfItemsSucceeded = numberOfItemsSucceeded;
        return this;
    }
    public Long getValueOfItemsSucceeded() {
        return valueOfItemsSucceeded;
    }
    public Batch setValueOfItemsSucceeded(Long valueOfItemsSucceeded) {
        this.valueOfItemsSucceeded = valueOfItemsSucceeded;
        return this;
    }
    public Date getLastUpdated() {
        return lastUpdated;
    }
    public Batch setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }
    public Date getDateCreated() {
        return dateCreated;
    }
    public Batch setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }
    
    
    
}
