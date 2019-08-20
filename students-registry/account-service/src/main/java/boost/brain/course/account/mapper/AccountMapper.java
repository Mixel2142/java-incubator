package boost.brain.course.account.mapper;

import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.repository.entities.AccountEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountMapper {

        public AccountDto entityToDto(AccountEntity account) {
            AccountDto accountDto = new AccountDto();
            accountDto.setAccountId(account.getAccountId());
            accountDto.setEmail(account.getEmail());
            accountDto.setPassword(account.getPassword());
            return accountDto;
        }

        public AccountEntity dtoToAccount(AccountDto accountDto) {
            AccountEntity account = new AccountEntity();
            account.setAccountId(accountDto.getAccountId());
            account.setEmail(accountDto.getEmail());
            account.setPassword(accountDto.getPassword());
            return account;
        }

        public List<AccountDto> toProjectDtos(List<AccountEntity> accounts) {
            List<AccountDto> accountsDto = new ArrayList<>();
            for (AccountEntity account : accounts) {
                AccountDto accountDto = new AccountDto();
                accountDto.setAccountId(account.getAccountId());
                accountDto.setEmail(accountDto.getEmail());
                accountDto.setPassword(accountDto.getPassword());
                accountsDto.add(accountDto);
            }
            return accountsDto;
        }
}
