package com.pdm.employees;

public abstract class Employee {

    protected int id;
    protected String name;
    protected double averageMonthSalary;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAverageMonthSalary() {
        return averageMonthSalary;
    }

    public abstract void setAverageMonthSalary();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + averageMonthSalary +
                '}';
    }
}
