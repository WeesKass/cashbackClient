package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {
    @GetMapping(value = "/searchPage")
    public String searchPage(Model model, String search){
        model.addAttribute("searchResult", search);
        return "searchPage";
    }

}
