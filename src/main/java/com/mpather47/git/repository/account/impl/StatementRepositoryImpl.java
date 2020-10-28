/**
 package com.mpather47.git.repository.account.impl;


 import com.mpather47.git.entity.account.Statement;
 import com.mpather47.git.repository.account.StatementRepository;

 import java.util.HashSet;
 import java.util.Set;

 public class StatementRepositoryImpl implements StatementRepository {

 private static StatementRepository statementRepository = null;
 private Set<Statement> statementDB;

 private StatementRepositoryImpl(){
 this.statementDB = new HashSet<>();
 }

 public static StatementRepository getStatementRepository() {
 if (statementRepository == null) statementRepository = new StatementRepositoryImpl();
 return statementRepository;

 }
 @Override
 public Statement create(Statement statement) {
 this.statementDB.add(statement);
 return statement;
 }

 @Override
 public Statement read(String statementNum) {
 Statement statement = null;
 for(Statement s : this.statementDB){
 if(s.getStatementNum().equalsIgnoreCase(statementNum)){
 statement = s;
 break;
 }
 }

 return  statement;
 }

 @Override
 public Statement update(Statement statement) {
 Statement oldstmDB = read(statement.getStatementNum());

 if(oldstmDB != null){
 this.statementDB.remove(oldstmDB);
 this.statementDB.add(statement);

 }
 return statement;
 }

 @Override
 public boolean delete(String statementNum) {
 Statement statement = read(statementNum);
 if(statement != null) {
 this.statementDB.remove(statement);
 return true;
 }
 return false;
 }

 @Override
 public Set<Statement> getAll() {
 return statementDB;
 }
 }
 **/