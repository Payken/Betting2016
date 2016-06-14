package com.ai.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;

/**
 * Created by fdarmoch on 2015-12-28.
 */
@Controller
@RequestMapping("/") // url (w domysle http://localhost:8080)
public class UserController {




    @RequestMapping("/user")  //  rozszerzenie urla z klasy, brak oznacza ze to ten sam url
    public String getView(Model model) {
        return "user"; // zwraca sciezke wzgledna do widoku, domyslnie folder templates w resources
    }


}