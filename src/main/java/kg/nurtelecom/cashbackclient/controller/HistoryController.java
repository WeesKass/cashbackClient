package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.service.BalanceHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HistoryController {

    @Autowired
    BalanceHistoryService balanceHistoryService;

    @GetMapping(value = "/historyPage")
    public String historyPage(Model model){
        model.addAttribute("historyList", balanceHistoryService.getAllHistory(1L));
        return "historyPage";
    }
}
