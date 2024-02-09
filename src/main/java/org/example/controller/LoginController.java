package org.example.controller;

import org.example.dto.LoginUserResponseDTO;
import org.example.dto.UserLoginDTO;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.usecase.LoginUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController; //168 / 85 pj 2 parceiras contabilizei Riss

import java.net.http.HttpResponse;

@RestController
public class LoginController {

    @Autowired
    private LoginUseCase loginUseCase;

    @PostMapping("/login")
    public LoginUserResponseDTO login(@RequestBody UserLoginDTO userLoginDTO) {
        return loginUseCase.login(userLoginDTO);
    }

}