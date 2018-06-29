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

    public void setResult(Result result) {
        this.result = result;
    }

    public static class Result {
        private Long code;
        private String message;
        public Long getCode() {
            return code;
        }
        public void setCode(Long code) {
            this.code = code;
        }
        public String getMessage() {
            return message;
        }
        public void setMessage(String message) {
            this.message = message;
        }
        
        
    }
    
    public String getBatchItemUuid() {
        return batchItemUuid;
    }

    public void setBatchItemUuid(String batchItemUuid) {
        this.batchItemUuid = batchItemUuid;
    }
    
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public enum Status {
        SUBMITTED
    }
    
}

