package swag.rest.nis_risk_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "actions")
@Accessors(fluent = true)
public class Actions {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getSupportNotNeeded() {
        return supportNotNeeded;
    }

    public void setSupportNotNeeded(Boolean supportNotNeeded) {
        this.supportNotNeeded = supportNotNeeded;
    }

    public Boolean getSignContract() {
        return signContract;
    }

    public void setSignContract(Boolean signContract) {
        this.signContract = signContract;
    }

    public Boolean getLiveInDanger() {
        return liveInDanger;
    }

    public void setLiveInDanger(Boolean liveInDanger) {
        this.liveInDanger = liveInDanger;
    }

    public Boolean getNeedSupport() {
        return needSupport;
    }

    public void setNeedSupport(Boolean needSupport) {
        this.needSupport = needSupport;
    }


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "support_not_needed")
    private Boolean supportNotNeeded;

    @Column(name = "sign_contract")
    private Boolean signContract;

    @Column(name = "live_in_danger")
    private  Boolean liveInDanger;

    @Column(name = "need_support")
    private Boolean needSupport;



}
