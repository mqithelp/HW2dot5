package pro.mqithelp.hw2dot5.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pro.mqithelp.hw2dot5.exception.EmployeeAlreadyAddedException;
import pro.mqithelp.hw2dot5.exception.EmployeeArrayIsFull;
import pro.mqithelp.hw2dot5.exception.EmployeeNotFoundException;

import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private String fullNameKey = "";
    private final Map<String, Employee> employees;

    public EmployeeServiceImpl() {
        this.employees = AppConfig.initEmployee();
    }

    @Override
    public String removeEmployee(String name, String surname) {
        setFullNameKey(name, surname);
        if (employees.containsKey(fullNameKey)) {
            employees.remove(fullNameKey);
            return "Сотрудник " + fullNameKey + " удалён. \n" + allEmployee();
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    public String addEmployee(String name, String surname) {
        if (employees.size()  >= MAX_EMPLYEE) {
            throw new EmployeeArrayIsFull();
        }
        setFullNameKey(name, surname);
        if (!employees.containsKey(fullNameKey)) {
            Employee person = new Employee(name, surname);
            employees.put(fullNameKey, person);
            return "Сотрудник добавлен:\n" + new Gson().toJson(person) + "\n" + allEmployee();
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public String findEmployee(String name, String surname) {
        setFullNameKey(name, surname);
        if (employees.containsKey(fullNameKey)) {
            return "Сотрудник найден:\n" + new Gson().toJson(fullNameKey) + "\n" + allEmployee();
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public String allEmployee() {
        return "Наши сотрудники: \n" + new Gson().toJson(employees);
    }

    private void setFullNameKey(String name, String surname) {
        fullNameKey = name + " " + surname;
    }

}
