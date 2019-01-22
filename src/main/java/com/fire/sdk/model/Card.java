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
