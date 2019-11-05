package com.ewp.xprt.model;


import com.ewp.xprt.util.patterns.ValidationPattern;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Пользователь программы, менеджер, админ и т.д.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "user")
@NoArgsConstructor @ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @Getter @Setter
    private Long id;

    @Pattern(regexp = ValidationPattern.USER_FIRSTNAME_LASTNAME_PATTERN)
    @Column(name = "first_name", nullable = false)
    @Getter @Setter
    private String firstName;

    @Pattern(regexp = ValidationPattern.USER_FIRSTNAME_LASTNAME_PATTERN)
    @Column(name = "last_name", nullable = false)
    @Getter @Setter
    private String lastName;

    @Column(name = "email", nullable = false, unique = true)
    @Getter @Setter
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column(name = "password", nullable = false)
    @Getter @Setter
    private String password;

    @Column(name = "is_enabled") // включен, разрешен??? user-info.js, всегда false
    @Getter @Setter
    private boolean isEnabled;

    /**
     * Права (роль)
     * FetchType.EAGER for initialize all fields.
     * We use FetchMode.SUBSELECT for loading all elements of all collections.
     */
    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "permissions",
            joinColumns = {@JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER"))},
            inverseJoinColumns = {@JoinColumn(name = "role_id", foreignKey = @ForeignKey(name = "FK_ROLE"))})
    @Getter @Setter
    private List<Role> role = new ArrayList<>();

    public User(@Pattern(regexp = ValidationPattern.USER_FIRSTNAME_LASTNAME_PATTERN) String firstName, @Pattern(regexp = ValidationPattern.USER_FIRSTNAME_LASTNAME_PATTERN) String lastName, String email, String password, boolean isEnabled, @NotNull List<Role> role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;
        this.role = role;
    }

    public User(@Pattern(regexp = ValidationPattern.USER_FIRSTNAME_LASTNAME_PATTERN) String firstName, @Pattern(regexp = ValidationPattern.USER_FIRSTNAME_LASTNAME_PATTERN) String lastName, String email, String password, boolean isEnabled, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.isEnabled = isEnabled;
        this.role.add(role);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.synchronizedList(role);
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public String getPassword() {
        return password;
    }

}
