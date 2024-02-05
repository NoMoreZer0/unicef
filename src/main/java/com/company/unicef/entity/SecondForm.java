package com.company.unicef.entity;

import io.jmix.core.DeletePolicy;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.entity.annotation.OnDeleteInverse;
import io.jmix.core.metamodel.annotation.Composition;
import io.jmix.core.metamodel.annotation.InstanceName;
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
@Table(name = "SECOND_FORM", indexes = {
        @Index(name = "IDX_SECOND_FORM_STUDENT", columnList = "STUDENT_ID")
})
@Entity
public class SecondForm {
    @InstanceName
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private Long id;

    @OnDeleteInverse(DeletePolicy.DENY)
    @JoinColumn(name = "STUDENT_ID")
    @Composition
    @OneToOne(fetch = FetchType.LAZY)
    private Student student;

    @Column(name = "CASE_ID_NUM")
    private String caseIdNum;

    @JmixGeneratedValue
    @Column(name = "UUID")
    private UUID uuid;

    @Column(name = "SCHOOL_MASK")
    private String schoolMask;

    @Column(name = "CHILD_MOBILE_PHONE", length = 11)
    private String childMobilePhone;

    @Column(name = "EDUCATION_INSTITUTION")
    private String educationInstitution;

    @Column(name = "CASE_MANAGER")
    private String caseManager;

    @Column(name = "CONTACT_NUMBER")
    private String contactNumber;

    @Column(name = "HEALTH_CHRONICAL")
    private Boolean healthChronical;

    @Lob
    @Column(name = "HEALTH_CHRONICAL_TEXT")
    private String healthChronicalText;

    @Column(name = "HEALTH_NO_REGISTERED")
    private Boolean healthNoRegistered;

    @Column(name = "HEALTH_NO_VACCINATION")
    private Boolean healthNoVaccination;

    @Column(name = "HEALTH_DISABLED_NO_HELP")
    private Boolean healthDisabledNoHelp;

    @Lob
    @Column(name = "HEALTH_DISABLED_NO_HELP_TEXT")
    private String healthDisabledNoHelpText;

    @Column(name = "HEALTH_NO_HOSPITAL")
    private Boolean healthNoHospital;

    @Column(name = "HEALTH_NO_TESTING")
    private Boolean healthNoTesting;

    @Column(name = "HEALTH_NO_FOOD")
    private Boolean healthNoFood;

    @Lob
    @Column(name = "HEALTH_NO_FOOD_TEXT")
    private String healthNoFoodText;

    @Column(name = "HEALTH_NO_SPORT")
    private Boolean healthNoSport;

    @Column(name = "HEALTH_NO_EQUIPMENT")
    private Boolean healthNoEquipment;

    @Lob
    @Column(name = "HEALTH_NO_EQUIPMENT_TEXT")
    private String healthNoEquipmentText;

    @Column(name = "HEALTH_NO_COORDINATION")
    private Boolean healthNoCoordination;

    @Column(name = "HEALTH_BAD_WEIGHT_OR_HEIGHT")
    private Boolean healthBadWeightOrHeight;

    @Column(name = "HEALTH_FOBIA")
    private Boolean healthFobia;

    @Column(name = "HEALTH_BAD_HABITS")
    private Boolean healthBadHabits;

    @Column(name = "HEALTH_WETS_BED")
    private Boolean healthWetsBed;

    @Column(name = "HEALTH_BAD_SLEEP")
    private Boolean healthBadSleep;

    @Column(name = "HEALTH_HAS_TRAUMA")
    private Boolean healthHasTrauma;

    @Column(name = "HEALTH_BAD_COMMUNICATION")
    private Boolean healthBadCommunication;

    @Lob
    @Column(name = "HEAL_OTHERS")
    private String healthOthers;

    @Column(name = "EDU_NOT_LIKE")
    private Boolean eduNotLike;

    @Lob
    @Column(name = "EDU_NOT_LIKE_TEXT")
    private String eduNotLikeText;

    @Column(name = "EDU_NO_SUBJECT")
    private Boolean eduNoSubject;

    @Column(name = "EDU_WORKING")
    private Boolean eduWorking;

    @Column(name = "EDU_NO_DISCIPLINE")
    private Boolean eduNoDiscipline;

    @Column(name = "EDU_SCHOOL_FRIEND")
    private Boolean eduSchoolFriend;

    @Column(name = "EDU_SPECIAL_NEEDS")
    private Boolean eduSpecialNeeds;

    @Lob
    @Column(name = "EDU_SPECIAL_NEEDS_TEXT")
    private String eduSpecialNeedsText;

    @Column(name = "EDU_DIFFICULT_PROGRAM")
    private Boolean eduDifficultProgram;

    @Column(name = "EDU_DIFFICULT_PROGRAM_TEXT")
    private String eduDifficultProgramText;

    @Column(name = "EDU_FREQ_ABSENT")
    private Boolean eduFreqAbsent;

    @Lob
    @Column(name = "EDU_FREQ_ABSENT_TEXT")
    private String eduFreqAbsentText;

    @Column(name = "EDU_NO_ATTENTION")
    private Boolean eduNoAttention;

    @Lob
    @Column(name = "EDU_NO_ATTENTION_TEXT")
    private String eduNoAttentionText;

    @Column(name = "EDU_NO_CLUB")
    private Boolean eduNoClub;

    @Column(name = "EDU_NO_STATIONERY")
    private Boolean eduNoStationery;

    @Column(name = "EDU_NO_LAPTOP")
    private Boolean eduNoLaptop;

    @Column(name = "EDU_NO_UNIFORM")
    private Boolean eduNoUniform;

    @Column(name = "EDU_CONFLICT")
    private Boolean eduConflict;

    @Column(name = "EDU_NO_DESK")
    private Boolean eduNoDesk;

    @Column(name = "EDU_AMORAL_ABSENT")
    private Boolean eduAmoralAbsent;

    @Column(name = "EDU_LOW_MOTIVATION")
    private Boolean eduLowMotivation;

    @Lob
    @Column(name = "EDU_OTHERS")
    private String eduOthers;

    @Column(name = "EMO_NO_STABILITY")
    private Boolean emoNoStability;

    @Column(name = "EMO_ANXIETY")
    private Boolean emoAnxiety;

    @Lob
    @Column(name = "EMO_ANXIETY_TEXT")
    private String emoAnxietyText;

    @Column(name = "EMO_NO_FRIENDS")
    private Boolean emoNoFriends;

    @Column(name = "EMO_NO_FRIENDS_TEXT")
    private String emoNoFriendsText;

    @Column(name = "EMO_DEPRESSION")
    private Boolean emoDepression;

