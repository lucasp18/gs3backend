package org.example.controller;

import org.example.dto.RuleUpdateDTO;
import org.example.dto.UserCreateDTO;
import org.example.dto.UserUpdateDTO;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.usecase.CreateUserUseCase;
import org.example.usecase.UpdateDataUserUseCase;
import org.example.usecase.UpdateRuleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private UpdateDataUserUseCase updateDataUserUseCase;

    @Autowired
    private UpdateRuleUseCase updateRuleUseCase;

    @GetMapping("/user")
    public List<User> all() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{idUser}")
    public User user(@PathVariable Long idUser) {
        return userRepository.findById(idUser).orElseThrow(()-> new RuntimeException("Não existe usuário"));
    }

    @PostMapping("/user")
    public User create(@RequestBody @Valid UserCreateDTO userCreateDTO){
        return createUserUseCase.create(userCreateDTO);
    }

    @PatchMapping("/user/{id}")
    public User update(@RequestBody @Valid UserUpdateDTO userUpdateDTO, @PathVariable Long id){
        return updateDataUserUseCase.update(userUpdateDTO,id);
    }

    @PatchMapping("/user/rule/{id}")
    public User update(@RequestBody @Valid RuleUpdateDTO ruleUpdateDTO, @PathVariable Long id){
        return updateRuleUseCase.update(ruleUpdateDTO, id);
    }

}
