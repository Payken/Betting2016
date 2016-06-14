package com.ai.model;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.Null;

/**
 * Created by fdarmoch on 2016-01-02.
 */
public class SearchModel {

    private Integer walletid;
    private boolean active;


    SearchModel(){


    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getWalletid() {
        return walletid;
    }

    public void setWalletid(Integer walletid) {
        this.walletid = walletid;
    }
}
