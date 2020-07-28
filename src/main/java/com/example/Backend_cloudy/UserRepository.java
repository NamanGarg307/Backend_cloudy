package com.example.Backend_cloudy;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import com.example.Backend_cloudy.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("SELECT new com.example.Backend_cloudy.IdPassObject(u.id,u.password) FROM User u WHERE u.username = ?1")
    IdPassObject getPassForGivenUsername(String username);

    @Query("SELECT id FROM User where username= ?1")
    Integer checkIfExists(String username);


    //@Query("SELECT id FROM User WHERE username = ?1 ")
    //int getIdForGivenUsername(String username);

}
