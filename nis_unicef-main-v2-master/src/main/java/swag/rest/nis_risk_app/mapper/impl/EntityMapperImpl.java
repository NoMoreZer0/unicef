package swag.rest.nis_risk_app.mapper.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import swag.rest.nis_risk_app.dto.*;
import swag.rest.nis_risk_app.entity.*;
import swag.rest.nis_risk_app.mapper.EntityMapper;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Component
@RequiredArgsConstructor
public class EntityMapperImpl implements EntityMapper {

    private  final ModelMapper modelMapper;

    @Override
    public FirstPhase toEntity(FirstPhaseDto firstPhaseDto, String principal) {

        if ( firstPhaseDto == null ) {
            return null;
        }

        FirstPhase firstPhase = new FirstPhase();
        return convertFirstPhaseDtoToEntity(firstPhaseDto, principal, firstPhase);
    }


    public SecondPhase toEntity(SecondPhaseDto secondPhaseDto) {

        if ( secondPhaseDto == null ) {
            return null;
        }

        SecondPhase secondPhase = new SecondPhase();
        return convertSecondPhaseDtoToEntity(secondPhaseDto, secondPhase);
    }

    @Override
    public Student toExistEntity(Student student, StudentDto studentDto) {

        student.setPhoneNumber(studentDto.getPhoneNumber());

        student.address(studentDto.getAddress());

        student.nameOfStudent(studentDto.getNameOfStudent());

        student.grade(studentDto.getGrade());

        student.educationalNeeds(studentDto.getEducationalNeeds());

        student.dateOfBirth(studentDto.getDateOfBirth());

        student.gender(studentDto.getGender());

        student.setLanguage(studentDto.getLanguage());

        student.setSchool(studentDto.getSchool());

        student.setStudentStatus(studentDto.getStudentStatus());

        return student;
    }

