package com.example.employeepayrollapp.service;


import com.example.employeepayrollapp.dto.EmployeeDTO;
import com.example.employeepayrollapp.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {

    List<Employee> getEmployeePayrollData();

    Employee getEmployeePayrollDataById(int empId);

    List<Employee> getEmployeesByDepartment(String department);

    Employee createEmployeePayrollData(EmployeeDTO empPayrollDTO);

    Employee updateEmployeePayrollData(int empId, EmployeeDTO empPayrollDTO);

    void deleteEmployeePayrollData(int empId);
}