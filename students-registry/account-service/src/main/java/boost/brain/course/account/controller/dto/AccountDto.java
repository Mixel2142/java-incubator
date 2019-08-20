package boost.brain.course.account.controller.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.validation.constraints.NotEmpty;

@Data
public class AccountDto {
    @NonNull
    @NotEmpty
    private long accountId;
    @NonNull
    @NotEmpty
    private String email;
    @NonNull
    @NotEmpty
    private String password;


    public AccountDto() {

    }
//
//    public AccountDto(String email, String password) {
//        // this.accountId = accountId;
//        this.email = email;
//        this.password = password;
//
//    }
}
