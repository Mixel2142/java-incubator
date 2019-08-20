package boost.brain.course.account.controller;

import boost.brain.course.account.Constants;
import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.controller.exceptions.NotFoundException;
import boost.brain.course.account.mapper.AccountMapper;
import boost.brain.course.account.repository.AccountsRepository;
import boost.brain.course.account.repository.entities.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping(Constants.ACCOUNT_CONTROLLER_PREFIX)
public class AccountController {

    @Autowired
    private AccountsRepository repository;

    AccountMapper accountMapper = new AccountMapper();


    /**
     * Метод находит все аккаунты AccountsEntity
     * @param
     * @return List<AccountEntity>
     * @throws
     */
    @ResponseBody
    @GetMapping("/all")
    public List<AccountEntity> getAllCyclePath() {
        return repository.findAll();
    }

    /**
     * Метод находит все аккаунты AccountsEntity
     * @param
     * @return List<AccountEntity>
     * @throws
     */
    @GetMapping(path = Constants.READ_PREFIX + "/{id}",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody
    AccountDto read(@PathVariable long id) {
        AccountDto result = accountMapper.entityToDto(repository.findById(id).get());
        if (result == null) {
            throw new NotFoundException();
        }

        return result;
    }



//    @DeleteMapping(path = Constants.DELETE_PREFIX + "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public @ResponseBody String delete(@PathVariable long id) {
//        repository.delete(repository.findById(id).get());
////        {
//            return HttpStatus.OK.getReasonPhrase();
////        } else {
////            throw new NotFoundException();
////        }
//    }


//        @PatchMapping(path = Constants.UPDATE_PREFIX,
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//        AccountDto saveOrUpdate(@RequestBody AccountDto acc, @PathVariable long id) {
//
//            return repository.findById(id)
//                    .map(x -> {
//                        x.setEmail(acc.getEmail());
//                        x.setPassword(acc.getPassword());
//                        return repository.save(x);
//                    });
//                    .orElseGet(() -> {
//                        acc.setAccountId(id);
//                        AccountEntity result = accountMapper.dtoToAccount(acc);
//                        return repository.save(result);
//                    });
 //       }

    }



//    @ResponseBody
//    @RequestMapping(value="/deleteById", method = RequestMethod.DELETE)
//    public  String deleteById(@RequestBody AccountDto account){
//        String result ="deleting project with id: "+ account.getAccountId();
//        repository.delete(accountMapper.dtoToAccount(account).getAccountId());
//        return result;

//        @ResponseBody
//       // @RequestMapping(value="/findById",method = RequestMethod.GET)
//        @GetMapping("/{accountId}")
//        public AccountDto findById(@RequestBody AccountDto id) throws NoSuchElementException {
//            System.out.println(id.getAccountId());
//            //Project project = projectRepository.findById(id.getProjectId()).get();
//            System.out.println(repository.findById(accountMapper.dtoToAccount(id).getAccountId()));
//            AccountDto account = accountMapper.entityToDto(repository.findById(accountMapper.toProjectDtos(id).getProjectId()).get());
//            System.out.println(project.toString());
//            return account;
//        }

//    @ResponseBody
//    @GetMapping("/{accountId}")
//    Optional findOne(@PathVariable long accountId) {
//        return repository.findById(accountId);
////                .orElseThrow(() -> new CyclePathNotFoundException(globalId));
//    }


//    private final AccountRepository accountRepository;
//
//    @Autowired
//    public AccountController(AccountRepository accountRepository) {
//        this.accountRepository = accountRepository;
//    }
//
//    @PostMapping(path = Constants.CREATE_PREFIX,
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public @ResponseBody
//    AccountDto create(@RequestBody AccountDto accountDto) {
//        AccountDto result = accountRepository.create(accountDto);
//
//
//        return result;
//    }
//
//    @GetMapping(path = Constants.READ_PREFIX + "/{id}",
//            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public @ResponseBody
//    AccountDto read(@PathVariable long accountId) {
//        AccountDto result = accountRepository.read(accountId);
//        if (result == null) {
//            throw new NotFoundException();
//        }
//
//        return result;
//    }
//
//    @PatchMapping(path = Constants.UPDATE_PREFIX,
//            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @ResponseStatus(HttpStatus.OK)
//    public @ResponseBody String update(@RequestBody AccountDto accountDto) {
//        if (accountRepository.update(accountDto)) {
//            return HttpStatus.OK.getReasonPhrase();
//        } else {
//            throw new NotFoundException();
//        }
//
//
//    }
//
//    @DeleteMapping(path = Constants.DELETE_PREFIX + "/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public @ResponseBody String delete(@PathVariable long accountId) {
//        if (accountRepository.delete(accountId)) {
//            return HttpStatus.OK.getReasonPhrase();
//        } else {
//            throw new NotFoundException();
//        }
//    }
//}
