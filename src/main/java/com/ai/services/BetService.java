package com.ai.services;

import com.ai.domain.Bet;

import com.ai.domain.Wallet;
import com.ai.model.BetModel;
import com.ai.model.SearchModel;


import com.ai.repositories.BetRepository;
import com.ai.repositories.WalletRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by fdarmoch on 2016-01-02.
 */
@Service
@Transactional
public class BetService {


    @Autowired
    private BetRepository betRepository;

    @Autowired
    private WalletRepository walletRepository;

    public Bet getOne(Integer id) {
        return betRepository.getOne(id);
    }

    public List<Bet> safeguards() {
        return betRepository.findAll();
    }

    public void create(BetModel betModel) {
        Bet bet = new Bet();
        bet.setActive(true);
        bet.setHome(betModel.getHome());
        bet.setAway(betModel.getAway());
       // bet.setBid(betModel.getStack());
        bet.setOdd1(betModel.getOdd1());
        bet.setOddX(betModel.getOddX());
        bet.setOdd2(betModel.getOdd2());
        bet.setWallet(walletRepository.getOne(betModel.getWallet()));
        bet.setTimestamp(Timestamp.valueOf(betModel.getDateString()));
        betRepository.save(bet);
    }

    public List<Bet> getBets(SearchModel searchModel) throws JsonProcessingException {
        Pageable pageable;
        pageable = new PageRequest(0, 25, Sort.Direction.DESC, "timestamp");
        if (searchModel.getWalletid() == 0) {
            if(searchModel.isActive())
            return betRepository.findByActiveTrue();
            else return betRepository.findAll();
        } else {
            if (searchModel.isActive())
                return betRepository.findByWalletAndActiveTrue(walletRepository.getOne(searchModel.getWalletid()),pageable);
            else
            return betRepository.findByWallet(walletRepository.getOne(searchModel.getWalletid()), pageable);
        }
    }
}
