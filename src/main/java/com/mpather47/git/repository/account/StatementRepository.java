package com.mpather47.git.repository.account;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.repository.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
@Repository
public interface StatementRepository extends JpaRepository<Statement, String> {
}
