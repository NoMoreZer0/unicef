package swag.rest.nis_risk_app.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class ChildDevelopmentPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public Integer criteria;
    public String discoveredRiskFactors;
    public String measures;
    public String measurePeriod;
    public String employee;
    public RatingScale ratingScale;
    public Integer indicator;
}
