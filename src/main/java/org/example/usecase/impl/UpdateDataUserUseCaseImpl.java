package org.example.usecase.impl;

import org.example.dto.UserUpdateDTO;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.usecase.UpdateDataUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateDataUserUseCaseImpl implements UpdateDataUserUseCase {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User update(UserUpdateDTO userUpdateDTO, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe usuário"));

        User userFind = userRepository.findUserByUsername(userUpdateDTO.getUsername().toUpperCase());
        if(userFind != null){
            throw new RuntimeException("username já existe");
        }

        user.setUsername(userUpdateDTO.getUsername().toUpperCase());
        user.setPassword(userUpdateDTO.getPassword());
        user.setDtBorn(userUpdateDTO.getDtBorn());
        user.setName(userUpdateDTO.getName());
        return userRepository.save(user);
    }
}
