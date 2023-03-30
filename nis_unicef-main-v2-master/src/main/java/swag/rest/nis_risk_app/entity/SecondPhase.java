package swag.rest.nis_risk_app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "second_phase_2")
@Accessors(fluent = true)
public class SecondPhase extends Phase{
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FourthPhase getFourthPhase() {
        return fourthPhase;
    }

    public void setFourthPhase(FourthPhase fourthPhase) {
        this.fourthPhase = fourthPhase;
    }

    public HealthSection getHealthSection() {
        return healthSection;
    }

    public void setHealthSection(HealthSection healthSection) {
        this.healthSection = healthSection;
    }

    public EducationSection getEducationSection() {
        return educationSection;
    }

    public void setEducationSection(EducationSection educationSection) {
        this.educationSection = educationSection;
    }

    public EmotionalIntelligence getEmotionalIntelligence() {
        return emotionalIntelligence;
    }

    public void setEmotionalIntelligence(EmotionalIntelligence emotionalIntelligence) {
        this.emotionalIntelligence = emotionalIntelligence;
    }

    public IdentitySection getIdentitySection() {
        return identitySection;
    }

    public void setIdentitySection(IdentitySection identitySection) {
        this.identitySection = identitySection;
    }

    public FamilySection getFamilySection() {
        return familySection;
    }

    public void setFamilySection(FamilySection familySection) {
        this.familySection = familySection;
    }

    public SelfIndependence getSelfIndependence() {
        return selfIndependence;
    }

    public void setSelfIndependence(SelfIndependence selfIndependence) {
        this.selfIndependence = selfIndependence;
    }

    public SecuritySection getSecuritySection() {
        return securitySection;
    }

    public void setSecuritySection(SecuritySection securitySection) {
        this.securitySection = securitySection;
    }

    public AboutFamily getAboutFamily() {
        return aboutFamily;
    }

    public void setAboutFamily(AboutFamily aboutFamily) {
        this.aboutFamily = aboutFamily;
    }

    public Boolean getWarning() {
        return warning;
    }

    public void setWarning(Boolean warning) {
        this.warning = warning;
    }

    public Case getStudentCase() {
        return studentCase;
    }

    public void setStudentCase(Case studentCase) {
        this.studentCase = studentCase;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "health_section_id")
    private HealthSection healthSection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "education_section_id")
    private EducationSection educationSection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "emotional_intelligence_id")
    private EmotionalIntelligence emotionalIntelligence;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "identity_section_id")
    private IdentitySection identitySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "family_section_id")
    private FamilySection familySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "self_independence_id")
    private SelfIndependence selfIndependence;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "security_section_id")
    private SecuritySection securitySection;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "about_family_id")
    private AboutFamily aboutFamily;

    @Column(name = "warning")
    private Boolean warning;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cases_id")
    private Case studentCase;

    @Lob
    @Column(name = "document")
    @JsonIgnore
    private byte[] document;

    @OneToOne
    @JoinColumn(name = "fourth_phase_id")
    private FourthPhase fourthPhase;


    public SecondPhase warningStatus() throws IllegalAccessException {
        this.setWarning(this.emotionalIntelligence.bloodyRedEmotionalIntelligence().inDanger()
                     || this.familySection.bloodyRedFamilySection().inDanger());
        return this;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SecondPhase that = (SecondPhase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
