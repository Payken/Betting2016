package com.ai.model;

/**
 * Created by fdarmoch on 2016-01-02.
 */
public class EditModel {
    private Integer id;
    private Integer homegoals;
    private Integer awaygoals;
    private String won;
    EditModel(){


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHomegoals() {
        return homegoals;
    }

    public void setHomegoals(Integer homegoals) {
        this.homegoals = homegoals;
    }

    public Integer getAwaygoals() {
        return awaygoals;
    }

    public void setAwaygoals(Integer awaygoals) {
        this.awaygoals = awaygoals;
    }

    public String getWon() {
        return won;
    }

    public void setWon(String won) {
        this.won = won;
    }
}
