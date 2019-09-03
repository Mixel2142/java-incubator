package boost.brain.course.account.controller;

import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class HelloController {

    @Autowired
    AccountRepository repository;

    @RequestMapping(value = "/secure")
    public String secure() {
        return "You are authorize to access this page. This is secure page. ";
    }
    @RequestMapping(value = "/home")
    public String home() {
        return "This is public page. No need of authentication";
    }
}
