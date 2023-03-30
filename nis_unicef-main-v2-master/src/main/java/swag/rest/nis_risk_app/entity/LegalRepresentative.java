package swag.rest.nis_risk_app.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "legal_representative")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
public class LegalRepresentative {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public OtherPerson getOtherPerson() {
        return otherPerson;
    }

    public void setOtherPerson(OtherPerson otherPerson) {
        this.otherPerson = otherPerson;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private Father father;

    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Mother mother;

    @ManyToOne
    @JoinColumn(name = "other_person_id")
    private OtherPerson otherPerson;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        LegalRepresentative that = (LegalRepresentative) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
