package boost.brain.course.account.service;

import boost.brain.course.account.controller.dto.AccountDto;

public interface AccountsService {
     AccountDto findAccountByEmail(String email);
     void saveAccount(AccountDto account);



}
