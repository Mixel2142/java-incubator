package boost.brain.course.account.controller.dto;

import lombok.Data;

@Data
public class AccountDto {
    private long accountId;
    private String email;
    private String password;

}
