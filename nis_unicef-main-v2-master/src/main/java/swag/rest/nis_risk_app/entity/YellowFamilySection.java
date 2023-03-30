package swag.rest.nis_risk_app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "yellow_family_section")
public class YellowFamilySection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "no_positive_with_parent")
    private  Boolean noPositiveWithParent;
    @Column(name = "no_adult_depend")
    private  Boolean noAdultDepend;
    @Column(name = "no_bonding_parent_kid")
    private  Boolean noBondingParentKid;
    @Column(name = "no_like_family_member")
    private  Boolean noLikeFamilyMember;
    @Column(name = "no_friend")
    private  Boolean noFriend;
    @Column(name = "no_parent_skill")
    private Boolean noParentSkill;
    @Column(name = "take_parent_role")
    private Boolean takeParentRole;
    @Column(name = "far_away")
    private Boolean farAway;
    @Column(name = "problem_parent_kid")
    private Boolean problemParentKid;
    @Column(name = "chronic")
    private Boolean chronic;
    @Column(name = "sudimost")
    private Boolean sudimost;
    @Column(name = "trauma_past")
    private Boolean traumaPast;

}
