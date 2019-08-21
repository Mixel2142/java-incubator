package boost.brain.course.account.controller;

import boost.brain.course.account.Constants;
import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping(path = Constants.REGISTRATION_PREFIX,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    String registration() {
        return "registration";
    }

    @PostMapping(path = Constants.REGISTRATION_PREFIX,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    String addUser(AccountDto account, Map<String, Object> model) {
        AccountDto accountFromDb = accountRepository.read(account.getEmail());
        if (accountFromDb != null) {
            model.put("message", "Account exists!");
            return "registration";
        }
        accountRepository.create(account);

        return "redirect:/login";
    }
}