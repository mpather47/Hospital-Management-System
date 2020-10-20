package com.mpather47.git.entity.hospital;

public class Department {
    private int departmentId;
    private int employeeId;
    private String ward;
    private String role;

    public Department(DepartmentBuilder departmentBuilder){
        this.departmentId = departmentBuilder.departmentId;
        this.employeeId = departmentBuilder.employeeId;
        this.ward = departmentBuilder.ward;
        this.role = departmentBuilder.role;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getWard() {
        return ward;
    }

    public String getRole() {
        return role;
    }


    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", employeeId=" + employeeId +
                ", ward='" + ward + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public static class DepartmentBuilder{
        private int departmentId;
        private int employeeId;
        private String ward;
        private String role;

        public DepartmentBuilder(){}

        public DepartmentBuilder setDepartmentId(int departmentId) {
            this.departmentId = departmentId;
            return this;
        }

        public DepartmentBuilder setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
            return this;
        }

        public DepartmentBuilder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public DepartmentBuilder setRole(String role) {
            this.role = role;
            return this;
        }

        public Department build(){
            return new Department(this);
        }

        public DepartmentBuilder copy(Department department){
            this.departmentId = department.departmentId;
            this.employeeId = department.employeeId;
            this.role = department.role;
            this.ward = department.ward;
            return this;
        }
    }


}
