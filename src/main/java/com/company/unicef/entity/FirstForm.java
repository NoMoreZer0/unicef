package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.JmixEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@JmixEntity
@Table(name = "FIRST_FORM", indexes = {
        @Index(name = "IDX_FIRST_FORM_STUDENT", columnList = "STUDENT_ID")
})
@Entity
public class FirstForm {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "STUDENT_ID")
    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    @Column(name = "RISK_LEVEL")
    private String riskLevel;

    @Composition
    @OneToMany(mappedBy = "firstForm")
    private List<Meeting> meetings;

    @Column(name = "REASON_TEXT")
    private String reasonText;

    @Column(name = "SCHOOL_MASK")
    private String schoolMask;

    @Column(name = "CHECKBOX_LEGAL_PROBLEMS")
    private Boolean checkboxLegalProblems;

    @Column(name = "CHECKBOX_NO_ATTENDANCE")
    private Boolean checkboxNoAttendance;

    @Column(name = "CHECKBOX_CHILD_AT_RISK")
    private Boolean checkboxChildAtRisk;

    @Column(name = "CHECKBOX_EARLY_PREGNANCY")
    private Boolean checkboxEarlyPregnancy;

    @Column(name = "CHECKBOX_DISABLED")
    private Boolean checkboxDisabled;

    @Column(name = "CHECKBOX_HIV_CHILD")
    private Boolean checkboxHIVChild;

    @Column(name = "CHECKBOX_NO_FOOD")
    private Boolean checkboxNoFood;

    @Column(name = "CHECKBOX_NO_SEASON_CLOTHES")
    private Boolean checkboxNoSeasonClothes;

    @Column(name = "CHECKBOX_NO_CARE_OF_PARENTS")
    private Boolean checkboxNoCareOfParents;

    @Column(name = "CHECKBOX_CHILD_LABOUR")
    private Boolean checkboxChildLabour;

    @Column(name = "CHECKBOX_DOMESTIC_VIOLENCE")
    private Boolean checkboxDomesticViolence;

    @Column(name = "CHECKBOX_CHILD_ABUSE")
    private Boolean checkboxChildAbuse;

    @Column(name = "CHECKBOX_ORPHANGE")
    private Boolean checkboxOrphange;

    @Column(name = "CHECKBOX_PSIX")
    private Boolean checkboxPsix;

    @Column(name = "CHECKBOX_EXPLOTATION")
    private Boolean checkboxExplotation;

    @Column(name = "CHECKBOX_RELIGIOUS_RADICALISM")
    private Boolean checkboxReligiousRadicalism;

    @Column(name = "CHECKBOX_CONFLICT_ZONES")
    private Boolean checkboxConflictZones;

    @Column(name = "CHECKBOX_OUTSIDE_FAMILY")
    private Boolean checkboxOutsideFamily;

    @Lob
    @Column(name = "CHECKBOX_OTHERS1")
    private String checkboxOthers1;

    @Column(name = "CHECKBOX_SUICIDAL")
    private Boolean checkboxSuicidal;

    @Column(name = "CHECKBOX_RISK_ACTION")
    private Boolean checkboxRiskAction;

    @Column(name = "CHECKBOX_RISK_SUICIDAL")
    private Boolean checkboxRiskSuicidal;

    @Column(name = "CHECKBOX_GRIEF_OF_LOSS")
    private Boolean checkboxGriefOfLoss;

    @Column(name = "CHECKBOX_BULLING")
    private Boolean checkboxBulling;

    @Column(name = "CHECKBOX_STRESS_TRAUM")
    private Boolean checkboxStressTraum;

    @Column(name = "CHECKBOX_DAUN")
    private Boolean checkboxDaun;

    @Column(name = "CHECKBOX_WEAK_SKILLS")
    private Boolean checkboxWeakSkills;

    @Column(name = "CHECKBOX_PSYCHO")
    private Boolean checkboxPsycho;

    @Lob
    @Column(name = "CHECKBOX_OTHERS2")
    private String checkboxOthers2;

    @Column(name = "CHECKBOX_FREQUEST_ABSENCE")
    private Boolean checkboxFrequestAbsence;

    @Column(name = "CHECKBOX_BAD_GRADES")
    private Boolean checkboxBadGrades;

    @Column(name = "CHECKBOX_ABSENCE_BY_HEALTH")
    private Boolean checkboxAbsenceByHealth;

    @Column(name = "CHECKBOX_NO_CLOTHES_FOR_SCHOOL")
    private Boolean checkboxNoClothesForSchool;

    @Column(name = "CHECKBOX_NO_EDUCATION_MOTIVATION")
    private Boolean checkboxNoEducationMotivation;

    @Column(name = "CHECKBOX_NO_FAMILY_CONTROL")
    private Boolean checkboxNoFamilyControl;

    @Column(name = "CHECKBOX_NO_ADDITIONAL_CONSULTATION")
    private Boolean checkboxNoAdditionalConsultation;

    @Column(name = "CHECKBOX_CONSULTATION_ABSENCE")
    private Boolean checkboxConsultationAbsence;

    @Column(name = "CHECKBOX_BAD_CONSULTATION")
    private Boolean checkboxBadConsultation;

    @Column(name = "CHECKBOX_CHILD_PARENTS_CONFLICT")
    private Boolean checkboxChildParentsConflict;

    @Column(name = "CHECKBOX_CHILD_BETWEEN_CONFLICT")
    private Boolean checkboxChildBetweenConflict;

    @Column(name = "CHECKBOX_CHILD_TEACHER_CONFLICT")
    private Boolean checkboxChildTeacherConflict;

    @Lob
    @Column(name = "CHECKBOX_OTHERS3")
    private String checkboxOthers3;

    @Column(name = "CHECKBOX_LARGE_FAMILY")
    private Boolean checkboxLargeFamily;

    @Column(name = "CHECKBOX_PARENTS_WORK_MIGRATION")
    private Boolean checkboxParentsWorkMigration;

    @Column(name = "CHECKBOX_PARENTS_ALCO")
    private Boolean checkboxParentsAlco;

    @Column(name = "CHECKBOX_PARENTS_ZONA")
    private Boolean checkboxParentsZona;

    @Column(name = "CHECKBOX_PARENTS_BOMZH")
    private Boolean checkboxParentsBomzh;

    @Column(name = "CHECKBOX_PARENTS_LOW_EDUCATION")
    private Boolean checkboxParentsLowEducation;

    @Column(name = "CHECKBOX_PARENTS_WEAK_SKILLS")
    private Boolean checkboxParentsWeakSkills;

    @Column(name = "CHECKBOX_PARENTS_BAD_RELATIONSHIP")
    private Boolean checkboxParentsBadRelationship;

    @Column(name = "CHECKBOX_PARENTS_DIVORCE")
    private Boolean checkboxParentsDivorce;

    @Column(name = "CHEKBOX_PARENTS_NO_HOME")
    private Boolean checkboxParentsNoHome;

    @Column(name = "CHECKBOX_PARENTS_NO_DRUGS")
    private Boolean checkboxParentsNoDrugs;

    @Column(name = "CHECKBOX_PARENTS_NO_TRANSPORT")
    private Boolean checkboxParentsNoTransport;

    @Column(name = "CHECKBOX_PARENTS_NO_MONEY")
    private Boolean checkboxParentsNoMoney;

    @Column(name = "CHECKBOX_PARENTS_VIOLENCE")
    private Boolean checkboxParentsViolence;

    @Column(name = "CHECKBOX_PARENTS_PSYCHO")
    private Boolean checkboxParentsPsycho;

    @Column(name = "CHECKBOX_PARENTS_FAMILY_CONFLICT")
    private Boolean checkboxParentsFamilyConflict;

    @Column(name = "CHECKBOX_PARENTS_POOR_FAMILY")
    private Boolean checkboxParentsPoorFamily;

    @Column(name = "CHECKBOX_PARENTS_ELDERS")
    private Boolean checkboxParentsElders;

    @Column(name = "CHECKBOX_PARENTS_MOTHER_PREGNANT")
    private Boolean checkboxParentsMotherPregnant;

    @Column(name = "CHECKBOX_PARENTS_SINGLE_FAMILY")
    private Boolean checkboxParentsSingleFamily;

    @Column(name = "CHECKBOX_PARENTS_ORPHANGE")
    private Boolean checkboxParentsOrphange;

    @Column(name = "CHECKBOX_PARENTS_NO_SOCIAL_HELP")
    private Boolean checkboxParentsNoSocialHelp;

    @Column(name = "CHECKBOX_PARENTS_ISOLATION")
    private Boolean checkboxParentsIsolation;

    @Column(name = "CHECKBOX_PARENTS_NO_SERVICE_ACCESS")
    private Boolean checkboxParentsNoServiceAccess;

    @Column(name = "CHECKBOX_PARENTS_DISCRIMINATION")
    private Boolean checkboxParentsDiscrimination;

    @Column(name = "CHECKBOX_PARENTS_NO_WORK")
    private Boolean checkboxParentsNoWork;

    @Column(name = "CHECKBOX_PARENTS_HIV")
    private Boolean checkboxParentsHIV;

    @Column(name = "CHECKBOX_PARENTS_DISABLED")
    private Boolean checkboxParentsDisabled;

    @Column(name = "CHECKBOX_PARENTS_FROM_WAR")
    private Boolean checkboxParentsFromWar;

    @Column(name = "CHECKBOX_PARENTS_RELIGIOUS_RADICALIZATION")
    private Boolean checkboxParentsReligiousRadicalization;

    @Lob
    @Column(name = "CHECKBOX_OTHERS4")
    private String checkboxOthers4;

    @Column(name = "CHECKBOX_IND_FACTOR_ACADEMIC")
    private Boolean checkboxIndFactorAcademic;

    @Column(name = "CHECKBOX_IND_FACTOR_GOOD_PROBLEM_SOLVING")
    private Boolean checkboxIndFactorGoodProblemSolving;

    @Column(name = "CHECKBOX_IND_FACTOR_OWN_PROBLEM")
    private Boolean checkboxIndFactorOwnProblem;

    @Column(name = "CHECKBOX_IND_FACTOR_SELF_CONFIDENCE")
    private Boolean checkboxIndFactorSelfConfidence;

    @Lob
    @Column(name = "CHECKBOX_OTHERS5")
    private String checkboxOthers5;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_SAFE")
    private Boolean checkboxFamilyFactorSafe;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_CARING")
    private Boolean checkboxFamilyFactorCaring;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_STABLE")
    private Boolean checkboxFamilyFactorStable;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_GOOD_SKILLS")
    private Boolean checkboxFamilyFactorGoodSkills;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_POSITIVE")
    private Boolean checkboxFamilyFactorPositive;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_BASE_HELP")
    private Boolean checkboxFamilyFactorBaseHelp;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_STABLE_RELATIONSHIP")
    private Boolean checkboxFamilyFactorStableRelationship;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_RULES")
    private Boolean checkboxFamilyFactorRules;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_CARING_ADULTS")
    private Boolean checkboxFamilyFactorCaringAdults;

    @Column(name = "CHECKBOX_FAMILY_FACTOR_SOCIAL_MEDIA")
    private Boolean checkboxFamilyFactorSocialMedia;

    @Lob
    @Column(name = "CHECKBOX_OTHERS6")
    private String checkboxOthers6;

    @Column(name = "CHECKBOX_ENV_ECONOM_STABLE")
    private Boolean checkboxEnvEconomStable;

    @Column(name = "CHECKBOX_ENV_PARENTS_EMP")
    private Boolean checkboxEnvParentsEmp;

    @Column(name = "CHECKBOX_ENV_PARENTS_EDU")
    private Boolean checkboxEnvParentsEdu;

    @Column(name = "CHECKBOX_ENV_LIVING_COND")
    private Boolean checkboxEnvLivingCond;

    @Column(name = "CHECKBOX_ENV_SOCIAL_HELP")
    private Boolean checkboxEnvSocialHelp;

    @Column(name = "CHECKBOX_ENV_MEDICAL_ADULTS_AND_KINDS")
    private Boolean checkboxEnvMedicalAdultsAndKinds;

    @Column(name = "CHECKBOX_ENV_COORDINATION_SERVICES")
    private Boolean checkboxEnvCoordinationServices;

    @Lob
    @Column(name = "CHECKBOX_OTHERS7")
    private String checkboxOthers7;

    @Column(name = "CHECKBOX_SCHOOL_SAFE_ENV")
    private Boolean checkboxSchoolSafeEnv;

    @Column(name = "CHECKBOX_SCHOOL_ADD")
    private Boolean checkboxSchoolAdd;

    @Column(name = "CHECKBOX_SCHOOL_NPA")
    private Boolean checkboxSchoolNPA;

    @Column(name = "CHECKBOX_SCHOOL_MENTOR")
    private Boolean checkboxSchoolMentor;

    @Column(name = "CHECKBOX_SCHOOL_PARENTS_COMM")
    private Boolean checkboxSchoolParentsComm;

    @Column(name = "CHECKBOX_SCHOOL_INCLUSIVE")
    private Boolean checkboxSchoolInclusive;

    @Column(name = "CHECKBOX_SCHOOL_ADD_CREATIVE")
    private Boolean checkboxSchoolAddCreative;

    @Column(name = "CHECKBOX_SCHOOL_PROFILACTATION")
    private Boolean checkboxSchoolProfilactation;

    @Lob
    @Column(name = "CHECKBOX_OTHERS8")
    private String checkboxOthers8;

    @Column(name = "CASE_REASON")
    private String caseReason;

    @Column(name = "CHECKBOX_RISK_LEVEL_NO")
    private Boolean checkboxFinalRiskLevelNo;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_NO_STEP1")
    private Boolean checkboxFinalRiskLevelNoStep1;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_NO_STEP2")
    private Boolean checkboxFinalRiskLevelNoStep2;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_NO_STEP3")
    private Boolean checkboxFinalRiskLevelNoStep3;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_NO_OTHERS")
    private String checkboxFinalRiskLevelNoOthers;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_LOW")
    private Boolean checkboxFinalRiskLevelLow;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_LOW_STEP1")
    private Boolean checkboxFinalRiskLevelLowStep1;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_LOW_STEP2")
    private Boolean checkboxFinalRiskLevelLowStep2;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_LOW_OTHERS")
    private String checkboxFinalRiskLevelLowOthers;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_MEDIUM")
    private Boolean checkboxFinalRiskLevelMedium;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_MEDIUM_STEP1")
    private Boolean checkboxFinalRiskLevelMediumStep1;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_MEDIUM_STEP2")
    private Boolean checkboxFinalRiskLevelMediumStep2;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_MEDIUM_OTHERS")
    private String checkboxFinalRiskLevelMediumOthers;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_HIGH")
    private Boolean checkboxFinalRiskLevelHigh;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_HIGH_STEP1")
    private Boolean checkboxFinalRiskLevelHighStep1;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_HIGH_STEP2")
    private Boolean checkboxFinalRiskLevelHighStep2;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_HIGH_STEP3")
    private Boolean checkboxFinalRiskLevelHighStep3;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_HIGH_STEP4")
    private Boolean checkboxFinalRiskLevelHighStep4;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_HIGH_STEP5")
    private Boolean checkboxFinalRiskLevelHighStep5;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_HIGH_STEP6")
    private Boolean checkboxFinalRiskLevelHighStep6;

    @Column(name = "CHECKBOX_FINAL_RISK_LEVEL_HIGH_OTHERS")
    private String checkboxFinalRiskLevelHighOthers;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public SchoolMask getSchoolMask() {
        return schoolMask == null ? null : SchoolMask.fromId(schoolMask);
    }

    public void setSchoolMask(SchoolMask schoolMask) {
        this.schoolMask = schoolMask == null ? null : schoolMask.getId();
    }

    public String getReasonText() {
        return reasonText;
    }

    public void setReasonText(String reasonText) {
        this.reasonText = reasonText;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public Boolean getCheckboxChildBetweenConflict() {
        return checkboxChildBetweenConflict;
    }

    public void setCheckboxChildBetweenConflict(Boolean checkboxChildBetweenConflict) {
        this.checkboxChildBetweenConflict = checkboxChildBetweenConflict;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getCheckboxFinalRiskLevelHighOthers() {
        return checkboxFinalRiskLevelHighOthers;
    }

    public void setCheckboxFinalRiskLevelHighOthers(String checkboxFinalRiskLevelOthers) {
        this.checkboxFinalRiskLevelHighOthers = checkboxFinalRiskLevelOthers;
    }

    public Boolean getCheckboxFinalRiskLevelHighStep6() {
        return checkboxFinalRiskLevelHighStep6;
    }

    public void setCheckboxFinalRiskLevelHighStep6(Boolean checkboxFinalRiskLevelHighStep6) {
        this.checkboxFinalRiskLevelHighStep6 = checkboxFinalRiskLevelHighStep6;
    }

    public Boolean getCheckboxFinalRiskLevelHighStep5() {
        return checkboxFinalRiskLevelHighStep5;
    }

    public void setCheckboxFinalRiskLevelHighStep5(Boolean checkboxFinalRiskLevelHighStep5) {
        this.checkboxFinalRiskLevelHighStep5 = checkboxFinalRiskLevelHighStep5;
    }

    public Boolean getCheckboxFinalRiskLevelHighStep4() {
        return checkboxFinalRiskLevelHighStep4;
    }

    public void setCheckboxFinalRiskLevelHighStep4(Boolean checkboxFinalRiskLevelHighStep4) {
        this.checkboxFinalRiskLevelHighStep4 = checkboxFinalRiskLevelHighStep4;
    }

    public Boolean getCheckboxFinalRiskLevelHighStep3() {
        return checkboxFinalRiskLevelHighStep3;
    }

    public void setCheckboxFinalRiskLevelHighStep3(Boolean checkboxFinalRiskLevelHighStep3) {
        this.checkboxFinalRiskLevelHighStep3 = checkboxFinalRiskLevelHighStep3;
    }

    public Boolean getCheckboxFinalRiskLevelHighStep2() {
        return checkboxFinalRiskLevelHighStep2;
    }

    public void setCheckboxFinalRiskLevelHighStep2(Boolean checkboxFinalRiskLevelHighStep2) {
        this.checkboxFinalRiskLevelHighStep2 = checkboxFinalRiskLevelHighStep2;
    }

    public Boolean getCheckboxFinalRiskLevelHighStep1() {
        return checkboxFinalRiskLevelHighStep1;
    }

    public void setCheckboxFinalRiskLevelHighStep1(Boolean checkboxFinalRiskLevelHighStep1) {
        this.checkboxFinalRiskLevelHighStep1 = checkboxFinalRiskLevelHighStep1;
    }

    public String getCheckboxFinalRiskLevelMediumOthers() {
        return checkboxFinalRiskLevelMediumOthers;
    }

    public void setCheckboxFinalRiskLevelMediumOthers(String checkboxFinalRiskLevelMediumOthers) {
        this.checkboxFinalRiskLevelMediumOthers = checkboxFinalRiskLevelMediumOthers;
    }

    public Boolean getCheckboxFinalRiskLevelMediumStep2() {
        return checkboxFinalRiskLevelMediumStep2;
    }

    public void setCheckboxFinalRiskLevelMediumStep2(Boolean checkboxFinalRiskLevelMediumStep2) {
        this.checkboxFinalRiskLevelMediumStep2 = checkboxFinalRiskLevelMediumStep2;
    }

    public Boolean getCheckboxFinalRiskLevelMediumStep1() {
        return checkboxFinalRiskLevelMediumStep1;
    }

    public void setCheckboxFinalRiskLevelMediumStep1(Boolean checkboxFinalRiskLevelMediumStep1) {
        this.checkboxFinalRiskLevelMediumStep1 = checkboxFinalRiskLevelMediumStep1;
    }

    public String getCheckboxFinalRiskLevelLowOthers() {
        return checkboxFinalRiskLevelLowOthers;
    }

    public void setCheckboxFinalRiskLevelLowOthers(String checkboxFinalRiskLevelOthers) {
        this.checkboxFinalRiskLevelLowOthers = checkboxFinalRiskLevelOthers;
    }

    public Boolean getCheckboxFinalRiskLevelLowStep2() {
        return checkboxFinalRiskLevelLowStep2;
    }

    public void setCheckboxFinalRiskLevelLowStep2(Boolean checkboxFinalRiskLevelLowStep2) {
        this.checkboxFinalRiskLevelLowStep2 = checkboxFinalRiskLevelLowStep2;
    }

    public Boolean getCheckboxFinalRiskLevelLowStep1() {
        return checkboxFinalRiskLevelLowStep1;
    }

    public void setCheckboxFinalRiskLevelLowStep1(Boolean checkboxFinalRiskLevelLowStep1) {
        this.checkboxFinalRiskLevelLowStep1 = checkboxFinalRiskLevelLowStep1;
    }

    public String getCheckboxFinalRiskLevelNoOthers() {
        return checkboxFinalRiskLevelNoOthers;
    }

    public void setCheckboxFinalRiskLevelNoOthers(String checkboxFinalRiskLevelNoOthers) {
        this.checkboxFinalRiskLevelNoOthers = checkboxFinalRiskLevelNoOthers;
    }

    public Boolean getCheckboxFinalRiskLevelNoStep3() {
        return checkboxFinalRiskLevelNoStep3;
    }

    public void setCheckboxFinalRiskLevelNoStep3(Boolean checkboxFinalRiskLevelNoStep3) {
        this.checkboxFinalRiskLevelNoStep3 = checkboxFinalRiskLevelNoStep3;
    }

    public Boolean getCheckboxFinalRiskLevelNoStep2() {
        return checkboxFinalRiskLevelNoStep2;
    }

    public void setCheckboxFinalRiskLevelNoStep2(Boolean checkboxFinalRiskLevelNoStep2) {
        this.checkboxFinalRiskLevelNoStep2 = checkboxFinalRiskLevelNoStep2;
    }

    public Boolean getCheckboxFinalRiskLevelNoStep1() {
        return checkboxFinalRiskLevelNoStep1;
    }

    public void setCheckboxFinalRiskLevelNoStep1(Boolean checkboxFinalRiskLevelNoStep1) {
        this.checkboxFinalRiskLevelNoStep1 = checkboxFinalRiskLevelNoStep1;
    }

    public Boolean getCheckboxFinalRiskLevelHigh() {
        return checkboxFinalRiskLevelHigh;
    }

    public void setCheckboxFinalRiskLevelHigh(Boolean checkboxFinalRiskLevelHigh) {
        this.checkboxFinalRiskLevelHigh = checkboxFinalRiskLevelHigh;
    }

    public Boolean getCheckboxFinalRiskLevelMedium() {
        return checkboxFinalRiskLevelMedium;
    }

    public void setCheckboxFinalRiskLevelMedium(Boolean checkboxFinalRiskLevelMedium) {
        this.checkboxFinalRiskLevelMedium = checkboxFinalRiskLevelMedium;
    }

    public Boolean getCheckboxFinalRiskLevelLow() {
        return checkboxFinalRiskLevelLow;
    }

    public void setCheckboxFinalRiskLevelLow(Boolean checkboxFinalRiskLevelLow) {
        this.checkboxFinalRiskLevelLow = checkboxFinalRiskLevelLow;
    }

    public Boolean getCheckboxFinalRiskLevelNo() {
        return checkboxFinalRiskLevelNo;
    }

    public void setCheckboxFinalRiskLevelNo(Boolean checkboxRiskLevel) {
        this.checkboxFinalRiskLevelNo = checkboxRiskLevel;
    }

    public Boolean getCheckboxParentsIsolation() {
        return checkboxParentsIsolation;
    }

    public void setCheckboxParentsIsolation(Boolean checkboxParentsIsolation) {
        this.checkboxParentsIsolation = checkboxParentsIsolation;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel == null ? null : RiskLevel.fromId(riskLevel);
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel == null ? null : riskLevel.getId();
    }

    public Boolean getCheckboxEnvSocialHelp() {
        return checkboxEnvSocialHelp;
    }

    public void setCheckboxEnvSocialHelp(Boolean checkboxEnvSocialHelp) {
        this.checkboxEnvSocialHelp = checkboxEnvSocialHelp;
    }

    public String getCaseReason() {
        return caseReason;
    }

    public void setCaseReason(String caseReason) {
        this.caseReason = caseReason;
    }

    public String getCheckboxOthers8() {
        return checkboxOthers8;
    }

    public void setCheckboxOthers8(String checkboxOthers8) {
        this.checkboxOthers8 = checkboxOthers8;
    }

    public Boolean getCheckboxSchoolProfilactation() {
        return checkboxSchoolProfilactation;
    }

    public void setCheckboxSchoolProfilactation(Boolean checkboxSchoolProfilactation) {
        this.checkboxSchoolProfilactation = checkboxSchoolProfilactation;
    }

    public Boolean getCheckboxSchoolAddCreative() {
        return checkboxSchoolAddCreative;
    }

    public void setCheckboxSchoolAddCreative(Boolean checkboxSchoolAddCreative) {
        this.checkboxSchoolAddCreative = checkboxSchoolAddCreative;
    }

    public Boolean getCheckboxSchoolInclusive() {
        return checkboxSchoolInclusive;
    }

    public void setCheckboxSchoolInclusive(Boolean checkboxSchoolInclusive) {
        this.checkboxSchoolInclusive = checkboxSchoolInclusive;
    }

    public Boolean getCheckboxSchoolParentsComm() {
        return checkboxSchoolParentsComm;
    }

    public void setCheckboxSchoolParentsComm(Boolean checkboxSchoolParentsComm) {
        this.checkboxSchoolParentsComm = checkboxSchoolParentsComm;
    }

    public Boolean getCheckboxSchoolMentor() {
        return checkboxSchoolMentor;
    }

    public void setCheckboxSchoolMentor(Boolean checkboxSchoolMentor) {
        this.checkboxSchoolMentor = checkboxSchoolMentor;
    }

    public Boolean getCheckboxSchoolNPA() {
        return checkboxSchoolNPA;
    }

    public void setCheckboxSchoolNPA(Boolean checkboxSchoolNPA) {
        this.checkboxSchoolNPA = checkboxSchoolNPA;
    }

    public Boolean getCheckboxSchoolAdd() {
        return checkboxSchoolAdd;
    }

    public void setCheckboxSchoolAdd(Boolean checkboxSchoolAdd) {
        this.checkboxSchoolAdd = checkboxSchoolAdd;
    }

    public Boolean getCheckboxSchoolSafeEnv() {
        return checkboxSchoolSafeEnv;
    }

    public void setCheckboxSchoolSafeEnv(Boolean checkboxSchoolSafeEnv) {
        this.checkboxSchoolSafeEnv = checkboxSchoolSafeEnv;
    }

    public String getCheckboxOthers7() {
        return checkboxOthers7;
    }

    public void setCheckboxOthers7(String checkboxOthers7) {
        this.checkboxOthers7 = checkboxOthers7;
    }

    public Boolean getCheckboxEnvCoordinationServices() {
        return checkboxEnvCoordinationServices;
    }

    public void setCheckboxEnvCoordinationServices(Boolean checkboxEnvCoordinationServices) {
        this.checkboxEnvCoordinationServices = checkboxEnvCoordinationServices;
    }

    public Boolean getCheckboxEnvMedicalAdultsAndKinds() {
        return checkboxEnvMedicalAdultsAndKinds;
    }

    public void setCheckboxEnvMedicalAdultsAndKinds(Boolean checkboxEnvMedicalAdultsAndKinds) {
        this.checkboxEnvMedicalAdultsAndKinds = checkboxEnvMedicalAdultsAndKinds;
    }

    public Boolean getCheckboxEnvLivingCond() {
        return checkboxEnvLivingCond;
    }

    public void setCheckboxEnvLivingCond(Boolean checkboxEnvLivingCond) {
        this.checkboxEnvLivingCond = checkboxEnvLivingCond;
    }

    public Boolean getCheckboxEnvParentsEdu() {
        return checkboxEnvParentsEdu;
    }

    public void setCheckboxEnvParentsEdu(Boolean checkboxEnvParentsEdu) {
        this.checkboxEnvParentsEdu = checkboxEnvParentsEdu;
    }

    public Boolean getCheckboxEnvParentsEmp() {
        return checkboxEnvParentsEmp;
    }

    public void setCheckboxEnvParentsEmp(Boolean checkboxEnvParentsEmp) {
        this.checkboxEnvParentsEmp = checkboxEnvParentsEmp;
    }

    public Boolean getCheckboxEnvEconomStable() {
        return checkboxEnvEconomStable;
    }

    public void setCheckboxEnvEconomStable(Boolean checkboxEnvEconomStable) {
        this.checkboxEnvEconomStable = checkboxEnvEconomStable;
    }

    public String getCheckboxOthers6() {
        return checkboxOthers6;
    }

    public void setCheckboxOthers6(String checkboxOthers6) {
        this.checkboxOthers6 = checkboxOthers6;
    }

    public Boolean getCheckboxFamilyFactorSocialMedia() {
        return checkboxFamilyFactorSocialMedia;
    }

    public void setCheckboxFamilyFactorSocialMedia(Boolean checkboxFamilyFactorSocialMedia) {
        this.checkboxFamilyFactorSocialMedia = checkboxFamilyFactorSocialMedia;
    }

    public Boolean getCheckboxFamilyFactorCaringAdults() {
        return checkboxFamilyFactorCaringAdults;
    }

    public void setCheckboxFamilyFactorCaringAdults(Boolean checkboxFamilyFactorCaringAdults) {
        this.checkboxFamilyFactorCaringAdults = checkboxFamilyFactorCaringAdults;
    }

    public Boolean getCheckboxFamilyFactorRules() {
        return checkboxFamilyFactorRules;
    }

    public void setCheckboxFamilyFactorRules(Boolean checkboxFamilyFactorRules) {
        this.checkboxFamilyFactorRules = checkboxFamilyFactorRules;
    }

    public Boolean getCheckboxFamilyFactorStableRelationship() {
        return checkboxFamilyFactorStableRelationship;
    }

    public void setCheckboxFamilyFactorStableRelationship(Boolean checkboxFamilyFactorStableRelationship) {
        this.checkboxFamilyFactorStableRelationship = checkboxFamilyFactorStableRelationship;
    }

    public Boolean getCheckboxFamilyFactorBaseHelp() {
        return checkboxFamilyFactorBaseHelp;
    }

    public void setCheckboxFamilyFactorBaseHelp(Boolean checkboxFamilyFactorBaseHelp) {
        this.checkboxFamilyFactorBaseHelp = checkboxFamilyFactorBaseHelp;
    }

    public Boolean getCheckboxFamilyFactorPositive() {
        return checkboxFamilyFactorPositive;
    }

    public void setCheckboxFamilyFactorPositive(Boolean checkboxFamilyFactorPositive) {
        this.checkboxFamilyFactorPositive = checkboxFamilyFactorPositive;
    }

    public Boolean getCheckboxFamilyFactorGoodSkills() {
        return checkboxFamilyFactorGoodSkills;
    }

    public void setCheckboxFamilyFactorGoodSkills(Boolean checkboxFamilyFactorGoodSkills) {
        this.checkboxFamilyFactorGoodSkills = checkboxFamilyFactorGoodSkills;
    }

    public Boolean getCheckboxFamilyFactorStable() {
        return checkboxFamilyFactorStable;
    }

    public void setCheckboxFamilyFactorStable(Boolean checkboxFamilyFactorStable) {
        this.checkboxFamilyFactorStable = checkboxFamilyFactorStable;
    }

    public Boolean getCheckboxFamilyFactorCaring() {
        return checkboxFamilyFactorCaring;
    }

    public void setCheckboxFamilyFactorCaring(Boolean checkboxFamilyFactorCaring) {
        this.checkboxFamilyFactorCaring = checkboxFamilyFactorCaring;
    }

    public Boolean getCheckboxFamilyFactorSafe() {
        return checkboxFamilyFactorSafe;
    }

    public void setCheckboxFamilyFactorSafe(Boolean checkboxFamilyFactorSafe) {
        this.checkboxFamilyFactorSafe = checkboxFamilyFactorSafe;
    }

    public String getCheckboxOthers5() {
        return checkboxOthers5;
    }

    public void setCheckboxOthers5(String checkboxOthers5) {
        this.checkboxOthers5 = checkboxOthers5;
    }

    public Boolean getCheckboxIndFactorSelfConfidence() {
        return checkboxIndFactorSelfConfidence;
    }

    public void setCheckboxIndFactorSelfConfidence(Boolean checkboxIndFactorSelfConfidence) {
        this.checkboxIndFactorSelfConfidence = checkboxIndFactorSelfConfidence;
    }

    public Boolean getCheckboxIndFactorOwnProblem() {
        return checkboxIndFactorOwnProblem;
    }

    public void setCheckboxIndFactorOwnProblem(Boolean checkboxIndFactorOwnProblem) {
        this.checkboxIndFactorOwnProblem = checkboxIndFactorOwnProblem;
    }

    public Boolean getCheckboxIndFactorGoodProblemSolving() {
        return checkboxIndFactorGoodProblemSolving;
    }

    public void setCheckboxIndFactorGoodProblemSolving(Boolean checkboxIndFactorGoodProblemSolving) {
        this.checkboxIndFactorGoodProblemSolving = checkboxIndFactorGoodProblemSolving;
    }

    public Boolean getCheckboxIndFactorAcademic() {
        return checkboxIndFactorAcademic;
    }

    public void setCheckboxIndFactorAcademic(Boolean checkboxIndFactorAcademic) {
        this.checkboxIndFactorAcademic = checkboxIndFactorAcademic;
    }

    public String getCheckboxOthers4() {
        return checkboxOthers4;
    }

    public void setCheckboxOthers4(String checkboxOthers4) {
        this.checkboxOthers4 = checkboxOthers4;
    }

    public Boolean getCheckboxParentsReligiousRadicalization() {
        return checkboxParentsReligiousRadicalization;
    }

    public void setCheckboxParentsReligiousRadicalization(Boolean checkboxParentsReligiousRadicalization) {
        this.checkboxParentsReligiousRadicalization = checkboxParentsReligiousRadicalization;
    }

    public Boolean getCheckboxParentsFromWar() {
        return checkboxParentsFromWar;
    }

    public void setCheckboxParentsFromWar(Boolean checkboxParentsFromWar) {
        this.checkboxParentsFromWar = checkboxParentsFromWar;
    }

    public Boolean getCheckboxParentsDisabled() {
        return checkboxParentsDisabled;
    }

    public void setCheckboxParentsDisabled(Boolean checkboxParentsDisabled) {
        this.checkboxParentsDisabled = checkboxParentsDisabled;
    }

    public Boolean getCheckboxParentsHIV() {
        return checkboxParentsHIV;
    }

    public void setCheckboxParentsHIV(Boolean checkboxParentsHIV) {
        this.checkboxParentsHIV = checkboxParentsHIV;
    }

    public Boolean getCheckboxParentsNoWork() {
        return checkboxParentsNoWork;
    }

    public void setCheckboxParentsNoWork(Boolean checkboxParentsNoWork) {
        this.checkboxParentsNoWork = checkboxParentsNoWork;
    }

    public Boolean getCheckboxParentsDiscrimination() {
        return checkboxParentsDiscrimination;
    }

    public void setCheckboxParentsDiscrimination(Boolean checkboxParentsDiscrimination) {
        this.checkboxParentsDiscrimination = checkboxParentsDiscrimination;
    }

    public Boolean getCheckboxParentsNoServiceAccess() {
        return checkboxParentsNoServiceAccess;
    }

    public void setCheckboxParentsNoServiceAccess(Boolean checkboxParentsNoServiceAccess) {
        this.checkboxParentsNoServiceAccess = checkboxParentsNoServiceAccess;
    }

    public Boolean getCheckboxParentsNoSocialHelp() {
        return checkboxParentsNoSocialHelp;
    }

    public void setCheckboxParentsNoSocialHelp(Boolean checkboxParentsNoSocialHelp) {
        this.checkboxParentsNoSocialHelp = checkboxParentsNoSocialHelp;
    }

    public Boolean getCheckboxParentsOrphange() {
        return checkboxParentsOrphange;
    }

    public void setCheckboxParentsOrphange(Boolean checkboxParentsOrphange) {
        this.checkboxParentsOrphange = checkboxParentsOrphange;
    }

    public Boolean getCheckboxParentsSingleFamily() {
        return checkboxParentsSingleFamily;
    }

    public void setCheckboxParentsSingleFamily(Boolean checkboxParentsSingleFamily) {
        this.checkboxParentsSingleFamily = checkboxParentsSingleFamily;
    }

    public Boolean getCheckboxParentsMotherPregnant() {
        return checkboxParentsMotherPregnant;
    }

    public void setCheckboxParentsMotherPregnant(Boolean checkboxParentsMotherPregnant) {
        this.checkboxParentsMotherPregnant = checkboxParentsMotherPregnant;
    }

    public Boolean getCheckboxParentsElders() {
        return checkboxParentsElders;
    }

    public void setCheckboxParentsElders(Boolean checkboxParentsElders) {
        this.checkboxParentsElders = checkboxParentsElders;
    }

    public Boolean getCheckboxParentsPoorFamily() {
        return checkboxParentsPoorFamily;
    }

    public void setCheckboxParentsPoorFamily(Boolean checkboxParentsPoorFamily) {
        this.checkboxParentsPoorFamily = checkboxParentsPoorFamily;
    }

    public Boolean getCheckboxParentsFamilyConflict() {
        return checkboxParentsFamilyConflict;
    }

    public void setCheckboxParentsFamilyConflict(Boolean checkboxParentsFamilyConflict) {
        this.checkboxParentsFamilyConflict = checkboxParentsFamilyConflict;
    }

    public Boolean getCheckboxParentsPsycho() {
        return checkboxParentsPsycho;
    }

    public void setCheckboxParentsPsycho(Boolean checkboxParentsPsycho) {
        this.checkboxParentsPsycho = checkboxParentsPsycho;
    }

    public Boolean getCheckboxParentsViolence() {
        return checkboxParentsViolence;
    }

    public void setCheckboxParentsViolence(Boolean checkboxParentsViolence) {
        this.checkboxParentsViolence = checkboxParentsViolence;
    }

    public Boolean getCheckboxParentsNoMoney() {
        return checkboxParentsNoMoney;
    }

    public void setCheckboxParentsNoMoney(Boolean checkboxParentsNoMoney) {
        this.checkboxParentsNoMoney = checkboxParentsNoMoney;
    }

    public Boolean getCheckboxParentsNoTransport() {
        return checkboxParentsNoTransport;
    }

    public void setCheckboxParentsNoTransport(Boolean checkboxParentsNoTransport) {
        this.checkboxParentsNoTransport = checkboxParentsNoTransport;
    }

    public Boolean getCheckboxParentsNoDrugs() {
        return checkboxParentsNoDrugs;
    }

    public void setCheckboxParentsNoDrugs(Boolean checkboxParentsNoDrugs) {
        this.checkboxParentsNoDrugs = checkboxParentsNoDrugs;
    }

    public Boolean getCheckboxParentsNoHome() {
        return checkboxParentsNoHome;
    }

    public void setCheckboxParentsNoHome(Boolean chekboxParentsNoHome) {
        this.checkboxParentsNoHome = chekboxParentsNoHome;
    }

    public void setCheckboxNoAttendance(Boolean checkboxNoAttendance) {
        this.checkboxNoAttendance = checkboxNoAttendance;
    }

    public Boolean getCheckboxNoAttendance() {
        return checkboxNoAttendance;
    }

    public void setCheckboxExplotation(Boolean checkboxExplotation) {
        this.checkboxExplotation = checkboxExplotation;
    }

    public Boolean getCheckboxExplotation() {
        return checkboxExplotation;
    }

    public void setCheckboxSuicidal(Boolean checkboxSuicidal) {
        this.checkboxSuicidal = checkboxSuicidal;
    }

    public Boolean getCheckboxSuicidal() {
        return checkboxSuicidal;
    }

    public void setCheckboxRiskAction(Boolean checkboxRiskAction) {
        this.checkboxRiskAction = checkboxRiskAction;
    }

    public Boolean getCheckboxRiskAction() {
        return checkboxRiskAction;
    }

    public void setCheckboxRiskSuicidal(Boolean checkboxRiskSuicidal) {
        this.checkboxRiskSuicidal = checkboxRiskSuicidal;
    }

    public Boolean getCheckboxRiskSuicidal() {
        return checkboxRiskSuicidal;
    }

    public void setCheckboxFrequestAbsence(Boolean checkboxFrequestAbsence) {
        this.checkboxFrequestAbsence = checkboxFrequestAbsence;
    }

    public Boolean getCheckboxFrequestAbsence() {
        return checkboxFrequestAbsence;
    }

    public void setCheckboxConsultationAbsence(Boolean checkboxConsultationAbsence) {
        this.checkboxConsultationAbsence = checkboxConsultationAbsence;
    }

    public Boolean getCheckboxConsultationAbsence() {
        return checkboxConsultationAbsence;
    }

    public Boolean getCheckboxParentsDivorce() {
        return checkboxParentsDivorce;
    }

    public void setCheckboxParentsDivorce(Boolean checkboxParentsDivorce) {
        this.checkboxParentsDivorce = checkboxParentsDivorce;
    }

    public Boolean getCheckboxParentsBadRelationship() {
        return checkboxParentsBadRelationship;
    }

    public void setCheckboxParentsBadRelationship(Boolean checkboxParentsBadRelationship) {
        this.checkboxParentsBadRelationship = checkboxParentsBadRelationship;
    }

    public Boolean getCheckboxParentsWeakSkills() {
        return checkboxParentsWeakSkills;
    }

    public void setCheckboxParentsWeakSkills(Boolean checkboxParentsWeakSkills) {
        this.checkboxParentsWeakSkills = checkboxParentsWeakSkills;
    }

    public Boolean getCheckboxParentsLowEducation() {
        return checkboxParentsLowEducation;
    }

    public void setCheckboxParentsLowEducation(Boolean checkboxParentsLowEducation) {
        this.checkboxParentsLowEducation = checkboxParentsLowEducation;
    }

    public Boolean getCheckboxParentsBomzh() {
        return checkboxParentsBomzh;
    }

    public void setCheckboxParentsBomzh(Boolean checkboxParentsBomzh) {
        this.checkboxParentsBomzh = checkboxParentsBomzh;
    }

    public Boolean getCheckboxParentsZona() {
        return checkboxParentsZona;
    }

    public void setCheckboxParentsZona(Boolean checkboxParentsZona) {
        this.checkboxParentsZona = checkboxParentsZona;
    }

    public Boolean getCheckboxParentsAlco() {
        return checkboxParentsAlco;
    }

    public void setCheckboxParentsAlco(Boolean checkboxParentsAlco) {
        this.checkboxParentsAlco = checkboxParentsAlco;
    }

    public String getCheckboxOthers3() {
        return checkboxOthers3;
    }

    public void setCheckboxOthers3(String checkboxOthers3) {
        this.checkboxOthers3 = checkboxOthers3;
    }

    public Boolean getCheckboxParentsWorkMigration() {
        return checkboxParentsWorkMigration;
    }

    public void setCheckboxParentsWorkMigration(Boolean checkboxParentsWorkMigration) {
        this.checkboxParentsWorkMigration = checkboxParentsWorkMigration;
    }

    public Boolean getCheckboxLargeFamily() {
        return checkboxLargeFamily;
    }

    public void setCheckboxLargeFamily(Boolean checkboxLargeFamily) {
        this.checkboxLargeFamily = checkboxLargeFamily;
    }

    public Boolean getCheckboxChildTeacherConflict() {
        return checkboxChildTeacherConflict;
    }

    public void setCheckboxChildTeacherConflict(Boolean checkboxChildTeacherConflict) {
        this.checkboxChildTeacherConflict = checkboxChildTeacherConflict;
    }

    public Boolean getCheckboxChildParentsConflict() {
        return checkboxChildParentsConflict;
    }

    public void setCheckboxChildParentsConflict(Boolean checkboxChildParentsConflict) {
        this.checkboxChildParentsConflict = checkboxChildParentsConflict;
    }

    public Boolean getCheckboxBadConsultation() {
        return checkboxBadConsultation;
    }

    public void setCheckboxBadConsultation(Boolean checkboxBadConsultation) {
        this.checkboxBadConsultation = checkboxBadConsultation;
    }

    public Boolean getCheckboxNoAdditionalConsultation() {
        return checkboxNoAdditionalConsultation;
    }

    public void setCheckboxNoAdditionalConsultation(Boolean checkboxNoAdditionalConsultation) {
        this.checkboxNoAdditionalConsultation = checkboxNoAdditionalConsultation;
    }

    public Boolean getCheckboxNoFamilyControl() {
        return checkboxNoFamilyControl;
    }

    public void setCheckboxNoFamilyControl(Boolean checkboxNoFamilyControl) {
        this.checkboxNoFamilyControl = checkboxNoFamilyControl;
    }

    public Boolean getCheckboxNoEducationMotivation() {
        return checkboxNoEducationMotivation;
    }

    public void setCheckboxNoEducationMotivation(Boolean checkboxNoEducationMotivation) {
        this.checkboxNoEducationMotivation = checkboxNoEducationMotivation;
    }

    public Boolean getCheckboxNoClothesForSchool() {
        return checkboxNoClothesForSchool;
    }

    public void setCheckboxNoClothesForSchool(Boolean checkboxNoClothesForSchool) {
        this.checkboxNoClothesForSchool = checkboxNoClothesForSchool;
    }

    public Boolean getCheckboxAbsenceByHealth() {
        return checkboxAbsenceByHealth;
    }

    public void setCheckboxAbsenceByHealth(Boolean checkboxAbsenceByHealth) {
        this.checkboxAbsenceByHealth = checkboxAbsenceByHealth;
    }

    public Boolean getCheckboxBadGrades() {
        return checkboxBadGrades;
    }

    public void setCheckboxBadGrades(Boolean checkboxBadGrades) {
        this.checkboxBadGrades = checkboxBadGrades;
    }

    public String getCheckboxOthers2() {
        return checkboxOthers2;
    }

    public void setCheckboxOthers2(String checkboxOthers2) {
        this.checkboxOthers2 = checkboxOthers2;
    }

    public Boolean getCheckboxPsycho() {
        return checkboxPsycho;
    }

    public void setCheckboxPsycho(Boolean checkboxPsycho) {
        this.checkboxPsycho = checkboxPsycho;
    }

    public Boolean getCheckboxWeakSkills() {
        return checkboxWeakSkills;
    }

    public void setCheckboxWeakSkills(Boolean checkboxWeakSkills) {
        this.checkboxWeakSkills = checkboxWeakSkills;
    }

    public Boolean getCheckboxDaun() {
        return checkboxDaun;
    }

    public void setCheckboxDaun(Boolean checkboxDaun) {
        this.checkboxDaun = checkboxDaun;
    }

    public String getCheckboxOthers1() {
        return checkboxOthers1;
    }

    public void setCheckboxOthers1(String checkboxOthers1) {
        this.checkboxOthers1 = checkboxOthers1;
    }

    public Boolean getCheckboxStressTraum() {
        return checkboxStressTraum;
    }

    public void setCheckboxStressTraum(Boolean checkboxStressTraum) {
        this.checkboxStressTraum = checkboxStressTraum;
    }

    public Boolean getCheckboxBulling() {
        return checkboxBulling;
    }

    public void setCheckboxBulling(Boolean checkboxBulling) {
        this.checkboxBulling = checkboxBulling;
    }

    public Boolean getCheckboxGriefOfLoss() {
        return checkboxGriefOfLoss;
    }

    public void setCheckboxGriefOfLoss(Boolean checkboxGriefOfLoss) {
        this.checkboxGriefOfLoss = checkboxGriefOfLoss;
    }

    public Boolean getCheckboxOutsideFamily() {
        return checkboxOutsideFamily;
    }

    public void setCheckboxOutsideFamily(Boolean checkboxOutsideFamily) {
        this.checkboxOutsideFamily = checkboxOutsideFamily;
    }

    public Boolean getCheckboxConflictZones() {
        return checkboxConflictZones;
    }

    public void setCheckboxConflictZones(Boolean checkboxConflictZones) {
        this.checkboxConflictZones = checkboxConflictZones;
    }

    public Boolean getCheckboxReligiousRadicalism() {
        return checkboxReligiousRadicalism;
    }

    public void setCheckboxReligiousRadicalism(Boolean checkboxReligiousRadicalism) {
        this.checkboxReligiousRadicalism = checkboxReligiousRadicalism;
    }

    public Boolean getCheckboxPsix() {
        return checkboxPsix;
    }

    public void setCheckboxPsix(Boolean checkboxPsix) {
        this.checkboxPsix = checkboxPsix;
    }

    public Boolean getCheckboxOrphange() {
        return checkboxOrphange;
    }

    public void setCheckboxOrphange(Boolean checkboxOrphange) {
        this.checkboxOrphange = checkboxOrphange;
    }

    public Boolean getCheckboxChildAbuse() {
        return checkboxChildAbuse;
    }

    public void setCheckboxChildAbuse(Boolean checkboxChildAbuse) {
        this.checkboxChildAbuse = checkboxChildAbuse;
    }

    public Boolean getCheckboxDomesticViolence() {
        return checkboxDomesticViolence;
    }

    public void setCheckboxDomesticViolence(Boolean checkboxDomesticViolence) {
        this.checkboxDomesticViolence = checkboxDomesticViolence;
    }

    public Boolean getCheckboxChildLabour() {
        return checkboxChildLabour;
    }

    public void setCheckboxChildLabour(Boolean checkboxChildLabour) {
        this.checkboxChildLabour = checkboxChildLabour;
    }

    public Boolean getCheckboxNoCareOfParents() {
        return checkboxNoCareOfParents;
    }

    public void setCheckboxNoCareOfParents(Boolean checkboxNoCareOfParents) {
        this.checkboxNoCareOfParents = checkboxNoCareOfParents;
    }

    public Boolean getCheckboxNoSeasonClothes() {
        return checkboxNoSeasonClothes;
    }

    public void setCheckboxNoSeasonClothes(Boolean checkboxNoSeasonClothes) {
        this.checkboxNoSeasonClothes = checkboxNoSeasonClothes;
    }

    public Boolean getCheckboxNoFood() {
        return checkboxNoFood;
    }

    public void setCheckboxNoFood(Boolean checkboxNoFood) {
        this.checkboxNoFood = checkboxNoFood;
    }

    public Boolean getCheckboxHIVChild() {
        return checkboxHIVChild;
    }

    public void setCheckboxHIVChild(Boolean checkboxHIVChild) {
        this.checkboxHIVChild = checkboxHIVChild;
    }

    public Boolean getCheckboxDisabled() {
        return checkboxDisabled;
    }

    public void setCheckboxDisabled(Boolean checkboxDisabled) {
        this.checkboxDisabled = checkboxDisabled;
    }

    public Boolean getCheckboxEarlyPregnancy() {
        return checkboxEarlyPregnancy;
    }

    public void setCheckboxEarlyPregnancy(Boolean checkboxEarlyPregnancy) {
        this.checkboxEarlyPregnancy = checkboxEarlyPregnancy;
    }

    public Boolean getCheckboxChildAtRisk() {
        return checkboxChildAtRisk;
    }

    public void setCheckboxChildAtRisk(Boolean checkboxChildAtRisk) {
        this.checkboxChildAtRisk = checkboxChildAtRisk;
    }

    public Boolean getCheckboxLegalProblems() {
        return checkboxLegalProblems;
    }

    public void setCheckboxLegalProblems(Boolean checkboxLegalProblems) {
        this.checkboxLegalProblems = checkboxLegalProblems;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}