package boost.brain.course.account.controller;

import boost.brain.course.account.Constants;
import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.controller.exceptions.NotFoundException;
import boost.brain.course.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(Constants.ACCOUNT_CONTROLLER_PREFIX)
public class AccountController {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @PostMapping(path = Constants.CREATE_PREFIX,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    AccountDto create(@RequestBody AccountDto accountDto) {
        AccountDto result = accountRepository.create(accountDto);


        return result;
    }

    @GetMapping(path = Constants.READ_PREFIX + "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    AccountDto read(@PathVariable long accountId) {
        AccountDto result = accountRepository.read(accountId);
        if (result == null) {
            throw new NotFoundException();
        }

        return result;
    }

    @PatchMapping(path = Constants.UPDATE_PREFIX,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String update(@RequestBody AccountDto accountDto) {
        if (accountRepository.update(accountDto)) {
            return HttpStatus.OK.getReasonPhrase();
        } else {
            throw new NotFoundException();
        }


    }

    @DeleteMapping(path = Constants.DELETE_PREFIX + "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String delete(@PathVariable long accountId) {
        if (accountRepository.delete(accountId)) {
            return HttpStatus.OK.getReasonPhrase();
        } else {
            throw new NotFoundException();
        }
    }
}
