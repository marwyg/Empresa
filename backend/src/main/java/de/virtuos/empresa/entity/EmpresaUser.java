package de.virtuos.empresa.entity;

import de.virtuos.empresa.entity.converter.EmpresaUserRoleToStringConverter;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EmpresaUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "empresa_user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_name")
    @Enumerated(EnumType.STRING)
    @Convert(converter = EmpresaUserRoleToStringConverter.class)
    private Set<EmpresaUserRole> roles;

    /**
     * getter
     *
     * @return Int id
     */
    public Integer getId() {
        return id;
    }

    /**
     * setter
     *
     * @param id the id
     */
    public void setId(Integer id) {
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

    public Collection<EmpresaUserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<EmpresaUserRole> roles) {
        this.roles = roles;
    }

    public void addRole(EmpresaUserRole role) {
        if (roles == null) roles = new HashSet<>();
        roles.add(role);
    }

    public String[] convertRolesToArray() {
        if (roles == null) return null;
        return Arrays.stream(roles.toArray()).map(Object::toString).toArray(String[]::new);
    }

}
