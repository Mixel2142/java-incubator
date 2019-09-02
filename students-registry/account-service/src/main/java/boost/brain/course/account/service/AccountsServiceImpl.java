package boost.brain.course.account.service;

import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.controller.exceptions.NotFoundException;
import boost.brain.course.account.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl  {

//    @Autowired
//    private AccountRepository accountRepo;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//
//    @Override
//    public AccountDto findAccountByEmail(String email) {
//        AccountDto account = accountRepo.read(email);
//        if (email == null) {
//            throw new NotFoundException();
//        }
//
//        return account;
//    }
//
//    @Override
//    public void saveAccount(AccountDto account) {
//        account.setPassword(bCryptPasswordEncoder.encode(account.getPassword()));
//        accountRepo.create(account);
//    }
}
