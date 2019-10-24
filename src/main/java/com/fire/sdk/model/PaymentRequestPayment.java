package com.fire.sdk.model;

public class PaymentRequestPayment {
    private String aspspUuid;
    private String currency;
    private Long amount;
    private String myRef;
    private String returnUrl;
    private OrderDetails orderDetails;

    public String getAspspUuid() {
        return aspspUuid;
    }

    public PaymentRequestPayment setAspspUuid(String aspspUuid) {
        this.aspspUuid = aspspUuid;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public PaymentRequestPayment setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public PaymentRequestPayment setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getMyRef() {
        return myRef;
    }

    public PaymentRequestPayment setMyRef(String myRef) {
        this.myRef = myRef;
        return this;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public PaymentRequestPayment setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public PaymentRequestPayment setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }
}
