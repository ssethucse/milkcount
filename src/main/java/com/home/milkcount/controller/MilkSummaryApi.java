package com.home.milkcount.controller;

import com.home.milkcount.model.Login;
import com.home.milkcount.model.Milk_Details;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface MilkSummaryApi {
    @PostMapping("/signup/details")
    ResponseEntity signUp(@RequestBody Login login);

    @PostMapping("/login/user")
    ResponseEntity<String> loginUser(@RequestBody Login login);

    @DeleteMapping("/login/remove")
    ResponseEntity<String> removeUser(@RequestParam("username") String username);

    @GetMapping("/milks/prices")
    String getAllMilkPrices();

    @PostMapping("/milks/details")
    String saveMilkDetails(@RequestBody Milk_Details milk_details);

    @GetMapping("/milks/retrieving")
    String getMilkDetails(@RequestParam("username") String username);

    @DeleteMapping("/milks/remove")
    String removeMilk(@RequestParam("name") String name);
}
