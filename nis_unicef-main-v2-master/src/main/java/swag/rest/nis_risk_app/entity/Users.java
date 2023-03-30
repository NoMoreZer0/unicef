package swag.rest.nis_risk_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import swag.rest.nis_risk_app.util.Role;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "FIO")
    private String fio;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

    @Column(name = "school")
    private String school;

    @Lob
    @Column(name = "picture")
    @ToString.Exclude
    @JsonIgnore
    private byte[] picture;

    @Column(name = "picture_link")
    private String pictureLink;


    @Column(name = "enabled")
    @JsonIgnore
    private boolean enabled;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    @OneToMany(mappedBy = "curator")
    @JsonIgnore
    @ToString.Exclude
    private List<Student> studentList;

    @OneToMany(mappedBy = "meetingHolder")
    @JsonIgnore
    @ToString.Exclude
    private List<CaseMeetings> caseMeeting;

    @Column(name = "is_curator")
    private Boolean isCurator;

    @ManyToMany
    @JsonIgnore
    @ToString.Exclude
    private List<Notification> notifications;

    @ManyToMany
    @JsonIgnore
    @ToString.Exclude
    private List<CommonFiles> files;

    public static String getCurrentUserRole() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        return authentication
                .getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList()).get(0);
    }



    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role.name()));
        return authorities;
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
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", FIO='" + fio + '\'' +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", position='" + position + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Users users = (Users) o;
        return id != null && Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
