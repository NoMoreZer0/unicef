package swag.rest.nis_risk_app.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "mother")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Mother extends Parent {
    @Column(name = "realMother")
    Boolean realMother;
}
