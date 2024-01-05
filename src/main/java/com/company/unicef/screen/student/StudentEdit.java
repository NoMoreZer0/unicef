package com.company.unicef.screen.student;

import com.company.unicef.entity.Student;
import com.company.unicef.entity.StudentStatusField;
import io.jmix.core.DataManager;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.screen.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@UiController("Student.edit")
@UiDescriptor("student-edit.xml")
@EditedEntityContainer("studentDc")
public class StudentEdit extends StandardEditor<Student> {
    private static final Logger log = LoggerFactory.getLogger(StudentEdit.class);
    @Autowired
    private DataManager dataManager;

    @Subscribe("birthDateField")
    public void onBirthDateFieldValueChange(final HasValue.ValueChangeEvent<Date> event) {
        log.info(String.valueOf(event.getValue()));
        Date date = new Date();
        log.info("Current date: " + date);
    }

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        if (getEditedEntity().getStatus() == null) {
            getEditedEntity().setStatus(StudentStatusField.GRAY);
        }

        if (getEditedEntity().getStudentId() == null) {
            String newStudentId = getNewStudentId();
            getEditedEntity().setStudentId(newStudentId);
        }
    }

    private String getNewStudentId() {
        int lastStudentId = dataManager.loadValue("select max(cast(e.studentId integer)) from Student e", Integer.class)
                .optional()
                .orElse(0);
        return String.format("%06d", lastStudentId + 1);
    }
}
