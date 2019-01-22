package com.fire.sdk.model;

import java.util.Date;

public class BatchItem {
    private String batchItemUuid;
    private Status status;
    private Result result;
    private Date dateCreated;
    private Date lastUpdated;

    
    public Result getResult() {
        return result;
    }

    public BatchItem setResult(Result result) {
        this.result = result;
        return this;
    }

    public static class Result {
        private Long code;
        private String message;
        public Long getCode() {
            return code;
        }
        public Result setCode(Long code) {
            this.code = code;
            return this;
        }
        public String getMessage() {
            return message;
        }
        public Result setMessage(String message) {
            this.message = message;
            return this;
        }
        
        
    }
    
    public String getBatchItemUuid() {
        return batchItemUuid;
    }

    public BatchItem setBatchItemUuid(String batchItemUuid) {
        this.batchItemUuid = batchItemUuid;
        return this;
    }
    
    public Status getStatus() {
        return status;
    }

    public BatchItem setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public BatchItem setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public BatchItem setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

    public enum Status {
        SUBMITTED
    }
    
}

