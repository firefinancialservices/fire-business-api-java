package com.fire.sdk.model;

/**
 * {
 *     "type":"ECOMMERCE_SERVICES",
 *     "code": "",
 *     "ican": 10901,
 *     "currency":"EUR",
 *     "amount":32000,
 *     "myRef":"Fees",
 *     "
 * ":"Colm testing PIS_ECOMMERCE_SERVICES",
 *     "maxNumberPayments":1,
 *     "maxNumberCustomerPayments":1,
 *     "returnUrl":"https://www.google.com/response",
 *     "orderDetails":
 *     {
 *          "orderId":"order id here 15415115",
 *          "productId":"987654411",
 *          "customerNumber":"123645",
 *          "variableReference":"variable reference here",
 *          "comment1":"comment 1 here",
 *          "comment2":"comment 2 here",
 *          "merchantCustomerIdentification":"08303863544",
 *          "deliveryAddressLine1":"The Street",
 *          "deliveryAddressLine2":"The Way",
 *          "deliveryCity":"London",
 *          "deliveryPostCode":"EC15155",
 *          "deliveryCountry":"GB"
 *     }
 * }
 */
public class PaymentRequest {
    String type;
    Long icanTo;
    String code;
    String currency;
    Long amount;
    String myRef;
    String description;
    Integer maxNumberPayments;
    Integer maxNumberCustomerPayments;
    String returnUrl;
    OrderDetails orderDetails;

    public Long getIcanTo() {
        return icanTo;
    }

    public PaymentRequest setIcanTo(Long icanTo) {
        this.icanTo = icanTo;
        return this;
    }

    public String getCode() {
        return code;
    }

    public PaymentRequest setCode(String code) {
        this.code = code;
        return this;
    }

    public String getType() {
        return type;
    }

    public PaymentRequest setType(String type) {
        this.type = type;
        return this;
    }

    public String getCurrency() {
        return currency;
    }

    public PaymentRequest setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public Long getAmount() {
        return amount;
    }

    public PaymentRequest setAmount(Long amount) {
        this.amount = amount;
        return this;
    }

    public String getMyRef() {
        return myRef;
    }

    public PaymentRequest setMyRef(String myRef) {
        this.myRef = myRef;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PaymentRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getMaxNumberPayments() {
        return maxNumberPayments;
    }

    public PaymentRequest setMaxNumberPayments(Integer maxNumberPayments) {
        this.maxNumberPayments = maxNumberPayments;
        return this;
    }

    public Integer getMaxNumberCustomerPayments() {
        return maxNumberCustomerPayments;
    }

    public PaymentRequest setMaxNumberCustomerPayments(Integer maxNumberCustomerPayments) {
        this.maxNumberCustomerPayments = maxNumberCustomerPayments;
        return this;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public PaymentRequest setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public PaymentRequest setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
        return this;
    }


}
