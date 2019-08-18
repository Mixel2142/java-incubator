package boost.brain.course.account.repository.entities;

import boost.brain.course.account.controller.dto.AccountDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ACCOUNTS")
public class AccountEntity {
    @Id
   // @Column(name = "ACCOUNT_ID", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long accountId;
    @ManyToMany
    @JoinTable(name = "users", joinColumns = @JoinColumn(name = "email"), 
            inverseJoinColumns = @JoinColumn(name = "user_email"))
    private String email;
    private String password;
    
    
}