    private FirstPhase convertFirstPhaseDtoToEntity(FirstPhaseDto firstPhaseDto, String principal, FirstPhase firstPhase) {

        log.info(principal + " - principal");
        firstPhase.setSource(
                modelMapper.map(firstPhaseDto.getSource(), Source.class));

        firstPhase.setDraft(Boolean.TRUE);
        firstPhase.setSignDate("");
        firstPhase.setEndDate("");
        firstPhase.setReason(firstPhaseDto.getReason());

        firstPhase.setFamilyNeighbor(
                modelMapper.map(firstPhaseDto.getFamilyNeighbor(), FamilyNeighbor.class));

        firstPhase.setStartDate(LocalDateTime.now().toString());

        firstPhase.setLegalRepresentative(
                modelMapper.map(firstPhaseDto.getLegalRepresentative(), LegalRepresentative.class));

        firstPhase.setStudentInformation(
                modelMapper.map(firstPhaseDto.getStudentInformationDto(), StudentInformation.class));

        firstPhase.setStartDate(LocalDateTime.now().toString());

        firstPhase.setSocMedRiskFactor(new SocMedRiskFactor());
        firstPhase.getSocMedRiskFactor().setGreenSocMedRiskFactor(modelMapper.map(firstPhaseDto.getSocMedRiskFactor()
                .getGreenSocMedRiskFactor(), GreenSocMedRiskFactor.class));
        firstPhase.getSocMedRiskFactor().setYellowSocMedRiskFactor(modelMapper.map(firstPhaseDto.getSocMedRiskFactor()
                .getYellowSocMedRiskFactor(), YellowSocMedRiskFactor.class));
        firstPhase.getSocMedRiskFactor().setRedSocMedRiskFactor(modelMapper.map(firstPhaseDto.getSocMedRiskFactor()
                .getRedSocMedRiskFactor(), RedSocMedRiskFactor.class));

        firstPhase.setIndividualRiskFactor(new IndividualRiskFactor());
        firstPhase.getIndividualRiskFactor().setYellowIndividualRiskFactor(modelMapper.map(firstPhaseDto
                .getIndividualRiskFactor().getYellowIndividualRiskFactor(), YellowIndividualRiskFactor.class));
        firstPhase.getIndividualRiskFactor().setRedIndividualRiskFactor(modelMapper.map(firstPhaseDto
                .getIndividualRiskFactor().getRedIndividualRiskFactor(), RedIndividualRiskFactor.class));

        firstPhase.setAcademicRiskFactor(new AcademicRiskFactor());
        firstPhase.getAcademicRiskFactor().setGreenAcademicRiskFactor(modelMapper.map(firstPhaseDto
                .getAcademicRiskFactor().getGreenAcademicRiskFactor(), GreenAcademicRiskFactor.class));
        firstPhase.getAcademicRiskFactor().setYellowAcademicRiskFactor(modelMapper.map(firstPhaseDto
                .getAcademicRiskFactor().getYellowAcademicRiskFactor(), YellowAcademicRiskFactor.class));

        firstPhase.setFamilyRiskFactor(new FamilyRiskFactor());
        firstPhase.getFamilyRiskFactor().setGreenFamilyRiskFactor(modelMapper.map(firstPhaseDto.getFamilyRiskFactor()
                .getGreenFamilyRiskFactor(), GreenFamilyRiskFactor.class));
        firstPhase.getFamilyRiskFactor().setYellowFamilyRiskFactor(modelMapper.map(firstPhaseDto.getFamilyRiskFactor()
                .getYellowFamilyRiskFactor(), YellowFamilyRiskFactor.class));

        firstPhase.setIndividualSafeFactor(modelMapper.map(firstPhaseDto.getIndividualSafeFactor(), IndividualSafeFactor.class));
        firstPhase.setFamilySafeFactor(modelMapper.map(firstPhaseDto.getFamilySafeFactor(), FamilySafeFactor.class));
        firstPhase.setEnvironmentSafeFactor(modelMapper.map(firstPhaseDto.getEnvironmentSafeFactor(), EnvironmentSafeFactor.class));
        firstPhase.setSchoolSafeFactor(modelMapper.map(firstPhaseDto.getSchoolSafeFactor(), SchoolSafeFactor.class));

        firstPhase.setAdditionalComment(firstPhaseDto.getAdditionalComment());
        firstPhase.setActions(modelMapper.map(firstPhaseDto.getActions(), Actions.class));

        return firstPhase;
    }

