package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.model.OrganizationModel;
import kg.nurtelecom.cashbackclient.service.ClientOrgSubscribesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClientOrgSubscribesController {
    @Autowired
    ClientOrgSubscribesService subscribesService;

    @GetMapping(value = "/subscribes")
    public String clientOrgSubscribes(Model model) {
        Map<String, List<OrganizationModel>> result;
        result = subscribesService.getAllSubscribes(1L);
        model.addAttribute("categoryOrganizationList", result);
        return "clientOrgSubscribes";
    }
}
