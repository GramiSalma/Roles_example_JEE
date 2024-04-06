package ma.emsi.exemplerolesjee;

import ma.emsi.exemplerolesjee.entities.Role;
import ma.emsi.exemplerolesjee.entities.User;
import ma.emsi.exemplerolesjee.service.UserService;
import org.hibernate.sql.ast.SqlTreeCreationException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class ExempleRolesJeeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExempleRolesJeeApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserService userService){
        return args->{
            User u=new User();
            u.setUsername("user1");
            u.setPassword("123456");
            userService.addNewUser(u);

            User u2=new User();
            u2.setUsername("admin1");
            u2.setPassword("123456");
            userService.addNewUser(u2);

            Stream.of("STUDENT","ADMIN","USER").forEach(r->{
                Role role=new Role();
                role.setRoleName(r);
                userService.addNewRole(role);
            });

            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","USER");

            userService.addRoleToUser("admin1","USER");
            userService.addRoleToUser("admin1","ADMIN");


            try{
                User user=userService.authenticate("user1","123456");
                System.out.println(user.getUserId());
                System.out.println(user.getUsername());

                user.getRoles().forEach(r->{
                    System.out.println("Role=>"+r);
                });
            }catch (Exception exception){
                exception.printStackTrace();
            }



        };
    }
}
