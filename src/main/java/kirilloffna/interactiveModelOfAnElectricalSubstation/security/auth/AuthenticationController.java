package kirilloffna.interactiveModelOfAnElectricalSubstation.security.auth;

import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.Role;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class AuthenticationController {

  @GetMapping("/")
  public String main(Authentication authentication) {
    if (authentication != null && authentication.isAuthenticated()) {
      Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
      if (authorities != null && !authorities.isEmpty()) {
        if (authorities.contains(new SimpleGrantedAuthority(Role.ROLE_ADMIN.name()))) {
          return "redirect:/admin";
        } else if (authorities.contains(new SimpleGrantedAuthority(Role.ROLE_ENGINEER.name()))) {
          return "redirect:/engineer";
        } else if (authorities.contains(new SimpleGrantedAuthority(Role.ROLE_USER.name()))) {
          return "redirect:/user";
        }
      }
    }
    return "redirect:/login";
  }

  @GetMapping("/admin")
  public String admin() {
    return "adminDefault";
  }

  @GetMapping("/engineer")
  public String engineer() {
    return "redirect:/substations";
  }

  @GetMapping("/user")
  public String substation() {
    return "redirect:/substations/viewing";
  }

  @GetMapping("/login")
  public String showMainPage() {
    return "loginPage";
  }
}
