package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.model.ClientChangeModel;
import kg.nurtelecom.cashbackclient.model.ClientModel;
import kg.nurtelecom.cashbackclient.model.DeviceChangeModel;
import kg.nurtelecom.cashbackclient.service.CodeService;
import kg.nurtelecom.cashbackclient.service.ProfileService;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {

    @Autowired
    private CodeService codeService;
    @Autowired
    private ProfileService profileService;

    private ContextHolder contextHolder = ContextHolder.getInstance();

    @GetMapping(value = "/p")
    public String main(Model model) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        model.addAttribute("device", new DeviceChangeModel());
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("client", profileService.getClientById(contextHolder.getClientId()));


        return "profile";
    }

    @PostMapping(value = "/p")
    public String update(@ModelAttribute ClientModel clientModel) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        ClientChangeModel dto = new ClientChangeModel(clientModel.getFirstName(), clientModel.getLastName(), clientModel.getPatronymic(), clientModel.getClientSex(), clientModel.getNationality(), clientModel.getLocale());
        profileService.putClientById(contextHolder.getClientId(), dto);

        return "redirect:/p";
    }
    @PostMapping(value = "/p/c")
    public String change(@ModelAttribute DeviceChangeModel deviceModel) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        System.out.println("change:");
        System.out.println(deviceModel);

        if (deviceModel.getCurrentPassword()!=null && (deviceModel.getNewPassword().equals(deviceModel.getConfirmPassword()))){
            if(profileService.putDeviceById(contextHolder.getClientId(), deviceModel)){
                return "redirect:/p";
            }
        }


        return "redirect:/p?error";
    }
}