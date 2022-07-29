package com.edu.ces3.Employees.dao;

import com.edu.ces3.Employees.models.Employess;
import com.edu.ces3.Employees.models.Ocupations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class Ocupationlmpl implements OcupationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ocupations> getOcupations() {
        String query = "FROM Ocupations";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Ocupations getOcupation(int id) {
        return entityManager.find(Ocupations.class, id);
    }

    @Override
    public Ocupations createOcupation(Ocupations ocupation) {
        return entityManager.merge(ocupation);
    }

    @Override
    public Ocupations updateOcupation(int id, Ocupations ocupation) {
        ocupation.setId(id);
        return entityManager.merge(ocupation);
    }

    @Override
    public Ocupations deleteOcupation(int id) {
        Ocupations ocupation = entityManager.find(Ocupations.class, id);
        entityManager.remove(ocupation);

        return ocupation;
    }
}
