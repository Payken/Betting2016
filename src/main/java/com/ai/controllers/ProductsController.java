package com.ai.controllers;



import com.ai.domain.Bet;
import com.ai.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by fdarmoch on 2015-12-28.
 */
@Controller
@RequestMapping("/products") // url (w domysle http://localhost:8080)
public class ProductsController {

@Autowired
BetService betService;

 @ModelAttribute("products")
 private List<Bet> protections() {return betService.safeguards();}

    @RequestMapping()  //  rozszerzenie urla z klasy, brak oznacza ze to ten sam url
    public String getView(Model model) {
        return "products"; // zwraca sciezke wzgledna do widoku, domyslnie folder templates w resources
    }


}