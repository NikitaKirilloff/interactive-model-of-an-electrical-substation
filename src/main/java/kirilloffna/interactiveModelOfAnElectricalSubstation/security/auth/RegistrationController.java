package kirilloffna.interactiveModelOfAnElectricalSubstation.security.auth;

import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.Role;
import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.User;
import kirilloffna.interactiveModelOfAnElectricalSubstation.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
  public String registration(@ModelAttribute("user") User user, @RequestParam("secretWord") String role) {
    if ("ADMIN".equals(role)) {
      user.setRole(Role.ROLE_ADMIN);
    } else if ("ENGINEER".equals(role)) {
      user.setRole(Role.ROLE_ENGINEER);
    } else {
      user.setRole(Role.ROLE_USER);
    }
    userService.saveUser(user);
    return "redirect:/login";
  }
}
