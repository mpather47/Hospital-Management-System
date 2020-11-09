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
        boolean statementExist = false;
        Statement newStatement = StatementFactory.createStatement(statement.getDate(), statement.getPaymentDue(), statement.getDetails());
        if(statement !=null){
            statementExist = true;
        }
        if(statementExist) {
            return statementService.create(newStatement);
        }
        else return StatementFactory.createStatement(null,0.00,null);
    }

    @GetMapping("/read{id}")
    public Statement read(@PathVariable String id){
        boolean statementExist = false;
        if(id !=null){
            statementExist = true;
        }
        if (statementExist = true) {
            return statementService.read(id);
        }
        else return null;
    }

    @PostMapping("/update")
    public Statement update(@RequestBody Statement statement){
        boolean statementExist = false;
        if(statement !=null) {
            statementExist = true;
        }
        if (statementExist) {
            return statementService.update(statement);
        }
        else return null;
    }

    @GetMapping("/all")
    public Set<Statement> getAll(){
        return statementService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        boolean statementExist = false;
        if(id != null){
            statementExist = true;
        }
        if (statementExist) {
            return statementService.delete(id);
        }
        else return false;
    }
}
