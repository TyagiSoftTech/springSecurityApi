package com.spring.springapi.service.Imp;

import com.spring.springapi.Repository.EmployeeRepository;
import com.spring.springapi.model.Employee;
import com.spring.springapi.exception.DataNotFoundExceptionException;
import com.spring.springapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    public EmployeeServiceImp() { }

    public List<Employee> getAllEmployee() {
        try{
            return this.employeeRepository.findAll();
        }catch (Exception e) {
            throw new DataNotFoundExceptionException("data not found exception"+e.getMessage());
        }
    }
    @Override
    public Employee getEmployeeById(long employeeId) {
        try {
            return employeeRepository.findById(employeeId).get();
        }catch (Exception e)
        {
            throw new DataNotFoundExceptionException("Data not fount exception, please fill correct employeeId"+e.getMessage());
        }
    }
    @Override
    public Employee addEmployee(Employee employee) {
        try{
            employeeRepository.save(employee);
            return employee;
        }catch (Exception e)
        {
            throw new DataNotFoundExceptionException("Data not found exception, please save correct information"+e.getMessage());
        }
    }
    @Override
    public Employee updateEmployee(Employee employee) {
        try{
            employeeRepository.save(employee);
            return employee;
        }catch (Exception e)
        {
            throw new DataNotFoundExceptionException("Data not found. please fill correct information"+e.getMessage());
        }
    }
    @Override
    public void deleteEmployee(long employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
        }catch (Exception e){
            throw new DataNotFoundExceptionException("Data not found. please fetch correct employeeId "+e.getMessage());
        }
    }
}
