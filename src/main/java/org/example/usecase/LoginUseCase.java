package org.example.usecase;

import org.example.dto.LoginUserResponseDTO;
import org.example.dto.UserLoginDTO;
import org.example.entity.User;

public interface LoginUseCase {

    public LoginUserResponseDTO login(UserLoginDTO userLoginDTO);

}
