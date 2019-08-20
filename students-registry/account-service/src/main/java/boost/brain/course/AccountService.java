package boost.brain.course;

import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.repository.AccountsRepository;
import boost.brain.course.account.repository.entities.AccountEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AccountService {
    public static void main(String[] args){
        SpringApplication.run(AccountService.class, args);
    }

//    @Bean
//    CommandLineRunner initDatabase(AccountsRepository repository) {
//
//        return args -> {
//            List<AccountDto> temp = new ArrayList<>();
//            temp.add(new AccountDto("arkaleks@yandex.ru", "password"));
//            temp.add(new AccountDto("arkaleks@yandex1.ru", "password1"));
//            temp.add(new AccountDto("arkaleks@yandex2.ru", "password2"));
//
//            for (AccountDto cp : temp) {
//                repository.save(cp);
//            }
//
//        };
//    }
}
