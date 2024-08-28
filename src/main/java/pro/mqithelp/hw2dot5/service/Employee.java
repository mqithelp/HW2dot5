package pro.mqithelp.hw2dot5.service;

import org.springframework.stereotype.Service;

import java.util.Objects;

public class Employee {
    private static int count;
    private int id;
    private final String surname;
    private final String name;

    public Employee(String surname, String name) {
        this.name = name;
        this.surname = surname;
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
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
        return Objects.hash(id, name, surname);
    }

    @Override
    public String toString() {
        return "id=" + getId() +
                "\tФИО: " + surname + ' ' + name + '.';
    }

}
