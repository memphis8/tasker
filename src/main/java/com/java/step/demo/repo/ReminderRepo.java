package com.java.step.demo.repo;

import com.java.step.demo.entity.Reminder;
import org.springframework.data.repository.CrudRepository;

//TODO Тип айди для репозитория требует уточнения!!!!
public interface ReminderRepo extends CrudRepository<Reminder, Long> {

}
