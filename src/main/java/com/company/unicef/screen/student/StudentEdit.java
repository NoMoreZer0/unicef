package com.company.unicef.screen.student;

import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.Student;
import org.slf4j.Logger;

import java.util.Date;

@UiController("Student.edit")
@UiDescriptor("student-edit.xml")
@EditedEntityContainer("studentDc")
public class StudentEdit extends StandardEditor<Student> {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(StudentEdit.class);

    @Subscribe("birthDateField")
    public void onBirthDateFieldValueChange(final HasValue.ValueChangeEvent<Date> event) {
        log.info(String.valueOf(event.getValue()));
        Date date = new Date();
        log.info("Current date: " + date);
    }

}