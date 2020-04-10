package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CodePageController {

    @Autowired
    private CodeService codeService;

    @GetMapping(value = "/codePage")
    public String codePage(Model model) {
        model.addAttribute("code", codeService.getCodeByClientId(2L));
        return "codePage";

    }
}
