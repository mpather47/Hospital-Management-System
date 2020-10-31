package com.mpather47.git.entity.account;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {

    @Id
    private String accountId;
    private double balance;
    private String paymentMethod;

    protected Account(){}

    private Account(Builder builder) {
        this.accountId = builder.accountId;
        this.balance = builder.balance;
        this.paymentMethod = builder.paymentMethod;

    }

    public String getAccountId() {
        return accountId; }

    public double getBalance() {
        return balance; }

    public String getPaymentMethod() {
        return paymentMethod; }

    @Override
    public String toString(){

        return "AccountFactory" + "  accountId:  " + accountId
                + "  " + "  balance:  " + balance
                + " " + " paymentMethod  " + paymentMethod ;
    }

    public static class Builder{
        private String accountId;
        private double balance;
        private String paymentMethod;

        public Builder setAccountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder setBalance(double balance) {
            this.balance = balance;
            return this;
        }

        public Builder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public Builder copy(Account account){
            this.accountId = account.accountId;
            this.balance = account.balance;
            this.paymentMethod = account.paymentMethod;
            return this;
        }

        public Account build(){

            return new Account(this);
        }
    }

}

