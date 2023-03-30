package swag.rest.nis_risk_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "other_person_living_with_family")
public class OtherPersonLivingWithFamily {
    private String fio;
    private String birthDate;
    private String relationLevel;
    private String workplace;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fourth_phase_id")
    @JsonIgnore
    private FourthPhase fourthPhase;
}
