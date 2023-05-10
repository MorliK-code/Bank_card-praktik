package ua.com.bank.bank_card.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegController {


    @GetMapping("/reg")
    public String getPageReg() {
        return "reg";
    }
}