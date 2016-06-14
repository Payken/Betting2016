package com.ai.config;

/**
 * Created by fdarmoch on 2016-01-13.
 */
import com.ai.domain.User;
import com.ai.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;




    @Service
    public class UserDetService implements UserDetailsService {

        @Autowired
        private UserRepository userRepository;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            User user = userRepository.findByLogin(username);
            if(user == null) {
                throw new UsernameNotFoundException("Not found user with login: " + username);
            }
            return new UserDet(user);
        }
    }


