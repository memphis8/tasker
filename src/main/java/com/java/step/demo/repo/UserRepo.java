package com.java.step.demo.repo;

import com.java.step.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

//TODO Тип айди для репозитория требует уточнения!!!!
public interface UserRepo extends CrudRepository<User, Long> {
    User findByLogin(String login);

}
