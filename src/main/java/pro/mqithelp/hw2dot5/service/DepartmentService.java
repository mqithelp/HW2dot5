package pro.mqithelp.hw2dot5.service;

public interface DepartmentService {
    String getAll();

    String getAll(Integer departmentId);

    String getMaxSalaryByDepartment(Integer departmentId);

    String getMinSalaryByDepartment(Integer departmentId);
}
