package com.example.Backend_cloudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping(path="/Backendcloudy")
public class UserAuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path="/signup")
    public @ResponseBody SignupResponce signup(@RequestParam String username,
                                       @RequestParam String password){
        User u=new User();
        SignupResponce signupResponce=new SignupResponce();
        if(userRepository.checkIfExists(username)==null){
            u.setUsername(username);
            u.setPassword(password);
            userRepository.save(u);
            signupResponce.setResponce("Signup successful");
            return signupResponce;
        }
        signupResponce.setResponce("Username already taken");
        return signupResponce;
    }

    @PostMapping(path="/login")
    public @ResponseBody IdPassObject authentication(@RequestParam String username){
        return userRepository.getPassForGivenUsername(username);
    }



}
