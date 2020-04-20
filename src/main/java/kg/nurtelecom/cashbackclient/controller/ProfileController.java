package kg.nurtelecom.cashbackclient.controller;

import kg.nurtelecom.cashbackclient.model.*;
import kg.nurtelecom.cashbackclient.service.CodeService;
import kg.nurtelecom.cashbackclient.service.ProfileService;
import kg.nurtelecom.cashbackclient.utils.ContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfileController {

    @Autowired
    private CodeService codeService;
    @Autowired
    private ProfileService profileService;

    private ContextHolder contextHolder = ContextHolder.getInstance();

    @GetMapping(value = "/profile")
    public String main(Model model) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        ProfileModel profileModel = profileService.getClientById(contextHolder.getClientId());
        model.addAttribute("device", new DeviceChangeModel());
        model.addAttribute("phone", new PhoneChangeModel());
        model.addAttribute("code", codeService.getCodeByClientId());
        model.addAttribute("client", profileModel.getClient());
        model.addAttribute("profile", profileModel);


        return "profile";
    }

    @PostMapping(value = "/profile")
    public String update(@ModelAttribute ClientModel clientModel) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        ClientChangeModel dto = new ClientChangeModel(clientModel.getFirstName(), clientModel.getLastName(), clientModel.getPatronymic(), clientModel.getClientSex(), clientModel.getNationality(), clientModel.getLocale());
        profileService.putClientById(contextHolder.getClientId(), dto);

        return "redirect:/profile";
    }
    @PostMapping(value = "/profile/password")
    public String change(@ModelAttribute DeviceChangeModel deviceModel) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        System.out.println("change password:");
        System.out.println(deviceModel);

        if (deviceModel.getCurrentPassword()!=null && (deviceModel.getNewPassword().equals(deviceModel.getConfirmPassword()))){
            if(profileService.putDeviceById(contextHolder.getClientId(), deviceModel)){
                return "redirect:/profile";
            }
        }


        return "redirect:/profile?error";
    }

    @PostMapping(value = "/profile/phone")
    public String change(@ModelAttribute PhoneChangeModel phone) {
//        if (contextHolder.getHeaders().get("Authorization") == null) {
//            return "redirect:/login";
//        }
        System.out.println("change phone:");
        System.out.println(phone);
        if(profileService.changeDeviceById(contextHolder.getClientId(), phone.getPhoneNumber())){
            return "redirect:/profile";
        }


        return "redirect:/profile?error";
    }
}