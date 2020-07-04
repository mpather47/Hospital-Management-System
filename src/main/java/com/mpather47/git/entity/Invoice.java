package com.mpather47.git.entity;


public class Invoice {

    private long invoiceNum;
    private Account details;


    public Invoice(Builder builder){

        this.invoiceNum = builder.invoiceNum;
        this.details = builder.details;

    }

    public long getInvoiceNum() {
        return invoiceNum; }

    public Account getDetails(){
        return details; }

    @Override
    public String toString(){


        return "Invoice" + "  invoiceNum: " + invoiceNum + " details " + details ;
    }

    public static class Builder {
        private  long invoiceNum;
        private  Account details;

        public Builder setInvoiceNum(long invoiceNum) {

            this.invoiceNum = invoiceNum;
            return this;
        }

        public Builder setDetails(Account details) {
            this.details = details;
            return this;
        }

        private Builder copy(Invoice invoice){

            this.invoiceNum = invoice.invoiceNum;
            this.details = invoice.details;
            return this;
        }
        public Invoice build(){

            return new Invoice(this);

        }
    }

}