    private SecondPhase convertSecondPhaseDtoToEntity(SecondPhaseDto secondPhaseDto, SecondPhase secondPhase) {

        secondPhase.setAboutFamily(new AboutFamily());
        secondPhase.getAboutFamily()
                .greenAboutFamily(
                        modelMapper.map(secondPhaseDto.getAboutFamily().getGreenAboutFamily(), GreenAboutFamily.class))
                .yellowAboutFamily(
                        modelMapper.map(secondPhaseDto.getAboutFamily().getYellowAboutFamily(), YellowAboutFamily.class));

        secondPhase.setEducationSection(new EducationSection());
        secondPhase.getEducationSection()
                .greenEducationSection(
                        modelMapper.map(secondPhaseDto.getEducationSection().getGreenEducationSection(), GreenEducationSection.class))
                .yellowEducationSection(
                        modelMapper.map(secondPhaseDto.getEducationSection().getYellowEducationSection(), YellowEducationSection.class))
                .redEducationSection(
                        modelMapper.map(secondPhaseDto.getEducationSection().getRedEducationSection(), RedEducationSection.class));

        secondPhase.setEmotionalIntelligence(new EmotionalIntelligence());
        secondPhase.getEmotionalIntelligence()
                .yellowEmotionalIntelligence(
                        modelMapper.map(secondPhaseDto.getEmotionalIntelligence().getYellowEmotionalIntelligence(), YellowEmotionalIntelligence.class))
                .redEmotionalIntelligence(
                        modelMapper.map(secondPhaseDto.getEmotionalIntelligence().getRedEmotionalIntelligence(), RedEmotionalIntelligence.class))
                .bloodyRedEmotionalIntelligence(
                        modelMapper.map(secondPhaseDto.getEmotionalIntelligence().getBloodyRedEmotionalIntelligence(), BloodyRedEmotionalIntelligence.class));;

        secondPhase.setHealthSection(new HealthSection());
        secondPhase.getHealthSection()
                .greenHealthSection(
                        modelMapper.map(secondPhaseDto.getHealthSection().getGreenHealthSection(), GreenHealthSection.class))
                .yellowHealthSection(
                        modelMapper.map(secondPhaseDto.getHealthSection().getYellowHealthSection(), YellowHealthSection.class))
                .redHealthSection(
                        modelMapper.map(secondPhaseDto.getHealthSection().getRedHealthSection(), RedHealthSection.class));

        secondPhase.setIdentitySection(new IdentitySection());
        secondPhase.getIdentitySection()
                .greenIdentitySection(
                        modelMapper.map(secondPhaseDto.getIdentitySection().getGreenIdentitySection(), GreenIdentitySection.class))
                .yellowIdentitySection(
                        modelMapper.map(secondPhaseDto.getIdentitySection().getYellowIdentitySection(), YellowIdentitySection.class))
                .redIdentitySection(
                        modelMapper.map(secondPhaseDto.getIdentitySection().getRedIdentitySection(), RedIdentitySection.class));


        secondPhase.setSecuritySection(new SecuritySection());
        secondPhase.getSecuritySection()
                .greenSecuritySection(
                        modelMapper.map(secondPhaseDto.getSecuritySection().getGreenSecuritySection(), GreenSecuritySection.class))
                .yellowSecuritySection(
                        modelMapper.map(secondPhaseDto.getSecuritySection().getYellowSecuritySection(), YellowSecuritySection.class))
                .redSecuritySection(
                        modelMapper.map(secondPhaseDto.getSecuritySection().getRedSecuritySection(), RedSecuritySection.class));


        secondPhase.setSelfIndependence(new SelfIndependence());
        secondPhase.getSelfIndependence()
                .greenSelfIndependence(
                        modelMapper.map(secondPhaseDto.getSelfIndependence().getGreenSelfIndependence(), GreenSelfIndependence.class))
                .yellowSelfIndependence(
                        modelMapper.map(secondPhaseDto.getSelfIndependence().getYellowSelfIndependence(), YellowSelfIndependence.class));

        secondPhase.setFamilySection(new FamilySection());
        secondPhase.getFamilySection()
                .greenFamilySection(
                        modelMapper.map(secondPhaseDto.getFamilySection().getGreenFamilySection(), GreenFamilySection.class))
                .yellowFamilySection(
                        modelMapper.map(secondPhaseDto.getFamilySection().getYellowFamilySection(), YellowFamilySection.class))
                .redFamilySection(
                        modelMapper.map(secondPhaseDto.getFamilySection().getRedFamilySection(), RedFamilySection.class))
                .bloodyRedFamilySection(
                        modelMapper.map(secondPhaseDto.getFamilySection().getBloodyRedFamilySection(), BloodyRedFamilySection.class));

       return secondPhase;
    }




