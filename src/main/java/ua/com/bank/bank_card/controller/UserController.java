package ua.com.bank.bank_card.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String getRegistrationPage(){
        return "register";
    }


    @PostMapping("/register")
    public String saveNewClient(@RequestParam("username") String username,
                                @RequestParam("password") String password,
                                @RequestParam("firstName") String firstName,
                                @RequestParam("lastName") String lastName,
                                @RequestParam("fatherName") String fatherName,
                                @RequestParam("email") String email,
                                @RequestParam("phone") String phone,
                                @RequestParam("age") int age
    ) {

        Users users = new Users();

        users.setUsername(username);
        users.setPassword(password);


        Users user1 = userService.saveNewUserToDB(users);


        Client client = new Client();

        client.setFirstName(firstName);
        client.setLastName(lastName);
        client.setFatherName(fatherName);
        client.setEmail(email);
        client.setPhone(phone);
        client.setAge(age);
        client.setUsers(user1);

        clientService.saveNewClientToDB(client);

        return "redirect:/login";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextHolder.clearContext();


        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return "redirect:/logout-page";
    }
}