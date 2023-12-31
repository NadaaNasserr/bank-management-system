package com.example.bankmanagementsystem.Controller;


import com.example.bankmanagementsystem.API.ApiException;
import com.example.bankmanagementsystem.Model.User;
import com.example.bankmanagementsystem.Service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
private final AuthService authService;




    //All
//    @PostMapping("/register")
//    public ResponseEntity register(@Valid @RequestBody User newUser){
//        authService.register(newUser);
//        return ResponseEntity.status(201).body(new ApiException("User Created"));
//    }
//
//
//    //All
//    @PostMapping("/login")
//    public ResponseEntity login(){
//        return ResponseEntity.status(200).body(new ApiException("Logged in successfully"));
//    }
//
//
//    //ALL
//    @PostMapping("/logout")
//    public ResponseEntity logout(){
//        return ResponseEntity.status(200).body("logout");
//    }
//
//    // Admin
//    @GetMapping("/all-users")
//    public ResponseEntity getUsers(){
//        return ResponseEntity.status(200).body(authService.getAllUsers());
//    }
//

}
