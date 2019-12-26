package haianh.com.edu.sodaubai.model;

import java.util.Set;

public class RoleDTO extends AuditDTO {

    private Long id;

    private String name;

    private Set<UserDTO> users;

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

    public Set<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDTO> users) {
        this.users = users;
    }

    public enum ROLE {
        ADMIN, USER
    }

    public RoleDTO(ROLE role){
        this.name = role.name();
    }

    public RoleDTO(){
    }
}
