package swag.rest.nis_risk_app.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "family_safe_factor")
public class FamilySafeFactor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "family_rule_set")
    private Boolean familyRuleSet;

    @Column(name = "role_model")
    private Boolean roleModel;

    @Column(name = "supporting_environment")
    private Boolean supportingEnvironment;

    @Column(name = "safe_bonding")
    private Boolean safeBonding;

    @Column(name = "caring_parent")
    private Boolean caringParent;

    @Column(name = "stability")
    private Boolean stability;

    @Column(name = "good_parent_skills")
    private Boolean goodParentSkills;

    @Column(name = "positive_practice")
    private Boolean positivePractice;

    @Column(name = "basic_need")
    private Boolean basicNeed;

    @Column(name = "sustainable_relation")
    private Boolean sustainableRelation;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilySafeFactor that = (FamilySafeFactor) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}