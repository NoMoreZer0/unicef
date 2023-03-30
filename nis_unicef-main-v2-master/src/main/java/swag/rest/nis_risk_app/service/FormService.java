package swag.rest.nis_risk_app.service;

import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.springframework.stereotype.Service;
import swag.rest.nis_risk_app.dto.FirstPhaseDto;
import swag.rest.nis_risk_app.dto.FormDto;
import swag.rest.nis_risk_app.dto.FourthPhaseDto;
import swag.rest.nis_risk_app.dto.SecondPhaseDto;
import swag.rest.nis_risk_app.entity.Case;
import swag.rest.nis_risk_app.entity.FirstPhase;
import swag.rest.nis_risk_app.entity.FourthPhase;
import swag.rest.nis_risk_app.entity.SecondPhase;
import swag.rest.nis_risk_app.entity.Student;

import java.io.IOException;
import java.util.List;

@Service
public interface FormService {
    FirstPhase createFirstForm(FirstPhaseDto firstPhaseDto, Student student, Long caseId) throws IllegalAccessException;

    Boolean isFirstFormFullyFilled(Long formDd);

    Boolean isSecondFormFullyFilled(Long formDd);

    FirstPhase updateFirstForm(FirstPhaseDto firstPhaseDto, Long formId);

    FirstPhase updatePartOfFirstForm(FirstPhaseDto firstPhaseDto, Long formId);

    List<FirstPhase> getAllFirstForms();

    FirstPhase calculateRiskStatus(FirstPhase firstPhase);

    FirstPhase getFirstFormById(Long id);

    FirstPhase persistFirstFormEntity(FirstPhase newForm);

    SecondPhase createSecondForm(SecondPhaseDto secondPhaseDto, Long caseId, Student student) throws IllegalAccessException;

    FirstPhase persistUpdatedFirstFormEntity(FirstPhase firstPhaseToUpdate, FirstPhaseDto firstPhaseDto);

    SecondPhase updateSecondForm(SecondPhaseDto secondPhaseDto, Long formId);

    List<SecondPhase> getAllSecondForms();

    SecondPhase persistSecondFormEntity(SecondPhase newForm, SecondPhaseDto secondPhaseDto
    , Case studentCase);


    SecondPhase persistUpdatedSecondFormEntity(SecondPhase newForm, SecondPhase secondPhase);

    byte[] generateFirstForm(Long formId) throws Exception;

    byte[] generateSecondForm(Long formId) throws Docx4JException, IOException;

    byte[] generateFourthForm(Long formId) throws Docx4JException, IOException;

    FourthPhase createFourthForm(FourthPhaseDto fourthPhaseDto, Long caseId, Student student);

    List<FourthPhase> getAllFourthForms();

    List<FormDto> getAllForms();

    FourthPhase updateFourthForm(FourthPhaseDto fourthPhaseDto, Long formId);

    FourthPhase persistFourthFormEntity(FourthPhase newForm, Long caseId);
}
