package haianh.com.edu.sodaubai.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role_info")
public class Role extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public enum ROLE {
        ADMIN, USER
    }

    public Role(ROLE role){
        this.name = role.name();
    }

}
