package com.mpather47.git.entity.account;

public class Statement {

    private int statementNum;
    private Account details;


    public Statement(Builder builder){
        this.statementNum = builder.statementNum;
        this.details = builder.details;

    }

    public int getStatementNum() {
        return statementNum; }

    public Account getDetails() {

        return details; }



    public String toString(){

        return "Statement" + "  statementNum: " +
                statementNum + " details: " + details  ;
    }

    public static class Builder {
        private int statementNum;
        private Account details;

        public Builder setStatementNum(int statementNum) {
            this.statementNum = statementNum;
            return this;
        }

        public Builder setDetails(Account details) {
            this.details = details;
            return this;
        }


        public Builder copy(Statement statement){
            this.statementNum = statement.statementNum;
            this.details = statement.details;
            return this;
        }

        public Statement build(){

            return new Statement(this);

        }
    }
}
