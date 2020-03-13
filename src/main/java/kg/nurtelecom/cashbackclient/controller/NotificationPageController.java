package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotificationPageController {
    @GetMapping(value = "/notificationPage")
    public String notificationPage(Model model) {return "notificationPage";}
}
