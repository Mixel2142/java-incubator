package boost.brain.course.account.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService{

    public boolean validateEmail(String email, String password) {
        return (email.equals("email") && password.equals("password")) ? true : false;
    }
}
