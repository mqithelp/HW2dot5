package pro.mqithelp.hw2dot5.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pro.mqithelp.hw2dot5.exception.EmployeeAlreadyAddedException;
import pro.mqithelp.hw2dot5.exception.EmployeeArrayIsFull;
import pro.mqithelp.hw2dot5.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl(List<Employee> employees) {
        initEmployee(employees);
        this.employees = employees;
    }

    @Override
    public String removeEmployee(String name, String surname) {
        Employee person = new Employee(name, surname);
        int indexDelPerson = employees.indexOf(person);
        if (indexDelPerson > 0) {
            employees.remove(indexDelPerson);
            return "Сотрудник " + new Gson().toJson(person) + " удалён.";
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String addEmployee(String name, String surname) {
        if (employees.size() >= MAX_EMPLYEE) {
            throw new EmployeeArrayIsFull();
        }
        Employee person = new Employee(name, surname);
        if (employees.indexOf(person) == -1) {
            employees.add(person);
            return "Сотрудник добавлен:\n" + new Gson().toJson(person);
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public String findEmployee(String name, String surname) {
        Employee person = new Employee(name, surname);
        if (employees.indexOf(person) > -1) {
            return "Сотрудник найден:\n" + new Gson().toJson(person);
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String allEmployee() {
        String json = new Gson().toJson(employees);
        return "Наши сотрудники: \n" + json;
    }

    private void initEmployee(List<Employee> employees) {
        employees.add(new Employee("Bill", "Gates"));
        employees.add(new Employee("Steve", "Jobs"));
        employees.add(new Employee("Mark", "Zuckerberg"));
        employees.add(new Employee("Jeff", "Bezos"));
        employees.add(new Employee("Larry", "Page"));
        employees.add(new Employee("Sergey", "Brin"));
        employees.add(new Employee("Elon", "Musk"));
        employees.add(new Employee("Satya", "Nadella"));
        employees.add(new Employee("Tim", "Cook"));
        employees.add(new Employee("Eric", "Schmidt"));
    }
}
