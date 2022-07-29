package com.edu.ces3.Employees.dao;

import com.edu.ces3.Employees.models.Ocupations;

import java.util.List;

public interface OcupationDao {

    List<Ocupations> getOcupations();

    Ocupations getOcupation(int id);

    Ocupations createOcupation(Ocupations ocupation);

    Ocupations updateOcupation(int id, Ocupations ocupation);

    Ocupations deleteOcupation(int id);

}
