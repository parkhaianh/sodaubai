package haianh.com.edu.sodaubai.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import haianh.com.edu.sodaubai.entity.Role;

import java.util.Set;

public class UserDTO extends AuditDTO {

    private Long id;

    private String username;

    private String password;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("password_confirm")
    private String passwordConfirm;

    private Set<Role> roles;
    
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public enum Status {
        ACTIVE, INACTIVE, WAITING
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
