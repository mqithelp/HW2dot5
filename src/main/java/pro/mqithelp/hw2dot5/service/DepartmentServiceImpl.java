package pro.mqithelp.hw2dot5.service;

import org.springframework.stereotype.Service;
import pro.mqithelp.hw2dot5.component.EmployeeData;
import pro.mqithelp.hw2dot5.exception.EmployeeDepartmentNotFoundException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeData departments;

    public DepartmentServiceImpl(EmployeeData departments) {
        this.departments = departments;
    }

    @Override
    public String getAll() {
        return departments.getEmployees().values()
                .stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.groupingBy(Employee::getDepartmentId, Collectors.mapping(Employee::getByDepartment, Collectors.joining()))).toString();
    }
    @Override
    public String getAll(Integer departmentId) {
        List<Employee> salaryList =
                departments.getEmployees().values()
                        .stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                        .toList();

        if (salaryList.isEmpty()) {
            throw new EmployeeDepartmentNotFoundException();
        }
        return "Сотрудники отдела " + departmentId + ":\n" + salaryList;

    }
    @Override
    public String getMaxSalaryByDepartment(Integer departmentId) {
        int indexMaxSalary;
        String result;
        List<Employee> salaryList =
                departments.getEmployees().values()
                        .stream()
                        .filter(e -> e.getDepartmentId() == departmentId)
                        .sorted(Comparator.comparingInt(Employee::getSalary))
                        .toList();

        if (salaryList.isEmpty()) throw new EmployeeDepartmentNotFoundException();
        indexMaxSalary = salaryList.size() - 1;
        result = "Сотрудники отдела " + departmentId + ":\n" + salaryList;
        return "Максимальная зарплата в отделе " + departmentId + " у " + salaryList.get(indexMaxSalary) + " - \n " + result;
    }

    @Override
    public String getMinSalaryByDepartment(Integer departmentId) {
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
        result = "Сотрудники отдела " + departmentId + ":\n" + salaryList;
        return "Минимальная зарплата в отделе " + departmentId + " у " + salaryList.get(0) + " - \n " + result;
    }

}
