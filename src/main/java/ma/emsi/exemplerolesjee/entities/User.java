package ma.emsi.exemplerolesjee.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import java.util.ArrayList;
import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="USERS")
public class User {
    @Id
    private String userId;

    @Column(name="USER_NAME",unique=true,length=20)
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private String password;
    @ManyToMany(mappedBy ="users",fetch= FetchType.EAGER)
    private List<Role> roles=new ArrayList<>();
    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }
}
