package com.ai.controllers;


import com.ai.domain.User;


import com.ai.domain.Wallet;
import com.ai.model.BetModel;
import com.ai.model.SearchModel;
import com.ai.services.BetService;
import com.ai.services.UserService;

import com.ai.services.WalletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fdarmoch on 2015-12-28.
 */
@Controller
@RequestMapping("/admin") // url (w domysle http://localhost:8080)
public class AdminController {

    @Autowired
    UserService userService;
    @Autowired
    BetService betService;
    @Autowired
    private WalletService walletService;
    @ModelAttribute("wallets")
    private List<Wallet> walletList(){

        System.out.println(walletService.wallets().toString());
        return walletService.wallets();
    }


//    @ModelAttribute("users")
//    private List<User> userList(){
//        return userService.getUsers();
//    }

    @RequestMapping //  rozszerzenie urla z klasy, brak oznacza ze to ten sam url
    public String getView() {

        return "home"; // zwraca sciezke wzgledna do widoku, domyslnie folder templates w resources

    }

    @RequestMapping(value="/addBet", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public String searchProduct(@RequestBody BetModel betModel) throws JsonProcessingException {

betService.create(betModel);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(betModel);


    }





}