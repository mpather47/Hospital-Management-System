package com.mpather47.git.repository.account;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.repository.IRepository;

import java.util.Set;

public interface StatementRepository extends IRepository<Statement, String> {

    Set<Statement> getAll();
}
