package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ForgotPasswordController {

    @GetMapping(value = "/forgotPassword")
    public String forgotPassword(Model model){
        return "authorization/forgotPassword";
    }
}
