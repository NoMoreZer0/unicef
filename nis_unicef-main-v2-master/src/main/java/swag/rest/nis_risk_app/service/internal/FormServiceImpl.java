package swag.rest.nis_risk_app.service.internal;


import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.docx4j.Docx4J;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import swag.rest.nis_risk_app.dao.*;
import swag.rest.nis_risk_app.dto.*;
import swag.rest.nis_risk_app.entity.*;
import swag.rest.nis_risk_app.exception.*;
import swag.rest.nis_risk_app.helper.FormGenerator;
import swag.rest.nis_risk_app.mapper.impl.EntityMapperImpl;
import swag.rest.nis_risk_app.service.FormService;
import swag.rest.nis_risk_app.util.Role;
import swag.rest.nis_risk_app.util.StudentStatus;

import javax.transaction.Transactional;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static swag.rest.nis_risk_app.constant.Constant.FIRST_PHASE_DOWNLOAD_LINK;
import static swag.rest.nis_risk_app.constant.Constant.FOURTH_PHASE_DOWNLOAD_LINK;
import static swag.rest.nis_risk_app.constant.Constant.SECOND_PHASE_DOWNLOAD_LINK;
import static swag.rest.nis_risk_app.entity.Users.getCurrentUserRole;

@Slf4j
@Service
@RequiredArgsConstructor
public class FormServiceImpl implements FormService {

    @Value("${template.form1}")
    private String form1;

    @Value("${template.form2}")
    private String form2;

    @Value("${template.form4}")
    private String form4;

    private final ModelMapper modelMapper;

    private final EntityMapperImpl entityMapper;

    private final FirstPhaseRepository firstPhaseRepository;

    private final SecondPhaseRepository secondPhaseRepository;

    private final FourthPhaseRepository fourthPhaseRepository;

    private final FormGenerator<FirstPhase> firstFormGenerator;

    private final FormGenerator<SecondPhase> secondFormGenerator;

    private final FormGenerator<FourthPhase> fourthFormGenerator;

    private final FamilyNeighborRepository familyNeighborRepository;

    private final FamilyRiskFactorRepository familyRiskFactorRepository;

    private final FatherRepository fatherRepository;

    private final IndividualRiskFactorRepository individualRiskFactorRepository;

    private final IndividualSafeFactorRepository individualSafeFactorRepository;

    private final FamilySafeFactorRepository familySafeFactorRepository;

    private final EnvironmentSafeFactorRepository environmentSafeFactorRepository;

    private final SchoolSafeFactorRepository schoolSafeFactorRepository;

    private final LegalRepresentativeRepository legalRepresentativeRepository;

    private final SourceRepository sourceRepository;

    private final SocMedRiskFactorRepository socMedRiskFactorRepository;

    private final MotherRepository motherRepository;

    private final OtherPersonRepository otherPersonRepository;

    private final AcademicRiskFactorRepository academicRiskFactorRepository;

    private final StudentInformationRepository studentInformationRepository;

    private final ActionsRepository actionsRepository;

    private final UserRepository userRepository;

    private final OtherPersonLivingWithFamilyRepository otherPersonLivingWithFamilyRepository;

    private final OutOfSchoolOrganizationEmployeeRepository outOfSchoolOrganizationEmployeeRepository;

    private final ChildDevelopmentNeedsRepository childDevelopmentNeedsRepository;

    private final ParentSkillsRepository parentSkillsRepository;

    private final OpinionOfInvolvedPartiesRepository opinionOfInvolvedPartiesRepository;

    private final ApplicationContext context;




    @Override
    @Transactional
    public FirstPhase createFirstForm(FirstPhaseDto firstPhaseDto, Student student, Long caseId) {

        FirstPhase newForm = entityMapper.toEntity(firstPhaseDto, getCurrentUserRole());

        FirstPhase entityToSave = persistFirstFormEntity(newForm);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByUsername(auth.getName())
            .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        entityToSave.setUser(user);
        Case studentCase = context.getBean(CaseRepository.class).findById(caseId)
            .orElseThrow(() -> new CaseNotFound(caseId));
        entityToSave.setStudentCase(studentCase);

        return firstPhaseRepository.save(calculateRiskStatus(entityToSave));
    }

    @Override
    public Boolean isFirstFormFullyFilled(Long formId) {
        FirstPhase firstPhase = firstPhaseRepository
                .findById(formId)
                .orElseThrow(() ->
                        new FirstFormNotFound(formId));
        return firstPhase.getAcademicRiskFactor() != null
                && firstPhase.getIndividualRiskFactor() != null
                && firstPhase.getSocMedRiskFactor() != null
                && firstPhase.getFamilyRiskFactor() != null
                && firstPhase.getIndividualSafeFactor() != null
                && firstPhase.getFamilySafeFactor() != null
                && firstPhase.getEnvironmentSafeFactor() != null
                && firstPhase.getSchoolSafeFactor() != null;
    }

    @Override
    public Boolean isSecondFormFullyFilled(Long formDd) {
        SecondPhase secondPhase = secondPhaseRepository
                .findById(formDd)
                .orElseThrow(() ->
                        new SecondFormNotFound(formDd));
        return secondPhase.familySection() != null
                && secondPhase.securitySection() != null
                && secondPhase.identitySection() != null
                && secondPhase.healthSection() != null
                && secondPhase.educationSection() != null
                && secondPhase.selfIndependence() != null
                && secondPhase.aboutFamily() != null
                && secondPhase.emotionalIntelligence() != null;
    }

    @Override
    @Transactional
    public FirstPhase updateFirstForm(FirstPhaseDto firstPhaseDto, Long formId) {

        FirstPhase firstPhaseToUpdate = firstPhaseRepository
                .findById(formId)
                .orElseThrow(() ->
                        new FirstFormNotFound(formId));

        FirstPhase entityToUpdate = persistUpdatedFirstFormEntity(firstPhaseToUpdate, firstPhaseDto);

        return firstPhaseRepository.save(calculateRiskStatus(entityToUpdate));
    }

    @Override
    public FirstPhase updatePartOfFirstForm(FirstPhaseDto firstPhaseDto, Long formId) {
        FirstPhase firstPhaseToUpdate = firstPhaseRepository
                .findById(formId)
                .orElseThrow(() ->
                        new FirstFormNotFound(formId));
        FirstPhase entityToUpdate = persistPartlyUpdatedFirstFormEntity(firstPhaseToUpdate);
        return firstPhaseRepository.save(calculateRiskStatus(entityToUpdate));
    }

