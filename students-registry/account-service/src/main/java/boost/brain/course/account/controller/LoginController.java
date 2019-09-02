package boost.brain.course.account.controller;

import boost.brain.course.account.Constants;
import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping(Constants.ACCOUNT_CONTROLLER_PREFIX)
public class LoginController {

//    @Autowired
//    private AccountsService accountsService;


    @GetMapping(path = Constants.LOGIN_PREFIX,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
        ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

//    @GetMapping(path = Constants.REGISTRATION_PREFIX,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public @ResponseBody
//    ModelAndView registration(){
//        ModelAndView modelAndView = new ModelAndView();
//        AccountDto account = new AccountDto();
//        modelAndView.addObject("account", account);
//        modelAndView.setViewName("registration");
//        return modelAndView;
//    }
//
//
//    @PostMapping(path = Constants.REGISTRATION_PREFIX,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public @ResponseBody
//    ModelAndView createNewAccount(AccountDto account, BindingResult bindingResult) {
//        ModelAndView modelAndView = new ModelAndView();
//        AccountDto userExists = accountsService.findAccountByEmail(account.getEmail());
//        if (userExists != null) {
//            bindingResult
//                    .rejectValue("email", "error.account",
//                            "There is already an account registered with the email provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("registration");
//        } else {
//            accountsService.saveAccount(account);
//            modelAndView.addObject("successMessage", "Account has been registered successfully");
//            modelAndView.addObject("account", new AccountDto());
//            modelAndView.setViewName("registration");
//
//        }
//        return modelAndView;
//    }



//    @GetMapping(path = Constants.LOGOUT_PREFIX,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public @ResponseBody
//    String logout(SessionStatus session) {
//        SecurityContextHolder.getContext().setAuthentication(null);
//        session.setComplete();
//        return "redirect:/welcome";
//    }

}
