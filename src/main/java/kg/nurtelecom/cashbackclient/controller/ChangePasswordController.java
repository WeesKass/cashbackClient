package kg.nurtelecom.cashbackclient.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ChangePasswordController {
    @GetMapping(value = "/changePassword")
    public String  changePasswordPage(Model model) {return "changePassword";}

    @PostMapping("/resetPassword")
    public String resetPassword(Model model, Integer masa, Integer wzrost) {

        String x = String.valueOf(masa);
        String y = String.valueOf(wzrost);

        if(x==null ){
            model.addAttribute("wzrost",true);
            return"/layout";
        }

        if(y==null ){
            model.addAttribute("wzrost",true);
            return"/layout";
        }
        return "/changePassword";
    }

//    // Gets a Person.
//    @RequestMapping(value="/edit", method=RequestMethod.GET)
//    public String getEditPerson(@RequestParam("personId") String personId, Model model) {
//        logger.info(PersonController.class.getName() + ".getEditPerson() method called.");
//
//        Person person = personDAO.get(Integer.parseInt(personId));
//        model.addAttribute("person", person);
//
//        // Set view.
//        return "/edit";
//    }
}
