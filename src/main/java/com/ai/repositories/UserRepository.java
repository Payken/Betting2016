package com.ai.repositories;

import com.ai.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by fdarmoch on 2015-12-28.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByLogin(String username);
List<User> findByRoleIdNotLike(Integer id);
List<User> findByRoleId(Integer id);

//    public User getUserInfo(String username){
//        String sql = "SELECT u.name name, u.password password, FROM "+
//                "ai.user u";
//        //INNER JOIN comp_authorities a on u.username=a.username WHERE "+
//          //      "u.enabled =1 and u.username = ?";
//
//        return user;
//    }


}