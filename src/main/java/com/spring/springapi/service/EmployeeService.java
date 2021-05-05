package com.spring.springapi.service;

import com.google.common.io.Files;
import com.spring.springapi.model.Employee;
import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(long employeeId);
    Employee addEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(long employeeId);

}
