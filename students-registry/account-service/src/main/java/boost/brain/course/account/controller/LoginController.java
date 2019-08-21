package boost.brain.course.account.controller;

import boost.brain.course.account.Constants;
import boost.brain.course.account.controller.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(Constants.ACCOUNT_CONTROLLER_PREFIX)
public class LoginController {

    @Autowired
    LoginDAO logindao;

    @GetMapping(path = Constants.LOGIN_PREFIX,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    String showLogin()
    {
        return "LOGIN";
    }


    @PostMapping(path = Constants.LOGIN_PREFIX,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    String submit(@RequestParam("email") String email,@RequestParam("password") String password, ModelMap m)
    {
        System.out.println("email:" + email);
        System.out.println("password:" + password);

        if(logindao.submit(email, password, m))
        {
            return "HOME";
        }
        else
        {
            return "LOGIN";
        }
    }
}
