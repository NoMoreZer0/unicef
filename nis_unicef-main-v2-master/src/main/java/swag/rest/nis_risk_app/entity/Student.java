package swag.rest.nis_risk_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;
import swag.rest.nis_risk_app.util.StudentStatus;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Student extends StudentInformation{

    @Column(name = "language")
    private String language;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "school")
    private String school;

    @ManyToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    @JsonIgnore
    private Users curator;

    @ManyToMany
    @ToString.Exclude
    private List<Parent> parents;

    @Column(name = "student_status")
    @Enumerated(EnumType.STRING)
    private StudentStatus studentStatus;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "student_case_id")
    @JsonIgnore
    private Case studentCase;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "student_emergency_id")
    @JsonIgnore
    private Emergency studentEmergency;


}
