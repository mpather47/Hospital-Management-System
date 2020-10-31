package com.mpather47.git.entity.account;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Statement {

    @Id
    private String statementNum;
    private String  date;
    private double paymentDue;
    private transient Account details;


    protected Statement(){}

    private Statement(Builder builder){
        this.statementNum = builder.statementNum;
        this.paymentDue = builder.paymentDue;
        this.date = builder.date;
        this.details = builder.details;

    }

    public String getStatementNum() { return statementNum; }

    public String getDate() {
        return date;
    }

    public Double getPaymentDue() {
        return paymentDue;
    }

    public Account getDetails() { return details; }

    @Override
    public String toString() {
        return "Statement{" +
                "statementNum='" + statementNum + '\'' +
                ", date='" + date + '\'' +
                ", paymentDue=" + paymentDue +
                ", details=" + details +
                '}';
    }

    public static class Builder {

        private String statementNum;
        private String date;
        private double paymentDue;
        private Account details;

        public Builder setStatementNum(String statementNum) {
            this.statementNum = statementNum;
            return this;
        }

        public Builder setDate(String date) {

            this.date = date;
            return this;
        }

        public Builder setPaymentDue(double paymentDue) {

            this.paymentDue = paymentDue;
            return this;
        }

        public Builder setDetails(Account details) {
            this.details = details;
            return this;
        }


        public Builder copy(Statement statement){
            this.statementNum = statement.statementNum;
            this.date = statement.date;
            this.paymentDue = statement.paymentDue;
            this.details = statement.details;
            return this;
        }

        public Statement build(){

            return new Statement(this);

        }


    }
}
