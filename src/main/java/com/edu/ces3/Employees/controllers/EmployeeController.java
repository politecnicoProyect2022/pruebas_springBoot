package com.edu.ces3.Employees.controllers;

import com.edu.ces3.Employees.dao.EmployeeDao;
import com.edu.ces3.Employees.models.Employess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @RequestMapping(value = "test")
    public String test(){
        return "Hola Spring Boot";
    }

    @RequestMapping(value = "api/employees", method = RequestMethod.GET)
    public List<Employess> getEmployees(){
        /*ArrayList<Employess> Employees = new ArrayList<>();
        Employees.add(new Employess(1, "lenior","alsate","lenior@gmail.com", new Date(2022, 07, 24), null));
        Employees.add(new Employess(2, "leniores","alsates","leniores@gmail.com", new Date(2022, 07, 24), null));*/

        return employeeDao.getEmployees();
    }

    @RequestMapping(value = "api/employee/{id}", method = RequestMethod.GET)
    public Employess getEmployee(@PathVariable("id") int id){
        return employeeDao.getEmployee(id);
    }

    @RequestMapping(value = "api/employee", method = RequestMethod.POST)
    public Employess insertEmployee(@RequestBody Employess employee){
        return employeeDao.createEmployee(employee);
    }

    @RequestMapping(value = "api/employee/{id}", method = RequestMethod.PUT)
    public Employess updateEmployee(@PathVariable("id") int id, @RequestBody Employess employee){
        return employeeDao.updateEmployee(id, employee);
    }

    @RequestMapping(value = "api/employee/{id}", method = RequestMethod.DELETE)
    public Employess deleteEmployee(@PathVariable("id") int id){
        return employeeDao.deleteEmployee(id);
    }
}
