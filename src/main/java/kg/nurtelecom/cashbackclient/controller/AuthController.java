package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.model.AuthModel;
import kg.nurtelecom.cashbackclient.service.AuthService;
import kg.nurtelecom.cashbackclient.service.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class AuthController {

    @Autowired
    private AuthService authService;
    @Autowired
    private RequestTemplate requestTemplate;


    @GetMapping(value = "/login")
    public String authPage(Model model){
        if (requestTemplate.getHeaders().get("Authorization") == null){
            model.addAttribute("user", new AuthModel());
            return "authorization/authorization";
        } else {
            return "redirect:/";
        }


    }

    @PostMapping(value = "/login")
    public String login(@ModelAttribute(value = "user") AuthModel authModel){
        if(authService.login(authModel)){
            return "redirect:/";
        }
        return "redirect:/login?error";
    }

    @GetMapping(value = "/logout")
    public String logout(){
        authService.logout();
        return "redirect:/login?logout";
    }
}
