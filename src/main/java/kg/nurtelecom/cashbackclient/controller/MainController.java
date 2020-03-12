package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/layout")
    public String main(Model model){
        return "layout";
    }

    @GetMapping(value = "/")
    public String authorization(Model model){
        return "authorization/authorization";
    }

    @GetMapping(value = "/forgotPassword")
    public String forgotPassword(Model model){
        return "authorization/forgotPassword";
    }

    @GetMapping(value = "/settings")
    public String setting(Model model){
        return "settingsPage";
    }

    @GetMapping(value = "/history")
    public String history(Model model){
        return "history";
    }

    @GetMapping(value = "/search")
    public String search(Model model){
        return "search";
    }

    @GetMapping(value = "/clientPromoCodePage")
    public String clientPromoCodePage(Model model)
    {
        return "clientPromoCodePage";
    }

    @GetMapping(value = "/codePage")
    public String codePage(Model model) {return "codePage";}

    @GetMapping(value = "/notificationPage")
    public String notificationPage(Model model) {return "notificationPage";}

}

