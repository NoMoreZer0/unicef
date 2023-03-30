package swag.rest.nis_risk_app.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import swag.rest.nis_risk_app.dto.EducationForm4Dto;
import swag.rest.nis_risk_app.dto.FirstPhaseDto;
import swag.rest.nis_risk_app.dto.StudentDto;
import swag.rest.nis_risk_app.entity.FirstPhase;
import swag.rest.nis_risk_app.entity.Student;

@Mapper(
        componentModel = "spring"
)
public interface EntityMapper {

    FirstPhase toEntity(FirstPhaseDto firstPhaseDto, String principal);

    Student toExistEntity(Student student, StudentDto studentDto);
}
