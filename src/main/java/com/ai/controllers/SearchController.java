
package com.ai.controllers;

import com.ai.domain.Wallet;
import com.ai.model.SearchModel;
import com.ai.repositories.BetRepository;
import com.ai.repositories.UserRepository;


import com.ai.services.BetService;
import com.ai.services.UserService;
import com.ai.services.WalletService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by fdarmoch on 2015-12-28.
 */
@Controller
@RequestMapping("/search") // url (w domysle http://localhost:8080)
public class SearchController {


@Autowired
    BetRepository betRepository;
@Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
   private BetService betService;
    @Autowired
    private WalletService walletService;


    @ModelAttribute("categories")
    private List<Wallet> walletList(){
        return walletService.wallets();
    }



    @RequestMapping  //  rozszerzenie urla z klasy, brak oznacza ze to ten sam url
    public String getView(Model model) {
        return "search"; // zwraca sciezke wzgledna do widoku, domyslnie folder templates w resources
    }


    @RequestMapping(value="/searchBet", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public String searchProduct(@RequestBody SearchModel searchModel) throws JsonProcessingException {


        ObjectMapper objectMapper = new ObjectMapper();

//        DateFormat df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
//        objectMapper.setDateFormat(df);
objectMapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
        objectMapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII,true);

            return objectMapper.writeValueAsString(betService.getBets(searchModel));


    }


    @RequestMapping(value="/activeBet", method=RequestMethod.GET)
    @ResponseBody
    public String getActive() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(betRepository.findByActiveTrue());
    }



}