    private FirstPhase persistPartlyUpdatedFirstFormEntity(FirstPhase firstPhaseToUpdate) {


        AcademicRiskFactor academicRiskFactor = null;

//        if (firstPhaseToUpdate.getPsychoRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_THERAPIST.name()))
            academicRiskFactor = academicRiskFactorRepository.save(
                    modelMapper.map(firstPhaseToUpdate.getAcademicRiskFactor(), AcademicRiskFactor.class));

        firstPhaseToUpdate.setAcademicRiskFactor(academicRiskFactor);

        SocMedRiskFactor socMedRiskFactor = null;

//        if (firstPhaseToUpdate.getSocMedRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_MED.name()))
            socMedRiskFactor = socMedRiskFactorRepository.save(
                    modelMapper.map(firstPhaseToUpdate.getSocMedRiskFactor(), SocMedRiskFactor.class));

        firstPhaseToUpdate.setSocMedRiskFactor(socMedRiskFactor);

        FamilyRiskFactor familyRiskFactor = null;

//        if (firstPhaseToUpdate.getCuratorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_CURATOR.name()))
            familyRiskFactor = familyRiskFactorRepository.save(
                    modelMapper.map(firstPhaseToUpdate.getFamilyRiskFactor(), FamilyRiskFactor.class));

        firstPhaseToUpdate.setFamilyRiskFactor(familyRiskFactor);

        IndividualRiskFactor individualRiskFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
            individualRiskFactor = individualRiskFactorRepository.save(
                    modelMapper.map(firstPhaseToUpdate.getIndividualRiskFactor(), IndividualRiskFactor.class));

        firstPhaseToUpdate.setIndividualRiskFactor(individualRiskFactor);

        IndividualSafeFactor individualSafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        individualSafeFactor = individualSafeFactorRepository.save(
                modelMapper.map(firstPhaseToUpdate.getIndividualSafeFactor(), IndividualSafeFactor.class));

        firstPhaseToUpdate.setIndividualSafeFactor(individualSafeFactor);

        FamilySafeFactor familySafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        familySafeFactor = familySafeFactorRepository.save(
                modelMapper.map(firstPhaseToUpdate.getFamilySafeFactor(), FamilySafeFactor.class));

        firstPhaseToUpdate.setFamilySafeFactor(familySafeFactor);

        EnvironmentSafeFactor environmentSafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        environmentSafeFactor = environmentSafeFactorRepository.save(
                modelMapper.map(firstPhaseToUpdate.getEnvironmentSafeFactor(), EnvironmentSafeFactor.class));

        firstPhaseToUpdate.setEnvironmentSafeFactor(environmentSafeFactor);

        SchoolSafeFactor schoolSafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        schoolSafeFactor = schoolSafeFactorRepository.save(
                modelMapper.map(firstPhaseToUpdate.getSchoolSafeFactor(), SchoolSafeFactor.class));

        firstPhaseToUpdate.setSchoolSafeFactor(schoolSafeFactor);

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
        firstPhaseToUpdate.setAdditionalComment(firstPhaseToUpdate.getAdditionalComment());

        return firstPhaseToUpdate;
    }

    public FirstPhase persistUpdatedFirstFormEntity(FirstPhase firstPhaseToUpdate, FirstPhaseDto firstPhaseDto) {


        StudentInformation studentInformationPersisted = studentInformationRepository.save(
                modelMapper.map(firstPhaseDto.getStudentInformationDto(), StudentInformation.class)
                        .id(firstPhaseToUpdate.getStudentInformation().id()));
        firstPhaseToUpdate.setStudentInformation(studentInformationPersisted);

        FamilyNeighbor familyNeighborTemp = modelMapper.map(firstPhaseDto.getFamilyNeighbor(), FamilyNeighbor.class);
        familyNeighborTemp.id(firstPhaseToUpdate.getFamilyNeighbor().id());
        FamilyNeighbor familyNeighbor = familyNeighborRepository.save(familyNeighborTemp);
        firstPhaseToUpdate.setFamilyNeighbor(familyNeighbor);

        LegalRepresentative legalRepresentativeTemp = firstPhaseToUpdate.getLegalRepresentative();
        Father fatherTemp = modelMapper.map(firstPhaseDto.getLegalRepresentative().getFather(), Father.class);
        fatherTemp.id(firstPhaseToUpdate.getLegalRepresentative().id());
        Father father = fatherRepository.save(fatherTemp);

        Mother motherTemp = modelMapper.map(firstPhaseToUpdate.getLegalRepresentative().mother(), Mother.class);
        motherTemp.id(firstPhaseToUpdate.getLegalRepresentative().mother().id());
        Mother mother = motherRepository.save(motherTemp);

        OtherPerson otherPersonTemp =
                modelMapper.map(firstPhaseDto.getLegalRepresentative().getOtherPerson(), OtherPerson.class);
        otherPersonTemp.id(firstPhaseToUpdate.getLegalRepresentative().otherPerson().id());
        OtherPerson otherPerson = otherPersonRepository.save(otherPersonTemp);

        legalRepresentativeTemp.father(father);
        legalRepresentativeTemp.mother(mother);
        legalRepresentativeTemp.otherPerson(otherPerson);

        LegalRepresentative legalRepresentative = legalRepresentativeRepository.save(legalRepresentativeTemp);

        firstPhaseToUpdate.setLegalRepresentative(legalRepresentative);

        AcademicRiskFactor academicRiskFactor = null;

//        if (firstPhaseToUpdate.getPsychoRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_THERAPIST.name()))
            academicRiskFactor = academicRiskFactorRepository.save(
                    modelMapper.map(firstPhaseToUpdate.getAcademicRiskFactor(), AcademicRiskFactor.class));

        firstPhaseToUpdate.setAcademicRiskFactor(academicRiskFactor);

        SocMedRiskFactor socMedRiskFactor = null;

//        if (firstPhaseToUpdate.getSocMedRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_MED.name()))
            socMedRiskFactor = socMedRiskFactorRepository.save(
                    modelMapper.map(firstPhaseToUpdate.getSocMedRiskFactor(), SocMedRiskFactor.class));

        firstPhaseToUpdate.setSocMedRiskFactor(socMedRiskFactor);

        FamilyRiskFactor familyRiskFactor = null;

//        if (firstPhaseToUpdate.getCuratorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_CURATOR.name()))
            familyRiskFactor = familyRiskFactorRepository.save(
                    modelMapper.map(firstPhaseToUpdate.getFamilyRiskFactor(), FamilyRiskFactor.class));

        firstPhaseToUpdate.setFamilyRiskFactor(familyRiskFactor);

        IndividualRiskFactor individualRiskFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
            individualRiskFactor = individualRiskFactorRepository.save(
                    modelMapper.map(firstPhaseToUpdate.getIndividualRiskFactor(), IndividualRiskFactor.class));

        firstPhaseToUpdate.setIndividualRiskFactor(individualRiskFactor);

        IndividualSafeFactor individualSafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        individualSafeFactor = individualSafeFactorRepository.save(
                modelMapper.map(firstPhaseToUpdate.getIndividualSafeFactor(), IndividualSafeFactor.class));

        firstPhaseToUpdate.setIndividualSafeFactor(individualSafeFactor);

        FamilySafeFactor familySafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        familySafeFactor = familySafeFactorRepository.save(
                modelMapper.map(firstPhaseToUpdate.getFamilySafeFactor(), FamilySafeFactor.class));

        firstPhaseToUpdate.setFamilySafeFactor(familySafeFactor);

        EnvironmentSafeFactor environmentSafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        environmentSafeFactor = environmentSafeFactorRepository.save(
                modelMapper.map(firstPhaseToUpdate.getEnvironmentSafeFactor(), EnvironmentSafeFactor.class));

        firstPhaseToUpdate.setEnvironmentSafeFactor(environmentSafeFactor);

        SchoolSafeFactor schoolSafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        schoolSafeFactor = schoolSafeFactorRepository.save(
                modelMapper.map(firstPhaseToUpdate.getSchoolSafeFactor(), SchoolSafeFactor.class));

        firstPhaseToUpdate.setSchoolSafeFactor(schoolSafeFactor);

        firstPhaseToUpdate.setActions(actionsRepository.save(
                modelMapper.map(firstPhaseDto.getActions(), Actions.class)
                        .id(firstPhaseToUpdate.getActions().id())));
        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        firstPhaseToUpdate.setAdditionalComment(firstPhaseToUpdate.getAdditionalComment());

        firstPhaseToUpdate.setSource(sourceRepository.save(
                modelMapper.map(firstPhaseToUpdate.getSource(), Source.class)));

        return firstPhaseToUpdate;
    }

