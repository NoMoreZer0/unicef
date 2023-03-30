package com.company.unicef.screen.student;

import io.jmix.ui.screen.*;
import com.company.unicef.entity.Student;

@UiController("Student.edit")
@UiDescriptor("student-edit.xml")
@EditedEntityContainer("studentDc")
public class StudentEdit extends StandardEditor<Student> {
}