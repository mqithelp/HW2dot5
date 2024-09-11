package pro.mqithelp.hw2dot5.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class AppConfig {
    @Bean
    public static Map<String, Employee> initEmployee() {

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

        return persons.stream()
                .collect(Collectors.toMap(Employee::getFullNameKey, employee -> employee));
    }
}
