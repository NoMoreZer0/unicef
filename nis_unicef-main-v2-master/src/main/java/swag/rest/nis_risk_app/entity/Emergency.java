package swag.rest.nis_risk_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Emergency {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "informed_administration_fio")
    private String informedAdministrationFIO;

    @Column(name = "informed_parent_fio")
    private String informedParentFIO;

    @Column(name = "is_student_isolated")
    private String isStudentIsolated;

    @Column(name = "is_student_transferred")
    private String isStudentTransferred;

    @OneToMany(mappedBy = "fileEmergency")
    @JsonIgnore
    @ToString.Exclude
    private List<File> files;

    @OneToOne(mappedBy = "studentEmergency")
    private Student student;

    public Emergency(String informedAdministrationFIO, String informedParentFIO, String isStudentIsolated, String isStudentTransferred, Student student) {
        this.informedAdministrationFIO = informedAdministrationFIO;
        this.informedParentFIO = informedParentFIO;
        this.isStudentIsolated = isStudentIsolated;
        this.isStudentTransferred = isStudentTransferred;
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Emergency emergency = (Emergency) o;
        return id != null && Objects.equals(id, emergency.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
