package swag.rest.nis_risk_app.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@Table(name = "source")
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
public class Source {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateOfMeeting() {
        return dateOfMeeting;
    }

    public void setDateOfMeeting(String dateOfMeeting) {
        this.dateOfMeeting = dateOfMeeting;
    }

    public String getNameOfPerson() {
        return nameOfPerson;
    }

    public void setNameOfPerson(String nameOfPerson) {
        this.nameOfPerson = nameOfPerson;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getConnectionWithStudent() {
        return connectionWithStudent;
    }

    public void setConnectionWithStudent(String connectionWithStudent) {
        this.connectionWithStudent = connectionWithStudent;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "date_of_meeting")
    private String dateOfMeeting;

    @Column(name = "name_of_person")
    private String nameOfPerson;

    @Column(name = "organization")
    private String organization;

    @Column(name = "connection_with_student")
    private String connectionWithStudent;

    @Column(name = "contact")
    private String contact;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Source source = (Source) o;
        return id != null && Objects.equals(id, source.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}