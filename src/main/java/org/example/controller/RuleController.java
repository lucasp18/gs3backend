package org.example.controller;

import org.example.entity.Rule;
import org.example.entity.User;
import org.example.repository.RuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RuleController {

    @Autowired
    private RuleRepository ruleRepository;

    @GetMapping("/rule")
    public List<Rule> all() {
        return ruleRepository.findAll();
    }

}