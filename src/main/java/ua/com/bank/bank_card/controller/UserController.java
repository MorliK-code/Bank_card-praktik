package ua.com.bank.bank_card.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ua.com.bank.bank_card.entity.Client;
import ua.com.bank.bank_card.entity.Users;
import ua.com.bank.bank_card.service.ClientManagerService;
import ua.com.bank.bank_card.service.UsersManagerService;

@Controller
public class UserController {

    private final ClientManagerService clientService;

    private final UsersManagerService userService;

    @Autowired
    public UserController(ClientManagerService clientService, UsersManagerService userService) {
        this.clientService = clientService;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }


    @GetMapping("/register")
    public String getRegistrationPage(Model model){

        model.addAttribute("users", new Users());
        model.addAttribute("client", new Client());

        return "register";
    }


    @PostMapping("/register")
    public String saveNewClient(@Valid Users users,
                                  BindingResult bindingResult,
                                  @Valid Client client,
                                  BindingResult bindingResult1,
                                  Model model
    ){

        if(bindingResult.hasErrors()){
            return "/register";
        }

        if(bindingResult1.hasErrors()){
            return "/register";
        }

        /* Перевірка користувача в системі  */

        if(userService.getLogicByUser(users.getUsername())){
            //  model.addAttribute("err", "Користувач з таким іменем вже існує!");
            return "/register";
        }


        Users user1 = userService.saveNewUserToDB(users);

        client.setUsers(user1);

        clientService.saveNewClientToDB(client);

        return "redirect:/login";
    }
}