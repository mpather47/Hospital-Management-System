package com.mpather47.git.repository.account;

import com.mpather47.git.entity.account.Account;
import com.mpather47.git.repository.IRepository;
import java.util.Set;

public interface AccountRepository extends IRepository<Account, String> {

    Set<Account>getll();
}
