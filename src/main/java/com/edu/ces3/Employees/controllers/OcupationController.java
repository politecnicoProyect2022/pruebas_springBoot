package com.edu.ces3.Employees.controllers;

import com.edu.ces3.Employees.dao.OcupationDao;
import com.edu.ces3.Employees.models.Ocupations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class OcupationController {

    @Autowired
    private OcupationDao ocupationDao;

    @RequestMapping(value = "api/ocupations", method = RequestMethod.GET)
    public List<Ocupations> getEmployees(){
        /*ArrayList<Employess> Employees = new ArrayList<>();
        Employees.add(new Employess(1, "lenior","alsate","lenior@gmail.com", new Date(2022, 07, 24), null));
        Employees.add(new Employess(2, "leniores","alsates","leniores@gmail.com", new Date(2022, 07, 24), null));*/

        return ocupationDao.getOcupations();
    }

    @RequestMapping(value = "api/ocupation/{id}", method = RequestMethod.GET)
    public Ocupations getEmployee(@PathVariable("id") int id){
        return ocupationDao.getOcupation(id);
    }

    @RequestMapping(value = "api/ocupation", method = RequestMethod.POST)
    public Ocupations insertEmployee(@RequestBody Ocupations ocupation){
        Date today = new Date();
        ocupation.setCreateAt(today);
        return ocupationDao.createOcupation(ocupation);
    }

    @RequestMapping(value = "api/ocupation/{id}", method = RequestMethod.PUT)
    public Ocupations updateEmployee(@PathVariable("id") int id, @RequestBody Ocupations ocupation){
        Ocupations beforeOcupation = ocupationDao.getOcupation(id); //Recuperamos la ocupación antes de ser actualizada para no perder la fecha de creación

        Date today = new Date();
        ocupation.setUpdateAt(today);
        ocupation.setCreateAt(beforeOcupation.getCreateAt());
        return ocupationDao.updateOcupation(id, ocupation);
    }

    @RequestMapping(value = "api/ocupation/{id}", method = RequestMethod.DELETE)
    public Ocupations deleteEmployee(@PathVariable("id") int id){
        return ocupationDao.deleteOcupation(id);
    }
}
