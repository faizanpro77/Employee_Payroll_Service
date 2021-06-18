package com.bridgelabz;

public class EmployeePayrollData {
    private  String name;
    private int id;
    private double salary;

    public EmployeePayrollData(int id, String name, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "EmployeePayrollData{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
