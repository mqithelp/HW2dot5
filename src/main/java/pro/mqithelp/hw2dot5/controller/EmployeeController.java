package pro.mqithelp.hw2dot5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.mqithelp.hw2dot5.exception.EmployeeAlreadyAddedException;
import pro.mqithelp.hw2dot5.exception.EmployeeArrayIsFull;
import pro.mqithelp.hw2dot5.exception.EmployeeDepartmentNotFoundException;
import pro.mqithelp.hw2dot5.exception.EmployeeNotFoundException;
import pro.mqithelp.hw2dot5.service.EmployeeService;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String allPersons() {
        return employeeService.allEmployee();
    }

    @GetMapping("add")
    public String add(@RequestParam("firstName") String name,
                      @RequestParam("lastName") String surname) {
        try {
            return employeeService.addEmployee(name, surname);

        } catch (EmployeeAlreadyAddedException e) {
            return "Сотрудник уже есть.\n";
        } catch (EmployeeArrayIsFull e) {
            return "В базе нет места.";
        }
    }

    @GetMapping("remove")
    public String remove(
            @RequestParam("firstName") String name,
            @RequestParam("lastName") String surname) {
        try {
            return employeeService.removeEmployee(name, surname);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден. \n";
        }
    }

    @GetMapping("find")
    public String find(@RequestParam("firstName") String name,
                       @RequestParam("lastName") String surname) {
        try {
            return employeeService.findEmployee(name, surname);
        } catch (EmployeeNotFoundException e) {
            return "Сотрудник не найден. \n";
        }
    }

    @GetMapping("max-salary")
    public String getMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        try {
            return employeeService.getMaxSalaryByDepartment(departmentId);
        } catch (EmployeeDepartmentNotFoundException e) {
            return "Департамент не найден.";
        }
    }

    @GetMapping("min-salary")
    public String getMinSalary(@RequestParam("departmentId") Integer departmentId) {
        try {
            return employeeService.getMinSalaryByDepartment(departmentId);
        } catch (EmployeeDepartmentNotFoundException e) {
            return "Департамент не найден.";
        }
    }

    @GetMapping("all")
    public String getAll(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        if (departmentId != null) {
            try {
                return employeeService.getAll(departmentId);
            } catch (EmployeeDepartmentNotFoundException e) {
                return "Департамент не найден.";
            }
        }
        return employeeService.getAll();
    }
}
