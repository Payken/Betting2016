package com.ai.services;

import com.ai.domain.Wallet;

import com.ai.model.WalletModel;
import com.ai.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by fdarmoch on 2016-01-02.
 */
@Service
@Transactional
public class WalletService {

    @Autowired
    private WalletRepository walletRepository;

    public void create(WalletModel walletModel){
    Wallet wallet = new Wallet();
wallet.setName(walletModel.getName());
    walletRepository.save(wallet);
    }


    public List<Wallet> wallets() {
        return walletRepository.findAll();
    }

}
