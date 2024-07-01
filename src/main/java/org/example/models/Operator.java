package org.example.models;

public class Operator extends BaseModel{

    public Operator(String name, long employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    String name;
    long employeeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }
}
