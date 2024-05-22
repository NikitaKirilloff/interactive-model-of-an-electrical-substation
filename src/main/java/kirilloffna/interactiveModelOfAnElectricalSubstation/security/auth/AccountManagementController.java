package kirilloffna.interactiveModelOfAnElectricalSubstation.security.auth;

import kirilloffna.interactiveModelOfAnElectricalSubstation.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountManagementController {
  private final UserService userService;

  @GetMapping
  public String getAllAccounts(Model model) {
    model.addAttribute("users", userService.getAllUsers());
    return "accountManagement";
  }
}
