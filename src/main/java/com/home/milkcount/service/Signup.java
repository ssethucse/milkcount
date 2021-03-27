package com.home.milkcount.service;

import com.home.milkcount.model.Login;
import com.home.milkcount.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Signup {

    @Autowired
    LoginRepository loginRepository;

    public String saveDetails(Login login) {
        Optional<String> name = Optional.ofNullable(login.getName());
        Optional<String> pass = Optional.ofNullable(login.getPassword());
        if (name.isPresent() && pass.isPresent()) {
            boolean match = loginRepository.findAll().stream()
                    .anyMatch(data -> data.getName().equalsIgnoreCase(name.get()));
            if (!match) {
                loginRepository.save(login);
                return "Successfully Saved";
            }
        }
        return null;
    }

    public String validateUser(Login login) {
        Optional<String> name = Optional.ofNullable(login.getName());
        Optional<String> pass = Optional.ofNullable(login.getPassword());
        if (name.isPresent() && pass.isPresent()) {
            boolean match = loginRepository.findAll().stream()
                    .anyMatch(data -> data.getName().equalsIgnoreCase(name.get())
                            && data.getPassword().equalsIgnoreCase(pass.get()));
            if (match) {
                return "Login Success";
            }
        }
        return null;
    }

    public String removeUser(String username) {
        Optional<String> name = Optional.ofNullable(username);
        if (name.isPresent()) {
            List<Login> collect = loginRepository.findAll().stream()
                    .filter(data -> data.getName().equalsIgnoreCase(username))
                    .collect(Collectors.toList());
            loginRepository.deleteAll(collect);
        }
        return null;
    }
}