    @Override
    @Transactional
    public List<FirstPhase> getAllFirstForms() {
        if(getCurrentUserRole().equals(Role.ROLE_CASE_MANAGER.name())){
            return firstPhaseRepository.findAll();
        } else {
            return firstPhaseRepository.findAll()
                .stream()
                .filter(s -> s.getUser().getRole().name().equals(getCurrentUserRole()))
                .collect(Collectors.toList());
        }
    }

    @Override
    public FirstPhase calculateRiskStatus(FirstPhase firstPhase) {
        if(firstPhase.getSocMedRiskFactor() != null
                && firstPhase.getIndividualRiskFactor() != null
                && firstPhase.getFamilyRiskFactor() != null
                && firstPhase.getAcademicRiskFactor() != null){
            if(firstPhase.isRiskStatusHigh()){
                firstPhase.setStudentStatusRisk(StudentStatus.RED);
                return firstPhase;
            } else if (firstPhase.isRiskStatusYellow()) {
                firstPhase.setStudentStatusRisk(StudentStatus.YELLOW);
            }else {
                firstPhase.setStudentStatusRisk(StudentStatus.GREEN);
            }
        }
        return firstPhase;
    }

    @Override
    public FirstPhase getFirstFormById(Long id) {
        return firstPhaseRepository
                .findById(id)
                .orElseThrow(() ->
                        new FirstFormNotFound(id));
    }


    @Override
    @Transactional
    public FirstPhase persistFirstFormEntity(FirstPhase newForm) {

        StudentInformation studentInformationToPersist = studentInformationRepository
                .save(modelMapper.map(newForm.getStudentInformation(), StudentInformation.class));

        StudentInformation studentInformationPersisted = studentInformationRepository.save(
                studentInformationToPersist);

        newForm.setStudentInformation(studentInformationPersisted);

        FamilyNeighbor familyNeighbor = familyNeighborRepository.save(newForm.getFamilyNeighbor());

        newForm.setFamilyNeighbor(familyNeighbor);

        LegalRepresentative legalRepresentativeTemp = new LegalRepresentative();

        Father father = fatherRepository.save(
                modelMapper.map(newForm.getLegalRepresentative().father(), Father.class));

        Mother mother = motherRepository.save(
                modelMapper.map(newForm.getLegalRepresentative().mother(), Mother.class));

        OtherPerson otherPerson = otherPersonRepository.save(
                modelMapper.map(newForm.getLegalRepresentative().otherPerson(), OtherPerson.class));

        legalRepresentativeTemp.father(father);
        legalRepresentativeTemp.mother(mother);
        legalRepresentativeTemp.otherPerson(otherPerson);

        LegalRepresentative legalRepresentative = legalRepresentativeRepository.save(legalRepresentativeTemp);

        newForm.setLegalRepresentative(legalRepresentative);


        AcademicRiskFactor academicRiskFactor = null;

//        if (newForm.getPsychoRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_THERAPIST.name()))
            academicRiskFactor = academicRiskFactorRepository.save(
                    modelMapper.map(newForm.getAcademicRiskFactor(), AcademicRiskFactor.class));

        newForm.setAcademicRiskFactor(academicRiskFactor);

        SocMedRiskFactor socMedRiskFactor = null;

//        if (newForm.getSocMedRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_MED.name()))
            socMedRiskFactor = socMedRiskFactorRepository.save(
                    modelMapper.map(newForm.getSocMedRiskFactor(), SocMedRiskFactor.class));

        newForm.setSocMedRiskFactor(socMedRiskFactor);

        FamilyRiskFactor familyRiskFactor = null;

//        if (newForm.getCuratorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_CURATOR.name()))
            familyRiskFactor = familyRiskFactorRepository.save(
                    modelMapper.map(newForm.getFamilyRiskFactor(), FamilyRiskFactor.class));

        newForm.setFamilyRiskFactor(familyRiskFactor);

        IndividualRiskFactor individualRiskFactor = null;

//        if (newForm.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
            individualRiskFactor = individualRiskFactorRepository.save(
                    modelMapper.map(newForm.getIndividualRiskFactor(), IndividualRiskFactor.class));

        newForm.setIndividualRiskFactor(individualRiskFactor);

        IndividualSafeFactor individualSafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        individualSafeFactor = individualSafeFactorRepository.save(
                modelMapper.map(newForm.getIndividualSafeFactor(), IndividualSafeFactor.class));

        newForm.setIndividualSafeFactor(individualSafeFactor);

        FamilySafeFactor familySafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        familySafeFactor = familySafeFactorRepository.save(
                modelMapper.map(newForm.getFamilySafeFactor(), FamilySafeFactor.class));

        newForm.setFamilySafeFactor(familySafeFactor);

        EnvironmentSafeFactor environmentSafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        environmentSafeFactor = environmentSafeFactorRepository.save(
                modelMapper.map(newForm.getEnvironmentSafeFactor(), EnvironmentSafeFactor.class));

        newForm.setEnvironmentSafeFactor(environmentSafeFactor);

        SchoolSafeFactor schoolSafeFactor = null;

//        if (firstPhaseToUpdate.getInspectorRiskFactor() != null && getCurrentUserRole().equals(Role.ROLE_POLICE.name()))
        schoolSafeFactor = schoolSafeFactorRepository.save(
                modelMapper.map(newForm.getSchoolSafeFactor(), SchoolSafeFactor.class));

        newForm.setSchoolSafeFactor(schoolSafeFactor);

        newForm.setActions(actionsRepository.save(newForm.getActions()));

        String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();

        userRepository
                .findByUsername(currentUser)
                .orElseThrow(() ->
                        new UserNotFound(currentUser));

        newForm.setAdditionalComment(newForm.getAdditionalComment());
        newForm.setSource(sourceRepository.save(
                modelMapper.map(newForm.getSource(), Source.class)));

        return newForm;
    }


