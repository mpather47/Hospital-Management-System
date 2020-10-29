package com.mpather47.git.services.account.impl;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.repository.account.StatementRepository;
import com.mpather47.git.repository.account.impl.StatementRepositoryImpl;
import com.mpather47.git.services.account.StatementService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class StatementServiceImpl implements StatementService {

    private static StatementService statementService = null;
    private StatementRepository repository;

    private StatementServiceImpl(){

        this.repository = StatementRepositoryImpl.getStatementRepository();
    }

    public static StatementService getStatementService(){
        if(statementService == null) statementService = new StatementServiceImpl();
        return statementService;
    }

    @Override
    public Set<Statement> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Statement create(Statement statement) {
        return this.repository.create(statement);
    }

    @Override
    public Statement read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Statement update(Statement statement) {
        return this.repository.update(statement);
    }

    @Override
    public boolean delete(String s) {
        return this.repository.delete(s);
    }
}
