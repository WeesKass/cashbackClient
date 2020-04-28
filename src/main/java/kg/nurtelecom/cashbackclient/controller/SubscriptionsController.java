package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.service.BalanceHistoryService;
import kg.nurtelecom.cashbackclient.service.CodeService;
import kg.nurtelecom.cashbackclient.service.OrganizationService;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionsController {

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private BalanceHistoryService historyService;
    @Autowired
    private CodeService codeService;

    private ContextHolder contextHolder = ContextHolder.getInstance();

    @GetMapping(value = "/subs")
    public String main(Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("history", historyService.getAllHistory(0, 10));
        model.addAttribute("orgsList", organizationService.getAllOrgs(0, 5));
        return "subscriptions";
    }

    @GetMapping(value = "subs/history/list/")
    public String main(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = "10") Integer size,
                       Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("history", historyService.getAllHistory(page, size));
        model.addAttribute("orgsList", organizationService.getAllOrgs(0, 5));
        return "subscriptions";
    }

}