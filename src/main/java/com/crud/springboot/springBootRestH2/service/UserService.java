package com.crud.springboot.springBootRestH2.service;


import com.crud.springboot.springBootRestH2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserService extends JpaRepository<User, Integer>{
}
