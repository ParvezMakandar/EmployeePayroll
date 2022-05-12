package com.example.employeepayrollapp.service;

import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.exception.EmployeePayrollException;
import com.example.employeepayrollapp.model.Employee;
import com.example.employeepayrollapp.repository.EmployeePayrollRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class EmployeePayrollService implements IEmployeePayrollService{

    @Autowired
    private EmployeePayrollRepository employeeRepository;


    public List<Employee> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }


    public Employee getEmployeePayrollDataById(int empId) {
        return employeeRepository
                .findById(empId)
                .orElseThrow( () -> new EmployeePayrollException("Employee with employeeId " + empId +" does not exists..!!"));
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return employeeRepository.findEmployeesByDepartment(department);
    }


    public Employee createEmployeePayrollData(EmployeeDTO empPayrollDTO) {
        Employee empData = null;
        empData = new Employee(empPayrollDTO);
        log.debug("Emp Data : "+empData.toString());
        return employeeRepository.save(empData);
    }


    public Employee updateEmployeePayrollData(int empId, EmployeeDTO empPayrollDTO) {
        Employee empData = this.getEmployeePayrollDataById(empId);
        empData.updateEmployeePayrollData(empPayrollDTO);
        return employeeRepository.save(empData);
    }


    public void deleteEmployeePayrollData(int empId) {
        Employee empData = this.getEmployeePayrollDataById(empId);
        employeeRepository.delete(empData);
    }
}