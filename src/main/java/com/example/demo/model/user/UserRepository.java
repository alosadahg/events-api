package com.example.demo.model.user;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByEmail(String email);
    List<User> findByUid(int id);
    List<User> findByEmailAndPassword(String email, String password);
}
