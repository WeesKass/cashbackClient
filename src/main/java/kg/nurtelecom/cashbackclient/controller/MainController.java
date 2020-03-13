package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = "/layout")
    public String main(Model model) {return "layout";}
}
