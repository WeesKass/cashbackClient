package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.service.*;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OrgInfoController {

    @Autowired
    private BonusService bonusService;
    @Autowired
    private FilialService filialService;
    @Autowired
    private EventService eventService;
    @Autowired
    private CodeService codeService;
    @Autowired
    private OrganizationService organizationService;

    private ContextHolder contextHolder = ContextHolder.getInstance();

    @GetMapping(value = "/info/{id}")
    public String main(@PathVariable("id") Long id, Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("bonuses", bonusService.getAllBonusByOrgId(id,0, 3));
        model.addAttribute("filials", filialService.getAllFilialsByOrgId(id,0, 1));
        model.addAttribute("events", eventService.getAllEventsByOrgId(id,0, 2));
        model.addAttribute("org", organizationService.getOrganizationInfo(id));
        return "orgInfo";
    }
    @GetMapping(value = "/info/{id}/filial/list")
    public String filialPagination(@PathVariable("id") Long id,
                                  @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", required = false, defaultValue = "1") Integer size,
                                  Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("bonuses", bonusService.getAllBonusByOrgId(id,0, 3));
        model.addAttribute("filials", filialService.getAllFilialsByOrgId(id,page, size));
        model.addAttribute("events", eventService.getAllEventsByOrgId(id,0, 2));
        model.addAttribute("org", organizationService.getOrganizationInfo(id));

        return "orgInfo";
    }
    @GetMapping(value = "/info/{id}/event/list")
    public String eventPagination(@PathVariable("id") Long id,
                                  @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", required = false, defaultValue = "2") Integer size,
                                  Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("bonuses", bonusService.getAllBonusByOrgId(id,0, 3));
        model.addAttribute("events", eventService.getAllEventsByOrgId(id, page, size));
        model.addAttribute("filials", filialService.getAllFilialsByOrgId(id,0, 1));
        model.addAttribute("org", organizationService.getOrganizationInfo(id));

        return "orgInfo";
    }

    @GetMapping(value = "/info/{id}/bonus/list")
    public String bonusPagination(@PathVariable("id") Long id,
                                  @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                  @RequestParam(value = "size", required = false, defaultValue = "3") Integer size,
                                  Model model) {
        if (contextHolder.getHeaders().get("Authorization") == null) {
            return "redirect:/login";
        }
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("bonuses", bonusService.getAllBonusByOrgId(id, page, size));
        model.addAttribute("events", eventService.getAllEventsByOrgId(id,0, 2));
        model.addAttribute("filials", filialService.getAllFilialsByOrgId(id,0, 1));
        model.addAttribute("org", organizationService.getOrganizationInfo(id));

        return "orgInfo";
    }
}
