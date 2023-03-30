package swag.rest.nis_risk_app.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "opinion_of_involved_parties")
public class OpinionOfInvolvedParties {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String childComment;
    private String parentComment;
    private String organizationComment;
}
