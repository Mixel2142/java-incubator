package boost.brain.course.account.repository.entities;

import boost.brain.course.account.controller.dto.AccountDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ACCOUNTS")
@Access(AccessType.FIELD)
@Getter
@Setter
public class AccountEntity {
    @Id
    @Column(name = "ACCOUNT_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;
//    @ManyToMany
//    @JoinTable(name = "users", joinColumns = @JoinColumn(name = "email"),
//            inverseJoinColumns = @JoinColumn(name = "user_email"))
    @Column(name = "ACCOUNT_EMAIL")
    private String email;
    @Column(name = "ACCOUNT_PASSWORD")
    private String password;

    public AccountEntity(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public AccountEntity() {

    }


}
