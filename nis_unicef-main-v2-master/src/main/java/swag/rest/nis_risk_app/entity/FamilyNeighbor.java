package swag.rest.nis_risk_app.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity(name = "family_neighbor")
@AllArgsConstructor
public class FamilyNeighbor extends Parent{
}
