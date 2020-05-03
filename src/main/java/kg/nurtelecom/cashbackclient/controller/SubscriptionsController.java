package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.model.DateSearchModel;
import kg.nurtelecom.cashbackclient.model.DeviceChangeModel;
import kg.nurtelecom.cashbackclient.service.BalanceHistoryService;
import kg.nurtelecom.cashbackclient.service.CodeService;
import kg.nurtelecom.cashbackclient.service.OrganizationService;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SubscriptionsController {

    private final OrganizationService organizationService;
    private final BalanceHistoryService historyService;
    private final CodeService codeService;
//    private SimpleDateFormat format;
    private ContextHolder contextHolder = ContextHolder.getInstance();

    public SubscriptionsController(OrganizationService organizationService, BalanceHistoryService historyService, CodeService codeService) {
        this.organizationService = organizationService;
        this.historyService = historyService;
        this.codeService = codeService;
//        format = new SimpleDateFormat("dd-MM-yyyy");
    }

    @GetMapping(value = "/subs")
    public String subs(Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        model.addAttribute("search", new DateSearchModel());
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("history", historyService.getAllHistory(0, 1));
        model.addAttribute("orgsList", organizationService.getAllOrgs(0, 5));
        return "subscriptions";
    }

    @GetMapping(value = "/subs/{id}")
    public String subsPage(@PathVariable("id") Long catId,
                           @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                           @RequestParam(value = "size", required = false, defaultValue = "5") Integer size,
                           Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        model.addAttribute("search", new DateSearchModel());
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("history", historyService.getAllHistory(0, 1));
        model.addAttribute("orgsList", organizationService.getAllOrgsByCatId(catId, page, size));
        return "subscriptions";
    }

    @GetMapping(value = "/subs/history/list/")
    public String history(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                          @RequestParam(value = "size", required = false, defaultValue = "1") Integer size,
                          Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        model.addAttribute("search", new DateSearchModel());
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("history", historyService.getAllHistory(page, size));
        model.addAttribute("orgsList", organizationService.getAllOrgs(0, 5));
        return "subscriptions";
    }

    @GetMapping(value = "/subs/history/search/")
    public String historyByDate(@ModelAttribute DateSearchModel dateSearchModel,
                          @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                          @RequestParam(value = "size", required = false, defaultValue = "1") Integer size,
                          Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        System.out.println("yo");
        model.addAttribute("code", codeService.getCodeByClientId());
//        try {
            model.addAttribute("history", historyService.getAllHistoryByDate(dateSearchModel.getFrom(), dateSearchModel.getTo(), page, size));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        model.addAttribute("orgsList", organizationService.getAllOrgs(0, 5));
        return "subscriptions";
    }

}