package com.ai.model;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.Base64Utils;

import java.io.File;
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
private float odd ;
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

    public float getOdd() {
        return odd;
    }

    public void setOdd(float odd) {
        this.odd = odd;
    }

    public Integer getWallet() {
        return wallet;
    }

    public void setWallet(Integer wallet) {
        this.wallet = wallet;
    }
}
