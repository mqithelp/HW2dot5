package pro.mqithelp.hw2dot5.service;

public interface EmployeeService {
    int MAX_EMPLYEE = 10;

    String removeEmployee(String name, String surname, Integer passportNumber);

    String addEmployee(String name, String surname, Integer passportNumber);

    String findEmployee(String name, String surname, Integer passportNumber);

    String allEmployee();
}
