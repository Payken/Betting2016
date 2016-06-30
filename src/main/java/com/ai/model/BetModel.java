package com.ai.model;

import java.sql.Time;
import java.util.Date;

/**
 * Created by fdarmoch on 2016-01-02.
 */
public class BetModel {

  private String  home ;
private String   away;
   private String dateString;
   private String timeString;
    private Date date;
   private Time time;
 private float stack;
private float odd1 ;
private float oddX ;
private float odd2 ;
private Integer wallet;

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

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    public String getTimeString() {
        return timeString;
    }

    public void setTimeString(String timeString) {
        this.timeString = timeString;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public float getStack() {
        return stack;
    }

    public void setStack(float stack) {
        this.stack = stack;
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

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }
}
