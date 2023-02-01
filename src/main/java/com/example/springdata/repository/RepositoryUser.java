package com.example.springdata.repository;

import com.example.springdata.Module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryUser extends JpaRepository <User,Integer> {

    User findUserByEmail (String Email);

    User findUserById (Integer id);

    List<User> findAllByAgeGreaterThanEqual(Integer age);

    List<User>  findAllByRole(String role);

    User findUserByUsernameAndPassword(String username,String password);
}
