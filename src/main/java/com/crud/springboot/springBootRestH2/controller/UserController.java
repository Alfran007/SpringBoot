package com.crud.springboot.springBootRestH2.controller;



import com.crud.springboot.springBootRestH2.model.User;
import com.crud.springboot.springBootRestH2.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {
	
    @Autowired
    private UserService userService;

    // Select, Insert, Delete, Update Operations for User

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    User getUser(@PathVariable Integer id){
        return  userService.findById(id).get();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    String addUser(@RequestBody User user){
        User savedUser = userService.save(user);
        return "SUCCESS";
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    User updateUser(@RequestBody User user){
        User updatedUser = userService.save(user);
        return updatedUser;
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    Map<String, String> deleteUser(@RequestParam Integer id){
        Map<String, String> status = new HashMap<>();
        Optional<User> user = userService.findById(id);
        if(user.isPresent()) {
        	userService.delete(user.get());
            status.put("Status", "User deleted successfully");
        }
        else {
            status.put("Status", "User does not exist");
        }
        return status;
    }

    // Select, Insert, Delete for List of Employees

    @RequestMapping(value = "/userall", method = RequestMethod.GET)
    List<User> getAllUsers(){
    	System.out.println("In");
        return userService.findAll();
    }

    @RequestMapping(value = "/userall", method = RequestMethod.POST)
    String addAllUsers(@RequestBody List<User> userList){
    	userService.saveAll(userList);
        return "SUCCESS";
    }

    @RequestMapping(value = "/userall", method = RequestMethod.DELETE)
    String deleteAllUsers(){
    	userService.deleteAll();
        return "SUCCESS";
    }
}
