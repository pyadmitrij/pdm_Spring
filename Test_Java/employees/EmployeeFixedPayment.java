package com.pdm.employees;

public class EmployeeFixedPayment extends Employee {

    private double fixedMonthPayment;

    public EmployeeFixedPayment(int id, String name, double fixedMonthPayment) {
        super(id, name);
        this.fixedMonthPayment = fixedMonthPayment;
        setAverageMonthSalary();
    }

    public double getFixedMonthPayment() {
        return fixedMonthPayment;
    }

    public void setFixedMonthPayment(double fixedMonthPayment) {
        this.fixedMonthPayment = fixedMonthPayment;
    }

    public void setAverageMonthSalary() {
        averageMonthSalary = fixedMonthPayment;
    }
}
