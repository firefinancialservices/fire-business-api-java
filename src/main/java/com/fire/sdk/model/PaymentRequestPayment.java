package com.fire.sdk.model;


public class PaymentRequestPayment {
    private String aspspUuid;
    private String currency;
    private Long amount;
    private String myRef;
    private String returnUrl;
    private OrderDetails orderDetails;
    private String paymentUuid;
    private String redirectUrl;
    private String status;
    private String dateCreated;

    public String getPaymentUuid() {
        return paymentUuid;
    }

    public PaymentRequestPayment setPaymentUuid(String paymentUuid) {
        this.paymentUuid = paymentUuid;
        return this;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public PaymentRequestPayment setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PaymentRequestPayment setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public PaymentRequestPayment setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

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
