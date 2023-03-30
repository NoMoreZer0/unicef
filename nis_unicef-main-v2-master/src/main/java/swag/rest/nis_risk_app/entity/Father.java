package swag.rest.nis_risk_app.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity(name = "father")
@AllArgsConstructor
@NoArgsConstructor
public class Father extends Parent{
    @Column(name = "realFather")
    Boolean realFather;


}
