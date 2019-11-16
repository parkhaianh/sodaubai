package haianh.com.edu.sodaubai.service;

import haianh.com.edu.sodaubai.entity.Role;
import haianh.com.edu.sodaubai.entity.User;
import haianh.com.edu.sodaubai.repository.RoleRepository;
import haianh.com.edu.sodaubai.repository.UserRepository;
import haianh.com.edu.sodaubai.utils.SodaubaiException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public void save(User user) {
        User existedUser = findByUsername(user.getUsername());
        if(!Objects.isNull(existedUser)) {
            throw new SodaubaiException("username is existed!");
        }
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