    @Override
    public SecondPhase createSecondForm(SecondPhaseDto secondPhaseDto, Long caseId, Student student)
            throws IllegalAccessException {

        SecondPhase newForm = entityMapper.toEntity(secondPhaseDto);

        Case studentCase = context.getBean(CaseRepository.class)
            .findById(caseId)
            .orElseThrow(() ->
                new CaseNotFound(caseId));

        SecondPhase entityToSave = persistSecondFormEntity(newForm, secondPhaseDto, studentCase);

//        if (studentCase.getFirstForm() == null) throw new FirstFormNotCreated();

        entityToSave.setStudentCase(studentCase);

        SecondPhase secondPhase = context.getBean(SecondPhaseRepository.class).save(
                entityToSave
                        .warningStatus());

        if (studentCase.getSecondPhases() != null)
            studentCase.getSecondPhases().add(secondPhase);
        else
            studentCase.setSecondPhases(Set.of(secondPhase));

        context.getBean(CaseRepository.class).save(studentCase);

        context.getBean(FourthPhaseRepository.class)
                .findByStudentCaseId(studentCase.getId())
                .ifPresent(fourthPhase -> {
                    fourthPhase.setStudentCase(studentCase);
                    context.getBean(FourthPhaseRepository.class).save(fourthPhase);
                });

        return secondPhase;

    }


    @Override
    @Transactional
    public SecondPhase updateSecondForm(SecondPhaseDto secondPhaseDto, Long formId) {

        SecondPhase secondPhaseToUpdate = context.getBean(SecondPhaseRepository.class)
                .findById(formId)
                .orElseThrow(() ->
                        new SecondFormNotFound(formId));

        SecondPhase secondPhaseUpdated = entityMapper.toExistEntity(secondPhaseDto, secondPhaseToUpdate);

        SecondPhase entityToUpdate = persistUpdatedSecondFormEntity(secondPhaseUpdated, secondPhaseToUpdate);

        return context.getBean(SecondPhaseRepository.class).save(entityToUpdate);


    }

    @Override
    @Transactional
    public List<SecondPhase> getAllSecondForms() {
        return context.getBean(SecondPhaseRepository.class).findAll();
    }

