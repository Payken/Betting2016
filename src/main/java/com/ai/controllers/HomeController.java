package com.ai.controllers;


import com.ai.domain.LoginPOJO;
import com.ai.domain.Role;
import com.ai.domain.User;

import com.ai.domain.Wallet;
import com.ai.repositories.RoleRepository;
import com.ai.repositories.UserRepository;
import com.ai.repositories.WalletRepository;
import com.ai.services.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
@Autowired
    RoleRepository roleRepository;
    @Autowired
    WalletRepository walletRepository;
    @RequestMapping()  //  rozszerzenie urla z klasy, brak oznacza ze to ten sam url
    public String getView(Model model) {
        init();
        return "redirect:/index"; // zwraca sciezke wzgledna do widoku, domyslnie folder templates w resources
    }
    @RequestMapping("/index")  //  rozszerzenie urla z klasy, brak oznacza ze to ten sam url
    public String getIndex(Model model) {

        return "index"; // zwraca sciezke wzgledna do widoku, domyslnie folder templates w resources
    }

    private void init() {
//        System.out.println(userRepository.findByLogin("admin"));
        if (userRepository.findByLogin("admin")==null)
        {User Admin = new User();
        Admin.setLogin("admin");
        Admin.setPassword("admin");
        Role RoleAdmin = new Role();
        RoleAdmin.setType("Admin");
        roleRepository.save(RoleAdmin);
        Admin.setRole(roleRepository.findByType("Admin"));
        userRepository.save(Admin);
        Role RoleUser = new Role();
        RoleUser.setType("User");
        roleRepository.save(RoleUser);
        User user = new User();
        user.setLogin("user");
        user.setPassword("user");
        user.setCredits(100);
        user.setRole(roleRepository.findByType("User"));
        userRepository.save(user);
            Wallet wallet = new Wallet();
            wallet.setName("Pilka nozna");
            if (walletRepository.findByName("Pilka nozna")==null)
            walletRepository.save(wallet);
            Wallet wallet2 = new Wallet();
            wallet2.setName("Koszykowka");
            if (walletRepository.findByName("Koszykowka")==null)
            walletRepository.save(wallet2);
            Wallet wallet3 = new Wallet();
            if (walletRepository.findByName("Siatkowka")==null)
            wallet3.setName("Siatkowka");
            walletRepository.save(wallet3);
        }
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
    public String searchProduct(@RequestBody LoginPOJO loginPOJO) throws JsonProcessingException {


        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userService.isCorrect(loginPOJO));


    }
    @RequestMapping(value="/getUserInfo", method=RequestMethod.GET)
    @ResponseBody
    public String getInfo(@RequestParam("mail")String mail) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(userRepository.findByMail(mail));
    }

}