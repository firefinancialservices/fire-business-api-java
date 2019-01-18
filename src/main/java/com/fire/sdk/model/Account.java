package com.fire.sdk.model;

public class Account {
    private Long ican;
    private String name;
    private Long balance;
    private String ciban;
    private String cbic;
    private String cnsc;
    private String ccan;
    private Currency currency;
    private boolean defaultAccount;
    private String status;
    private String colour;
    
    public Long getIcan() {
        return ican;
    }
    public void setIcan(Long ican) {
        this.ican = ican;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getBalance() {
        return balance;
    }
    public void setBalance(Long balance) {
        this.balance = balance;
    }
    public String getCiban() {
        return ciban;
    }
    public void setCiban(String ciban) {
        this.ciban = ciban;
    }
    public String getCbic() {
        return cbic;
    }
    public void setCbic(String cbic) {
        this.cbic = cbic;
    }
    public String getCnsc() {
        return cnsc;
    }
    public void setCnsc(String cnsc) {
        this.cnsc = cnsc;
    }
    public String getCcan() {
        return ccan;
    }
    public void setCcan(String ccan) {
        this.ccan = ccan;
    }
    public Currency getCurrency() {
        return currency;
    }
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
    public boolean isDefaultAccount() {
        return defaultAccount;
    }
    public void setDefaultAccount(boolean defaultAccount) {
        this.defaultAccount = defaultAccount;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getColour() {
        return colour;
    }
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    
}
