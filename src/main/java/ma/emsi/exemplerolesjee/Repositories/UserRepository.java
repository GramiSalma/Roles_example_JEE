package ma.emsi.exemplerolesjee.Repositories;

import ma.emsi.exemplerolesjee.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByUsername(String userName);

}
