package com.edu.ces3.Employees.dao;

import com.edu.ces3.Employees.models.Employess;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeesImpl implements EmployeeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employess> getEmployees() {
        String query = "FROM Employess";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Employess getEmployee(int id) {
        return entityManager.find(Employess.class, id);
    }

    @Override
    public Employess createEmployee(Employess employess) {
        return entityManager.merge(employess);
    }

    @Override
    public Employess updateEmployee(int id, Employess employess) {
        employess.setId(id);
        return entityManager.merge(employess);
    }

    @Override
    public Employess deleteEmployee(int id) {
        Employess employee = entityManager.find(Employess.class, id);
        entityManager.remove(employee);

        return employee;
    }
}
