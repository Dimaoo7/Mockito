package pro.sky.mockito.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pro.sky.mockito.exception.EmployeeNotFoundException;
import pro.sky.mockito.model.EmployeeMap;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {

    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void beforeEach() {
        employeeService = new EmployeeServiceImpl();
    }

    @Test
    public void showAllEmployees() {
        assertNotNull(employeeService.showAllEmployees());
    }

    @Test
    public void findEmployee() {
        EmployeeMap expected = employeeService.createEmployee("Иван", "Иванов", 5000, 2);
        assertNotNull(expected);
        assertEquals(2, expected.getDepartment());
        assertEquals(5000, expected.getSalary());
        assertEquals("Иван", expected.getFirstName());
        assertEquals("Иванов", expected.getLastName());


    }

    @Test
    public void createEmployee() {
        EmployeeMap employee = employeeService.createEmployee("Иван", "Иванов", 1000, 1);
        assertNotNull(employee);
        assertEquals("Иван", employee.getFirstName());
        assertEquals("Иванов", employee.getLastName());
        assertEquals(1000, employee.getSalary());
        assertEquals(1, employee.getDepartment());
    }

    @Test
    public void removeEmployee() {
        EmployeeMap expected = employeeService.createEmployee("Иван", "Иванов", 5000, 2);
        assertNotNull(expected);
        assertEquals(2, expected.getDepartment());
        assertEquals(5000, expected.getSalary());
        assertEquals("Иван", expected.getFirstName());
        assertEquals("Иванов", expected.getLastName());
    }

    @Test
    public void createEmployeeException() {
        assertThrows(EmployeeNotFoundException.class,
                () -> employeeService.removeEmployee("Петя", "Петров", 2000, 4));
    }
}
