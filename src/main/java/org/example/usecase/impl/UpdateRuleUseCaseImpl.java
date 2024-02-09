package org.example.usecase.impl;

import org.example.dto.RuleUpdateDTO;
import org.example.entity.Rule;
import org.example.entity.User;
import org.example.repository.RuleRepository;
import org.example.repository.UserRepository;
import org.example.usecase.UpdateRuleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateRuleUseCaseImpl implements UpdateRuleUseCase {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RuleRepository ruleRepository;

    @Override
    public User update(RuleUpdateDTO ruleUpdateDTO, Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("Não existe usuário"));
        Rule rule = ruleRepository.findById(ruleUpdateDTO.getId()).orElseThrow( () -> new RuntimeException("perfil não encontrado"));
        user.setRule(rule);
        return userRepository.save(user);
    }
}
