package haianh.com.edu.sodaubai.service;

import haianh.com.edu.sodaubai.entity.Role;
import haianh.com.edu.sodaubai.entity.User;
import haianh.com.edu.sodaubai.repository.RoleRepository;
import haianh.com.edu.sodaubai.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = new Role(Role.ROLE.USER);
        user.setRoles(Stream.of(role).collect(Collectors.toSet()));
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
