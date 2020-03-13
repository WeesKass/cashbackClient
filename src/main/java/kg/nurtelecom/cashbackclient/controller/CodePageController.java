package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodePageController {
    @GetMapping(value = "/codePage")
    public String codePage(Model model) {return "codePage";}
}
