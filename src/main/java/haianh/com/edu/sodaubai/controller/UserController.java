package haianh.com.edu.sodaubai.controller;

import haianh.com.edu.sodaubai.model.UserDTO;
import haianh.com.edu.sodaubai.security.SecurityService;
import haianh.com.edu.sodaubai.service.UserService;
import haianh.com.edu.sodaubai.utils.SodaubaiException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {

    private UserService userService;

    private SecurityService securityService;

    public UserController(UserService userService, SecurityService securityService) {
        this.userService = userService;
        this.securityService = securityService;
    }

    @PostMapping("registration")
    public ModelAndView registration(Model model,@ModelAttribute("userForm") UserDTO user) {
        try {
            user.setStatus(UserDTO.Status.ACTIVE);
            user.setFullName("");
            userService.save(user);
            securityService.autoLogin(user.getUsername(), user.getPasswordConfirm());
        } catch (SodaubaiException se) {
            model.addAttribute("error", se.getMessage());
            return new ModelAndView("registration");
        }
        return new ModelAndView("index");
    }

    @GetMapping("registration")
    public String getRegistration(Model model) {
        model.addAttribute("userForm", new UserDTO());
        return "registration";
    }

    @GetMapping("index")
    public String goToIndex() {
        return "index";
    }
}
