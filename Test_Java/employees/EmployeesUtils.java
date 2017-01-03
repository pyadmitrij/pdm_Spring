package com.pdm.employees;

import java.util.List;

public class EmployeesUtils {

    public void printAllList(List<Employee> list) {
        list.stream().forEach(element -> System.out.println(element));
    }

    public List<Employee> sortList(List<Employee> list) {

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++) {
                String name1 = list.get(i).getName();
                String name2 = list.get(j).getName();
                if (name1.compareTo(name2) >= 0) {
                    Employee temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }

        for (int i = 0; i < list.size(); i++)
            for (int j = i + 1; j < list.size(); j++) {
                double salary1 = list.get(i).getAverageMonthSalary();
                double salary2 = list.get(j).getAverageMonthSalary();
                if (salary1 > salary2) {
                    Employee temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }

        return list;
    }

    public void infoFiveEmployee(List<Employee> list) {
        for (int i = 0; i < 5; i++)
            System.out.println(list.get(i));
    }

    public void threeLastEmployee(List<Employee> list) {
        for (int i = list.size() - 1; i > list.size() - 4; i--)
            System.out.println("Employee{id=" + list.get(i).getId() + "}");
    }
}
