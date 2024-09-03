package pro.mqithelp.hw2dot5.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

public class Employee {
    private final String surname;
    private final String name;

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public Integer getPassport() {
        return passport;
    }

    private Integer passport;

    public Employee(String name, String surname, Integer passport) {
        this.name = name;
        this.surname = surname;
        this.passport = passport;
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
        return name + " " + surname + " Паспорт: " + getPassport() + " \n";
    }

}
