package pro.mqithelp.hw2dot5.service;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import pro.mqithelp.hw2dot5.exception.EmployeeAlreadyAddedException;
import pro.mqithelp.hw2dot5.exception.EmployeeArrayIsFull;
import pro.mqithelp.hw2dot5.exception.EmployeeDepartmentNotFoundException;
import pro.mqithelp.hw2dot5.exception.EmployeeNotFoundException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        if (employees.size() >= MAX_EMPLYEE) {
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

    @Override
    public String getMaxSalaryByDepartment(Integer departmentId) {
        int indexMaxSalary;
        String result;
        List<Employee> salaryList =
                employees.entrySet()
                        .stream()
                        .map(Map.Entry::getValue)
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .sorted(Comparator.comparingInt(Employee::getSalary))
                        .collect(Collectors.toList());

        if (salaryList.size() == 0) throw new EmployeeDepartmentNotFoundException();
        indexMaxSalary = salaryList.size() - 1;
        result = "Сотрудники отдела " + departmentId + ":\n" + salaryList;
        return "Максимальная зарплата в отделе " + departmentId + " у " + salaryList.get(indexMaxSalary) + " - \n " + result;
    }

    @Override
    public String getMinSalaryByDepartment(Integer departmentId) {
        String result;
        List<Employee> salaryList =
                employees.entrySet()
                        .stream()
                        .map(Map.Entry::getValue)
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .sorted(Comparator.comparingInt(Employee::getSalary))
                        .collect(Collectors.toList());

        if (salaryList.size() == 0) throw new EmployeeDepartmentNotFoundException();
        result = "Сотрудники отдела " + departmentId + ":\n" + salaryList;
        return "Минимальная зарплата в отделе " + departmentId + " у " + salaryList.get(0) + " - \n " + result;
    }

    @Override
    public String getAll(Integer departmentId) {
        return "all" + departmentId;
    }

    @Override
    public String getAll() {
        String result = employees.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.groupingBy(Employee::getDepartmentId,Collectors.mapping(Employee::getByDepartment,Collectors.joining()))).toString();
               //.map(e -> e.getByDepartment()).collect(Collectors.joining(" === "));
//                .collect(Collectors.toList()
return result;
    }

    private void setFullNameKey(String name, String surname) {
        fullNameKey = name + surname + "Key";
    }


}
