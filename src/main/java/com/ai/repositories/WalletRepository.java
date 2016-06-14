package com.ai.repositories;

import com.ai.domain.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fdarmoch on 2015-12-28.
 */

public interface WalletRepository extends JpaRepository<Wallet, Integer> {


   List<Wallet> findAll();



}