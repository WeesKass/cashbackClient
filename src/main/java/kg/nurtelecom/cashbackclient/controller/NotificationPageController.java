package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotificationPageController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping(value = "/notificationPage")
    public String notificationPage(Model model) {
        model.addAttribute("notifications", notificationService.getNotifications());
        return "notificationPage";}
}
