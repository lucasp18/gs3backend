package org.example.usecase.impl;

import org.example.dto.UserCreateDTO;
import org.example.entity.Rule;
import org.example.entity.User;
import org.example.repository.RuleRepository;
import org.example.repository.UserRepository;
import org.example.usecase.CreateUserUseCase;
import org.example.util.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateUserUseCaseImpl implements CreateUserUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RuleRepository ruleRepository;


    @Override
    public User create(UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setName(userCreateDTO.getName());
        user.setPassword(Hash.password(userCreateDTO.getPassword()));
        user.setDtBorn(userCreateDTO.getDtBorn());

        User userFind = userRepository.findUserByUsername(userCreateDTO.getUsername().toUpperCase());
        if(userFind != null){
            throw new RuntimeException("username já existe");
        }
        user.setUsername(Hash.username(userCreateDTO.getName()));
        Rule rule = ruleRepository.findById(userCreateDTO.getRule().getId()).orElseThrow( () -> new RuntimeException("perfil não encontrado"));

        user.setRule(rule);
        return userRepository.save(user);
    }

}
