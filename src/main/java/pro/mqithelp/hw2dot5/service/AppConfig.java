package pro.mqithelp.hw2dot5.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;
import java.util.Map;
@Configuration
public class AppConfig {
    @Bean
    public static Map<Integer, Employee> initEmployee() {
        Map<Integer, Employee> map = new HashMap<>();
        map.put(1, new Employee("Bill", "Gates"));
        map.put(2,new Employee("Steve", "Jobs"));
        map.put(3,new Employee("Mark", "Zuckerberg"));
        map.put(4,new Employee("Jeff", "Bezos"));
        map.put(5,new Employee("Larry", "Page"));
        map.put(6,new Employee("Sergey", "Brin"));
        map.put(7,new Employee("Elon", "Musk"));
        map.put(8,new Employee("Satya", "Nadella"));
        map.put(9,new Employee("Tim", "Cook"));
        map.put(10,new Employee("Eric", "Schmidt"));
        return map;
    }
}
