package haianh.com.edu.sodaubai.service;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import haianh.com.edu.sodaubai.entity.Role;
import haianh.com.edu.sodaubai.entity.Role.ROLE;
import haianh.com.edu.sodaubai.entity.User;
import haianh.com.edu.sodaubai.model.UserDTO;
import haianh.com.edu.sodaubai.repository.RoleRepository;
import haianh.com.edu.sodaubai.repository.UserRepository;
import haianh.com.edu.sodaubai.utils.SodaubaiException;

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
    public void save(UserDTO user) {
    	User existedUser = findByUsername(user.getUsername());
        if(!Objects.isNull(existedUser)) {
            throw new SodaubaiException("username is existed!");
        }
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role userRole = roleRepository.findRoleByName(ROLE.USER.name());
        User userInfo = new ObjectMapper().convertValue(user, User.class);
        userInfo.setRoles(Stream.of(userRole).collect(Collectors.toSet()));
        userRepository.save(userInfo);
    }

    @Override
    public haianh.com.edu.sodaubai.entity.User findByUsername(String username) {
    	return userRepository.findByUsername(username);
    }
}
