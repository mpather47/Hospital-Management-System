package com.mpather47.git.controller.account;

import com.mpather47.git.entity.account.Statement;
import com.mpather47.git.factory.account.StatementFactory;
import com.mpather47.git.services.account.impl.StatementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/statement")
public class StatementController {

    @Autowired
    private StatementServiceImpl statementService;

    @PostMapping("/create")
    public Statement create(@RequestBody Statement statement){
        Statement newStatement = StatementFactory.createStatement(
                statement.getDate(),
                statement.getPaymentDue(),
                statement.getDetails());
        return statementService.create(newStatement);
    }

    @GetMapping("/read{id}")
    public Statement read(@PathVariable String id){
        return statementService.read(id);
    }

    @PostMapping("/update")
    public Statement update(@RequestBody Statement statement){
        return statementService.update(statement);
    }

    @GetMapping("/all")
    public Set<Statement> getAll(){
        return statementService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return statementService.delete(id);
    }
}
