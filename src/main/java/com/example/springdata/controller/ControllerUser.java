package com.example.springdata.controller;

import com.example.springdata.Module.User;
import com.example.springdata.Service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user")
public class ControllerUser {
    private final UserService UserService;

    @GetMapping("/get")
    public ResponseEntity getUsers(){
        List<User> userList=UserService.getUser();
        return ResponseEntity.status(200).body(userList);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user , Errors errors){
        if(errors.hasErrors()){
            String msg= errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(msg);

        }
        UserService.addUser(user);
        return ResponseEntity.status(200).body("added done");
    }

@PutMapping("/update/{id}")
   public ResponseEntity updateUser(@Valid @RequestBody Integer id ,User user , Errors errors) {
    if(errors.hasErrors()){
        String msg= errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(msg);

    }
    UserService.updateUser(id,user);
    return ResponseEntity.status(200).body("update done");
}

@DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(Integer id ){
        UserService.deleteUser(id);
    return ResponseEntity.status(200).body("deleted done");
}

    @GetMapping("/byemail/{email}")
    public ResponseEntity getByemail(@PathVariable String email){
        User user=UserService.findUserByEmail(email);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/byage/{age}")
    public ResponseEntity getByage(@PathVariable Integer age){
        List<User> user=UserService.findbyage(age);
        return ResponseEntity.status(200).body(user);
    }
    @GetMapping("/byrole/{role}")
    public ResponseEntity getByrole(@PathVariable String role){
        List<User> user= UserService.findbyrole(role);
        return ResponseEntity.status(200).body(user);
    }

    @GetMapping("/check/{username}/{password}")
    public ResponseEntity getByrole(@PathVariable String username,@PathVariable String password){
        User user=UserService.check(username,password);
        return ResponseEntity.status(200).body(user);
    }


}
