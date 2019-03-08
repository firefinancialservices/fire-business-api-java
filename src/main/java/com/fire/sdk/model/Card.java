package com.fire.sdk.model;

import java.util.Date;

public class Card {
    private long cardId;
    private String provider;
    private String alias;
    private String maskedPan;
    private String firstName;
    private String lastName;
    private String businessName;
    private Date expiryDate;
    private Boolean blocked;
    private String dateCreated;
    private Long eurIcan;
    private Long gbpIcan;
    private String status;
    private String statusReason;
    private Long userId;
    
    
    
    
    public Boolean getBlocked() {
        return blocked;
    }
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }
    public String getDateCreated() {
        return dateCreated;
    }
    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
    public Long getEurIcan() {
        return eurIcan;
    }
    public void setEurIcan(Long eurIcan) {
        this.eurIcan = eurIcan;
    }
    public Long getGbpIcan() {
        return gbpIcan;
    }
    public void setGbpIcan(Long gbpIcan) {
        this.gbpIcan = gbpIcan;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatusReason() {
        return statusReason;
    }
    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public long getCardId() {
        return cardId;
    }
    public Card setCardId(long cardId) {
        this.cardId = cardId;
        return this;
    }
    public String getProvider() {
        return provider;
    }
    public Card setProvider(String provider) {
        this.provider = provider;
        return this;
    }
    public String getAlias() {
        return alias;
    }
    public Card setAlias(String alias) {
        this.alias = alias;
        return this;
    }
    public String getMaskedPan() {
        return maskedPan;
    }
    public Card setMaskedPan(String maskedPan) {
        this.maskedPan = maskedPan;
        return this;
    }
    public String getFirstName() {
        return firstName;
    }
    public Card setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }
    public String getLastName() {
        return lastName;
    }
    public Card setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public String getBusinessName() {
        return businessName;
    }
    public Card setBusinessName(String businessName) {
        this.businessName = businessName;
        return this;
    }
    public Date getExpiryDate() {
        return expiryDate;
    }
    public Card setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }
    
    
}
