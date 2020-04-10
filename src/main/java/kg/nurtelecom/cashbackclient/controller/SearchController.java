package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @Autowired
    private SearchService searchService;

    @GetMapping(value = "/searchPage")
    public String searchPage(Model model, String search){
        model.addAttribute("search",searchService.findByName(search.toLowerCase()));
        return "searchPage";
    }

}
