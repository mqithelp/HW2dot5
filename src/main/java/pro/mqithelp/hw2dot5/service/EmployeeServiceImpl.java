package pro.mqithelp.hw2dot5.service;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private Employee employee = new Employee("dfd","sdfsdf");


    public String getFullName() {
        return employee.toString();
    }

}
