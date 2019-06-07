package nl.teundeclercq.portofolio.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
public class UserToDo {
    private String id;
    private String username;
    private String email;
    private Role role;
    private Set<Portfolio> portfolios;
    private Set<Admin> admins;
    public UserToDo(String id, String username, String email, Role role, Set<Portfolio> portfolios, Set<Admin> admins) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.portfolios = portfolios;
        this.admins = admins;
    }
}
