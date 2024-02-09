package org.example.usecase;

import org.example.dto.UserUpdateDTO;
import org.example.entity.User;

public interface UpdateDataUserUseCase {

    public User update(UserUpdateDTO userUpdateDTO, Long id);
}
