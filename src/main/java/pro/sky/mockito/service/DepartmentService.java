package pro.sky.mockito.service;

import org.springframework.stereotype.Service;
import pro.sky.mockito.exception.DataNotTransmittedException;
import pro.sky.mockito.exception.EmployeeNotFoundException;
import pro.sky.mockito.model.EmployeeMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService {


    private final EmployeeServiceImpl employeeServiceImpl;

    public DepartmentService(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    public void getException() {
        if (employeeServiceImpl.showAllEmployees() == null) {
            throw new EmployeeNotFoundException("Нету данных");
        }
    }

    public void getException2(Integer department) {
        if (department == null) {
            throw new DataNotTransmittedException("Данные не переданы");
        }
    }


    public List<EmployeeMap> findEmployeesByDepartment(Integer department) {
        getException();
        getException2(department);
        return employeeServiceImpl.showAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .toList();
    }

    public int findSumSalaryForDepartment(Integer department) {
        getException();
        getException2(department);

        return employeeServiceImpl.showAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .map(EmployeeMap::getSalary)
                .reduce(Integer::sum).get();
    }

    public int findMaxSalaryForDepartment(Integer department) {
        getException();
        getException2(department);
        return employeeServiceImpl.showAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(EmployeeMap::getSalary).max().getAsInt();
    }

    public int findMinSalaryForDepartment(Integer department) {
        getException();
        getException2(department);
        return employeeServiceImpl.showAllEmployees().stream()
                .filter(e -> e.getDepartment() == department)
                .mapToInt(EmployeeMap::getSalary).min().getAsInt();
    }

    public Map<Integer, List<EmployeeMap>> findEmployeesGroupByDepartment() {
        getException();
        return employeeServiceImpl.showAllEmployees().stream()
                .collect(Collectors.groupingBy(EmployeeMap::getDepartment));

    }


    public int findAverageSalaryForDepartment(int i) {
        getException();
        return i;
    }
}
