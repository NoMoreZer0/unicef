package swag.rest.nis_risk_app.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "family_history_form4")
@AllArgsConstructor
public class FamilyHistoryForm4 extends ChildDevelopmentPlan{

}