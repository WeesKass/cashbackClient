package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientPromoCodePageController {

    @GetMapping(value = "/clientPromoCodePage")
    public String clientPromoCodePage(Model model) { return "clientPromoCodePage"; }
}
