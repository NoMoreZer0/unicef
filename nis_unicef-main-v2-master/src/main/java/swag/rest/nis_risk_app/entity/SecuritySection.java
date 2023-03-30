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
@Table(name = "security_section")
public class SecuritySection {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RedSecuritySection getRedSecuritySection() {
        return redSecuritySection;
    }

    public void setRedSecuritySection(RedSecuritySection redSecuritySection) {
        this.redSecuritySection = redSecuritySection;
    }

    public YellowSecuritySection getYellowSecuritySection() {
        return yellowSecuritySection;
    }

    public void setYellowSecuritySection(YellowSecuritySection yellowSecuritySection) {
        this.yellowSecuritySection = yellowSecuritySection;
    }

    public GreenSecuritySection getGreenSecuritySection() {
        return greenSecuritySection;
    }

    public void setGreenSecuritySection(GreenSecuritySection greenSecuritySection) {
        this.greenSecuritySection = greenSecuritySection;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "red_security_section_id")
    private RedSecuritySection redSecuritySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "yellow_security_section_id")
    private YellowSecuritySection yellowSecuritySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "green_security_section_id")
    private GreenSecuritySection greenSecuritySection;

}
