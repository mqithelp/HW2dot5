package pro.mqithelp.hw2dot5.controller;

import org.springframework.web.bind.annotation.*;
import pro.mqithelp.hw2dot5.exception.EmployeeDepartmentNotFoundException;
import pro.mqithelp.hw2dot5.service.DepartmentService;
import pro.mqithelp.hw2dot5.service.Employee;

import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public Collection<Employee> getByID(@PathVariable(value = "id", required = false) Integer departmentId) {
        if (departmentId != null) {
            return departmentService.getAll(departmentId);
        } else {
            throw new EmployeeDepartmentNotFoundException();
        }
    }

    @GetMapping("/{id}/salary/sum")
    public Integer getSumSalaryByDepartment(@PathVariable("id") Integer departmentId) {
        if (departmentId != null) {
            return departmentService.getSumByDepartment(departmentId);
        } else {
            throw new EmployeeDepartmentNotFoundException();
        }
    }

    @GetMapping("{id}/salary/max")
    public Integer getMaxSalary(@PathVariable("id") Integer departmentId) {
        if (departmentId != null) {
            return departmentService.getMaxSalaryByDepartment(departmentId);
        } else {
            throw new EmployeeDepartmentNotFoundException();
        }
    }

    @GetMapping("{id}/salary/min")
    public Integer getMinSalary(@PathVariable("id") Integer departmentId) {
        if (departmentId != null) {
            return departmentService.getMinSalaryByDepartment(departmentId);
        } else {
            throw new EmployeeDepartmentNotFoundException();
        }

    }

    @GetMapping("/employees")
    public Map<String, Employee> getAll() {
        return departmentService.getAll();
    }

}