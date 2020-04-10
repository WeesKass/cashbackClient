package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.service.OrganizationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OrganizationInfoController {

    @Autowired
    OrganizationInfoService organizationInfoService;

    @GetMapping(value = "/orgInfo/{id}")
    public String clientOrgSubscribes(@PathVariable("id")Long id, Model model) {
        model.addAttribute("organizationInfo", organizationInfoService.getOrganizationInfo(id));
        return "organizationInfo";
    }

}
