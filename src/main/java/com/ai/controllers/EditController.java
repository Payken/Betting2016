package com.ai.controllers;


import com.ai.domain.Bet;
import com.ai.model.EditModel;
import com.ai.model.SearchModel;
import com.ai.repositories.BetRepository;
import com.ai.services.BetService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.Console;

/**
 * Created by fdarmoch on 2015-12-28.
 */
@Controller
@RequestMapping("/edit") // url (w domysle http://localhost:8080)
public class EditController {


@Autowired
    BetService betService;
@Autowired
    BetRepository betRepository;

    @RequestMapping(value="*/doIT", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public String edit(@RequestBody EditModel editModel) throws JsonProcessingException {
// TODO: 2016-06-28 Obsługa zakładu 
        Bet bet= new Bet();
bet=betService.getOne(editModel.getId());
        bet.setHomeGoals(editModel.getHomegoals());
        bet.setAwayGoals(editModel.getAwaygoals());
        bet.setWon(Boolean.parseBoolean(editModel.getWon()));
        bet.setActive(Boolean.parseBoolean("FALSE"));
        betRepository.save(bet);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(editModel);


    }

    @RequestMapping("/{id}")
    public String showProduct(@PathVariable Integer id, Model model){
        model.addAttribute("product", betService.getOne(id));
        return "edit";
    }

//    @RequestMapping("/edit/{someID}")
//   String getAttr(@PathVariable(value="someID") String id) {
//      System.out.println(id);
//
//    return "edit";
//
//    }

}