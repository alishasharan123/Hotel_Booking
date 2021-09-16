package com.hotel.login.MyLogin.Controller;

import com.hotel.login.MyLogin.Services.User;
import com.hotel.login.MyLogin.Services.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@RestController
public class MyController {
@Autowired
    UserDao  userDao;
    @GetMapping("/")
    public String firstMethod()
    {
        return "Welcome to Spring boot Application";
    }

    @GetMapping("/users")
    public List<User> getStudent()
    {
        return userDao.findAll();  //Does what getAllStudent method does in springMVC
    }

    @RequestMapping("/sign")
    public String Signin(@RequestParam String username, @RequestParam String password)
    {

      String p= userDao.findByUsername(username);
      if(p.equals(password))
          return "Congats! you are signed ";


        return "you have entered wrong password";


//      userDetails= userDao.findByUsername(username);
//
//       if((us.get(4).equals(password)))
//       return "Congats! you are signed ";
//
//       return "you have entered wrong password";
    }

    @RequestMapping("/signup")


    public String insertUser(@RequestBody User user){
        try{
            userDao.save(user);
            return "Data is Inserted";
        }catch (Exception e){
            return (e.getMessage());
        }
    }

}
