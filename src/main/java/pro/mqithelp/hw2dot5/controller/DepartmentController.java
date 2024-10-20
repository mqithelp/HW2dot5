package pro.mqithelp.hw2dot5.controller;

import org.springframework.web.bind.annotation.*;
import pro.mqithelp.hw2dot5.exception.EmployeeDepartmentNotFoundException;
import pro.mqithelp.hw2dot5.service.DepartmentService;

@RestController
@RequestMapping(path = "/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public String getByID(@PathVariable(value = "id", required = false) Integer departmentId) {
        if (departmentId != null) {
            try {
                return departmentService.getAll(departmentId);
            } catch (EmployeeDepartmentNotFoundException e) {
                return "Департамент не найден.";
            }
        }
        return departmentService.getAll();
    }

    @GetMapping("/{id}/salary/sum")
    public String getSumSalaryByDepartment(@PathVariable("id") Integer departmentId) {
        try {
            return departmentService.getSumByDepartment(departmentId).toString();
        } catch (EmployeeDepartmentNotFoundException e) {
            return "Департамент не найден.";
        }
    }

    @GetMapping("{id}/salary/max")
    public String getMaxSalary(@PathVariable("id") Integer departmentId) {
        try {
            return departmentService.getMaxSalaryByDepartment(departmentId);
        } catch (EmployeeDepartmentNotFoundException e) {
            return "Департамент не найден.";
        }
    }

    @GetMapping("{id}/salary/min")
    public String getMinSalary(@PathVariable("id") Integer departmentId) {
        try {
            return departmentService.getMinSalaryByDepartment(departmentId);
        } catch (EmployeeDepartmentNotFoundException e) {
            return "Департамент не найден.";
        }
    }

    @GetMapping("/employees")
    public String getAll() {
        return departmentService.getAll();
    }

}