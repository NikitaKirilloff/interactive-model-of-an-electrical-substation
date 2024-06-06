package kirilloffna.interactiveModelOfAnElectricalSubstation.security.auth;

import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.Role;
import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.User;
import kirilloffna.interactiveModelOfAnElectricalSubstation.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/{id}")
  public String deleteAccount(@PathVariable Long id) {
    User user = userService.getUserById(id);
    if (!user.getRole().equals(Role.ROLE_ADMIN)) {
      userService.deleteUser(id);
    }
    return "redirect:/account";
  }
}
