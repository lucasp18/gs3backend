package org.example.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    private LocalDate dtBorn;

    private String name;

    private String username;
    @JsonIgnore
    private String password;

    private Boolean active;


    @ManyToOne
    private Rule rule;

    public User(LocalDate dtBorn, String nome, String username, String password, Boolean active, Rule rule) {
        this.name = nome;
        this.dtBorn = dtBorn;
        this.username = username;
        this.password = password;
        this.active = active;
        this.rule = rule;
    }

    public User() {
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDtBorn() {
        return dtBorn;
    }

    public void setDtBorn(LocalDate dtBorn) {
        this.dtBorn = dtBorn;
    }

    public String getName() {
        return name;
    }

    public void setName(String nome) {
        this.name = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
