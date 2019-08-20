package boost.brain.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountService {
    public static void main(String[] args){
        SpringApplication.run(AccountService.class, args);
    }

//    @Bean
//    CommandLineRunner initDatabase(AccountRepository repository) {
//
//        return args -> {
//            List<AccountDto> temp = new ArrayList<>();
//            temp.add(new AccountDto("arkaleks@yandex.ru", "password"));
//            temp.add(new AccountDto("arkaleks@yandex1.ru", "password1"));
//            temp.add(new AccountDto("arkaleks@yandex2.ru", "password2"));
//            for (AccountDto cp : temp) {
//                repository.create(cp);
//            }
//
//        };
//    }
}
