package com.mpather47.git.entity.employee;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

@Entity

/**
 * @authour @Pilisa
 * Decription: Entity for Position

 */

public class Job  {
    @Id
    private String jobTittle;

    protected Job(){}

    private Job(Builder builder) {
        this.jobTittle =builder.jobTittle;

    }

    public Job(Position.Builder builder) {
    }


    public String getJobTittle() {
        return jobTittle;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobTittle='" + jobTittle + '\'' +
                '}';
    }
    public static class Builder{
        private String jobTittle;

        public Builder setjobTittle(String  jobTittle) {
            this.jobTittle = jobTittle;
            return this;
        }

        public Builder copy(Job job){
            this.jobTittle =job.jobTittle;
            return this;
        }
        public Job build(){
            return new Job (this);
        }


    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return jobTittle.equals(job.jobTittle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobTittle);
    }
}

