package org.example.dto;

public class LoginUserResponseDTO {

    private Boolean auth;
    private Long idRule;
    private Long idUser;

    public Long getIdRule() {
        return idRule;
    }

    public void setIdRule(Long idRule) {
        this.idRule = idRule;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public Boolean getAuth() {
        return auth;
    }

    public void setAuth(Boolean auth) {
        this.auth = auth;
    }
}
