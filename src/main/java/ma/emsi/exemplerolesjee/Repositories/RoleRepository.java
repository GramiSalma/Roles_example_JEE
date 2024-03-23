package ma.emsi.exemplerolesjee.Repositories;

import ma.emsi.exemplerolesjee.entities.Role;
import ma.emsi.exemplerolesjee.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
