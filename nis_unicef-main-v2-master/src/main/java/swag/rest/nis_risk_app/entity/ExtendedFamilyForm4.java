package swag.rest.nis_risk_app.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "extended_family_form4")
@AllArgsConstructor
public class ExtendedFamilyForm4 extends ChildDevelopmentPlan{

}