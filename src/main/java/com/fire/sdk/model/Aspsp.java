package com.fire.sdk.model;

import java.util.Date;

public class Aspsp {
    private String aspspUuid;
    private String alias;
    private String logoUrl;
    private Country country;
    private Currency currency;
    private Date dateCreated;
    private Date lastUpdated;

    public String getAspspUuid() {
        return aspspUuid;
    }

    public void setAspspUuid(String aspspUuid) {
        this.aspspUuid = aspspUuid;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
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
}
