package com.hotel.login.MyLogin.Services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,String> {

    @Query(value="Select password from Usertable where username=?1",nativeQuery = true)
    public String findByUsername(String username);
}