     public <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
        return source
                .stream()
                .map(element -> modelMapper.map(element, targetClass))
                .collect(Collectors.toList());
    }


    public SecondPhase toExistEntity(SecondPhaseDto secondPhaseDto, SecondPhase secondPhaseToUpdate) {

        if ( secondPhaseDto == null ) {
            return null;
        }

        return convertSecondPhaseDtoToEntity(secondPhaseDto, secondPhaseToUpdate);

    }

    public FourthPhase toEntityFourthPhase(FourthPhaseDto fourthPhaseDto, FourthPhase fourthPhase) {
        if ( fourthPhaseDto == null ) {
            return null;
        }

        return convertFourthPhaseDtoToEntity(fourthPhaseDto, fourthPhase);
    }

    private FourthPhase convertFourthPhaseDtoToEntity(FourthPhaseDto fourthPhaseDto, FourthPhase fourthPhase) {
        fourthPhase.setDate(fourthPhaseDto.getDate());
        fourthPhase.setPlanReviewDate(fourthPhaseDto.getPlanReviewDate());
        fourthPhase.setEducationalNeed(fourthPhaseDto.getEducationalNeed());

        ChildDevelopmentNeeds childDevelopmentNeeds = new ChildDevelopmentNeeds();
        fourthPhase.setChildDevelopmentNeeds(childDevelopmentNeeds);

        HealthForm4 healthForm4 = new HealthForm4();
        EducationForm4 educationForm4 = new EducationForm4();
        EmotionalDevelopmentForm4 emotionalDevelopmentForm4 = new EmotionalDevelopmentForm4();
        IdentityForm4 identityForm4 = new IdentityForm4();
        SocialPresentationForm4 socialPresentationForm4 = new SocialPresentationForm4();
        FamilyForm4 familyForm4 = new FamilyForm4();
        SelfIndependenceForm4 selfIndependenceForm4 = new SelfIndependenceForm4();

        fourthPhase.getChildDevelopmentNeeds().setHealthForm4(healthForm4);
        fourthPhase.getChildDevelopmentNeeds().setEducationForm4(educationForm4);
        fourthPhase.getChildDevelopmentNeeds().setEmotionalDevelopmentForm4(emotionalDevelopmentForm4);
        fourthPhase.getChildDevelopmentNeeds().setIdentityForm4(identityForm4);
        fourthPhase.getChildDevelopmentNeeds().setSocialPresentationForm4(socialPresentationForm4);
        fourthPhase.getChildDevelopmentNeeds().setFamilyForm4(familyForm4);
        fourthPhase.getChildDevelopmentNeeds().setSelfIndependenceForm4(selfIndependenceForm4);

        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getChildDevelopmentNeeds().getHealthForm4(), fourthPhaseDto.getChildDevelopmentNeeds().getHealthForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getChildDevelopmentNeeds().getEducationForm4(), fourthPhaseDto.getChildDevelopmentNeeds().getEducationForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getChildDevelopmentNeeds().getEmotionalDevelopmentForm4(), fourthPhaseDto.getChildDevelopmentNeeds().getEmotionalDevelopmentForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getChildDevelopmentNeeds().getIdentityForm4(), fourthPhaseDto.getChildDevelopmentNeeds().getIdentityForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getChildDevelopmentNeeds().getSocialPresentationForm4(), fourthPhaseDto.getChildDevelopmentNeeds().getSocialPresentationForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getChildDevelopmentNeeds().getFamilyForm4(), fourthPhaseDto.getChildDevelopmentNeeds().getFamilyForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getChildDevelopmentNeeds().getSelfIndependenceForm4(), fourthPhaseDto.getChildDevelopmentNeeds().getSelfIndependenceForm4());

        ParentSkills parentSkills = new ParentSkills();
        fourthPhase.setParentSkills(parentSkills);

        BasicCareForm4 basicCareForm4 = new BasicCareForm4();
        SecurityForm4 securityForm4 = new SecurityForm4();
        EmotionalHeatForm4 emotionalHeatForm4 = new EmotionalHeatForm4();
        StabilityForm4 stabilityForm4 = new StabilityForm4();
        DirectionBordersForm4 directionBordersForm4 = new DirectionBordersForm4();
        StimulationForm4 stimulationForm4 = new StimulationForm4();
        ParentProblemsForm4 parentProblemsForm4 = new ParentProblemsForm4();
        HousingWorkIncomeForm4 housingWorkIncomeForm4 = new HousingWorkIncomeForm4();
        FamilyHistoryForm4 familyHistoryForm4 = new FamilyHistoryForm4();
        ExtendedFamilyForm4 extendedFamilyForm4 = new ExtendedFamilyForm4();
        ResourcesForm4 resourcesForm4 = new ResourcesForm4();
        SocialIntegrationForm4 socialIntegrationForm4 = new SocialIntegrationForm4();

        fourthPhase.getParentSkills().setBasicCareForm4(basicCareForm4);
        fourthPhase.getParentSkills().setSecurityForm4(securityForm4);
        fourthPhase.getParentSkills().setEmotionalHeatForm4(emotionalHeatForm4);
        fourthPhase.getParentSkills().setStabilityForm4(stabilityForm4);
        fourthPhase.getParentSkills().setDirectionBordersForm4(directionBordersForm4);
        fourthPhase.getParentSkills().setStimulationForm4(stimulationForm4);
        fourthPhase.getParentSkills().setParentProblemsForm4(parentProblemsForm4);
        fourthPhase.getParentSkills().setHousingWorkIncomeForm4(housingWorkIncomeForm4);
        fourthPhase.getParentSkills().setFamilyHistoryForm4(familyHistoryForm4);
        fourthPhase.getParentSkills().setExtendedFamilyForm4(extendedFamilyForm4);
        fourthPhase.getParentSkills().setResourcesForm4(resourcesForm4);
        fourthPhase.getParentSkills().setSocialIntegrationForm4(socialIntegrationForm4);

        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getBasicCareForm4(), fourthPhaseDto.getParentSkills().getBasicCareForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getSecurityForm4(), fourthPhaseDto.getParentSkills().getSecurityForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getEmotionalHeatForm4(), fourthPhaseDto.getParentSkills().getEmotionalHeatForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getStabilityForm4(), fourthPhaseDto.getParentSkills().getStabilityForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getDirectionBordersForm4(), fourthPhaseDto.getParentSkills().getDirectionBordersForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getStimulationForm4(), fourthPhaseDto.getParentSkills().getStimulationForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getParentProblemsForm4(), fourthPhaseDto.getParentSkills().getParentProblemsForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getHousingWorkIncomeForm4(), fourthPhaseDto.getParentSkills().getHousingWorkIncomeForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getFamilyHistoryForm4(), fourthPhaseDto.getParentSkills().getFamilyHistoryForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getExtendedFamilyForm4(), fourthPhaseDto.getParentSkills().getExtendedFamilyForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getResourcesForm4(), fourthPhaseDto.getParentSkills().getResourcesForm4());
        setFieldsFourthPhaseChildDevelopmentPlan(fourthPhase.getParentSkills().getSocialIntegrationForm4(), fourthPhaseDto.getParentSkills().getSocialIntegrationForm4());


        System.out.println(fourthPhase.getChildDevelopmentNeeds());
        System.out.println(fourthPhase.getChildDevelopmentNeeds().getEducationForm4().criteria);
        fourthPhase.setOtherPersonLivingWithFamilyList(mapList(fourthPhaseDto.getOtherPersonLivingWithFamilyList(), OtherPersonLivingWithFamily.class));
        fourthPhase.setOutOfSchoolOrganizationEmployees(mapList(fourthPhaseDto.getOutOfSchoolOrganizationEmployees(), OutOfSchoolOrganizationEmployee.class));
        fourthPhase.setOpinionOfInvolvedParties(modelMapper.map(fourthPhaseDto.getOpinionOfInvolvedParties(), OpinionOfInvolvedParties.class));

        return fourthPhase;
    }

    public void setFieldsFourthPhaseChildDevelopmentPlan(ChildDevelopmentPlan cdp, ChildDevelopmentPlanDto cdpDto) {
        cdp.criteria = cdpDto.criteria;
        cdp.discoveredRiskFactors = cdpDto.discoveredRiskFactors;
        cdp.employee = cdpDto.employee;
        cdp.ratingScale = cdpDto.ratingScale;
        cdp.indicator = cdpDto.indicator;
        cdp.measures = cdpDto.measures;
        cdp.measurePeriod = cdpDto.measurePeriod;
    }
}
