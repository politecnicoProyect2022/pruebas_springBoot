package com.edu.ces3.Employees.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "employees")
public class Employess {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;
    @CreationTimestamp
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAtt;
    @UpdateTimestamp
    @Column(name = "update_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAtt;

    public Employess() {
    }

    public Employess(int id, String name, String lastName, String email, Date createdAtt, Date updatedAtt) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.createdAtt = createdAtt;
        this.updatedAtt = updatedAtt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAtt() {
        return createdAtt;
    }

    public void setCreatedAtt(Date createdAtt) {
        this.createdAtt = createdAtt;
    }

    public Date getUpdatedAtt() {
        return updatedAtt;
    }

    public void setUpdatedAtt(Date updatedAtt) {
        this.updatedAtt = updatedAtt;
    }
}
