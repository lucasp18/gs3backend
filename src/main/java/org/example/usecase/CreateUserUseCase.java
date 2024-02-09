package org.example.usecase;

import org.example.dto.UserCreateDTO;
import org.example.entity.User;

public interface CreateUserUseCase {

    public User create(UserCreateDTO userCreateDTO);
}
