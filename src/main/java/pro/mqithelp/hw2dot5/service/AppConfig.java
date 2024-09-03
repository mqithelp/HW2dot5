package pro.mqithelp.hw2dot5.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Configuration
public class AppConfig {
    @Bean
    public static Map<Integer, Employee> initEmployee() {

        List<Employee> persons = new ArrayList(List.of(
                new Employee("Bill", "Gates", 456),
                new Employee("Steve", "Jobs", 123),
                new Employee("Mark", "Zuckerberg", 3232),
                new Employee("Jeff", "Bezos", 1234),
                new Employee("Larry", "Page", 234),
                new Employee("Sergey", "Brin", 345),
                new Employee("Elon", "Musk", 678),
                new Employee("Satya", "Nadella", 900),
                new Employee("Tim", "Cook", 912),
                new Employee("Eric", "Schmidt", 913)));

        Map<Integer, Employee> map = persons.stream()
                .collect(Collectors.toMap(Employee::getPassport, employee -> employee));


//        Map<Integer, Employee> map = new HashMap<>(persons.size()); //persons.stream().collect(Collectors.toMap(Object::hashCode, Function.identity()));
//        persons.forEach(item -> map.put(Objects.hash(), new Employee(item.getName(), item.getSurname(), item.getPassport())));
        return map;
    }
}
