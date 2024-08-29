package pro.mqithelp.hw2dot5.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl(List<Employee> employees) {
        initEmployee(employees);
        this.employees = employees;
    }

    public String getFullName(Integer index) {
        return employees.get(index).toString();
    }

    @Override
    public String removeEmployee(String name, String surname) {
        return "Удаляем сотрудника " + name + " " + surname;
    }

    @Override
    public String addEmployee(String name, String surname) {
        return "Добавляем сотрудника " + name + " " + surname;
    }

    @Override
    public String findEmployee(String name, String surname) {
        return "Ищем сотрудника " + name + " " + surname;
    }

    @Override
    public String allEmployee() {
        return "Наши сотрудники: \n" + employees;
    }

    private void initEmployee(List<Employee> employees) {
        employees.add(new Employee("Bill", "Gates"));
        employees.add(new Employee("Steve","Jobs"));
        employees.add(new Employee("Mark","Zuckerberg"));
        employees.add(new Employee("Jeff","Bezos"));
        employees.add(new Employee("Larry","Page"));
        employees.add(new Employee("Sergey","Brin"));
        employees.add(new Employee("Elon","Musk"));
        employees.add(new Employee("Satya","Nadella"));
        employees.add(new Employee("Tim","Cook"));
        employees.add(new Employee("Eric","Schmidt"));
    }
}
