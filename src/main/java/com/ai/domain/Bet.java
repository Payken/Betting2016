package com.ai.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groovy.transform.ToString;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
/**
 * Created by fdarmoch on 2015-12-30.
 */
@Table(name = "`BET`")
public class Bet {




    @Id
    @GeneratedValue
    private Integer id;
    private String home;
    private String away;
    private Integer homeGoals;
    private Integer awayGoals;
    private boolean won;
    private boolean active;
    private float bid;
    private float odd1;
    private float oddX;
    private float odd2;
    private Timestamp timestamp;
    private String S;
    @ManyToOne
    @JoinColumn(name = "wallet")
    @JsonIgnore
    private Wallet wallet;


    public String getS() {
        return S;
    }

    public void setS(String s) {
        S = s;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public String getAway() {
        return away;
    }

    public void setAway(String away) {
        this.away = away;
    }

    public float getBid() {
        return bid;
    }

    public void setBid(float bid) {
        this.bid = bid;
    }

    public float getOdd1() {
        return odd1;
    }

    public void setOdd1(float odd1) {
        this.odd1 = odd1;
    }

    public float getOddX() {
        return oddX;
    }

    public void setOddX(float oddX) {
        this.oddX = oddX;
    }

    public float getOdd2() {
        return odd2;
    }

    public void setOdd2(float odd2) {
        this.odd2 = odd2;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
        this.S = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.timestamp);
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }


}
