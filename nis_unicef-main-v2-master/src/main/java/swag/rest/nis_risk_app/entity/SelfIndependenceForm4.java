package swag.rest.nis_risk_app.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "self_independence_form4")
@AllArgsConstructor
public class SelfIndependenceForm4 extends ChildDevelopmentPlan{

}
