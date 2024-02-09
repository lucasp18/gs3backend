package org.example.usecase;

import org.example.dto.RuleUpdateDTO;
import org.example.dto.UserUpdateDTO;
import org.example.entity.User;

public interface UpdateRuleUseCase {

    public User update(RuleUpdateDTO ruleUpdateDTO, Long id);
}
