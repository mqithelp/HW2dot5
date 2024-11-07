package pro.mqithelp.hw2dot5.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pro.mqithelp.hw2dot5.component.EmployeeData;
import pro.mqithelp.hw2dot5.exception.EmployeeDepartmentNotFoundException;
import pro.mqithelp.hw2dot5.exception.EmployeeNotFoundException;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DepartmentServiceImplTest {
    @Mock
    private EmployeeData employeeData;
    @InjectMocks
    private DepartmentServiceImpl departmentService;

    Map<String, Employee> testListEmployee = new HashMap<>();
    List<Employee> employeeList = new ArrayList<>();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        employeeList.add(new Employee("Bill", "Gates", 0, 100));
        employeeList.add(new Employee("Steve", "Jobs", 1, 120));
        employeeList.add(new Employee("Mark", "Zuckerberg", 2, 10));
        employeeList.add(new Employee("Jeff", "Bezos", 2, 100));
        testListEmployee.put("zero", employeeList.get(0));
        testListEmployee.put("one", employeeList.get(1));
        testListEmployee.put("two", employeeList.get(2));
        testListEmployee.put("three", employeeList.get(3));
        when(employeeData.getEmployees()).thenReturn(testListEmployee);
    }

    @Test
    void getAllWithOutDepartment() {
        assertEquals(departmentService.getAll(), testListEmployee);
    }

    @Test
    void getAllWithDepartment() {
        int departmentId = 2;
        assertEquals(departmentService.getAll(departmentId),
                testListEmployee.values().stream().filter(e -> e.getDepartmentId() == departmentId)
                        .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                        .toList());
    }

    @Test
    void getAllNotExistWithDepartment() {
        int departmentId = -1;
        assertThrows(EmployeeDepartmentNotFoundException.class, () ->
                departmentService.getAll(departmentId));
    }

    @Test
    void getMaxSalaryByDepartment() {
        assertEquals(departmentService.getMaxSalaryByDepartment(2), testListEmployee.get("three").getSalary());
    }

    @Test
    void getMinSalaryByDepartment() {
        assertEquals(departmentService.getMinSalaryByDepartment(2), testListEmployee.get("two").getSalary());
    }

    @Test
    void getSumByDepartment() {
        int departmentId = 2;
        int resultSum = testListEmployee.values()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
        assertEquals(departmentService.getSumByDepartment(departmentId), resultSum);

    }

    @Test
    void getSumByNotExistDepartment() {
        int departmentId = -1;
        assertThrows(EmployeeDepartmentNotFoundException.class, () -> departmentService.getSumByDepartment(departmentId));
    }
}