package haianh.com.edu.sodaubai.service;

import haianh.com.edu.sodaubai.entity.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}
