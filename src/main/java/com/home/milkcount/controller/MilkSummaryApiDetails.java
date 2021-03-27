package com.home.milkcount.controller;

import com.home.milkcount.model.Login;
import com.home.milkcount.model.Milk_Details;
import com.home.milkcount.service.Signup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MilkSummaryApiDetails implements MilkSummaryApi {
    @Autowired
    Signup signup;

    @Override
    public ResponseEntity<String> signUp(Login login) {
        Optional<String> result = Optional.ofNullable(signup.saveDetails(login));
        if (result.isPresent()) {
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Already Exist", HttpStatus.CONFLICT);
        }
    }

    @Override
    public ResponseEntity<String> loginUser(Login login) {
        Optional<String> result = Optional.ofNullable(signup.validateUser(login));
        if (result.isPresent()) {
            return new ResponseEntity<String>(result.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Login Details Failed", HttpStatus.BAD_GATEWAY);
        }
    }

    @Override
    public ResponseEntity<String> removeUser(String username) {
        Optional<String> result = Optional.ofNullable(username);
        if (result.isPresent()) {
            return new ResponseEntity<String>(signup.removeUser(username), HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Details Not Found", HttpStatus.CONFLICT);
        }
    }

    @Override
    public String getAllMilkPrices() {
        return null;
    }

    @Override
    public String saveMilkDetails(Milk_Details milk_details) {
        return null;
    }

    @Override
    public String getMilkDetails(String username) {
        return null;
    }

    @Override
    public String removeMilk(String name) {
        return null;
    }
}
