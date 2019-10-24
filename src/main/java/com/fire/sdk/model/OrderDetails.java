package com.fire.sdk.model;

public class OrderDetails {
        String orderId;
        String productId;
        String customerNumber;
        String variableReference;
        String comment1;
        String comment2;
        String merchantCustomerIdentification;
        String deliveryAddressLine1;
        String deliveryAddressLine2;
        String deliveryCity;
        String deliveryPostCode;
        String deliveryCountry;

        public String getOrderId() {
            return orderId;
        }

        public OrderDetails setOrderId(String orderId) {
            this.orderId = orderId;
            return this;
        }

        public String getProductId() {
            return productId;
        }

        public OrderDetails setProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public String getCustomerNumber() {
            return customerNumber;
        }

        public OrderDetails setCustomerNumber(String customerNumber) {
            this.customerNumber = customerNumber;
            return this;
        }

        public String getVariableReference() {
            return variableReference;
        }

        public OrderDetails setVariableReference(String variableReference) {
            this.variableReference = variableReference;
            return this;
        }

        public String getComment1() {
            return comment1;
        }

        public OrderDetails setComment1(String comment1) {
            this.comment1 = comment1;
            return this;
        }

        public String getComment2() {
            return comment2;
        }

        public OrderDetails setComment2(String comment2) {
            this.comment2 = comment2;
            return this;
        }

        public String getMerchantCustomerIdentification() {
            return merchantCustomerIdentification;
        }

        public OrderDetails setMerchantCustomerIdentification(String merchantCustomerIdentification) {
            this.merchantCustomerIdentification = merchantCustomerIdentification;
            return this;
        }

        public String getDeliveryAddressLine1() {
            return deliveryAddressLine1;
        }

        public OrderDetails setDeliveryAddressLine1(String deliveryAddressLine1) {
            this.deliveryAddressLine1 = deliveryAddressLine1;
            return this;
        }

        public String getDeliveryAddressLine2() {
            return deliveryAddressLine2;
        }

        public OrderDetails setDeliveryAddressLine2(String deliveryAddressLine2) {
            this.deliveryAddressLine2 = deliveryAddressLine2;
            return this;
        }

        public String getDeliveryCity() {
            return deliveryCity;
        }

        public OrderDetails setDeliveryCity(String deliveryCity) {
            this.deliveryCity = deliveryCity;
            return this;
        }

        public String getDeliveryPostCode() {
            return deliveryPostCode;
        }

        public OrderDetails setDeliveryPostCode(String deliveryPostCode) {
            this.deliveryPostCode = deliveryPostCode;
            return this;
        }

        public String getDeliveryCountry() {
            return deliveryCountry;
        }

        public OrderDetails setDeliveryCountry(String deliveryCountry) {
            this.deliveryCountry = deliveryCountry;
            return this;
        }
    }