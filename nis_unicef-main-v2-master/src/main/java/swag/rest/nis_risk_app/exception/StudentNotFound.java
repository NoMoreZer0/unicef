package swag.rest.nis_risk_app.exception;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound(Long studentId) {
        super(String.format("Student with id %s not found", studentId));
    }
}
