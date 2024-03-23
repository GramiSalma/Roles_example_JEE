package ma.emsi.exemplerolesjee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="ROLES")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    @Column(name="ROLE_NAME",unique=true,length=20)
    private String roleName;
    private String description;
    @ManyToMany(fetch= FetchType.EAGER)
   // @JoinTable(name="USERS_ROLES")
    @ToString.Exclude
    private List<User> users=new ArrayList<>();
}