    @Lob
    @Column(name = "EMO_DEPRESSION_TEXT")
    private String emoDepressionText;

    @Column(name = "EMO_BULLYING")
    private Boolean emoBullying;

    @Column(name = "EMO_OUTSIDE_OF_HOME")
    private Boolean emoOutsideOfHome;

    @Column(name = "EMO_ALONE")
    private Boolean emoAlone;

    @Lob
    @Column(name = "EMO_ALONE_TEXT")
    private String emoAloneText;

    @Column(name = "EMO_SELF_HARASSMENT")
    private Boolean emoSelfHarassment;

    @Column(name = "EMO_RAN_AWAY")
    private Boolean emoRanAway;

    @Column(name = "EMO_IS_BULLY")
    private Boolean emoIsBully;

    @Column(name = "EMO_RISKING_ACTION")
    private Boolean emoRiskingAction;

    @Lob
    @Column(name = "EMO_RISKING_ACTION_TEXT")
    private String emoRiskingActionText;

    @Column(name = "EMO_CONFLICT_WITNESS")
    private Boolean emoConflictWitness;

    @Lob
    @Column(name = "EMO_CONFLICT_WITNESS_TEXT")
    private String emoConflictWitnessText;

    @Column(name = "EMO_NO_EMOTION_CONTROL")
    private Boolean emoNoEmotionControl;

    @Column(name = "EMO_SUICIDIAL")
    private Boolean emoSuicidial;

    @Column(name = "EMO_SUICIDIAL_ATTEMPT")
    private Boolean emoSuicidialAttempt;

    @Column(name = "EMO_STEALS")
    private Boolean emoSteals;

    @Column(name = "EMO_ON_REGISTER")
    private Boolean emoOnRegister;

    @Lob
    @Column(name = "EMO_ON_REGISTER_TEXT")
    private String emoOnRegisterText;

    @Column(name = "EMO_AGGRESSOR")
    private Boolean emoAggressor;

    @Column(name = "EMO_NO_BAD_NO_GOOD")
    private Boolean emoNoBadNoGood;

    @Column(name = "EMO_NOT_NORMAL")
    private Boolean emoNotNormal;

    @Lob
    @Column(name = "EMO_OTHERS")
    private String emoOthers;

    @Column(name = "IDENT_DISCRIMINATION")
    private Boolean identDiscrimination;

    @Lob
    @Column(name = "IDENT_DISCRIMINATION_TEXT")
    private String identDiscriminationText;

    @Column(name = "IDENT_NO_FAMILY")
    private Boolean identNoFamily;

    @Column(name = "IDENT_GENDER_CONF")
    private Boolean identGenderConf;

    @Column(name = "IDENT_GENDER_DONT_KNOW")
    private Boolean identGenderDontKnow;

    @Lob
    @Column(name = "IDENT_GENDER_DONT_KNOW_TEXT")
    private String identGenderDontKnowText;

    @Column(name = "IDENT_POSITIVE_INDIVIDUAL")
    private Boolean identPositiveIndividual;

    @Column(name = "IDENT_AGE_SOL")
    private Boolean identAgeSol;

    @Lob
    @Column(name = "IDENT_AGE_SOL_TEXT")
    private String identAgeSolText;

    @Column(name = "IDENT_NOT_SURE_MYSELF")
    private Boolean identNotSureMyself;

    @Column(name = "IDENT_NOT_SATISFIED")
    private Boolean identNotSatisfied;

    @Column(name = "IDENT_NO_CULTURAL")
    private Boolean identNoCultural;

    @Column(name = "IDENT_NOT_INDEPENDENT")
    private Boolean identNotIndependent;

    @Column(name = "IDENT_NO_HYGIENE")
    private Boolean identNoHygiene;

    @Lob
    @Column(name = "IDENT_OTHERS")
    private String identOthers;

    @Column(name = "FAMILY_NO_RELATIONSHIP")
    private Boolean familyNoRelationship;

    @Lob
    @Column(name = "FAMILY_NO_RELATIONSHIP_TEXT")
    private String familyNoRelationshipText;

    @Column(name = "FAMILY_NO_ADULT")
    private Boolean familyNoAdult;

    @Column(name = "FAMILY_DOMESTIC_VIOLENCE")
    private Boolean familyDomesticViolence;

    @Column(name = "FAMILY_NO_CONNECTION")
    private Boolean familyNoConnection;

    @Column(name = "FAMILY_BAD_REVIEW")
    private Boolean familyBadReview;

    @Lob
    @Column(name = "FAMILY_BAD_REVIEW_TEXT")
    private String familyBadReviewText;

    @Column(name = "FAMILY_BAD_FRIENDS")
    private Boolean familyBadFriends;

    @Lob
    @Column(name = "FAMILY_BAD_FRIENDS_TEXT")
    private String familyBadFriendsText;

    @Column(name = "FAMILY_NO_SKILLS")
    private Boolean familyNoSkills;

    @Column(name = "FAMILY_CHILD_IS_ADULT")
    private Boolean familyChildIsAdult;

    @Column(name = "FAMILY_DIFFERENT_PARENTS")
    private Boolean familyDifferentParents;

    @Column(name = "FAMILY_CHILD_CONFLICT")
    private Boolean familyChildConflict;

    @Lob
    @Column(name = "FAMILY_CHILD_CONFLICT_TEXT")
    private String familyChildConflictText;

    @Column(name = "FAMILY_NO_TIME_COMMUNICATION")
    private Boolean familyNoTimeCommunication;

    @Column(name = "FAMILY_AWAY_FROM_PARENTS")
    private Boolean familyAwayFromParents;

    @Column(name = "FAMILY_SEXUAL_PROBLEMS")
    private Boolean familySexualProblems;

    @Lob
    @Column(name = "FAMILY_SEXUAL_PROBLEMS_TEXT")
    private String familySexualProblemsText;

    @Column(name = "FAMILY_CHILD_PARENT_CONFLICT")
    private Boolean familyChildParentConflict;

    @Column(name = "FAMILY_CHRONICAL_DISEASE")
    private Boolean familyChronicalDisease;

    @Lob
    @Column(name = "FAMILY_CHRONICAL_DISEASE_TEXT")
    private String familyChronicalDiseaseText;

    @Column(name = "FAMILY_HAS_JAIL")
    private Boolean familyHasJail;

    @Column(name = "FAMILY_HAS_TRAUMA")
    private Boolean familyHasTrauma;

    @Lob
    @Column(name = "FAMILY_HAS_TRAUMA_TEXT")
    private String familyHasTraumaText;

    @Lob
    @Column(name = "FAMILY_OTHERS")
    private String familyOthers;