    @Override
    @Transactional
    public SecondPhase persistSecondFormEntity(SecondPhase newForm, SecondPhaseDto secondPhase,
                                               Case studentCase) {

        context.getBean(GreenAboutFamilyRepository.class)
                .save(newForm.getAboutFamily().greenAboutFamily());

        context.getBean(YellowAboutFamilyRepository.class)
                .save(newForm.getAboutFamily().yellowAboutFamily());

        AboutFamily securitySection = context.getBean(AboutFamilyRepository.class)
                .save(newForm.getAboutFamily());


        context.getBean(GreenFamilySectionRepository.class)
            .save(newForm.getFamilySection().getGreenFamilySection());

        context.getBean(YellowFamilySectionRepository.class)
            .save(newForm.getFamilySection().getYellowFamilySection());

        context.getBean(RedFamilySectionRepository.class)
            .save(newForm.getFamilySection().getRedFamilySection());

        FamilySection familySection = context.getBean(FamilySectionRepository.class)
            .save(newForm.getFamilySection());


        context.getBean(GreenEducationSectionRepository.class)
                .save(newForm.getEducationSection().greenEducationSection());

        context.getBean(YellowEducationSectionRepository.class)
                .save(newForm.getEducationSection().yellowEducationSection());

        context.getBean(RedEducationSectionRepository.class)
                .save(newForm.getEducationSection().redEducationSection());

        EducationSection educationSection = context.getBean(EducationSectionRepository.class)
                .save(newForm.getEducationSection());


        context.getBean(YellowEmotionalIntelligenceRepository.class)
                .save(newForm.getEmotionalIntelligence().yellowEmotionalIntelligence());

        context.getBean(RedEmotionalIntelligenceRepository.class)
                .save(newForm.getEmotionalIntelligence().redEmotionalIntelligence());

        context.getBean(BloodyRedEmotionalIntelligenceRepository.class)
                .save(newForm.getEmotionalIntelligence().bloodyRedEmotionalIntelligence());

        EmotionalIntelligence emotionalIntelligence = context
                .getBean(EmotionalIntelligenceRepository.class)
                .save(newForm.getEmotionalIntelligence());


        context.getBean(GreenHealthSectionRepository.class)
                .save(newForm.getHealthSection().greenHealthSection());

        context.getBean(YellowHealthSectionRepository.class)
                .save(newForm.getHealthSection().yellowHealthSection());

        context.getBean(RedHealthSectionRepository.class)
                .save(newForm.getHealthSection().redHealthSection());


        HealthSection healthSection = context.getBean(HealthSectionRepository.class)
                .save(newForm.getHealthSection());


        context.getBean(GreenIdentitySectionRepository.class)
                .save(newForm.getIdentitySection().greenIdentitySection());

        context.getBean(YellowIdentitySectionRepository.class)
                .save(newForm.getIdentitySection().yellowIdentitySection());

        context.getBean(RedIdentitySectionRepository.class)
                .save(newForm.getIdentitySection().redIdentitySection());

        IdentitySection identitySection = context.getBean(IdentitySectionRepository.class)
                .save(newForm.getIdentitySection());



        context.getBean(GreenSecuritySectionRepository.class)
                .save(newForm.getSecuritySection().greenSecuritySection());

        context.getBean(YellowSecuritySectionRepository.class)
                .save(newForm.getSecuritySection().yellowSecuritySection());

        context.getBean(RedSecuritySectionRepository.class)
                .save(newForm.getSecuritySection().redSecuritySection());

        context.getBean(SecuritySectionRepository.class)
                .save(newForm.getSecuritySection());


        context.getBean(GreenSelfIndependenceRepository.class)
                .save(newForm.getSelfIndependence().greenSelfIndependence());

        context.getBean(YellowSelfIndependenceRepository.class)
                .save(newForm.getSelfIndependence().yellowSelfIndependence());

        context.getBean(SelfIndependenceRepository.class)
                .save(newForm.getSelfIndependence());

        FourthPhase fourthPhase = new FourthPhase();
        fourthPhase.setPartOfSecondForm(new PartOfSecondForm());
        PartOfSecondForm partOfSecondForm = fourthPhase.getPartOfSecondForm();

        int globalCounterOfAdditionalFieldsInFourthPhase = 0;

        int countOfFieldsForHealthSectionInFourthPhase = 0;

        HealthSectionFromSecondPhase healthSectionFromSecondPhase =
            new HealthSectionFromSecondPhase();

        if (healthSection.getYellowHealthSection().getHaveHealthIssues()) {
            healthSectionFromSecondPhase.setHealthIssues(healthSection.yellowHealthSection()
                .getHealthIssues());
            countOfFieldsForHealthSectionInFourthPhase++;
        }

        if (healthSection.getYellowHealthSection().getNoPedSocMed()) {
            healthSectionFromSecondPhase.setNoPedSocMed(healthSection.yellowHealthSection()
                .getNoPedSocMed());
            countOfFieldsForHealthSectionInFourthPhase++;
        }

        if (healthSection.getRedHealthSection().getNotEatWell()) {
            healthSectionFromSecondPhase.setNotEatWell(healthSection.getRedHealthSection()
                .getNotEatWell());
            countOfFieldsForHealthSectionInFourthPhase++;
        }

        if (healthSection.getRedHealthSection().getNoGlasses()) {
            healthSectionFromSecondPhase.setNoGlasses(healthSection.getRedHealthSection()
                .getNoGlasses());
            countOfFieldsForHealthSectionInFourthPhase++;
        }

        if (healthSection.getRedHealthSection().getBadHabits()) {
            healthSectionFromSecondPhase.setBadHabits(healthSection.getRedHealthSection()
                .getBadHabits());
            countOfFieldsForHealthSectionInFourthPhase++;
        }

        if (healthSection.getRedHealthSection().getIncontinence()) {
            healthSectionFromSecondPhase.setIncontinence(healthSection.getRedHealthSection()
                .getIncontinence());
            countOfFieldsForHealthSectionInFourthPhase++;
        }

        if (healthSection.getRedHealthSection().getSpeechIssues()) {
            healthSectionFromSecondPhase.setSpeechIssues(healthSection.getRedHealthSection()
                .getSpeechIssues());
            countOfFieldsForHealthSectionInFourthPhase++;
        }

        if (countOfFieldsForHealthSectionInFourthPhase > 0) {
            HealthSectionFromSecondPhase persistedHealth = context.getBean(HealthSectionFromSecondPhaseRepository.class)
                .save(healthSectionFromSecondPhase);
            partOfSecondForm.setHealthSectionFromSecondPhase(persistedHealth);

            globalCounterOfAdditionalFieldsInFourthPhase++;
        }

        EducationSectionFromSecondPhase educationSectionFromSecondPhase =
            new EducationSectionFromSecondPhase();

        int countOfFieldsForEducationSectionInFourthPhase = 0;

        if (educationSection.getRedEducationSection().getNoLikeAttend()) {
            educationSectionFromSecondPhase.setNoLikeAttend(educationSection.redEducationSection()
                .getNoLikeAttend());
            countOfFieldsForEducationSectionInFourthPhase++;
        }

        if (educationSection.getRedEducationSection().getSpecialNeed()) {
            educationSectionFromSecondPhase.setSpecialNeed(educationSection.redEducationSection()
                .getSpecialNeed());
            countOfFieldsForEducationSectionInFourthPhase++;
        }

        if (educationSection.getRedEducationSection().getStudyingTrouble()) {
            educationSectionFromSecondPhase.setStudyingTrouble(educationSection.redEducationSection()
                .getStudyingTrouble());
            countOfFieldsForEducationSectionInFourthPhase++;
        }

        if (educationSection.getRedEducationSection().getOftenMiss()) {
            educationSectionFromSecondPhase.setOftenMiss(educationSection.redEducationSection()
                .getOftenMiss());
            countOfFieldsForEducationSectionInFourthPhase++;
        }

        if (educationSection.getYellowEducationSection().getNoConcentration()) {
            educationSectionFromSecondPhase
                .setNoConcentration(educationSection.getYellowEducationSection()
                                                    .getNoConcentration());
            countOfFieldsForEducationSectionInFourthPhase++;
        }

        if (countOfFieldsForEducationSectionInFourthPhase > 0) {
            EducationSectionFromSecondPhase persistedEducation =
                context.getBean(EducationSectionFromSecondPhaseRepository.class)
                .save(educationSectionFromSecondPhase);
            partOfSecondForm.setEducationSectionFromSecondPhase(persistedEducation);
            globalCounterOfAdditionalFieldsInFourthPhase++;
        }

        EmotionalIntelligenceFromSecondPhase emotionalIntelligenceFromSecondPhase =
            new EmotionalIntelligenceFromSecondPhase();

        int countOfFieldsForEmotionalIntelligenceInFourthPhase = 0;

        if (emotionalIntelligence.getBloodyRedEmotionalIntelligence().getAnxiety()) {
            emotionalIntelligenceFromSecondPhase
                .setAnxiety(emotionalIntelligence.getBloodyRedEmotionalIntelligence()
                    .getAnxiety());
            countOfFieldsForEmotionalIntelligenceInFourthPhase++;
        }

        if (emotionalIntelligence.getBloodyRedEmotionalIntelligence().getDepression()) {
            emotionalIntelligenceFromSecondPhase
                .setDepression(emotionalIntelligence.getBloodyRedEmotionalIntelligence()
                    .getDepression());
            countOfFieldsForEmotionalIntelligenceInFourthPhase++;
        }

        if (emotionalIntelligence.getBloodyRedEmotionalIntelligence().getBullied()) {
            emotionalIntelligenceFromSecondPhase
                .setBullied(emotionalIntelligence.getBloodyRedEmotionalIntelligence()
                    .getBullied());
            countOfFieldsForEmotionalIntelligenceInFourthPhase++;
        }

        if (emotionalIntelligence.getYellowEmotionalIntelligence().getNoSchoolFriends()) {
            emotionalIntelligenceFromSecondPhase
                .setNoSchoolFriends(emotionalIntelligence.getYellowEmotionalIntelligence()
                    .getNoSchoolFriends());
            countOfFieldsForEmotionalIntelligenceInFourthPhase++;
        }

        if (emotionalIntelligence.getYellowEmotionalIntelligence().getEmotionalAlone()) {
            emotionalIntelligenceFromSecondPhase
                .setEmotionalAlone(emotionalIntelligence.getYellowEmotionalIntelligence()
                    .getEmotionalAlone());
            countOfFieldsForEmotionalIntelligenceInFourthPhase++;
        }

        if (emotionalIntelligence.getYellowEmotionalIntelligence().getRiskyBehaviour()) {
            emotionalIntelligenceFromSecondPhase
                .setRiskyBehaviour(emotionalIntelligence.getYellowEmotionalIntelligence()
                    .getRiskyBehaviour());
            countOfFieldsForEmotionalIntelligenceInFourthPhase++;
        }

        if (emotionalIntelligence.getYellowEmotionalIntelligence().getWitnessConflict()) {
            emotionalIntelligenceFromSecondPhase
                .setWitnessConflict(emotionalIntelligence.getYellowEmotionalIntelligence()
                    .getWitnessConflict());
            countOfFieldsForEmotionalIntelligenceInFourthPhase++;
        }

        if (emotionalIntelligence.getYellowEmotionalIntelligence().getUchet()) {
            emotionalIntelligenceFromSecondPhase
                .setUchet(emotionalIntelligence.getYellowEmotionalIntelligence()
                    .getUchet());
            countOfFieldsForEmotionalIntelligenceInFourthPhase++;
        }

        if (countOfFieldsForEmotionalIntelligenceInFourthPhase > 0) {
            EmotionalIntelligenceFromSecondPhase persistedEmotional =
                context.getBean(EmotionalIntelligenceFromSecondPhaseRepository.class)
                .save(emotionalIntelligenceFromSecondPhase);
            partOfSecondForm
                .setEmotionalIntelligenceFromSecondPhase(persistedEmotional);
            globalCounterOfAdditionalFieldsInFourthPhase++;
        }

        IdentitySectionFromSecondPhase identitySectionFromSecondPhase =
            new IdentitySectionFromSecondPhase();

        int countOfFieldsForIdentitySectionInFourthPhase = 0;


        if (identitySection.redIdentitySection().getDiscrimination()) {
            identitySectionFromSecondPhase
                .setDiscrimination(true);
            countOfFieldsForIdentitySectionInFourthPhase++;
        }

        if (identitySection.redIdentitySection().getGenderAcceptanceProblem()) {
            identitySectionFromSecondPhase
                .setGenderAcceptanceProblem(true);
            countOfFieldsForIdentitySectionInFourthPhase++;
        }

        if (identitySection.yellowIdentitySection().getNoDecisionMaker()) {
            identitySectionFromSecondPhase
                .setNoDecisionMaker(true);
            countOfFieldsForIdentitySectionInFourthPhase++;
        }


        if (countOfFieldsForIdentitySectionInFourthPhase > 0) {
            IdentitySectionFromSecondPhase persistedIdentity =
                context.getBean(IdentitySectionFromSecondPhaseRepository.class)
                .save(identitySectionFromSecondPhase);
            partOfSecondForm
                .setIdentitySectionFromSecondPhase(persistedIdentity);
            globalCounterOfAdditionalFieldsInFourthPhase++;
        }

        FamilySectionFromSecondPhase familySectionFromSecondPhase =
            new FamilySectionFromSecondPhase();

        int countOfFieldsForFamilySectionInFourthPhase = 0;


        if (familySection.getYellowFamilySection().getNoPositiveWithParent()) {
            familySectionFromSecondPhase
                .setNoPositiveWithParent(true);
            countOfFieldsForFamilySectionInFourthPhase++;
        }

        if (familySection.getYellowFamilySection().getNoLikeFamilyMember()) {
            familySectionFromSecondPhase
                .setNoLikeFamilyMember(true);
            countOfFieldsForFamilySectionInFourthPhase++;
        }

        if (familySection.getYellowFamilySection().getNoFriend()) {
            familySectionFromSecondPhase
                .setNoFriend(true);
            countOfFieldsForFamilySectionInFourthPhase++;
        }

        if (Boolean.TRUE.equals(familySection.getRedFamilySection().getConstantlySeeingConflicts())) {
            familySectionFromSecondPhase
                .setConstantlySeeingConflicts(true);
            countOfFieldsForFamilySectionInFourthPhase++;
        }

        if (Boolean.TRUE.equals(familySection.getBloodyRedFamilySection().getNotSecuredFromSexualAffection())) {
            familySectionFromSecondPhase
                .setNotSecuredFromSexualAffection(true);
            countOfFieldsForFamilySectionInFourthPhase++;
        }

        if (familySection.getYellowFamilySection().getChronic()) {
            familySectionFromSecondPhase
                .setChronic(true);
            countOfFieldsForFamilySectionInFourthPhase++;
        }

        if (familySection.getYellowFamilySection().getTraumaPast()) {
            familySectionFromSecondPhase
                .setTraumaPast(true);
            countOfFieldsForFamilySectionInFourthPhase++;
        }


        if (countOfFieldsForFamilySectionInFourthPhase > 0) {
            FamilySectionFromSecondPhase persistedFamily =
                context.getBean(FamilySectionFromSecondPhaseRepository.class)
                .save(familySectionFromSecondPhase);
            partOfSecondForm
                .setFamilySectionFromSecondPhase(persistedFamily);

            globalCounterOfAdditionalFieldsInFourthPhase++;
        }

        SecuritySectionFromSecondPhase securitySectionFromSecondPhase =
            new SecuritySectionFromSecondPhase();

        int countOfFieldsForSecuritySectionInFourthPhase = 0;


        if (securitySection.getYellowAboutFamily().getCurrentHomeBad()) {
            securitySectionFromSecondPhase
                .setCurrentHomeBad(true);
            countOfFieldsForSecuritySectionInFourthPhase++;
        }

        if (securitySection.getYellowAboutFamily().getParentUnemployed()) {
            securitySectionFromSecondPhase
                .setParentUnemployed(true);
            countOfFieldsForSecuritySectionInFourthPhase++;
        }

        if (securitySection.getYellowAboutFamily().getFamilyNoTakeNeededAllowance()) {
            securitySectionFromSecondPhase
                .setFamilyNoTakeNeededAllowance(true);
            countOfFieldsForSecuritySectionInFourthPhase++;
        }

        if (securitySection.getYellowAboutFamily().getHaveMaterialIssue()) {
            securitySectionFromSecondPhase
                .setHaveMaterialIssue(true);
            countOfFieldsForSecuritySectionInFourthPhase++;
        }

        if (countOfFieldsForSecuritySectionInFourthPhase > 0) {
            SecuritySectionFromSecondPhase persistedSecurity =
                context.getBean(SecuritySectionFromSecondPhaseRepository.class)
                .save(securitySectionFromSecondPhase);
            partOfSecondForm
                .setSecuritySectionFromSecondPhase(persistedSecurity);
            globalCounterOfAdditionalFieldsInFourthPhase++;
        }


        if (globalCounterOfAdditionalFieldsInFourthPhase > 0) {
            PartOfSecondForm partOfSecondFormPersisted =
                context.getBean(PartOfSecondFormRepository.class)
                .save(partOfSecondForm);
            fourthPhase.setPartOfSecondForm(partOfSecondFormPersisted);
            fourthPhase.setStudentCase(studentCase);
            FourthPhase persistedFourthPhase = context.getBean(FourthPhaseRepository.class)
                .save(fourthPhase);
            newForm.setFourthPhase(persistedFourthPhase);
        }

        return newForm;

    }


