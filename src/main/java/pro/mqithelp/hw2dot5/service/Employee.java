package pro.mqithelp.hw2dot5.service;

import java.util.Objects;
import java.util.Random;

public class Employee {
    private final String surname;
    private final String name;
    private int departmentId;
    private int salary;

    public int getDepartmentId() {
        return departmentId;
    }

    public int getSalary() {
        return salary;
    }

    public Employee(String name, String surname, int departmentId, int salary) {
        this.surname = surname;
        this.name = name;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public Employee(String name, String surname) {
        this.surname = surname;
        this.name = name;
        Random random = new Random();
        this.departmentId = random.nextInt(7 - 1) + 1;
        this.salary = random.nextInt(200000 - 99999) + 99999;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return name + " " + surname + ". Отдел: " + departmentId + ". Зарплата: " + salary;
    }

    public String getFullNameKey() {
        return name + surname + "Key";
    }

    public String getByDepartment() {
        return name + " " + surname + " зарплата " + salary + "\n";
    }

}
