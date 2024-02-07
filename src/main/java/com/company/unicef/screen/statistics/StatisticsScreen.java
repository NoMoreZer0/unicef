package com.company.unicef.screen.statistics;

import com.company.unicef.entity.SchoolMask;
import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.ComboBox;
import io.jmix.ui.component.DateField;
import io.jmix.ui.component.Label;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@UiController("StatisticsScreen")
@UiDescriptor("statistics-screen.xml")
public class StatisticsScreen extends Screen {
    @Autowired
    private DataManager dataManager;
    @Autowired
    private DateField dateFieldBegin;
    @Autowired
    private DateField dateFieldEnd;
    @Autowired
    private ComboBox<SchoolMask> schoolMaskComboBox;
    @Autowired
    private Label secondFormCount;
    @Autowired
    private Label firstFormCount;
    @Autowired
    private Label openCaseCount;
    @Autowired
    private Label closedCaseCount;
    @Autowired
    private Label nullCaseCount;
    @Autowired
    private Notifications notifications;

    @Subscribe("calc")
    public void onCalcClick(final Button.ClickEvent event) {
        if (dateFieldBegin.getValue() == null) {
            notifications.create()
                    .withCaption("Введите дату начала")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
            return;
        }
        if (dateFieldEnd.getValue() == null) {
            notifications.create()
                    .withCaption("Введите дату окончания")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
            return;
        }
        if (schoolMaskComboBox.getValue() == null) {
            notifications.create()
                    .withCaption("Выберите школу")
                    .withType(Notifications.NotificationType.WARNING)
                    .show();
            return;
        }

        SchoolMask schoolMask = schoolMaskComboBox.getValue();
        Date dateBegin = (Date) dateFieldBegin.getValue();
        Date dateEnd = new Date(((Date) dateFieldEnd.getValue()).getTime() + (1000 * 60 * 60 * 24));
        int secondFormsTotal = dataManager.loadValue("select count(e) from SecondForm e where e.schoolMask = :schoolMask and e.createdDate >= :dateBegin and e.createdDate < :dateEnd", Integer.class)
                .parameter("schoolMask", schoolMask)
                .parameter("dateBegin", dateBegin)
                .parameter("dateEnd", dateEnd)
                .one();
        int firstFormsTotal = dataManager.loadValue("select count(e) from FirstForm e where e.schoolMask = :schoolMask and e.createdDate >= :dateBegin and e.createdDate < :dateEnd", Integer.class)
                .parameter("schoolMask", schoolMask)
                .parameter("dateBegin", dateBegin)
                .parameter("dateEnd", dateEnd)
                .one();
        int openCaseTotal = dataManager.loadValue("select count(e) from OpenCase e where e.schoolMask = :schoolMask and e.openingDate >= :dateBegin and e.openingDate < :dateEnd and e.status = 'A'", Integer.class)
                .parameter("schoolMask", schoolMask)
                .parameter("dateBegin", dateBegin)
                .parameter("dateEnd", dateEnd)
                .one();
        int closedCaseTotal = dataManager.loadValue("select count(e) from OpenCase e where e.schoolMask = :schoolMask and e.openingDate >= :dateBegin and e.openingDate < :dateEnd and e.status = 'B'", Integer.class)
                .parameter("schoolMask", schoolMask)
                .parameter("dateBegin", dateBegin)
                .parameter("dateEnd", dateEnd)
                .one();
        int nullCaseTotal = dataManager.loadValue("select count(e) from OpenCase e where e.schoolMask = :schoolMask and e.openingDate >= :dateBegin and e.openingDate < :dateEnd and e.status is null", Integer.class)
                .parameter("schoolMask", schoolMask)
                .parameter("dateBegin", dateBegin)
                .parameter("dateEnd", dateEnd)
                .one();
        secondFormCount.setValue(String.valueOf(secondFormsTotal));
        firstFormCount.setValue(String.valueOf(firstFormsTotal));
        openCaseCount.setValue(String.valueOf(openCaseTotal));
        closedCaseCount.setValue(String.valueOf(closedCaseTotal));
        nullCaseCount.setValue(String.valueOf(nullCaseTotal));
    }
}