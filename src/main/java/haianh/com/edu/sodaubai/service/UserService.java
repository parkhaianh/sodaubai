package haianh.com.edu.sodaubai.service;

import haianh.com.edu.sodaubai.model.UserDTO;

public interface UserService {

    void save(UserDTO user);

    haianh.com.edu.sodaubai.entity.User findByUsername(String username);
}
