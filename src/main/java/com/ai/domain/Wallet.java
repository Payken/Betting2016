package com.ai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
/**
 * Created by fdarmoch on 2016-01-02.
 */
public class Wallet {

      @Id
    @GeneratedValue
    private Integer Id;
    private String name;



    @OneToMany(mappedBy = "wallet")
    @JsonIgnore
    private List<Bet> bets;


////////////////////////////////////////////////////////////////////////////////////////

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}
