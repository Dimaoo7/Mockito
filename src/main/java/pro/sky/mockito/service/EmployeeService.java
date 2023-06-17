package pro.sky.mockito.service;

import pro.sky.mockito.model.EmployeeMap;

import java.util.Collection;

public interface EmployeeService {
    EmployeeMap createEmployee(String firstName, String lastName, int salary, int department);

    EmployeeMap removeEmployee(String firstname, String lastName,int salary,int department);

    EmployeeMap findEmployee(String firstname, String lastName,int salary,int department);

    Collection<EmployeeMap> showAllEmployees();
}
