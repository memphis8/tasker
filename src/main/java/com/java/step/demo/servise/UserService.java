package com.java.step.demo.servise;

import com.java.step.demo.entity.User;
import com.java.step.demo.repo.UserRepo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Data
public class UserService implements UserDetailsService {

    private UserRepo userRepo;
    private User user;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

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
