package com.mpather47.git.entity.account;

import java.io.Serializable;
public class Invoice {

    private String invoiceNum;
    private String invoiceDate;
    private String description;
    private Account details;

    private Invoice (){}

    private Invoice(Builder builder){
        this.invoiceNum = builder.invoiceNum;
        this.invoiceDate = builder.invoiceDate;
        this.description = builder.description;
        this.details = builder.details;

    }

    public String getInvoiceNum() {
        return invoiceNum; }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public String getDescription() {
        return description;
    }

    public Account getDetails(){
        return details; }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceNum='" + invoiceNum + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", description='" + description + '\'' +
                ", details=" + details +
                '}';
    }

    public static class Builder {
        private String invoiceNum;
        private String invoiceDate;
        private String description;
        private Account details;

        public Builder setInvoiceNum(String invoiceNum) {

            this.invoiceNum = invoiceNum;
            return this;
        }

        public Builder setInvoiceDate(String invoiceDate) {

            this.invoiceDate = invoiceDate;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setDetails(Account details) {
            this.details = details;
            return this;
        }

        public Builder copy(Invoice invoice) {

            this.invoiceNum = invoice.invoiceNum;
            this.invoiceDate = invoice.invoiceDate;
            this.description = invoice.description;
            this.details = invoice.details;
            return this;
        }

        public Invoice build() {

            return new Invoice(this);

        }

    }

}
