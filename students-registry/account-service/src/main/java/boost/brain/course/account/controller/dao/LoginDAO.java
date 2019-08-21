package boost.brain.course.account.controller.dao;

import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

    @Repository
    public class LoginDAO {

        public boolean submit(String email, String password, ModelMap m)
        {
            if(email.equals("email")&&password.equals("12345"))
            {
                m.addAttribute("email", email);
                return true;
            }
            else
            {
                m.addAttribute("errormsg","email and password doesn't match");
                return false;
            }
        }
    }

