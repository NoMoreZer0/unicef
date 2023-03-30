package swag.rest.nis_risk_app.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity(name = "other_person")
@AllArgsConstructor
@NoArgsConstructor
public class OtherPerson extends Parent {

    @Column(name = "who_exactly")
    private String whoExactly;

    @Column(name = "workplace")
    private String workplace;

}
