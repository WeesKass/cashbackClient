package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AuthorizationController {
    @GetMapping(value = "/")
    public String authorization(Model model){
        return "authorization/authorization";
    }
}
