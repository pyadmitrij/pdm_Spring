package com.pdm.employees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String... args) throws IOException {

        List<Employee> list = new ArrayList<>();
        EmployeesUtils utils = new EmployeesUtils();
        FileWorker worker = new FileWorker();
        String fileName = "employees.txt";

        Employee ef1 = new EmployeeFixedPayment(1, "Dmutro", 3328.0);
        Employee ef2 = new EmployeeFixedPayment(2, "Roman", 3630.0);
        Employee ef3 = new EmployeeFixedPayment(3, "Olga", 4160.0);
        Employee ef4 = new EmployeeFixedPayment(4, "Paul", 5540.0);
        Employee ef5 = new EmployeeFixedPayment(5, "Ira", 5824.0);

        Employee eh1 = new EmployeeHourPayment(6, "Alex", 20);
        Employee eh2 = new EmployeeHourPayment(7, "Vova", 25.0);
        Employee eh3 = new EmployeeHourPayment(8, "Slavik", 30.0);
        Employee eh4 = new EmployeeHourPayment(9, "Julia", 40.0);
        Employee eh5 = new EmployeeHourPayment(10, "Uriy", 45.0);

        list.add(ef1);
        list.add(ef2);
        list.add(ef3);
        list.add(ef4);
        list.add(ef5);

        list.add(eh1);
        list.add(eh2);
        list.add(eh3);
        list.add(eh4);
        list.add(eh5);

        utils.printAllList(list);
        System.out.println();

        utils.sortList(list);
        utils.printAllList(list);
        System.out.println();

        worker.printToFile(list, fileName);

        utils.infoFiveEmployee(list);
        System.out.println();

        utils.threeLastEmployee(list);

        System.out.println();
        worker.readerWithFile(fileName);

    }
}