    @Override
    @Transactional
    public SecondPhase persistUpdatedSecondFormEntity(SecondPhase newForm, SecondPhase secondPhase) {
        context.getBean(GreenAboutFamilyRepository.class)
                .save(newForm.getAboutFamily().greenAboutFamily());

        context.getBean(YellowAboutFamilyRepository.class)
                .save(newForm.getAboutFamily().yellowAboutFamily());

        context.getBean(AboutFamilyRepository.class)
                .save(newForm.getAboutFamily());


        context.getBean(GreenEducationSectionRepository.class)
                .save(newForm.getEducationSection().greenEducationSection());

        context.getBean(YellowEducationSectionRepository.class)
                .save(newForm.getEducationSection().yellowEducationSection());

        context.getBean(RedEducationSectionRepository.class)
                .save(newForm.getEducationSection().redEducationSection());

        context.getBean(EducationSectionRepository.class)
                .save(newForm.getEducationSection());

        context.getBean(YellowEmotionalIntelligenceRepository.class)
                .save(newForm.getEmotionalIntelligence().yellowEmotionalIntelligence());

        context.getBean(RedEmotionalIntelligenceRepository.class)
                .save(newForm.getEmotionalIntelligence().redEmotionalIntelligence());

        context.getBean(BloodyRedEmotionalIntelligenceRepository.class)
                .save(newForm.getEmotionalIntelligence().bloodyRedEmotionalIntelligence());

        context.getBean(EmotionalIntelligenceRepository.class)
                .save(newForm.getEmotionalIntelligence());


        context.getBean(GreenHealthSectionRepository.class)
                .save(newForm.getHealthSection().greenHealthSection());

        context.getBean(YellowHealthSectionRepository.class)
                .save(newForm.getHealthSection().yellowHealthSection());

        context.getBean(RedHealthSectionRepository.class)
                .save(newForm.getHealthSection().redHealthSection());


        context.getBean(HealthSectionRepository.class)
                .save(newForm.getHealthSection());


        context.getBean(GreenIdentitySectionRepository.class)
                .save(newForm.getIdentitySection().greenIdentitySection());

        context.getBean(YellowIdentitySectionRepository.class)
                .save(newForm.getIdentitySection().yellowIdentitySection());

        context.getBean(RedIdentitySectionRepository.class)
                .save(newForm.getIdentitySection().redIdentitySection());

        context.getBean(IdentitySectionRepository.class)
                .save(newForm.getIdentitySection());




        context.getBean(GreenSecuritySectionRepository.class)
                .save(newForm.getSecuritySection().greenSecuritySection());

        context.getBean(YellowSecuritySectionRepository.class)
                .save(newForm.getSecuritySection().yellowSecuritySection());

        context.getBean(RedSecuritySectionRepository.class)
                .save(newForm.getSecuritySection().redSecuritySection());

        context.getBean(SecuritySectionRepository.class)
                .save(newForm.getSecuritySection());



        context.getBean(GreenSelfIndependenceRepository.class)
                .save(newForm.getSelfIndependence().greenSelfIndependence());

        context.getBean(YellowSelfIndependenceRepository.class)
                .save(newForm.getSelfIndependence().yellowSelfIndependence());

        context.getBean(SelfIndependenceRepository.class)
                .save(newForm.getSelfIndependence());

        return newForm;
    }