    @Column(name = "SELF_NO_PHYSICIAL_ACTIVITY")
    private Boolean selfNoPhysicialActivity;

    @Column(name = "SELF_NO_PRACTICAL_SKILLS")
    private Boolean selfNoPracticalSkills;

    @Column(name = "SELF_NO_MONEY")
    private Boolean selfNoMoney;

    @Column(name = "SELF_NO_HELP")
    private Boolean selfNoHelp;

    @Lob
    @Column(name = "SELF_OTHERS")
    private String selfOthers;

    @Column(name = "PARENTS_NO_BASIC")
    private Boolean parentsNoBasic;

    @Lob
    @Column(name = "PARENTS_NO_BASIC_TEXT")
    private String parentsNoBasicText;

    @Column(name = "PARENTS_NO_DAILY_ROUTINE")
    private Boolean parentsNoDailyRoutine;

    @Column(name = "PARENTS_NO_SPACE")
    private Boolean parentsNoSpace;

    @Column(name = "PARENTS_NO_CHILD_HEALTH")
    private Boolean parentsNoChildHealth;

    @Column(name = "PARENTS_NO_PRAISED")
    private Boolean parentsNoPraised;

    @Column(name = "PARENTS_NO_SCHOOL")
    private Boolean parentsNoSchool;

    @Column(name = "PARENTS_DONT_KNOW")
    private Boolean parentsDontKnow;

    @Column(name = "PARENTS_DONT_CARE")
    private Boolean parentsDontCare;

    @Column(name = "PARENT_NO_DISCIPLINE")
    private Boolean parentNoDiscipline;

    @Lob
    @Column(name = "PARENTS_OTHERS")
    private String parentsOthers;

    @Column(name = "HOME_NO_HOME")
    private Boolean homeNoHome;

    @Column(name = "HOME_EVICTION")
    private Boolean homeEviction;

    @Column(name = "HOME_DANGER")
    private Boolean homeDanger;

    @Lob
    @Column(name = "HOME_DANGER_TEXT")
    private String homeDangerText;

    @Column(name = "HOME_NO_JOB")
    private Boolean homeNoJob;

    @Lob
    @Column(name = "HOME_NO_JOB_TEXT")
    private String homeNoJobText;

    @Column(name = "HOME_NO_BENEFITS")
    private Boolean homeNoBenefits;

    @Lob
    @Column(name = "HOME_NO_BENEFITS_TEXT")
    private String homeNoBenefitsText;

    @Column(name = "HOME_NO_MONEY")
    private Boolean homeNoMoney;

    @Lob
    @Column(name = "HOME_NO_MONEY_TEXT")
    private String homeNoMoneyText;

