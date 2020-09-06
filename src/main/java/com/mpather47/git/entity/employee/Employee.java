package com.mpather47.git.entity.employee;

import java.util.List;

public class Employee {
    private String employeeID;
    private String education;
    private String certification;
    private List<String> languages;

    public Employee(EmployeeBuilder employeeBuilder){
        this.employeeID = employeeBuilder.employeeID;
        this.education = employeeBuilder.education;
        this.certification = employeeBuilder.certification;
        this.languages = employeeBuilder.languages;
    }

    public String getEducation() {
        return education;
    }

    public String getCertification() {
        return certification;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID='" + employeeID + '\'' +
                ", education='" + education + '\'' +
                ", certification='" + certification + '\'' +
                ", languages=" + languages +
                '}';
    }

    public static class EmployeeBuilder{
        private String employeeID;
        private String education;
        private String certification;
        private List<String> languages;


        public EmployeeBuilder(){}

        public EmployeeBuilder setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public EmployeeBuilder setEducation(String education) {
            this.education = education;
            return this;
        }

        public EmployeeBuilder setCertification(String certification) {
            this.certification = certification;
            return this;
        }

        public EmployeeBuilder setLanguages(List<String> languages) {
            this.languages = languages;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }

        public EmployeeBuilder copy(Employee employee){
            this.employeeID = employee.employeeID;
            this.education = employee.education;
            this.certification = employee.certification;
            this.languages = employee.languages;
            return this;
        }
    }

}
