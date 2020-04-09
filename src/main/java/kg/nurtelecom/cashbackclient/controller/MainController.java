package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.service.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {


    @Autowired
    private RequestTemplate requestTemplate;

    @GetMapping(value = "/")
    public String main(Model model) {
        if ( requestTemplate.getHeaders().get("Authorization") ==  null) {
            return "redirect:/login";
        }
        return "layout";
    }
}
