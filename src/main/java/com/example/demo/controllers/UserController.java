package com.example.demo.controllers;


import com.example.demo.domains.User;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired(required = true)
    UserService userService;


    @GetMapping
    private String getUsers(){

        String finalJson = "[";

        List<User> userList = userService.findAll();
        List<String> userString = new ArrayList<>();
        for(int i = 0 ; i < userList.size() ; i++){
            finalJson = finalJson.concat(userList.get(i).toString()).concat(",");
            System.out.println(finalJson);
        }

        return finalJson;

    }

    @GetMapping("/{email}")
    private User getUserByUsername(@PathVariable(value = "email") String email){
        return userService.findByEmail(email);
    }

    @PostMapping("/signin")
    @ResponseStatus(value= HttpStatus.OK)
    private String signIn(@RequestBody User user){


        if(userService.findByEmail(user.getEmail()) != null){
            if(userService.findByEmail(user.getEmail()).getPassword() == user.getPassword()){
                return "True";
            }
        }



        return "Wrong password";
    }


}
