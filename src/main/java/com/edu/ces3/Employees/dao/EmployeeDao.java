package com.edu.ces3.Employees.dao;

import com.edu.ces3.Employees.models.Employess;

import java.util.List;

public interface EmployeeDao {

    List<Employess> getEmployees();

    Employess getEmployee(int id);

    Employess createEmployee(Employess employess);

    Employess updateEmployee(int id, Employess employess);

    Employess deleteEmployee(int id);
}
