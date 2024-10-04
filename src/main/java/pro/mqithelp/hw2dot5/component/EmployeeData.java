package pro.mqithelp.hw2dot5.component;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import pro.mqithelp.hw2dot5.service.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EmployeeData {
  private Map<String, Employee> employees;
//    private Map<String, Employee> employees = new HashMap<>();


    public Map<String, Employee> getEmployees() {
        return employees;
    }

    @PostConstruct
    public void init() {
        List<Employee> persons = new ArrayList<>(List.of(
                new Employee("Bill", "Gates", 1, 100000),
                new Employee("Steve", "Jobs", 2, 120000),
                new Employee("Mark", "Zuckerberg", 3, 110000),
                new Employee("Jeff", "Bezos", 4, 130000),
                new Employee("Larry", "Page", 1, 115000),
                new Employee("Sergey", "Brin", 5, 115000),
                new Employee("Elon", "Musk", 5, 150000),
                new Employee("Satya", "Nadella", 2, 125000),
                new Employee("Tim", "Cook", 1, 140000),
                new Employee("Eric", "Schmidt", 1, 135000)
        ));
        employees = persons.stream()
                .collect(Collectors.toMap(Employee::getFullNameKey, employee -> employee));
    }
}
