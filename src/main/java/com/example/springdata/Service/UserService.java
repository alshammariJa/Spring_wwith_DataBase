package com.example.springdata.Service;

import com.example.springdata.Exeption.Api;
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




    public User findUserByEmail(String email) {
        User user = RepositoryUser.findUserByEmail(email);
        if (user == null) {
            throw new Api("email is null");
        }
        return user;
    }

    public List<User> findbyage(Integer age) {
        List<User> user = RepositoryUser.findAllByAgeGreaterThanEqual(age);
        if (user == null) {
            throw new Api("this age is not here");
        }
        return user;
    }

    public List<User> findbyrole(String role){
        List<User> user = RepositoryUser.findAllByRole(role);
        if (user == null) {
            throw new Api("not here");
        }
        return user;
    }

    public User check(String username,String password){
        User user = RepositoryUser.findUserByUsernameAndPassword(username,password);
        if (user == null) {
            throw new Api("there is no user with this username and password");
        }
        return user;
    }
}
