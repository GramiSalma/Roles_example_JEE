package ma.emsi.exemplerolesjee.service;

import lombok.AllArgsConstructor;
import ma.emsi.exemplerolesjee.Repositories.RoleRepository;
import ma.emsi.exemplerolesjee.Repositories.UserRepository;
import ma.emsi.exemplerolesjee.entities.Role;
import ma.emsi.exemplerolesjee.entities.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {


        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {

        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {

        User user=findUserByUserName(userName);
        Role role=findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }

    }

    @Override
    public User authenticate(String userName, String pasword) {
        User user=userRepository.findByUsername(userName);
        if (user==null) throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(pasword)){
            return user;
        }
        throw new RuntimeException("Bad credentials");

    }
}
