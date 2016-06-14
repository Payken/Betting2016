package com.ai.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by fdarmoch on 2015-12-28.
 */
@Controller
@RequestMapping("/") // url (w domysle http://localhost:8080)
public class ContactController {




    @RequestMapping("/contact")  //  rozszerzenie urla z klasy, brak oznacza ze to ten sam url
    public String getView(Model model) {
        return "contact"; // zwraca sciezke wzgledna do widoku, domyslnie folder templates w resources
    }


}