    @Lob
    @Column(name = "HOME_OTHERS")
    private String homeOthers;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "secondForm")
    private OpenCase openCase;

    @Column(name = "HEALTH_LOW")
    private Boolean healthLow;

    @Column(name = "HEALTH_MEDIUM")
    private Boolean healthMedium;

    @Column(name = "HEALTH_HIGH")
    private Boolean healthHigh;

    @Column(name = "EDU_LOW")
    private Boolean eduLow;

    @Column(name = "EDU_MEDIUM")
    private Boolean eduMedium;

    @Column(name = "EDU_HIGH")
    private Boolean eduHigh;

    @Column(name = "EMO_LOW")
    private Boolean emoLow;

    @Column(name = "EMO_MEDIUM")
    private Boolean emoMedium;

    @Column(name = "EMO_HIGH")
    private Boolean emoHigh;

    @Column(name = "IDENT_LOW")
    private Boolean identLow;

    @Column(name = "IDENT_MEDIUM")
    private Boolean identMedium;

    @Column(name = "IDENT_HIGH")
    private Boolean identHigh;

    @Column(name = "FAMILY_LOW")
    private Boolean familyLow;

    @Column(name = "FAMILY_MEDIUM")
    private Boolean familyMedium;

    @Column(name = "FAMILY_HIGH")
    private Boolean familyHigh;

    @Column(name = "SELF_LOW")
    private Boolean selfLow;

    @Column(name = "SELF_MEDIUM")
    private Boolean selfMedium;

    @Column(name = "SELF_HIGH")
    private Boolean selfHigh;

    @Column(name = "PARENTS_LOW")
    private Boolean parentsLow;

    @Column(name = "PARENTS_MEDIUM")
    private Boolean parentsMedium;

    @Column(name = "PARENTS_HIGH")
    private Boolean parentsHigh;

    @Column(name = "HOME_LOW")
    private Boolean homeLow;

    @Column(name = "HOME_MEDIUM")
    private Boolean homeMedium;

    @Column(name = "HOME_HIGH")
    private Boolean homeHigh;

    @Composition
    @OneToMany(mappedBy = "secondForm", cascade = CascadeType.ALL)
    private List<PivotTableCheckBoxes> pivotTableCheckBoxes;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCaseIdNum(String caseIdNum) {
        this.caseIdNum = caseIdNum;
    }

    public String getCaseIdNum() {
        return caseIdNum;
    }

    public String getHomeNoMoneyText() {
        return homeNoMoneyText;
    }

    public void setHomeNoMoneyText(String homeNoMoneyText) {
        this.homeNoMoneyText = homeNoMoneyText;
    }

    public String getHomeNoBenefitsText() {
        return homeNoBenefitsText;
    }

    public void setHomeNoBenefitsText(String homeNoBenefitsText) {
        this.homeNoBenefitsText = homeNoBenefitsText;
    }

    public String getHomeNoJobText() {
        return homeNoJobText;
    }

    public void setHomeNoJobText(String homeNoJobText) {
        this.homeNoJobText = homeNoJobText;
    }

    public String getHomeDangerText() {
        return homeDangerText;
    }

    public void setHomeDangerText(String homeDangerText) {
        this.homeDangerText = homeDangerText;
    }

    public String getParentsNoBasicText() {
        return parentsNoBasicText;
    }

    public void setParentsNoBasicText(String parentsNoBasicText) {
        this.parentsNoBasicText = parentsNoBasicText;
    }

    public String getFamilyHasTraumaText() {
        return familyHasTraumaText;
    }

    public void setFamilyHasTraumaText(String familyHasTraumaText) {
        this.familyHasTraumaText = familyHasTraumaText;
    }

    public String getFamilyChronicalDiseaseText() {
        return familyChronicalDiseaseText;
    }

    public void setFamilyChronicalDiseaseText(String familyChronicalDiseaseText) {
        this.familyChronicalDiseaseText = familyChronicalDiseaseText;
    }

    public String getFamilySexualProblemsText() {
        return familySexualProblemsText;
    }

    public void setFamilySexualProblemsText(String familySexualProblemsText) {
        this.familySexualProblemsText = familySexualProblemsText;
    }

    public String getFamilyChildConflictText() {
        return familyChildConflictText;
    }

    public void setFamilyChildConflictText(String familyChildConflictText) {
        this.familyChildConflictText = familyChildConflictText;
    }

    public String getFamilyBadFriendsText() {
        return familyBadFriendsText;
    }

    public void setFamilyBadFriendsText(String familyBadFriendsText) {
        this.familyBadFriendsText = familyBadFriendsText;
    }

    public String getFamilyBadReviewText() {
        return familyBadReviewText;
    }

    public void setFamilyBadReviewText(String familyBadReviewText) {
        this.familyBadReviewText = familyBadReviewText;
    }

    public String getFamilyNoRelationshipText() {
        return familyNoRelationshipText;
    }

    public void setFamilyNoRelationshipText(String familyNoRelationshipText) {
        this.familyNoRelationshipText = familyNoRelationshipText;
    }

    public String getIdentAgeSolText() {
        return identAgeSolText;
    }

    public void setIdentAgeSolText(String identAgeSolText) {
        this.identAgeSolText = identAgeSolText;
    }

    public String getIdentGenderDontKnowText() {
        return identGenderDontKnowText;
    }

    public void setIdentGenderDontKnowText(String identGenderDontKnowText) {
        this.identGenderDontKnowText = identGenderDontKnowText;
    }

    public String getIdentDiscriminationText() {
        return identDiscriminationText;
    }

    public void setIdentDiscriminationText(String identDiscriminationText) {
        this.identDiscriminationText = identDiscriminationText;
    }

    public String getEmoOnRegisterText() {
        return emoOnRegisterText;
    }

    public void setEmoOnRegisterText(String emoOnRegisterText) {
        this.emoOnRegisterText = emoOnRegisterText;
    }

    public String getEmoConflictWitnessText() {
        return emoConflictWitnessText;
    }

    public void setEmoConflictWitnessText(String emoConflictWitnessText) {
        this.emoConflictWitnessText = emoConflictWitnessText;
    }

    public String getEmoRiskingActionText() {
        return emoRiskingActionText;
    }

    public void setEmoRiskingActionText(String emoRiskingActionText) {
        this.emoRiskingActionText = emoRiskingActionText;
    }

    public String getEmoAloneText() {
        return emoAloneText;
    }

    public void setEmoAloneText(String emoAloneText) {
        this.emoAloneText = emoAloneText;
    }

    public String getEmoDepressionText() {
        return emoDepressionText;
    }

    public void setEmoDepressionText(String emoDepressionText) {
        this.emoDepressionText = emoDepressionText;
    }

    public String getEmoNoFriendsText() {
        return emoNoFriendsText;
    }

    public void setEmoNoFriendsText(String emoNoFriendsText) {
        this.emoNoFriendsText = emoNoFriendsText;
    }

    public String getEmoAnxietyText() {
        return emoAnxietyText;
    }

    public void setEmoAnxietyText(String emoAnxietyText) {
        this.emoAnxietyText = emoAnxietyText;
    }

    public String getEduNoAttentionText() {
        return eduNoAttentionText;
    }

    public void setEduNoAttentionText(String eduNoAttentionText) {
        this.eduNoAttentionText = eduNoAttentionText;
    }

    public String getEduFreqAbsentText() {
        return eduFreqAbsentText;
    }

    public void setEduFreqAbsentText(String eduFreqAbsentText) {
        this.eduFreqAbsentText = eduFreqAbsentText;
    }

    public String getEduDifficultProgramText() {
        return eduDifficultProgramText;
    }

    public void setEduDifficultProgramText(String eduDifficultProgramText) {
        this.eduDifficultProgramText = eduDifficultProgramText;
    }

    public String getEduSpecialNeedsText() {
        return eduSpecialNeedsText;
    }

    public void setEduSpecialNeedsText(String eduSpecialNeedsText) {
        this.eduSpecialNeedsText = eduSpecialNeedsText;
    }

    public String getEduNotLikeText() {
        return eduNotLikeText;
    }

    public void setEduNotLikeText(String eduNotLikeText) {
        this.eduNotLikeText = eduNotLikeText;
    }

    public String getHealthNoEquipmentText() {
        return healthNoEquipmentText;
    }

    public void setHealthNoEquipmentText(String healthNoEquipmentText) {
        this.healthNoEquipmentText = healthNoEquipmentText;
    }

    public String getHealthNoFoodText() {
        return healthNoFoodText;
    }

    public void setHealthNoFoodText(String healthNoFoodText) {
        this.healthNoFoodText = healthNoFoodText;
    }

    public String getHealthDisabledNoHelpText() {
        return healthDisabledNoHelpText;
    }

    public void setHealthDisabledNoHelpText(String healthDisabledNoHelpText) {
        this.healthDisabledNoHelpText = healthDisabledNoHelpText;
    }

    public String getHealthChronicalText() {
        return healthChronicalText;
    }

    public void setHealthChronicalText(String healthChronicalText) {
        this.healthChronicalText = healthChronicalText;
    }

    public List<PivotTableCheckBoxes> getPivotTableCheckBoxes() {
        return pivotTableCheckBoxes;
    }

    public void setPivotTableCheckBoxes(List<PivotTableCheckBoxes> pivotTableCheckBoxes) {
        this.pivotTableCheckBoxes = pivotTableCheckBoxes;
    }

    public void setEduNoClub(Boolean eduNoClub) {
        this.eduNoClub = eduNoClub;
    }

    public Boolean getEduNoClub() {
        return eduNoClub;
    }

    public void setHomeLow(Boolean homeLow) {
        this.homeLow = homeLow;
    }

    public Boolean getHomeLow() {
        return homeLow;
    }

    public Boolean getHomeHigh() {
        return homeHigh;
    }

    public void setHomeHigh(Boolean homeHigh) {
        this.homeHigh = homeHigh;
    }

    public Boolean getHomeMedium() {
        return homeMedium;
    }

    public void setHomeMedium(Boolean homeMedium) {
        this.homeMedium = homeMedium;
    }

    public Boolean getParentsHigh() {
        return parentsHigh;
    }

    public void setParentsHigh(Boolean parentsHigh) {
        this.parentsHigh = parentsHigh;
    }

    public Boolean getParentsMedium() {
        return parentsMedium;
    }

    public void setParentsMedium(Boolean parentsMedium) {
        this.parentsMedium = parentsMedium;
    }

    public Boolean getParentsLow() {
        return parentsLow;
    }

    public void setParentsLow(Boolean parentsLow) {
        this.parentsLow = parentsLow;
    }

    public Boolean getSelfHigh() {
        return selfHigh;
    }

    public void setSelfHigh(Boolean selfHigh) {
        this.selfHigh = selfHigh;
    }

    public Boolean getSelfMedium() {
        return selfMedium;
    }

    public void setSelfMedium(Boolean selfMedium) {
        this.selfMedium = selfMedium;
    }

    public Boolean getSelfLow() {
        return selfLow;
    }

    public void setSelfLow(Boolean selfLow) {
        this.selfLow = selfLow;
    }

    public Boolean getFamilyHigh() {
        return familyHigh;
    }

    public void setFamilyHigh(Boolean familyHigh) {
        this.familyHigh = familyHigh;
    }

    public Boolean getFamilyMedium() {
        return familyMedium;
    }

    public void setFamilyMedium(Boolean familyMedium) {
        this.familyMedium = familyMedium;
    }

    public Boolean getFamilyLow() {
        return familyLow;
    }

    public void setFamilyLow(Boolean familyLow) {
        this.familyLow = familyLow;
    }

    public Boolean getIdentHigh() {
        return identHigh;
    }

    public void setIdentHigh(Boolean identHigh) {
        this.identHigh = identHigh;
    }

    public Boolean getIdentMedium() {
        return identMedium;
    }

    public void setIdentMedium(Boolean identMedium) {
        this.identMedium = identMedium;
    }

    public Boolean getIdentLow() {
        return identLow;
    }

    public void setIdentLow(Boolean identLow) {
        this.identLow = identLow;
    }

    public Boolean getEmoHigh() {
        return emoHigh;
    }

    public void setEmoHigh(Boolean emoHigh) {
        this.emoHigh = emoHigh;
    }

    public Boolean getEmoMedium() {
        return emoMedium;
    }

    public void setEmoMedium(Boolean emoMedium) {
        this.emoMedium = emoMedium;
    }

    public Boolean getEmoLow() {
        return emoLow;
    }

    public void setEmoLow(Boolean emoLow) {
        this.emoLow = emoLow;
    }

    public Boolean getEduHigh() {
        return eduHigh;
    }

    public void setEduHigh(Boolean eduHigh) {
        this.eduHigh = eduHigh;
    }

    public Boolean getEduMedium() {
        return eduMedium;
    }

    public void setEduMedium(Boolean eduMedium) {
        this.eduMedium = eduMedium;
    }

    public Boolean getEduLow() {
        return eduLow;
    }

    public void setEduLow(Boolean eduLow) {
        this.eduLow = eduLow;
    }

    public Boolean getHealthHigh() {
        return healthHigh;
    }

    public void setHealthHigh(Boolean healthHigh) {
        this.healthHigh = healthHigh;
    }

    public Boolean getHealthMedium() {
        return healthMedium;
    }

    public void setHealthMedium(Boolean healthMedium) {
        this.healthMedium = healthMedium;
    }

    public Boolean getHealthLow() {
        return healthLow;
    }

    public void setHealthLow(Boolean healthLow) {
        this.healthLow = healthLow;
    }

    public OpenCase getOpenCase() {
        return openCase;
    }

    public void setOpenCase(OpenCase openCase) {
        this.openCase = openCase;
    }

    public void setParentsDontCare(Boolean parentsDontCare) {
        this.parentsDontCare = parentsDontCare;
    }

    public Boolean getParentsDontCare() {
        return parentsDontCare;
    }

    public String getHomeOthers() {
        return homeOthers;
    }

    public void setHomeOthers(String homeOthers) {
        this.homeOthers = homeOthers;
    }

    public Boolean getHomeNoMoney() {
        return homeNoMoney;
    }

    public void setHomeNoMoney(Boolean homeNoMoney) {
        this.homeNoMoney = homeNoMoney;
    }

    public Boolean getHomeNoBenefits() {
        return homeNoBenefits;
    }

    public void setHomeNoBenefits(Boolean homeNoBenefits) {
        this.homeNoBenefits = homeNoBenefits;
    }

    public Boolean getHomeNoJob() {
        return homeNoJob;
    }

    public void setHomeNoJob(Boolean homeNoJob) {
        this.homeNoJob = homeNoJob;
    }

    public Boolean getHomeDanger() {
        return homeDanger;
    }

    public void setHomeDanger(Boolean homeDanger) {
        this.homeDanger = homeDanger;
    }

    public Boolean getHomeEviction() {
        return homeEviction;
    }

    public void setHomeEviction(Boolean homeEviction) {
        this.homeEviction = homeEviction;
    }

    public Boolean getHomeNoHome() {
        return homeNoHome;
    }

    public void setHomeNoHome(Boolean homeNoHome) {
        this.homeNoHome = homeNoHome;
    }

    public String getParentsOthers() {
        return parentsOthers;
    }

    public void setParentsOthers(String parentsOthers) {
        this.parentsOthers = parentsOthers;
    }

    public Boolean getParentNoDiscipline() {
        return parentNoDiscipline;
    }

    public void setParentNoDiscipline(Boolean parentNoDiscipline) {
        this.parentNoDiscipline = parentNoDiscipline;
    }

    public Boolean getParentsDontKnow() {
        return parentsDontKnow;
    }

    public void setParentsDontKnow(Boolean parentsDontKnow) {
        this.parentsDontKnow = parentsDontKnow;
    }

    public Boolean getParentsNoSchool() {
        return parentsNoSchool;
    }

    public void setParentsNoSchool(Boolean parentsNoSchool) {
        this.parentsNoSchool = parentsNoSchool;
    }

    public Boolean getParentsNoPraised() {
        return parentsNoPraised;
    }

    public void setParentsNoPraised(Boolean parentsNoPraised) {
        this.parentsNoPraised = parentsNoPraised;
    }

    public Boolean getParentsNoChildHealth() {
        return parentsNoChildHealth;
    }

    public void setParentsNoChildHealth(Boolean parentsNoChildHealth) {
        this.parentsNoChildHealth = parentsNoChildHealth;
    }

    public Boolean getParentsNoSpace() {
        return parentsNoSpace;
    }

    public void setParentsNoSpace(Boolean parentsNoSpace) {
        this.parentsNoSpace = parentsNoSpace;
    }

    public Boolean getParentsNoDailyRoutine() {
        return parentsNoDailyRoutine;
    }

    public void setParentsNoDailyRoutine(Boolean parentsNoDailyRoutine) {
        this.parentsNoDailyRoutine = parentsNoDailyRoutine;
    }

    public Boolean getParentsNoBasic() {
        return parentsNoBasic;
    }

    public void setParentsNoBasic(Boolean parentsNoBasic) {
        this.parentsNoBasic = parentsNoBasic;
    }

    public String getSelfOthers() {
        return selfOthers;
    }

    public void setSelfOthers(String selfOthers) {
        this.selfOthers = selfOthers;
    }

    public Boolean getSelfNoHelp() {
        return selfNoHelp;
    }

    public void setSelfNoHelp(Boolean selfNoHelp) {
        this.selfNoHelp = selfNoHelp;
    }

    public Boolean getSelfNoMoney() {
        return selfNoMoney;
    }

    public void setSelfNoMoney(Boolean selfNoMoney) {
        this.selfNoMoney = selfNoMoney;
    }

    public Boolean getSelfNoPracticalSkills() {
        return selfNoPracticalSkills;
    }

    public void setSelfNoPracticalSkills(Boolean selfNoPracticalSkills) {
        this.selfNoPracticalSkills = selfNoPracticalSkills;
    }

    public Boolean getSelfNoPhysicialActivity() {
        return selfNoPhysicialActivity;
    }

    public void setSelfNoPhysicialActivity(Boolean selfNoPhysicialActivity) {
        this.selfNoPhysicialActivity = selfNoPhysicialActivity;
    }

    public String getFamilyOthers() {
        return familyOthers;
    }

    public void setFamilyOthers(String familyOthers) {
        this.familyOthers = familyOthers;
    }

    public void setIdentAgeSol(Boolean identAgeSol) {
        this.identAgeSol = identAgeSol;
    }

    public Boolean getIdentAgeSol() {
        return identAgeSol;
    }

    public void setIdentNotSureMyself(Boolean identNotSureMyself) {
        this.identNotSureMyself = identNotSureMyself;
    }

    public Boolean getIdentNotSureMyself() {
        return identNotSureMyself;
    }

    public void setFamilyNoSkills(Boolean familyNoSkills) {
        this.familyNoSkills = familyNoSkills;
    }

    public Boolean getFamilyNoSkills() {
        return familyNoSkills;
    }

    public Boolean getFamilyHasTrauma() {
        return familyHasTrauma;
    }

    public void setFamilyHasTrauma(Boolean familyHasTrauma) {
        this.familyHasTrauma = familyHasTrauma;
    }

    public Boolean getFamilyHasJail() {
        return familyHasJail;
    }

    public void setFamilyHasJail(Boolean familyHasJail) {
        this.familyHasJail = familyHasJail;
    }

    public Boolean getFamilyChronicalDisease() {
        return familyChronicalDisease;
    }

    public void setFamilyChronicalDisease(Boolean familyChronicalDisease) {
        this.familyChronicalDisease = familyChronicalDisease;
    }

    public Boolean getFamilyChildParentConflict() {
        return familyChildParentConflict;
    }

    public void setFamilyChildParentConflict(Boolean familyChildParentConflict) {
        this.familyChildParentConflict = familyChildParentConflict;
    }

    public Boolean getFamilySexualProblems() {
        return familySexualProblems;
    }

    public void setFamilySexualProblems(Boolean familySexualProblems) {
        this.familySexualProblems = familySexualProblems;
    }

    public Boolean getFamilyAwayFromParents() {
        return familyAwayFromParents;
    }

    public void setFamilyAwayFromParents(Boolean familyAwayFromParents) {
        this.familyAwayFromParents = familyAwayFromParents;
    }

    public Boolean getFamilyNoTimeCommunication() {
        return familyNoTimeCommunication;
    }

    public void setFamilyNoTimeCommunication(Boolean familyNoTimeCommunication) {
        this.familyNoTimeCommunication = familyNoTimeCommunication;
    }

    public Boolean getFamilyChildConflict() {
        return familyChildConflict;
    }

    public void setFamilyChildConflict(Boolean familyChildConflict) {
        this.familyChildConflict = familyChildConflict;
    }

    public Boolean getFamilyDifferentParents() {
        return familyDifferentParents;
    }

    public void setFamilyDifferentParents(Boolean familyDifferentParents) {
        this.familyDifferentParents = familyDifferentParents;
    }

    public Boolean getFamilyChildIsAdult() {
        return familyChildIsAdult;
    }

    public void setFamilyChildIsAdult(Boolean familyChildIsAdult) {
        this.familyChildIsAdult = familyChildIsAdult;
    }

    public Boolean getFamilyBadFriends() {
        return familyBadFriends;
    }

    public void setFamilyBadFriends(Boolean familyBadFriends) {
        this.familyBadFriends = familyBadFriends;
    }

    public Boolean getFamilyBadReview() {
        return familyBadReview;
    }

    public void setFamilyBadReview(Boolean familyBadReview) {
        this.familyBadReview = familyBadReview;
    }

    public Boolean getFamilyNoConnection() {
        return familyNoConnection;
    }

    public void setFamilyNoConnection(Boolean familyNoConnection) {
        this.familyNoConnection = familyNoConnection;
    }

    public Boolean getFamilyDomesticViolence() {
        return familyDomesticViolence;
    }

    public void setFamilyDomesticViolence(Boolean familyDomesticViolence) {
        this.familyDomesticViolence = familyDomesticViolence;
    }

    public Boolean getFamilyNoAdult() {
        return familyNoAdult;
    }

    public void setFamilyNoAdult(Boolean familyNoAdult) {
        this.familyNoAdult = familyNoAdult;
    }

    public Boolean getFamilyNoRelationship() {
        return familyNoRelationship;
    }

    public void setFamilyNoRelationship(Boolean familyNoRelationship) {
        this.familyNoRelationship = familyNoRelationship;
    }

    public String getIdentOthers() {
        return identOthers;
    }

    public void setIdentOthers(String identOthers) {
        this.identOthers = identOthers;
    }

    public Boolean getIdentNoHygiene() {
        return identNoHygiene;
    }

    public void setIdentNoHygiene(Boolean identNoHygiene) {
        this.identNoHygiene = identNoHygiene;
    }

    public Boolean getIdentNotIndependent() {
        return identNotIndependent;
    }

    public void setIdentNotIndependent(Boolean identNotIndependent) {
        this.identNotIndependent = identNotIndependent;
    }

    public Boolean getIdentNoCultural() {
        return identNoCultural;
    }

    public void setIdentNoCultural(Boolean identNoCultural) {
        this.identNoCultural = identNoCultural;
    }

    public Boolean getIdentNotSatisfied() {
        return identNotSatisfied;
    }

    public void setIdentNotSatisfied(Boolean identNotSatisfied) {
        this.identNotSatisfied = identNotSatisfied;
    }

    public Boolean getIdentPositiveIndividual() {
        return identPositiveIndividual;
    }

    public void setIdentPositiveIndividual(Boolean identPositiveIndividual) {
        this.identPositiveIndividual = identPositiveIndividual;
    }

    public Boolean getIdentGenderDontKnow() {
        return identGenderDontKnow;
    }

    public void setIdentGenderDontKnow(Boolean identGenderDontKnow) {
        this.identGenderDontKnow = identGenderDontKnow;
    }

    public Boolean getIdentGenderConf() {
        return identGenderConf;
    }

    public void setIdentGenderConf(Boolean identGenderConf) {
        this.identGenderConf = identGenderConf;
    }

    public Boolean getIdentNoFamily() {
        return identNoFamily;
    }

    public void setIdentNoFamily(Boolean identNoFamily) {
        this.identNoFamily = identNoFamily;
    }

    public Boolean getIdentDiscrimination() {
        return identDiscrimination;
    }

    public void setIdentDiscrimination(Boolean identDiscrimination) {
        this.identDiscrimination = identDiscrimination;
    }

    public String getEmoOthers() {
        return emoOthers;
    }

    public void setEmoOthers(String emoOthers) {
        this.emoOthers = emoOthers;
    }

    public Boolean getEmoNotNormal() {
        return emoNotNormal;
    }

    public void setEmoNotNormal(Boolean emoNotNormal) {
        this.emoNotNormal = emoNotNormal;
    }

    public Boolean getEmoNoBadNoGood() {
        return emoNoBadNoGood;
    }

    public void setEmoNoBadNoGood(Boolean emoNoBadNoGood) {
        this.emoNoBadNoGood = emoNoBadNoGood;
    }

    public Boolean getEmoAggressor() {
        return emoAggressor;
    }

    public void setEmoAggressor(Boolean emoAggressor) {
        this.emoAggressor = emoAggressor;
    }

    public Boolean getEmoOnRegister() {
        return emoOnRegister;
    }

    public void setEmoOnRegister(Boolean emoOnRegister) {
        this.emoOnRegister = emoOnRegister;
    }

    public Boolean getEmoSteals() {
        return emoSteals;
    }

    public void setEmoSteals(Boolean emoSteals) {
        this.emoSteals = emoSteals;
    }

    public Boolean getEmoSuicidialAttempt() {
        return emoSuicidialAttempt;
    }

    public void setEmoSuicidialAttempt(Boolean emoSuicidialAttempt) {
        this.emoSuicidialAttempt = emoSuicidialAttempt;
    }

    public Boolean getEmoSuicidial() {
        return emoSuicidial;
    }

    public void setEmoSuicidial(Boolean emoSuicidial) {
        this.emoSuicidial = emoSuicidial;
    }

    public Boolean getEmoNoEmotionControl() {
        return emoNoEmotionControl;
    }

    public void setEmoNoEmotionControl(Boolean emoNoEmotionControl) {
        this.emoNoEmotionControl = emoNoEmotionControl;
    }

    public Boolean getEmoConflictWitness() {
        return emoConflictWitness;
    }

    public void setEmoConflictWitness(Boolean emoConflictWitness) {
        this.emoConflictWitness = emoConflictWitness;
    }

    public Boolean getEmoRiskingAction() {
        return emoRiskingAction;
    }

    public void setEmoRiskingAction(Boolean emoRiskingAction) {
        this.emoRiskingAction = emoRiskingAction;
    }

    public Boolean getEmoIsBully() {
        return emoIsBully;
    }

    public void setEmoIsBully(Boolean emoIsBully) {
        this.emoIsBully = emoIsBully;
    }

    public Boolean getEmoRanAway() {
        return emoRanAway;
    }

    public void setEmoRanAway(Boolean emoRanAway) {
        this.emoRanAway = emoRanAway;
    }

    public Boolean getEmoSelfHarassment() {
        return emoSelfHarassment;
    }

    public void setEmoSelfHarassment(Boolean emoSelfHarassment) {
        this.emoSelfHarassment = emoSelfHarassment;
    }

    public Boolean getEmoAlone() {
        return emoAlone;
    }

    public void setEmoAlone(Boolean emoAlone) {
        this.emoAlone = emoAlone;
    }

    public Boolean getEmoOutsideOfHome() {
        return emoOutsideOfHome;
    }

    public void setEmoOutsideOfHome(Boolean emoOutsideOfHome) {
        this.emoOutsideOfHome = emoOutsideOfHome;
    }

    public Boolean getEmoBullying() {
        return emoBullying;
    }

    public void setEmoBullying(Boolean emoBullying) {
        this.emoBullying = emoBullying;
    }

    public Boolean getEmoDepression() {
        return emoDepression;
    }

    public void setEmoDepression(Boolean emoDepression) {
        this.emoDepression = emoDepression;
    }

    public Boolean getEmoNoFriends() {
        return emoNoFriends;
    }

    public void setEmoNoFriends(Boolean emoNoFriends) {
        this.emoNoFriends = emoNoFriends;
    }

    public Boolean getEmoAnxiety() {
        return emoAnxiety;
    }

    public void setEmoAnxiety(Boolean emoAnxiety) {
        this.emoAnxiety = emoAnxiety;
    }

    public Boolean getEmoNoStability() {
        return emoNoStability;
    }

    public void setEmoNoStability(Boolean emoNoStability) {
        this.emoNoStability = emoNoStability;
    }

    public String getEduOthers() {
        return eduOthers;
    }

    public void setEduOthers(String eduOthers) {
        this.eduOthers = eduOthers;
    }

    public Boolean getEduLowMotivation() {
        return eduLowMotivation;
    }

    public void setEduLowMotivation(Boolean eduLowMotivation) {
        this.eduLowMotivation = eduLowMotivation;
    }

    public Boolean getEduAmoralAbsent() {
        return eduAmoralAbsent;
    }

    public void setEduAmoralAbsent(Boolean eduAmoralAbsent) {
        this.eduAmoralAbsent = eduAmoralAbsent;
    }

    public Boolean getEduNoDesk() {
        return eduNoDesk;
    }

    public void setEduNoDesk(Boolean eduNoDesk) {
        this.eduNoDesk = eduNoDesk;
    }

    public Boolean getEduConflict() {
        return eduConflict;
    }

    public void setEduConflict(Boolean eduConflict) {
        this.eduConflict = eduConflict;
    }

    public Boolean getEduNoUniform() {
        return eduNoUniform;
    }

    public void setEduNoUniform(Boolean eduNoUniform) {
        this.eduNoUniform = eduNoUniform;
    }

    public Boolean getEduNoLaptop() {
        return eduNoLaptop;
    }

    public void setEduNoLaptop(Boolean eduNoLaptop) {
        this.eduNoLaptop = eduNoLaptop;
    }

    public Boolean getEduNoStationery() {
        return eduNoStationery;
    }

    public void setEduNoStationery(Boolean eduNoStationery) {
        this.eduNoStationery = eduNoStationery;
    }

    public Boolean getEduNoAttention() {
        return eduNoAttention;
    }

    public void setEduNoAttention(Boolean eduNoAttention) {
        this.eduNoAttention = eduNoAttention;
    }

    public Boolean getEduFreqAbsent() {
        return eduFreqAbsent;
    }

    public void setEduFreqAbsent(Boolean eduFreqAbsent) {
        this.eduFreqAbsent = eduFreqAbsent;
    }

    public Boolean getEduDifficultProgram() {
        return eduDifficultProgram;
    }

    public void setEduDifficultProgram(Boolean eduDifficultProgram) {
        this.eduDifficultProgram = eduDifficultProgram;
    }

    public Boolean getEduSpecialNeeds() {
        return eduSpecialNeeds;
    }

    public void setEduSpecialNeeds(Boolean eduSpecialNeeds) {
        this.eduSpecialNeeds = eduSpecialNeeds;
    }

    public Boolean getEduSchoolFriend() {
        return eduSchoolFriend;
    }

    public void setEduSchoolFriend(Boolean eduSchoolFriend) {
        this.eduSchoolFriend = eduSchoolFriend;
    }

    public Boolean getEduNoDiscipline() {
        return eduNoDiscipline;
    }

    public void setEduNoDiscipline(Boolean eduNoDiscipline) {
        this.eduNoDiscipline = eduNoDiscipline;
    }

    public Boolean getEduWorking() {
        return eduWorking;
    }

    public void setEduWorking(Boolean eduWorking) {
        this.eduWorking = eduWorking;
    }

    public Boolean getEduNoSubject() {
        return eduNoSubject;
    }

    public void setEduNoSubject(Boolean eduNoSubject) {
        this.eduNoSubject = eduNoSubject;
    }

    public Boolean getEduNotLike() {
        return eduNotLike;
    }

    public void setEduNotLike(Boolean eduNotLike) {
        this.eduNotLike = eduNotLike;
    }

    public String getHealthOthers() {
        return healthOthers;
    }

    public void setHealthOthers(String healOthers) {
        this.healthOthers = healOthers;
    }

    public void setHealthNoVaccination(Boolean healthNoVaccination) {
        this.healthNoVaccination = healthNoVaccination;
    }

    public Boolean getHealthNoVaccination() {
        return healthNoVaccination;
    }

    public void setHealthNoFood(Boolean healthNoFood) {
        this.healthNoFood = healthNoFood;
    }

    public Boolean getHealthNoFood() {
        return healthNoFood;
    }

    public void setHealthNoCoordination(Boolean healthNoCoordination) {
        this.healthNoCoordination = healthNoCoordination;
    }

    public Boolean getHealthNoCoordination() {
        return healthNoCoordination;
    }

    public Boolean getHealthBadCommunication() {
        return healthBadCommunication;
    }

    public void setHealthBadCommunication(Boolean healthBadCommunication) {
        this.healthBadCommunication = healthBadCommunication;
    }

    public Boolean getHealthHasTrauma() {
        return healthHasTrauma;
    }

    public void setHealthHasTrauma(Boolean healthHasTrauma) {
        this.healthHasTrauma = healthHasTrauma;
    }

    public Boolean getHealthBadSleep() {
        return healthBadSleep;
    }

    public void setHealthBadSleep(Boolean healthBadSleep) {
        this.healthBadSleep = healthBadSleep;
    }

    public Boolean getHealthWetsBed() {
        return healthWetsBed;
    }

    public void setHealthWetsBed(Boolean healthWetsBed) {
        this.healthWetsBed = healthWetsBed;
    }

    public Boolean getHealthBadHabits() {
        return healthBadHabits;
    }

    public void setHealthBadHabits(Boolean healthBadHabits) {
        this.healthBadHabits = healthBadHabits;
    }

    public Boolean getHealthFobia() {
        return healthFobia;
    }

    public void setHealthFobia(Boolean healthFobia) {
        this.healthFobia = healthFobia;
    }

    public Boolean getHealthBadWeightOrHeight() {
        return healthBadWeightOrHeight;
    }

    public void setHealthBadWeightOrHeight(Boolean healthBadWeightOrHeight) {
        this.healthBadWeightOrHeight = healthBadWeightOrHeight;
    }

    public Boolean getHealthNoEquipment() {
        return healthNoEquipment;
    }

    public void setHealthNoEquipment(Boolean healthNoEquipment) {
        this.healthNoEquipment = healthNoEquipment;
    }

    public Boolean getHealthNoSport() {
        return healthNoSport;
    }

    public void setHealthNoSport(Boolean healthNoSport) {
        this.healthNoSport = healthNoSport;
    }

    public Boolean getHealthNoTesting() {
        return healthNoTesting;
    }

    public void setHealthNoTesting(Boolean healthNoTesting) {
        this.healthNoTesting = healthNoTesting;
    }

    public Boolean getHealthNoHospital() {
        return healthNoHospital;
    }

    public void setHealthNoHospital(Boolean healthNoHospital) {
        this.healthNoHospital = healthNoHospital;
    }

    public Boolean getHealthDisabledNoHelp() {
        return healthDisabledNoHelp;
    }

    public void setHealthDisabledNoHelp(Boolean healthDisabledNoHelp) {
        this.healthDisabledNoHelp = healthDisabledNoHelp;
    }

    public Boolean getHealthNoRegistered() {
        return healthNoRegistered;
    }

    public void setHealthNoRegistered(Boolean healthNoRegistered) {
        this.healthNoRegistered = healthNoRegistered;
    }

    public Boolean getHealthChronical() {
        return healthChronical;
    }

    public void setHealthChronical(Boolean healthChronical) {
        this.healthChronical = healthChronical;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCaseManager() {
        return caseManager;
    }

    public void setCaseManager(String caseManager) {
        this.caseManager = caseManager;
    }

    public EducationalInstitution getEducationInstitution() {
        return educationInstitution == null ? null : EducationalInstitution.fromId(educationInstitution);
    }

    public void setEducationInstitution(EducationalInstitution educationInstitution) {
        this.educationInstitution = educationInstitution == null ? null : educationInstitution.getId();
    }

    public String getChildMobilePhone() {
        return childMobilePhone;
    }

    public void setChildMobilePhone(String childMobilePhone) {
        this.childMobilePhone = childMobilePhone;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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