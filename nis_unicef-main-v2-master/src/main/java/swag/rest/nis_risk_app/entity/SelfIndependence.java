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
@Table(name = "self_independence_v2")
public class SelfIndependence {


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public YellowSelfIndependence getYellowSelfIndependence() {
        return yellowSelfIndependence;
    }

    public void setYellowSelfIndependence(YellowSelfIndependence yellowSelfIndependence) {
        this.yellowSelfIndependence = yellowSelfIndependence;
    }

    public GreenSelfIndependence getGreenSelfIndependence() {
        return greenSelfIndependence;
    }

    public void setGreenSelfIndependence(GreenSelfIndependence greenSelfIndependence) {
        this.greenSelfIndependence = greenSelfIndependence;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_self_independence_id")
    private YellowSelfIndependence yellowSelfIndependence;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "green_self_independence_id")
    private GreenSelfIndependence greenSelfIndependence;

}
