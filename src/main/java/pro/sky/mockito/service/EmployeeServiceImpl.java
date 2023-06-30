package pro.sky.mockito.service;

import org.springframework.stereotype.Service;
import pro.sky.mockito.exception.EmployeeAlreadyAddedException;
import pro.sky.mockito.exception.EmployeeNotFoundException;
import pro.sky.mockito.model.EmployeeMap;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

    @Service
    public class EmployeeServiceImpl implements EmployeeService {
        private final Map<String, EmployeeMap> employeeMap;

        public EmployeeServiceImpl() {
            this.employeeMap = new HashMap<>();
        }

        @Override
        public EmployeeMap createEmployee(String firstName, String lastName,int salary,int department) {
            EmployeeMap employee = new EmployeeMap(firstName,lastName,salary,department);
            if (employeeMap.containsKey(employee.getFullName())) {
                throw new EmployeeAlreadyAddedException("EmployeeAlreadyAdded");
            } else {
                this.employeeMap.put(employee.getFullName(), employee);
            }
            return employee;
        }

        @Override
        public EmployeeMap removeEmployee(String firstname, String lastName,int salary,int department) {
            EmployeeMap employee = new EmployeeMap(firstname, lastName,salary,department);
            if (employeeMap.containsKey(employee.getFullName())) {
                return employeeMap.remove(employee.getFullName());
            }
            throw new EmployeeNotFoundException("Employee not found");
        }

        @Override
        public EmployeeMap findEmployee(String firstname, String lastName,int salary,int department) {
            EmployeeMap employee = new EmployeeMap(firstname, lastName,salary,department);
            if (employeeMap.containsKey(employee.getFullName())) {
                return employeeMap.get(employee.getFullName());
            }
            throw new EmployeeNotFoundException("Employee not found");
        }

        @Override
        public Collection<EmployeeMap> showAllEmployees() {
            return Collections.unmodifiableCollection(employeeMap.values());
        }

    }
