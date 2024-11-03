package pro.mqithelp.hw2dot5.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pro.mqithelp.hw2dot5.component.EmployeeData;
import pro.mqithelp.hw2dot5.exception.EmployeeAlreadyAddedException;
import pro.mqithelp.hw2dot5.exception.EmployeeArrayIsFull;
import pro.mqithelp.hw2dot5.exception.EmployeeNotFoundException;

import static org.apache.commons.lang3.StringUtils.capitalize;
import static org.apache.commons.lang3.StringUtils.isAlpha;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private String fullNameKey = "";
    private final EmployeeData employees;


    public EmployeeServiceImpl(EmployeeData employees) {
        this.employees = employees;
    }

    @Override
    public String removeEmployee(String name, String surname) {
        if (!(isAlpha(name) && isAlpha(surname))) {
            throw new RuntimeException("400 Bad Request");
        }
        setFullNameKey(name, surname);
        if (employees.getEmployees().containsKey(fullNameKey)) {
            employees.getEmployees().remove(fullNameKey);
            return "Сотрудник " + fullNameKey + " удалён. \n" + allEmployee();
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");

    }

    @Override
    public boolean addEmployee(String name, String surname) {
        if (!(isAlpha(name) && isAlpha(surname))) {
            throw new RuntimeException("400 Bad Request");
        }

        if (employees.getEmployees().size() >= MAX_EMPLYEE) {
            throw new EmployeeArrayIsFull();
        }
        setFullNameKey(name, surname);
        if (!employees.getEmployees().containsKey(fullNameKey)) {
            Employee person = new Employee(name, surname);
            employees.getEmployees().put(fullNameKey, person);
            return true;
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public Employee findEmployee(String name, String surname) {
        if (!(isAlpha(name) && isAlpha(surname))) {
            throw new RuntimeException("400 Bad Request. Имя и фамилия должны содержать только буквы.");
        }
        setFullNameKey(name, surname);
        if (employees.getEmployees().containsKey(fullNameKey)) {
            return employees.getEmployees().get(fullNameKey);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден." + name + " " + surname);
    }

    @Override
    public String allEmployee() {
        return "Наши сотрудники: \n" + new Gson().toJson(employees);
    }

    private void setFullNameKey(String name, String surname) {
        fullNameKey = name + surname + "Key";
    }

}
