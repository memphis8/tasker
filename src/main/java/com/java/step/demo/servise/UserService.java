package com.java.step.demo.servise;

import com.java.step.demo.entity.Role;
import com.java.step.demo.entity.User;
import com.java.step.demo.repo.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@NoArgsConstructor
@Data
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    private User user;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userFromDb = userRepo.findByUsername(username);
        if(userFromDb==null){
            throw new UsernameNotFoundException(username);
        }
        else {
            this.user = userFromDb;
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        return user;
    }
}
