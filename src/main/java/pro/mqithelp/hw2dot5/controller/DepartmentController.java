package pro.mqithelp.hw2dot5.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.mqithelp.hw2dot5.exception.EmployeeDepartmentNotFoundException;
import pro.mqithelp.hw2dot5.service.DepartmentService;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("max-salary")
    public String getMaxSalary(@RequestParam("departmentId") Integer departmentId) {
        try {
            return departmentService.getMaxSalaryByDepartment(departmentId);
        } catch (EmployeeDepartmentNotFoundException e) {
            return "Департамент не найден.";
        }
    }
    @GetMapping("min-salary")
    public String getMinSalary(@RequestParam("departmentId") Integer departmentId) {
        try {
            return departmentService.getMinSalaryByDepartment(departmentId);
        } catch (EmployeeDepartmentNotFoundException e) {
            return "Департамент не найден.";
        }
    }

    @GetMapping("all")
    public String getAll(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        if (departmentId != null) {
            try {
                return departmentService.getAll(departmentId);
            } catch (EmployeeDepartmentNotFoundException e) {
                return "Департамент не найден.";
            }
        }
        return departmentService.getAll();
    }
}