    @Override
    public byte[] generateFirstForm(Long formId) throws Docx4JException, IOException {

        FirstPhase firstPhase = firstPhaseRepository
                .findById(formId)
                .orElseThrow(() -> new FirstFormNotFound(formId));

        byte[] result;

        try (ByteArrayOutputStream outputStreamDoc = new ByteArrayOutputStream()) {

            //Doc data replacement
            WordprocessingMLPackage wordMLPackage;
            wordMLPackage = Docx4J.load(getFileFromResourceAsStream(form1));
            firstFormGenerator.generatePdf(wordMLPackage, firstPhase);

            Docx4J.save(wordMLPackage, outputStreamDoc);
            result = outputStreamDoc.toByteArray();
        }

        firstPhase.setDocument(result);
        firstPhaseRepository.save(firstPhase);

        return result;
    }

    @Override
    @Transactional
    public byte[] generateSecondForm(Long formId) throws Docx4JException, IOException {
        SecondPhase secondPhase = secondPhaseRepository
                .findById(formId)
                .orElseThrow(() -> new SecondFormNotFound(formId));

        byte[] result;
        try(ByteArrayOutputStream outputStreamDoc = new ByteArrayOutputStream()) {
            WordprocessingMLPackage wordMLPackage;
            wordMLPackage = Docx4J.load(getFileFromResourceAsStream(form2));
            secondFormGenerator.generatePdf(wordMLPackage, secondPhase);
            Docx4J.save(wordMLPackage, outputStreamDoc);
            result = outputStreamDoc.toByteArray();
        }
        secondPhase.document(result);
        secondPhaseRepository.save(secondPhase);
        return result;
    }

