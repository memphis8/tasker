package com.java.step.demo.repo;

import com.java.step.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//TODO Тип айди для репозитория требует уточнения!!!!
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
