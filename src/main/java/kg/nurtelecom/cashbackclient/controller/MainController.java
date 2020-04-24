package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.service.BonusService;
import kg.nurtelecom.cashbackclient.service.CodeService;
import kg.nurtelecom.cashbackclient.service.EventService;
import kg.nurtelecom.cashbackclient.service.OrganizationService;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private OrganizationService organizationService;
    @Autowired
    private BonusService bonusService;
    @Autowired
    private EventService eventService;
    @Autowired
    private CodeService codeService;

    private ContextHolder contextHolder = ContextHolder.getInstance();

    @GetMapping(value = "/")
    public String main(Model model) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("bonuses", bonusService.getAllBonus(0, 3));
        model.addAttribute("events", eventService.getAllEvents(0, 2));
        model.addAttribute("orgList", organizationService.getAllOrgByNameOrDesc("",0,7));

        return "home";
    }
    @GetMapping(value = "org/list")
    public String organizationPagination(@RequestParam(value = "search", required = false, defaultValue = "") String search,
                       @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = "7") Integer size,
                       Model model) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("bonuses", bonusService.getAllBonus(0, 3));
        model.addAttribute("events", eventService.getAllEvents(0, 2));
        model.addAttribute("orgList", organizationService.getAllOrgByNameOrDesc(search, page, size));
        model.addAttribute("value", search);

        return "home";
    }
    @GetMapping(value = "event/list")
    public String eventPagination(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = "2") Integer size,
                       Model model) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("bonuses", bonusService.getAllBonus(0, 3));
        model.addAttribute("events", eventService.getAllEvents(page, size));
        model.addAttribute("orgList", organizationService.getAllOrgByNameOrDesc("",0,5));

        return "home";
    }

    @GetMapping(value = "bonus/list")
    public String bonusPagination(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                       @RequestParam(value = "size", required = false, defaultValue = "3") Integer size,
                       Model model) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("bonuses", bonusService.getAllBonus(page, size));
        model.addAttribute("events", eventService.getAllEvents(0, 2));
        model.addAttribute("orgList", organizationService.getAllOrgByNameOrDesc("",0,5));

        return "home";
    }
}
