package com.example.springdata.Service;

import com.example.springdata.Module.User;
import com.example.springdata.repository.RepositoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
 private final RepositoryUser RepositoryUser;

 public List<User> getUser(){
     return RepositoryUser.findAll();
 }

 public void  addUser(User user){
  RepositoryUser.save(user);
 }

 public Boolean updateUser(Integer id, User user){
 User oldUser = RepositoryUser.getById(id);
 if ( oldUser==null ){
     return false;
 }
 oldUser.setName(user.getName());
 oldUser.setUsername(user.getUsername());
 oldUser.setPassword(user.getPassword());
 oldUser.setEmail(user.getEmail());
 oldUser.setRole(user.getRole());
 oldUser.setAge(user.getAge());
 RepositoryUser.save(oldUser);
return true;
 }

    public Boolean deleteUser(Integer id){
        User oldUser = RepositoryUser.getById(id);
        if ( oldUser==null ){
            return false;
        }
        RepositoryUser.deleteById(id);
        return  true;
    }
}