    @Override
    public FourthPhase createFourthForm(FourthPhaseDto fourthPhaseDto, Long caseId, Student student) {
        Case studentCase = context.getBean(CaseRepository.class)
            .findById(caseId)
            .orElseThrow(() -> new CaseNotFound(caseId));
        FourthPhase fourthPhase = context.getBean(FourthPhaseRepository.class)
             .findByStudentCaseId(studentCase.getId())
             .orElse(new FourthPhase());
        FourthPhase newForm = entityMapper.toEntityFourthPhase(fourthPhaseDto, fourthPhase);
        log.info("Fourth form: {}", fourthPhase);

        FourthPhase entityToSave = persistFourthFormEntity(newForm, caseId);

        entityToSave.setStudentCase(studentCase);

        FourthPhase fourthPhasePersisted = fourthPhaseRepository.save(entityToSave);

        if (studentCase.getFourthPhases() != null)
            studentCase.getFourthPhases().add(fourthPhase);
        else
            studentCase.setFourthPhases(Set.of(fourthPhase));

        context.getBean(CaseRepository.class).save(studentCase);

        return fourthPhasePersisted;

    }

    @Override
    public List<FourthPhase> getAllFourthForms() {
        return fourthPhaseRepository.findAll();
    }

    @Override
    public List<FormDto> getAllForms() {
        List<FirstPhase> firstPhase = firstPhaseRepository.findAll();
        List<SecondPhase> secondPhases = secondPhaseRepository.findAll();
        List<FourthPhase> fourthPhases = fourthPhaseRepository.findAll();
        List<FormDto> formDto = firstPhase.stream().map(form ->
                FormDto.builder().id(form.getId())
                    .formType(FormType.FIRST)
                    .downloadLink(FIRST_PHASE_DOWNLOAD_LINK + form.getId())
                    .grade(form.getStudentInformation().getGrade())
                    .studentName(form.getStudentInformation().getNameOfStudent())
                    .build())
            .collect(Collectors.toList());
        secondPhases.stream().map(form ->
            FormDto.builder().id(form.getId())
                .formType(FormType.SECOND)
                .downloadLink(SECOND_PHASE_DOWNLOAD_LINK + form.getId())
                .grade(form.studentCase().getStudent().grade())
                .studentName(form.studentCase().getStudent().nameOfStudent())
                .build()).forEach(formDto::add);
        fourthPhases.stream().map(form ->
            FormDto.builder().id(form.getId())
                .formType(FormType.FOURTH)
                .downloadLink(FOURTH_PHASE_DOWNLOAD_LINK + form.getId())
                .grade(form.getStudentCase().getStudent().grade())
                .studentName(form.getStudentCase().getStudent().nameOfStudent())
                .build()).forEach(formDto::add);
        return formDto;
    }

    @Override
    public FourthPhase updateFourthForm(FourthPhaseDto fourthPhaseDto, Long formId) {
        return null;
    }

    @Override
    @Transactional
    public byte[] generateFourthForm(Long formId) throws Docx4JException, IOException {
        FourthPhase fourthPhase = fourthPhaseRepository
                .findById(formId)
                .orElseThrow(() -> new FourthFormNotFound(formId));

        byte[] result;
        try(ByteArrayOutputStream outputStreamDoc = new ByteArrayOutputStream()) {
            WordprocessingMLPackage wordMLPackage;
            wordMLPackage = Docx4J.load(getFileFromResourceAsStream(form4));
            fourthFormGenerator.generatePdf(wordMLPackage, fourthPhase);
            Docx4J.save(wordMLPackage, outputStreamDoc);
            result = outputStreamDoc.toByteArray();
        }
        fourthPhase.setDocument(result);
        fourthPhaseRepository.save(fourthPhase);
        return result;
    }

    @Override
    public FourthPhase persistFourthFormEntity(FourthPhase newForm, Long caseId) {
        List<OtherPersonLivingWithFamily> otherPersonLivingWithFamilyList = newForm.getOtherPersonLivingWithFamilyList();
        for (OtherPersonLivingWithFamily otherPersonLivingWithFamily: otherPersonLivingWithFamilyList) {
            otherPersonLivingWithFamily.setFourthPhase(newForm);
        }
        newForm.setOtherPersonLivingWithFamilyList(otherPersonLivingWithFamilyRepository.saveAll(otherPersonLivingWithFamilyList));

        List<OutOfSchoolOrganizationEmployee> outOfSchoolOrganizationEmployees = newForm.getOutOfSchoolOrganizationEmployees();
        for (OutOfSchoolOrganizationEmployee outOfSchoolOrganizationEmployee: outOfSchoolOrganizationEmployees) {
            outOfSchoolOrganizationEmployee.setFourthPhase(newForm);
        }
        newForm.setOutOfSchoolOrganizationEmployees(outOfSchoolOrganizationEmployeeRepository.saveAll(outOfSchoolOrganizationEmployees));

        ChildDevelopmentNeeds childDevelopmentNeeds = childDevelopmentNeedsRepository.save(newForm.getChildDevelopmentNeeds());
        newForm.setChildDevelopmentNeeds(childDevelopmentNeeds);
        ParentSkills parentSkills = parentSkillsRepository.save(newForm.getParentSkills());
        newForm.setParentSkills(parentSkills);
        OpinionOfInvolvedParties opinionOfInvolvedParties = opinionOfInvolvedPartiesRepository.save(newForm.getOpinionOfInvolvedParties());
        newForm.setOpinionOfInvolvedParties(opinionOfInvolvedParties);
        Case studentCase = context.getBean(CaseRepository.class)
                .findById(caseId)
                .orElseThrow(() ->
                        new CaseNotFound(caseId));
        newForm.setStudentCase(studentCase);
        return newForm;
    }

    private InputStream getFileFromResourceAsStream(String fileName) throws FileNotFoundException {

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new FileNotFoundException("File not found! " + fileName);
        } else {
            return inputStream;
        }

    }



}
