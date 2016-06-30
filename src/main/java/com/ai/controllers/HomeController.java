package com.ai.controllers;


import com.ai.domain.Login;
import com.ai.domain.User;
import com.ai.domain.Wallet;

import com.ai.repositories.UserRepository;
import com.ai.services.UserService;
import com.ai.services.WalletService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fdarmoch on 2015-12-28.
 */
@Controller
@RequestMapping("/") // url (w domysle http://localhost:8080)
public class HomeController {

@Autowired
    UserRepository userRepository;
@Autowired
    UserService userService;

    @RequestMapping()  //  rozszerzenie urla z klasy, brak oznacza ze to ten sam url
    public String getView(Model model) {
        return "redirect:/index"; // zwraca sciezke wzgledna do widoku, domyslnie folder templates w resources
    }
    @RequestMapping("/index")  //  rozszerzenie urla z klasy, brak oznacza ze to ten sam url
    public String getIndex(Model model) {
        return "index"; // zwraca sciezke wzgledna do widoku, domyslnie folder templates w resources
    }
    @RequestMapping(value="/addUser", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public String searchProduct(@RequestBody User user) throws JsonProcessingException {

        userService.create(user);
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userRepository.findByMail(user.getMail()));


    }
    @RequestMapping(value="/loginAndroid", method = RequestMethod.POST, produces = "application/JSON")
    @ResponseBody
    public String searchProduct(@RequestBody Login login) throws JsonProcessingException {


        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userService.isCorrect(login));


    }
    @RequestMapping(value="/getUserInfo", method=RequestMethod.GET)
    @ResponseBody
    public String getInfo(@RequestParam("mail")String mail) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userRepository.findByMail(mail));
    }

}