package com.java.step.demo.servise;

import com.java.step.demo.entity.User;
import com.java.step.demo.repo.UserRepo;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Data
public class UserService implements UserDetailsService {

    private UserRepo userRepo;
    private User user;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepo.findByLogin(userName);
        if(user==null){
            throw new UsernameNotFoundException(userName);
        }
        else {
            this.user = user;
        }
        return user;
    }
}
