package pro.mqithelp.hw2dot5.service;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Map<String, Employee> getAll();

    List<Employee> getAll(Integer departmentId);

    Integer getMaxSalaryByDepartment(Integer departmentId);

    Integer getMinSalaryByDepartment(Integer departmentId);
    Integer getSumByDepartment(Integer departmentId);

}
