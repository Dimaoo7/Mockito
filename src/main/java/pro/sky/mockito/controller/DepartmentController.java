package pro.sky.mockito.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.mockito.model.EmployeeMap;
import pro.sky.mockito.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/{id}/employees")
    public List<EmployeeMap> getListForDepartment(@PathVariable int id) {
        return departmentService.findEmployeesByDepartment(id);
    }
    @GetMapping(path = "/{id}/salary/sum")
    public int getSumSalaryForDepartment(@PathVariable int id) {
        return departmentService.findSumSalaryForDepartment(id);
    }
    @GetMapping(value = "/{id}/salary/max")
    public int getMaxSalaryForDepartment(@PathVariable int id) {
        return departmentService.findMaxSalaryForDepartment(id);
    }

    @GetMapping(path = "/{id}/salary/min")
    public int getMinSalaryForDepartment(@PathVariable int id) {
        return departmentService.findMinSalaryForDepartment(id);
    }

    @GetMapping(path = "/employees")
    public Map<Integer,List<EmployeeMap>> getEmployeesGroupByDepartment() {
        return departmentService.findEmployeesGroupByDepartment();
    }
}
