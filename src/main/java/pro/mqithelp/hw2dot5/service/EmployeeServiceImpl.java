package pro.mqithelp.hw2dot5.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private Map<Integer, Employee> employees = new HashMap<>();

    public EmployeeServiceImpl() {
        this.employees = AppConfig.initEmployee();
    }

    @Override
    public String removeEmployee(String name, String surname, Integer passportNumber) {
        Employee person = new Employee(name, surname,passportNumber);

        employees.remove(person);
//        int indexDelPerson = employees.indexOf(person);
//        if (indexDelPerson > -1) {
//            employees.remove(indexDelPerson);
//            return "Сотрудник " + new Gson().toJson(person) + " удалён.";
//        }
//        throw new EmployeeNotFoundException();
        return  "removed employee";
    }

    @Override
    public String addEmployee(String name, String surname, Integer passportNumber) {
//        if (employees.size() >= MAX_EMPLYEE) {
//            throw new EmployeeArrayIsFull();
//        }
//        Employee person = new Employee(name, surname);
//        if (employees.indexOf(person) == -1) {
//            employees.add(person);
//            return "Сотрудник добавлен:\n" + new Gson().toJson(person);
//        }
//        throw new EmployeeAlreadyAddedException();
        return  "added employee";
    }

    @Override
    public String findEmployee(String name, String surname, Integer passportNumber) {
//        Employee person = new Employee(name, surname);
//        if (employees.indexOf(person) > -1) {
//            return "Сотрудник найден:\n" + new Gson().toJson(person);
//        }
//        throw new EmployeeNotFoundException();
        return  "found employee";
    }

    @Override
    public String allEmployee() {
        return "Наши сотрудники: \n" + new Gson().toJson(employees);
    }

}
