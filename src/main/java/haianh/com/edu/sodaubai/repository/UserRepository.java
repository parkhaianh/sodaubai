package haianh.com.edu.sodaubai.repository;

import haianh.com.edu.sodaubai.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    @SuppressWarnings("unchecked")
	User save(User user);
}
