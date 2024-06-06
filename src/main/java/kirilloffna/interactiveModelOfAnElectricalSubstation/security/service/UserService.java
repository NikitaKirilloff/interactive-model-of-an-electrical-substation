package kirilloffna.interactiveModelOfAnElectricalSubstation.security.service;

import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.Role;
import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.User;
import kirilloffna.interactiveModelOfAnElectricalSubstation.security.entity.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService{

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  public User getUserById(Long id){
    return userRepository.getReferenceById(id);
  }

  public void saveUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    userRepository.save(user);
  }

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public void deleteUser(Long id) {
    userRepository.deleteById(id);
  }
}