package pro.mqithelp.hw2dot5.service;

public interface EmployeeService {
    int MAX_EMPLYEE = 10;

    String removeEmployee(String name, String surname);

    boolean addEmployee(String name, String surname);

    String findEmployee(String name, String surname);

    String allEmployee();

}
