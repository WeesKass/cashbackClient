package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChangePasswordController {
    @GetMapping(value = "/changePassword")
    public String  changePasswordPage(Model model) {return "changePassword";}

}
