package swag.rest.nis_risk_app.service.internal;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.rest.nis_risk_app.dao.EmergencyRepository;
import swag.rest.nis_risk_app.dao.StudentRepository;
import swag.rest.nis_risk_app.dto.EmergencyDto;
import swag.rest.nis_risk_app.entity.Emergency;
import swag.rest.nis_risk_app.entity.Student;
import swag.rest.nis_risk_app.service.EmergencyService;
import swag.rest.nis_risk_app.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmergencyServiceImpl implements EmergencyService {

    private final EmergencyRepository emergencyRepository;

    private final StudentRepository studentRepository;

    private final StudentService studentService;



    @Override
    @Transactional
    public Emergency save(EmergencyDto emergencyDto) {
        Student student = studentService.findStudentById(emergencyDto.getStudentId()).orElse(null);
        System.out.println(student.id());
        Emergency emergencyToSave = new Emergency(
                emergencyDto.getInformedAdministrationFIO(),
                emergencyDto.getInformedParentFIO(),
                emergencyDto.getIsStudentIsolated(),
                emergencyDto.getIsStudentTransferred(),
                student);
        student.setStudentEmergency(emergencyToSave);
        emergencyRepository.save(emergencyToSave);
        studentRepository.save(student);
        return emergencyToSave;
    }

    @Override
    public List<Emergency> getAllEmergency() {
        return emergencyRepository.findAll();
    }

    @Override
    public Emergency getEmergencyById(Long id) {
        return emergencyRepository.findById(id).orElse(null);
    }
}
