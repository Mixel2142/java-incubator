package boost.brain.course.account.repository.entities;

import boost.brain.course.account.controller.dto.AccountDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNTS")
@Getter
@Setter
public class AccountEntity {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long accountId;
//    @ManyToMany
//    @JoinTable(name = "users", joinColumns = @JoinColumn(name = "email"),
//            inverseJoinColumns = @JoinColumn(name = "user_email"))
    @Id
    @Column(name = "ACCOUNT_EMAIL")
    private String email;
    @Column(name = "ACCOUNT_PASSWORD")
    private String password;

}
