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
                new Employee("Bill", "Gates"),
                new Employee("Steve", "Jobs"),
                new Employee("Mark", "Zuckerberg"),
                new Employee("Jeff", "Bezos"),
                new Employee("Larry", "Page"),
                new Employee("Sergey", "Brin"),
                new Employee("Elon", "Musk"),
                new Employee("Satya", "Nadella"),
                new Employee("Tim", "Cook"),
                new Employee("Eric", "Schmidt")
        ));

        return persons.stream()
                .collect(Collectors.toMap(Employee::getFullNameKey, employee -> employee));
    }
}
