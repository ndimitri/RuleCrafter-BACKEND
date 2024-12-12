package be.storm.rulecrafterbackend.dl.entities.user;

import be.storm.rulecrafterbackend.dl.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Setter
@Entity
@Table(name = "user_")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
public class User extends BaseEntity implements UserDetails {

    @Column(nullable = false, unique = true, length = 123)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String picture;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this(username, password);
        this.email = email;
    }

    public User(Long id, String username, String password) {
        super(id);
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String email, String picture) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.picture = picture;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("USER"));
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }
}
