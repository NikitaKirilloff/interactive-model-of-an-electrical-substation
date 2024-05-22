package kirilloffna.interactiveModelOfAnElectricalSubstation.security.auth;

import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.User;
import kirilloffna.interactiveModelOfAnElectricalSubstation.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {

  private final UserService userService;

  @GetMapping()
  public String registration(Model model) {
    model.addAttribute("user", new User());
    return "registrationPage";
  }

  @PostMapping()
  public String registration(@ModelAttribute("user") User user) {
    userService.saveUser(user);
    return "redirect:/login";
  }
}
