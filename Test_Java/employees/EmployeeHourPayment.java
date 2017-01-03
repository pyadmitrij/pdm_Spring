package com.pdm.employees;

public class EmployeeHourPayment extends Employee {

    private final int WORK_DAY = 8;
    private final double INTEREST_RATE = 20.8;
    private double hourRate;

    public EmployeeHourPayment(int id, String name, double hourRate) {
        super(id, name);
        this.hourRate = hourRate;
        setAverageMonthSalary();
    }

    public double getHourRate() {
        return hourRate;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public void setAverageMonthSalary() {
        averageMonthSalary = INTEREST_RATE * WORK_DAY * hourRate;
    }
}
