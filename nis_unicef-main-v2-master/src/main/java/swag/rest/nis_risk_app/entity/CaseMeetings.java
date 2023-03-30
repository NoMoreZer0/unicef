package swag.rest.nis_risk_app.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "case_meeting")
public class CaseMeetings {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private String date;

    @ManyToOne
    @JoinColumn(name = "case_id", referencedColumnName = "id")
    private Case studentCase;

    @Column(name = "post")
    private String post;

    @Column(name = "rating")
    private String rating;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users meetingHolder;

    public CaseMeetings(String date, Case studentCase, Users meetingHolder) {
        this.date = date;
        this.studentCase = studentCase;
        this.meetingHolder = meetingHolder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CaseMeetings that = (CaseMeetings) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
