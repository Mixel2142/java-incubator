package boost.brain.course.account.controller;

import boost.brain.course.account.Constants;
import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.controller.exceptions.NotFoundException;
import boost.brain.course.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.ACCOUNT_CONTROLLER_PREFIX)
public class AccountController {

    private final AccountRepository repository;

    @Autowired
    public AccountController(AccountRepository repository) {
        this.repository = repository;
    }

    /**
     * Метод создает аккаунт AccountDto
     * @param accountDto
     * @return accountDto
     * @throws
     */

    /**
     * проверка метода
     * curl -d '{"accountId":11, "email":"newEmail", "password":"newPassword"}'
     * -H 'Content-Type: application/json'
     * http://localhost:8080/api/account/create
     */

    @PostMapping(path = Constants.CREATE_PREFIX,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    AccountDto create(@RequestBody AccountDto accountDto) {
        AccountDto result = repository.create(accountDto);
        return result;
    }

    /**
     * Метод считывает данные аккаунта AccountDto
     * @param accountDto
     * @return accountDto
     * @throws
     */

    /**
     * проверка метода
     * curl -v http://localhost:8080/api/account/read/accountId
     */

    @GetMapping(path = Constants.READ_PREFIX + "/{accountId}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    AccountDto read(@PathVariable long accountId) {
        AccountDto result = repository.read(accountId);
        if (result == null) {
            throw new NotFoundException();
        }
        return result;
    }


    /**
     * Метод изменяет данные аккаунта AccountDto
     * @param accountDto
     * @return String
     * @throws
     */

    /**
     * проверка метода
     * curl -d '{"accountId": accountId, "email":"newEmail", "password":"newPassword"}'
     * -H 'Content-Type: application/json'
     * -X PATCH http://localhost:8080/api/account/update
     */

    @PatchMapping(path = Constants.UPDATE_PREFIX,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String update(@RequestBody AccountDto accountDto) {
        if (repository.update(accountDto)) {
            return HttpStatus.OK.getReasonPhrase();
        } else {
            throw new NotFoundException();
        }
    }

    /**
     * Метод удаляет данные аккаунта AccountDto
     * @param accountId
     * @return String
     * @throws
     */

    /**
     * проверка метода
     * curl -X DELETE http://localhost:8080/api/account/dete/accountId
     */

    @DeleteMapping(path = Constants.DELETE_PREFIX + "/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String delete(@PathVariable long accountId) {
        if (repository.delete(accountId)) {
            return HttpStatus.OK.getReasonPhrase();
        } else {
            throw new NotFoundException();
        }
    }
}
