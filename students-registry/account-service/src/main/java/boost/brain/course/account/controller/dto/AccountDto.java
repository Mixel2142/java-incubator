package boost.brain.course.account.controller.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

@Data
public class AccountDto {
//    @NonNull
//    @NotEmpty
//    private long accountId;
    @NonNull
    @NotEmpty
 //   @Column(unique=true)
    private String email;
    @NonNull
    @NotEmpty
    private String password;


    public AccountDto() {

    }
}
