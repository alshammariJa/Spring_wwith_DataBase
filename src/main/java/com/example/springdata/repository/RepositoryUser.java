package com.example.springdata.repository;

import com.example.springdata.Module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends JpaRepository <User,Integer> {
}
