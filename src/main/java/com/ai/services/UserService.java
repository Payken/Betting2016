package com.ai.services;



import com.ai.domain.Bet;
import com.ai.domain.User;
import com.ai.repositories.RoleRepository;
import com.ai.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by fdarmoch on 2016-01-02.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    public void addToUserCart(User user, Integer id){
//
//        if (user.getCart().getProducts()==null)
//        {
//            user.getCart().setProducts(L);}

    }

    public List<User> getUsers(){
        return userRepository.findByRoleIdNotLike(1);
    }
    public List<User> getUsers2(){
        return userRepository.findByRoleId(1);
    }
    public void create(User user){
        User user1=new User();
        user1.setActive(true);
        user1.setName(user.getName());
        user1.setLogin(user.getLogin());
        user1.setRole(roleRepository.getOne(2));
        userRepository.save(user1);
        }


}
