package org.example.usecase.impl;

import org.example.dto.LoginUserResponseDTO;
import org.example.dto.UserLoginDTO;
import org.example.entity.User;
import org.example.repository.RuleRepository;
import org.example.repository.UserRepository;
import org.example.usecase.LoginUseCase;
import org.example.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class LoginUserCaseImpl implements LoginUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RuleRepository ruleRepository;

    @Override
    public LoginUserResponseDTO login(UserLoginDTO userLoginDTO) {
        User user = userRepository.login(userLoginDTO.getUsername(), Hash.password(userLoginDTO.getPassword()));
        if (user == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Usuario não encontrado"
            );
        }
        LoginUserResponseDTO loginUserResponseDTO = new LoginUserResponseDTO();
        loginUserResponseDTO.setAuth(true);
        return loginUserResponseDTO;
    }


}
