package com.example.bankmanagementsystem.Service;

import com.example.bankmanagementsystem.API.ApiException;
import com.example.bankmanagementsystem.Model.User;
import com.example.bankmanagementsystem.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;
//    public void register(User user){
//        user.setRole("USER");
//        String hash=new BCryptPasswordEncoder().encode(user.getPassword());
//        user.setPassword(hash);
//        authRepository.save(user);
//    }
//
//
//    public List<User> getAllUsers(){
//
//        return authRepository.findAll();
//    }
//
//    public User getUser(Integer id){
//        User user=authRepository.findUserById(id);
//        if (user==null){
//            throw new ApiException("User Not Found!");
//        }
//        return user;
//    }
//    public void deleteUser(Integer id){
//        User user=authRepository.findUserById(id);
//        if(user==null){
//            throw new ApiException("User Not Found");
//        }
//        authRepository.delete(user);
//    }
//
//
//    public void updateUser(User newUser , Integer id){
//        User oldUser=authRepository.findUserById(id);
//
//        newUser.setId(id);
//        newUser.setRole(oldUser.getRole());
//        newUser.setPassword(new BCryptPasswordEncoder().encode(newUser.getPassword()));
//        authRepository.save(newUser);
//    }

}
