package swag.rest.nis_risk_app.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import swag.rest.nis_risk_app.exception.*;

@ControllerAdvice
public class GlobalHandler {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {StudentNotFound.class, FirstFormNotFound.class, CaseNotFound.class,
                               FirstFormNotFound.class, ParentNotFound.class, SecondFormNotFound.class,
                               UserNotFound.class})
    String resourceNotFound(Exception ex) {
        return ex.getMessage();
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.SEE_OTHER)
    @ExceptionHandler(value = Exception.class)
    String serverError(Exception ex) {
        return ex.getMessage();
    }

}
