package pro.mqithelp.hw2dot5.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pro.mqithelp.hw2dot5.component.EmployeeData;
import pro.mqithelp.hw2dot5.exception.EmployeeAlreadyAddedException;
import pro.mqithelp.hw2dot5.exception.EmployeeNotFoundException;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {
    private static final Logger log = LoggerFactory.getLogger(EmployeeServiceTest.class);
    EmployeeData employeeData = new EmployeeData();
    EmployeeService employeeService = new EmployeeServiceImpl(employeeData);

    @BeforeEach
    void setUp() {
        employeeService.addEmployee("Elon", "Musk");
        employeeService.addEmployee("Bill", "Gates");

    }

    @Test
    void removeEmployee() {
        employeeService.removeEmployee("Elon", "Musk");
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("Elon", "Musk"));
    }

    @Test
    void removeEmployeeNotExists() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("Max", "Musk"));
    }

    @Test
    void addEmployee() {
        assertTrue(employeeService.addEmployee("Stiv", "Jobs"));
    }

    @Test
    void addEmployeeDuplicate() {
        assertTrue(employeeService.addEmployee("Stiv", "Jobs"));
        assertThrows(EmployeeAlreadyAddedException.class, () ->
                assertTrue(employeeService.addEmployee("Stiv", "Jobs")));
    }

    @Test
    void findEmployee() {
        Employee testEmployee = new Employee("Elon", "Musk");
        assertEquals(testEmployee, employeeService.findEmployee("Elon", "Musk"));
    }

    @Test
    void findEmployeeNotFound() {
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.findEmployee("Stiv", "Musk"));
    }

    @Test
    void findEmployeeErrorData() {
        assertThrows(RuntimeException.class, () -> employeeService.findEmployee("Stiv3", "M2-usk"));
    }

}