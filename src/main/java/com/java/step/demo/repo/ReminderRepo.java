package com.java.step.demo.repo;

import com.java.step.demo.entity.Reminder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//TODO Тип айди для репозитория требует уточнения!!!!
public interface ReminderRepo extends CrudRepository<Reminder, Long> {
    List<Reminder> findAllByUser_Login(String login);
}
