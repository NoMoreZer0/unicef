package swag.rest.nis_risk_app.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(fluent = true)
@Table(name = "emotional_intelligence_v2")
public class EmotionalIntelligence {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RedEmotionalIntelligence getRedEmotionalIntelligence() {
        return redEmotionalIntelligence;
    }

    public void setRedEmotionalIntelligence(RedEmotionalIntelligence redEmotionalIntelligence) {
        this.redEmotionalIntelligence = redEmotionalIntelligence;
    }

    public YellowEmotionalIntelligence getYellowEmotionalIntelligence() {
        return yellowEmotionalIntelligence;
    }

    public void setYellowEmotionalIntelligence(YellowEmotionalIntelligence yellowEmotionalIntelligence) {
        this.yellowEmotionalIntelligence = yellowEmotionalIntelligence;
    }

    public BloodyRedEmotionalIntelligence getBloodyRedEmotionalIntelligence() {
        return bloodyRedEmotionalIntelligence;
    }

    public void setBloodyRedEmotionalIntelligence(BloodyRedEmotionalIntelligence bloodyRedEmotionalIntelligence) {
        this.bloodyRedEmotionalIntelligence = bloodyRedEmotionalIntelligence;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "red_emotional_intelligence_id")
    private RedEmotionalIntelligence redEmotionalIntelligence;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_emotional_intelligence_id")
    private YellowEmotionalIntelligence yellowEmotionalIntelligence;


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "bloody_red_emotional_intelligence_id")
    private BloodyRedEmotionalIntelligence bloodyRedEmotionalIntelligence;

}
