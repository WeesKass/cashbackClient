package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientOrgSubscribesController {
    @GetMapping(value = "/clientOrgSubscribes")
    public String clientOrgSubscribes(Model model) {return "clientOrgSubscribes";}

}
