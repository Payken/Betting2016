package com.ai.repositories;



import com.ai.domain.Wallet;
import com.ai.domain.Bet;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by fdarmoch on 2015-12-28.
 */

public interface BetRepository extends JpaRepository<Bet, Integer> {


   List<Bet> findByHome(String name);
   List<Bet> findByWallet(Wallet wallet, Pageable pageable);
   List<Bet> findByWalletAndActiveTrue(Wallet wallet, Pageable pageable);
   List<Bet> findByActiveTrue();
//   List<Bet> findByNameContainingAndW(String name, Wallet wallet, Pageable pageable);
//   List<Bet> findByCategory(Wallet wallet, Pageable pageable);


}