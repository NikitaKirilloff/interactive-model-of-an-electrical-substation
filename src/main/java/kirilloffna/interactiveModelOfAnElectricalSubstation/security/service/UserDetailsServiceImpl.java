package kirilloffna.interactiveModelOfAnElectricalSubstation.security.service;

import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.CommonUserDetails;
import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.User;
import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserRepository userRepository;

  @Override
  @Transactional
  public CommonUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("Пользователь с E-mail '" + username + "' не найден"));
    return CommonUserDetails.build(user);
  }
}
