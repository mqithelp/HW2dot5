package pro.mqithelp.hw2dot5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.mqithelp.hw2dot5.service.EmployeeService;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String answerHello() {
        return employeeService.getFullName();
    }

}
