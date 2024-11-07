package pro.mqithelp.hw2dot5.service;

import org.springframework.stereotype.Service;
import pro.mqithelp.hw2dot5.component.EmployeeData;
import pro.mqithelp.hw2dot5.exception.EmployeeDepartmentNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeData departments;

    public DepartmentServiceImpl(EmployeeData departments) {
        this.departments = departments;
    }

    @Override
    public Map<String, Employee> getAll() {
        return departments.getEmployees();
    }

    @Override
    public List<Employee> getAll(Integer departmentId) {
        List<Employee> salaryList =
                departments.getEmployees().values()
                        .stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                        .toList();

        if (salaryList.isEmpty()) {
            throw new EmployeeDepartmentNotFoundException();
        }
        return salaryList;

    }

    @Override
    public Integer getMaxSalaryByDepartment(Integer departmentId) {
        int indexMaxSalary;
        List<Employee> salaryList = departments.getEmployees().values()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .toList();

        if (salaryList.isEmpty()) throw new EmployeeDepartmentNotFoundException();
        indexMaxSalary = salaryList.size() - 1;
        return salaryList.get(indexMaxSalary).getSalary();
    }

    @Override
    public Integer getMinSalaryByDepartment(Integer departmentId) {
        String result;
        List<Employee> salaryList =
                departments.getEmployees().values()
                        .stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .sorted(Comparator.comparingInt(Employee::getSalary))
                        .toList();

        if (salaryList.isEmpty()) {
            throw new EmployeeDepartmentNotFoundException();
        }
        return salaryList.get(0).getSalary();
    }

    @Override
    public Integer getSumByDepartment(Integer departmentId) {
        Integer result;
        result = departments.getEmployees().values()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();

        if (result <= 0) {
            throw new EmployeeDepartmentNotFoundException();
        }
        return result;
    }

}
