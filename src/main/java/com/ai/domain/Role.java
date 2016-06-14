package com.ai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by jrudnik on 2016-01-03.
 */
@Entity

public class Role {

    public Role(){};

    @Id
    @GeneratedValue

    private Integer id;

    private String type;
   @OneToMany(mappedBy = "role")
   @JsonIgnore
    private List<User> users;





///////////////////////////////////////////////////////////////////////


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}