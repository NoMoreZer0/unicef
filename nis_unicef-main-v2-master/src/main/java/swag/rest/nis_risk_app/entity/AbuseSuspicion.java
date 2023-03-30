package swag.rest.nis_risk_app.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "abuse_suspicion")
@Accessors(fluent = true)
public class AbuseSuspicion {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDomesticViolence() {
        return domesticViolence;
    }

    public void setDomesticViolence(Boolean domesticViolence) {
        this.domesticViolence = domesticViolence;
    }

    public Boolean getSexualAbuse() {
        return sexualAbuse;
    }

    public void setSexualAbuse(Boolean sexualAbuse) {
        this.sexualAbuse = sexualAbuse;
    }

    public Boolean getParentMakeDangerousEnv() {
        return parentMakeDangerousEnv;
    }

    public void setParentMakeDangerousEnv(Boolean parentMakeDangerousEnv) {
        this.parentMakeDangerousEnv = parentMakeDangerousEnv;
    }

    public Boolean getLocationUnknown() {
        return locationUnknown;
    }

    public void setLocationUnknown(Boolean locationUnknown) {
        this.locationUnknown = locationUnknown;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "domestic_violence")
    private Boolean domesticViolence;

    @Column(name = "sexual_abuse")
    private Boolean sexualAbuse;

    @Column(name = "parent_make_dangerous_env")
    private Boolean parentMakeDangerousEnv;

    @Column(name = "location_unknown")
    private Boolean locationUnknown;


}
