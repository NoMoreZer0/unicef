package com.company.unicef.screen.student;

import com.company.unicef.entity.StudentStatusField;
import com.company.unicef.entity.User;
import io.jmix.core.DataManager;
import io.jmix.notifications.NotificationManager;
import io.jmix.notifications.entity.ContentType;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.HasValue;
import io.jmix.ui.component.TextField;
import io.jmix.ui.model.DataContext;
import io.jmix.ui.model.InstanceLoader;
import io.jmix.ui.screen.*;
import com.company.unicef.entity.Student;
import org.docx4j.wml.U;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Subscribe
    public void onBeforeShow(final BeforeShowEvent event) {
        if (getEditedEntity().getStatus() != null) return;
        getEditedEntity().setStatus(StudentStatusField.GRAY);
    }


}
