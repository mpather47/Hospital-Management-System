package com.mpather47.git.services.account;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.services.IService;

import java.util.Set;

public interface StatementService extends IService<Statement,String> {

    Set<Statement> getAll();
}
