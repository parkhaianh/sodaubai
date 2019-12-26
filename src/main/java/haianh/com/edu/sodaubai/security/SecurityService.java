package haianh.com.edu.sodaubai.security;

public interface SecurityService {

    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
