package pro.sky.mockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import pro.sky.mockito.model.EmployeeMap;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

    @Mock
    private EmployeeServiceImpl employeeService;
    @InjectMocks
    private DepartmentService departmentService;

    @Test
    public void findEmployeesByDepartment() {
        EmployeeMap employeeMap = new EmployeeMap("Антон", "Антонов", 5000, 2);
        EmployeeMap employeeMap1 = new EmployeeMap("Петя", "Пупин", 1000, 2);
        EmployeeMap employeeMap2 = new EmployeeMap("Вика", "Пупина", 1200, 1);
        EmployeeMap employeeMap3 = new EmployeeMap("Катя", "Серова", 1500, 3);
        List<EmployeeMap> employeeMaps = new ArrayList<>();
        employeeMaps.add(employeeMap);
        employeeMaps.add(employeeMap1);
        employeeMaps.add(employeeMap2);
        employeeMaps.add(employeeMap3);
        Mockito.when(employeeService.showAllEmployees()).thenReturn(employeeMaps);
        List<EmployeeMap> expected = new ArrayList<>();
        expected.add(employeeMap);
        expected.add(employeeMap1);
        List<EmployeeMap> actual = departmentService.findEmployeesByDepartment(2);

        assertEquals(expected, actual);

    }

    @Test
    public void findSumSalaryForDepartmentNegativeTest() {
        EmployeeMap employeeMap = new EmployeeMap("Вася", "Пупкин", 5000, 2);
        EmployeeMap employeeMap1 = new EmployeeMap("Петя", "Петин", 1000, 2);
        EmployeeMap employeeMap2 = new EmployeeMap("Света", "Лютикова", 1200, 1);
        EmployeeMap employeeMap3 = new EmployeeMap("Катя", "Серова", 1500, 3);
        List<EmployeeMap> employeeMaps = new ArrayList<>();
        employeeMaps.add(employeeMap);
        employeeMaps.add(employeeMap1);
        employeeMaps.add(employeeMap2);
        employeeMaps.add(employeeMap3);

        Mockito.when(employeeService.showAllEmployees()).thenReturn(employeeMaps);

        assertThrows(Exception.class, () -> departmentService.findSumSalaryForDepartment(10));

    }

    @Test
    public void findMaxSalaryForDepartmentTest() {
        EmployeeMap employeeMap = new EmployeeMap("Вася", "Пупкин", 5000, 2);
        EmployeeMap employeeMap1 = new EmployeeMap("Петя", "Петин", 1000, 2);
        EmployeeMap employeeMap2 = new EmployeeMap("Света", "Лютикова", 1200, 1);
        EmployeeMap employeeMap3 = new EmployeeMap("Катя", "Серова", 1500, 3);
        List<EmployeeMap> employeeMaps = new ArrayList<>();
        employeeMaps.add(employeeMap);
        employeeMaps.add(employeeMap1);
        employeeMaps.add(employeeMap2);
        employeeMaps.add(employeeMap3);

        Mockito.when(employeeService.showAllEmployees()).thenReturn(employeeMaps);

        int actual = departmentService.findMaxSalaryForDepartment(2);
        assertEquals(5000, actual);
    }

    @Test
    public void findMinSalaryForDepartment() {
        EmployeeMap employeeMap = new EmployeeMap("Вася", "Пупкин", 5000, 2);
        EmployeeMap employeeMap1 = new EmployeeMap("Петя", "Петин", 1000, 2);
        EmployeeMap employeeMap2 = new EmployeeMap("Света", "Лютикова", 1200, 1);
        EmployeeMap employeeMap3 = new EmployeeMap("Катя", "Серова", 1500, 3);
        List<EmployeeMap> employeeMaps = new ArrayList<>();
        employeeMaps.add(employeeMap);
        employeeMaps.add(employeeMap1);
        employeeMaps.add(employeeMap2);
        employeeMaps.add(employeeMap3);

        Mockito.when(employeeService.showAllEmployees()).thenReturn(employeeMaps);

        int actual = departmentService.findMinSalaryForDepartment(2);
        assertEquals(1000, actual);

    }

    @Test
    public void findEmployeesGroupByDepartmentTest() {

        EmployeeMap employeeMap = new EmployeeMap("Вася", "Пупкин", 5000, 2);
        EmployeeMap employeeMap1 = new EmployeeMap("Петя", "Петин", 1000, 2);
        EmployeeMap employeeMap2 = new EmployeeMap("Света", "Лютикова", 1200, 1);
        EmployeeMap employeeMap3 = new EmployeeMap("Катя", "Серова", 1500, 3);
        List<EmployeeMap> employeeMaps = new ArrayList<>();
        employeeMaps.add(employeeMap);
        employeeMaps.add(employeeMap1);
        employeeMaps.add(employeeMap2);
        employeeMaps.add(employeeMap3);

        Mockito.when(employeeService.showAllEmployees()).thenReturn(employeeMaps);

        Map<Integer, List<EmployeeMap>> expected = new HashMap<>();
        List<EmployeeMap> list = new ArrayList<>();
        List<EmployeeMap> list1 = new ArrayList<>();
        List<EmployeeMap> list2 = new ArrayList<>();
        list.add(employeeMap);
        list.add(employeeMap1);
        list1.add(employeeMap2);
        list2.add(employeeMap3);
        expected.put(2, list);
        expected.put(1, list1);
        expected.put(3, list2);

        Map<Integer, List<EmployeeMap>> actual = departmentService.findEmployeesGroupByDepartment();

        assertEquals(expected, actual);


    }
}
