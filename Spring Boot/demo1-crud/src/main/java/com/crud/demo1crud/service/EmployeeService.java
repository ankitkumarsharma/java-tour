package com.crud.demo1crud.service;

import com.crud.demo1crud.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
