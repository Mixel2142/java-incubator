package boost.brain.course.account.repository;

import boost.brain.course.account.repository.entities.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface AccountsRepository extends JpaRepository<AccountEntity, Long> {

    @Override
    <S extends AccountEntity>S save(S s);


 //   <S extends AccountEntity>S update(S s);

//    public void deleteProjectByProjectId(long accountId);
}
