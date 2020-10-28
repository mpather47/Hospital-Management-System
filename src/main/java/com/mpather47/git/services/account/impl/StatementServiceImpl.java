package com.mpather47.git.services.account.impl;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.repository.account.StatementRepository;
import com.mpather47.git.services.account.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StatementServiceImpl implements StatementService {

    @Autowired
    private StatementRepository repository;


    @Override
    public Set<Statement> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Statement create(Statement statement) {
        return this.repository.save(statement);
    }

    @Override
    public Statement read(String s) {
        return this.repository.findById(s).orElseGet(null);
    }

    @Override
    public Statement update(Statement statement) {
        if(this.repository.existsById(statement.getStatementNum())){
            return this.repository.save(statement);
        }
        return null;
    }

    @Override
    public boolean delete(String s) {
        this.repository.deleteById(s);
        if(this.repository.existsById(s))return false;
        else return true;

    }
}
