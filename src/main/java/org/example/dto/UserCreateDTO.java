package org.example.dto;

import org.example.entity.Rule;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

public class UserCreateDTO {

    @NotNull
    private LocalDate dtBorn;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotNull
    private Rule rule;

    @NotNull
    @NotBlank
    private String username;

    public UserCreateDTO(LocalDate dtBorn, String name, String password, Rule rule, String username) {
        this.dtBorn = dtBorn;
        this.name = name;
        this.password = password;
        this.rule = rule;
        this.username = username;
    }

    public UserCreateDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
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

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}