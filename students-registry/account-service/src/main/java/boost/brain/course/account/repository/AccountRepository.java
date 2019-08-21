package boost.brain.course.account.repository;

import boost.brain.course.account.controller.dto.AccountDto;
import boost.brain.course.account.repository.entities.AccountEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
//Для простых репозиториев используйте что то типа SimpleJpaRepository
//но это учебный пример
public class AccountRepository {

    private final EntityManager entityManager;

    @Autowired
    public AccountRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public AccountDto create(AccountDto accountDto) {
        if (accountDto == null) {
            return null;
        }

        AccountEntity accountEntity = new AccountEntity();
        BeanUtils.copyProperties(accountDto, accountEntity);
        entityManager.persist(accountEntity);

        AccountDto result = new AccountDto();
        BeanUtils.copyProperties(accountEntity, result);

        return result;
    }

    public AccountDto read(String email) {
        AccountEntity accountEntity = entityManager.find(AccountEntity.class, email);
        if (accountEntity == null) {
            return null;
        }

        AccountDto result = new AccountDto();
        BeanUtils.copyProperties(accountEntity, result);

        return result;
    }

    public boolean update(AccountDto accountDto) {
        if (accountDto == null) {
            return false;
        }

        AccountEntity accountEntity = entityManager.find(AccountEntity.class, accountDto.getEmail());
        if (accountEntity == null) {
            return false;
        }

        BeanUtils.copyProperties(accountDto, accountEntity);
        entityManager.merge(accountEntity);

        return true;
    }

    public boolean delete(String email) {
        AccountEntity accountEntity = entityManager.find(AccountEntity.class, email);
        if (accountEntity == null) {
            return false;
        }

        entityManager.remove(accountEntity);
        return true;
    }



}
