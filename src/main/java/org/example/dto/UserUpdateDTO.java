package org.example.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class UserUpdateDTO {

    @NotNull
    private LocalDate dtBorn;

    @NotBlank
    private String name;

    @NotBlank
    private String password;

    @NotBlank
    private String username;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
