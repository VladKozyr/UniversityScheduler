package com.kma.scheduler.universityscheduler.entity;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
@Table(name="user")
@Inheritance(strategy = InheritanceType.JOINED)
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEntity  implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "Blank name...")
    private String name;
    @NotBlank(message = "Blank surname...")
    private String surname;
    private String password;

    private String role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.of(new Role(role)).collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public String getUsername() {
        return this.getName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}