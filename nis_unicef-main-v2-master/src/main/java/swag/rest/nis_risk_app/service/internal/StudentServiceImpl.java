package swag.rest.nis_risk_app.service.internal;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swag.rest.nis_risk_app.dao.CaseRepository;
import swag.rest.nis_risk_app.dao.ParentRepository;
import swag.rest.nis_risk_app.dao.StudentRepository;
import swag.rest.nis_risk_app.dto.StudentDto;
import swag.rest.nis_risk_app.entity.Parent;
import swag.rest.nis_risk_app.entity.Student;
import swag.rest.nis_risk_app.exception.ParentNotFound;
import swag.rest.nis_risk_app.exception.StudentNotFound;
import swag.rest.nis_risk_app.mapper.impl.EntityMapperImpl;
import swag.rest.nis_risk_app.util.CaseStatus;
import swag.rest.nis_risk_app.util.StudentStatus;
import swag.rest.nis_risk_app.service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final CaseRepository caseRepository;
    private final StudentRepository studentRepository;

    private final ParentRepository parentRepository;

    private final ModelMapper modelMapper;

    private final EntityMapperImpl entityMapper;

    @Transactional
    public Optional<Student> findStudentById(Long studentId){
        return studentRepository.findById(studentId);
    }

    @Override
    @Transactional
    public void changeStudentStatus(Long studentId, String studentStatus) {
        Student student = findStudentById(studentId).orElse(null);
        assert student != null;
        student.setStudentStatus(StudentStatus.valueOf(studentStatus));
    }

    @Override
    @Transactional
    public Student getStudentsByStatus(String status) {
        return studentRepository.findByStudentStatus(status);
    }



    @Override
    @Transactional
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public ResponseEntity<Object> saveStudent(StudentDto studentDto) {

        Student student;
        List<Parent> parents = new ArrayList<>();

        if(studentDto.getParentsDto() != null && studentDto.getParents() != null){
            return ResponseEntity.badRequest().build();
        }
        else if(studentDto.getParentsDto() != null){
            studentDto.getParentsDto().forEach(s -> parents.add(
                    parentRepository.save(modelMapper.map(s, Parent.class))));
            Student studentNotPersisted = modelMapper.map(studentDto, Student.class);
            studentNotPersisted.setParents(parents);
            student = studentRepository.save(studentNotPersisted);
        }else {
            studentDto.getParents()
                    .forEach(s -> parents.add(
                            parentRepository
                                    .findById(s.id())
                                    .orElseThrow(() ->
                                            new ParentNotFound(s.id())
                                    )));
            student = modelMapper.map(studentDto, Student.class);
            student.setParents(parents);
            studentRepository.save(student);
        }


        return ResponseEntity.ok(student);
    }

    @Override
    @Transactional
    public Student updateStudent(StudentDto studentDto, Long studentId) {
        Student studentToUpdate = studentRepository
                .findById(studentId)
                .orElseThrow(() ->
                        new StudentNotFound(studentId));
        Student updatedStudent = entityMapper.toExistEntity(studentToUpdate, studentDto);
        return  studentRepository.save(updatedStudent);
    }

    @Override
    public List<Student> getStudentsByName(String nameOfStudent) {
        return studentRepository.findByNameOfStudentContainingIgnoreCase(nameOfStudent);
    }

    @Override
    public Map<StudentStatus, Long> getStudentCountByStatus() {
        Map<StudentStatus, Long> map = new HashMap<>();
        List<Student> studentList = studentRepository.findAll();
        for (StudentStatus status : StudentStatus.values()) {
            map.put(status, studentList.stream().filter((s) -> s.getStudentStatus().equals(status)).count());
        }
        return map;
    }



}
