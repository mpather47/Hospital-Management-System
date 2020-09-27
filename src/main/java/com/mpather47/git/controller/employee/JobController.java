package com.mpather47.git.controller.employee;

import com.mpather47.git.entity.employee.Job;
import com.mpather47.git.entity.employee.Position;
import com.mpather47.git.factory.employee.JobFactory;
import com.mpather47.git.services.employee.impl.JobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired

    private JobServiceImpl jobService;

    @PostMapping("/create")
    public Job create(@RequestBody Job job) {

        Job newJob = JobFactory.buildJob(job.getJobTittle());
        return jobService.create(newJob);

    }


    @GetMapping("/read/{id}")
    public Job read(@PathVariable String id) {
        return jobService.read(id);
    }

    @PostMapping("/update")
    public Job update(@RequestBody Job job){
        return jobService.update(job);
    }

    @GetMapping("/all")
    public Set<Job> getall() {

        return jobService.getAll();
    }
    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable String id){
        return jobService.delete(id);
    }
}



