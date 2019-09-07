package com.java.step.demo.repo;

import com.java.step.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.UserDetails;

//TODO Тип айди для репозитория требует уточнения!!!!
public interface UserRepo extends JpaRepository<User, Long> {
    User findByLogin(String login);

}
