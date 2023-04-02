/*
 * Copyright 2021 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.company.unicef.screen.firstform;

import com.company.unicef.entity.RiskTabel;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfDocument;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.xml.XmlParser;
import com.vaadin.server.FileDownloader;
import io.jmix.core.DataManager;
import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.CheckBoxGroup;
import io.jmix.ui.component.Table;
import io.jmix.ui.model.CollectionContainer;
import io.jmix.ui.model.CollectionLoader;
import io.jmix.ui.screen.*;
import liquibase.pro.packaged.B;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@UiController("FirstForm")
@UiDescriptor("first-form.xml")
public class FirstForm extends Screen {

    private static final Logger log = LoggerFactory.getLogger(FirstForm.class);
    @Autowired
    protected DataManager dataManager;
    @Autowired
    private CheckBoxGroup<Integer> socialMedicalRiskFactorBox;

    private Map<Integer, Double> socialMedicalRiskMap;

    @Autowired
    private CheckBoxGroup<Integer> individualRiskFactor;

    private Map<Integer, Double> individualRiskMap;
    @Autowired
    private CheckBoxGroup<Integer> academicRiskFactor;

    private Map<Integer, Double> academicRiskMap;

    @Autowired
    private CheckBoxGroup<Integer> familyRiskFactor;

    private Map<Integer, Double> familyRiskMap;

    @Autowired
    private CheckBoxGroup<Integer> individualProtectionFactor;

    private Map<Integer, Double> individualProtectionMap;

    @Autowired
    private CheckBoxGroup<Integer> familyProtectionFactor;
    @Autowired
    private CheckBoxGroup<Integer> environmentProtectionFactor;
    @Autowired
    private CheckBoxGroup<Integer> schoolProtectionFactor;
    @Autowired
    private Notifications notifications;
    @Autowired
    private Table<RiskTabel> finalRiskTabel;
    private double sumCoef, sumNum, sumA;
    @Autowired
    private CollectionContainer<RiskTabel> riskTabelsDc;
    @Autowired
    private CollectionLoader<RiskTabel> riskTabelsDl;

    @Subscribe
    public void onInit(InitEvent event) {
        initSocialMedicalRiskFactorBox();
        initIndividualRiskFactor();
        initAcademicRiskFactor();

        initFamilyRiskFactor();
        initIndividualProtectionFactor();
        initFamilyProtectionFactor();
        initEnvironmentProtectionFactor();
        initSchoolProtectionFactor();
    }


    private void initSocialMedicalRiskFactorBox() {
        Map<String, Integer> map = new LinkedHashMap<>();
        socialMedicalRiskMap = new HashMap<>();
        map.put("Дети, находящиеся в риске остаться без опеки родителей или лиц их заменяющих", 1);
        socialMedicalRiskMap.put(1, 0.92);
        map.put("Дети/молодежь в риске (антисоциальное поведение) и конфликте с законом", 2);
        socialMedicalRiskMap.put(2, 0.84);
        map.put("Детский труд (ребенок подрабатывает, выполняет родительские обязанности в семье)", 3);
        socialMedicalRiskMap.put(3, 0.90);
        map.put("Инвалидность/наличие хронических заболеваний ребенка", 4);
        socialMedicalRiskMap.put(4, 0.72);
        map.put("Ранняя беременность/ Несовершеннолетние родители", 5);
        socialMedicalRiskMap.put(5, 0.88);
        map.put("Живущие с ВИЧ ребенок", 6);
        socialMedicalRiskMap.put(6, 0.76);
        map.put("Домашнее насилие*", 7);
        socialMedicalRiskMap.put(7, 0.94);
        map.put("Жестокое и небрежное обращения с ребенком*", 8);
        socialMedicalRiskMap.put(8, 0.88);
        map.put("Психическое заболевание ребенка", 9);
        socialMedicalRiskMap.put(9, 0.88);
        map.put("Эксплуатация и траффик (сексуальное рабство, продажа органов, торговля детей) *", 10);
        socialMedicalRiskMap.put(10, 0.92);
        map.put("Вовлечение ребенка в религиозный радикализм (экстремизм) ребенка (имеется информация от гос организации о вовлечении ребенка в данные религиозные направления)*", 11);
        socialMedicalRiskMap.put(11, 0.88);
        map.put("Ребенок, вернувшийся из зон вооруженных конфликтов", 12);
        socialMedicalRiskMap.put(12, 0.84);
        map.put("Опыт пребывания в институциональном учреждении (детский дом, интернаты, приюты, спец интернаты и др.)", 13);
        socialMedicalRiskMap.put(13, 0.80);
        map.put("Недостаточное и/или несбалансированное питание", 14);
        socialMedicalRiskMap.put(14, 0.72);
        map.put("Нет сезонной одежды", 15);
        socialMedicalRiskMap.put(15, 0.56);
        map.put("Юридические проблемы (например, отсутствие свидетельства о рождении ребенка, паспорта, прописки)", 16);
        socialMedicalRiskMap.put(16, 0.60);
        map.put("Ребенок проживает вне семьи (в интернате, у родственников, знакомых или проживает один)", 17);
        socialMedicalRiskMap.put(17, 0.70);
        socialMedicalRiskFactorBox.setOptionsMap(map);
    }

    private void initIndividualRiskFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
        individualRiskMap = new HashMap<>();
        map.put("Рискованное поведение (ранние половые отношения,употребление психоактивных веществ, алкоголя, табака, вандализм, вождение автомобиля без прав, участник буллинга/кибербуллинг)", 1);
        individualRiskMap.put(1, 0.96);
        map.put("Несуицидальное самоповреждающее поведение (самопорезы, самоудары, самоожоги и др.)", 2);
        individualRiskMap.put(2, 0.84);
        map.put("Риск самоубийства/история попыток совершения суицида", 3);
        individualRiskMap.put(3, 0.94);
        map.put("Переживание горя утраты", 4);
        individualRiskMap.put(4, 0.76);
        map.put("Дети, испытавшие стресс/ травму", 5);
        individualRiskMap.put(5, 0.76);
        map.put("Нарушения физического и умственного развития", 6);
        individualRiskMap.put(6, 0.78);
        map.put("Слабые навыки самообслуживания", 7);
        individualRiskMap.put(7, 0.64);
        map.put("Психоэмоциональные проблемы у ребенка (тревожность, агрессивность, страхи и др)", 8);
        individualRiskMap.put(8, 0.74);
        map.put("Ребенок подвергается буллингу в школе", 9);
        individualRiskMap.put(9, 0.88);
        individualRiskFactor.setOptionsMap(map);
    }

    private void initAcademicRiskFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
        academicRiskMap = new HashMap<>();
        map.put("Частые попуски уроков без уважительной причины (10 и более дней в четверть)", 1);
        academicRiskMap.put(1, 0.82);
        map.put("Частые попуски уроков по состоянию здоровья (стационарные/амбулаторные лечения из-за хронического заболевания, инвалидности)", 2);
        academicRiskMap.put(2, 0.70);
        map.put("Неудовлетворительные оценки по нескольким предметам (есть риск быть неаттестованным по ряду предметов и остаться на второй год обучения)", 3);
        academicRiskMap.put(3, 0.76);
        map.put("Низкая учебная мотивация ребенка по разным причинам", 4);
        academicRiskMap.put(4, 0.72);
        map.put("Ребенок не обеспечен всем необходимым для школьного образования (школьной формой, обувью, школьными канцелярским товарами)", 5);
        academicRiskMap.put(5, 0.68);
        map.put("Отсутствие родительского контроля. Ребенок отдан на воспитание бабушке/дедушке и др.", 6);
        academicRiskMap.put(6, 0.76);
        map.put("Школой не предоставляются дополнительные занятиям/консультации", 7);
        academicRiskMap.put(7, 0.64);
        map.put("Ученик не посещает (не желает/отказывается) от предлагаемых дополнительных занятий/консультаций в школе", 8);
        academicRiskMap.put(8, 0.64);
        map.put("Дополнительные занятия/консультации в школе предоставляются не качественно (отсутствует график/ученик и его родитель не ознакомлены с графиком доп. занятий; частые замены учителя/отсутствие учителя и др.)", 9);
        academicRiskMap.put(9, 0.64);
        map.put("Конфликтные отношения между учениками", 10);
        academicRiskMap.put(10, 0.78);
        map.put("Конфликтные отношения между учеником-учителем", 11);
        academicRiskMap.put(11, 0.78);
        map.put("Конфликтные отношения между учителем-родителем", 12);
        academicRiskMap.put(12, 0.74);
        academicRiskFactor.setOptionsMap(map);
    }

    private void initFamilyRiskFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
        familyRiskMap = new HashMap<>();
        map.put("Многодетная семья (4 детей/молодежь и более совместно проживающие)", 1);
        familyRiskMap.put(1, 0.54);
        map.put("Семья с детьми с одним родителем", 2);
        familyRiskMap.put(2, 0.56);
        map.put("Семьи, где член(ы) семьи имеют алкогольную или наркотическую зависимость", 3);
        familyRiskMap.put(3, 0.86);
        map.put("Родители в трудовой миграции", 4);
        familyRiskMap.put(4, 0.66);
        map.put("Родители относятся к людям без определенного места жительства", 5);
        familyRiskMap.put(5, 0.76);
        map.put("Семьи, вернувшиеся из зон вооруженных конфликтов", 6);
        familyRiskMap.put(6, 0.80);
        map.put("Родители или члены семьи вышедшие из мест заключения", 7);
        familyRiskMap.put(7, 0.78);
        map.put("Беременные мамы с маленькими детьми", 8);
        familyRiskMap.put(8, 0.52);
        map.put("Малоимущая семья (среднедушевой доход ниже прожиточного минимума (37389 тысяч тенге) за последние 12 месяцев)", 9);
        familyRiskMap.put(9, 0.72);
        map.put("Инвалидность родителя/члена семьи", 10);
        familyRiskMap.put(10, 0.68);
        map.put("Престарелые и пожилые родители", 11);
        familyRiskMap.put(11, 0.54);
        map.put("Религиозная радикализация (экстремизм) родителя/члена семьи*", 12);
        familyRiskMap.put(12, 0.76);
        map.put("Низкий образовательный уровень родителей", 13);
        familyRiskMap.put(13, 0.56);
        map.put("Слабые родительские компетенции", 14);
        familyRiskMap.put(14, 0.66);
        map.put("Нарушенная привязанность в детско-родительских отношениях", 15);
        familyRiskMap.put(15, 0.78);
        map.put("Развод/хронический развод (многожёнство, сожительство, живут раздельно без развода и др.)", 16);
        familyRiskMap.put(16, 0.80);
        map.put("Семейные конфликты (конфликты между супругами, детьми и родителями, между невесткой и свекровью)", 17);
        familyRiskMap.put(17, 0.78);
        map.put("Опыт родителя пребывания в институциональном учреждении (детский дом, интернаты, приюты и др)", 18);
        familyRiskMap.put(18, 0.64);
        map.put("Отсутствие жилья или плохие условия проживания", 19);
        familyRiskMap.put(19, 0.80);
        map.put("Отсутствие медикаментов и медицинского лечения у родителей", 20);
        familyRiskMap.put(20, 0.72);
        map.put("Отсутствие транспорт (напр., для посещения медицинских услуг человеком с инвалидностью)", 21);
        familyRiskMap.put(21, 0.64);
        map.put("Временные финансовые трудности в семье", 22);
        familyRiskMap.put(22, 0.60);
        map.put("Отсутствие социальной поддержки семьи (несмотря на то что он имеет право на АСП)", 23);
        familyRiskMap.put(23, 0.64);
        map.put("Социальная изоляция (семья не общается ни с кем)", 24);
        familyRiskMap.put(24, 0.72);
        map.put("Недостаточный доступ к услугам в местном сообществе (например, в сельской местности)", 25);
        familyRiskMap.put(25, 0.58);
        map.put("Дискриминация семьи или членов семьи в обществе", 26);
        familyRiskMap.put(26, 0.78);
        map.put("Безработный член семьи/самозанятый сезонный рабочий с низким доходом (стоит на бирже труда/сокращение/банкротство и др)", 27);
        familyRiskMap.put(27, 0.60);
        map.put("Культурные нормы в семье, которые поддерживают насилие или неравенство", 28);
        familyRiskMap.put(28, 0.82);
        map.put("Психическое заболевание родителя/члена семьи", 29);
        familyRiskMap.put(29, 0.86);
        map.put("Живущие с ВИЧ родитель/член семьи", 30);
        familyRiskMap.put(30, 0.74);
        familyRiskFactor.setOptionsMap(map);
    }

    private void initIndividualProtectionFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
        individualProtectionMap = new HashMap<>();
        map.put("Академические достижения/хорошая успеваемость в школе", 1);
        map.put("Хорошие жизненные и социальные навыки, навыки решения проблем", 2);
        map.put("Активность в решении собственных проблем", 3);
        map.put("Уверенность в себе, позитивное отношение", 4);
        individualProtectionFactor.setOptionsMap(map);
    }

    private void initFamilyProtectionFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Безопасная привязанность", 1);
        map.put("Заботливый родитель/взрослый член семьи", 2);
        map.put("Стабильность в семье", 3);
        map.put("Хорошие родительские навыки воспитания", 4);
        map.put("Позитивная родительская практика", 5);
        map.put("Поддержка базовых потребностей", 6);
        map.put("Устойчивые семейные отношения", 7);
        map.put("Установленные семейные правила и уход за детьми", 8);
        map.put("Заботливые взрослые вне семьи, кто служит в качестве ролевых моделей или наставников", 9);
        map.put("Поддерживающее семейное окружение и социальные сети", 10);
        familyProtectionFactor.setOptionsMap(map);
    }

    private void initEnvironmentProtectionFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Экономическая стабильность", 1);
        map.put("Трудоустройство родителей", 2);
        map.put("Образование у родителей", 3);
        map.put("Нормальные жилищные условия", 4);
        map.put("Социальная поддержка", 5);
        map.put("Доступ к медицинским, образовательным и социальным услугам для взрослых и детей", 6);
        map.put("Координация ресурсов и услуг", 7);
        environmentProtectionFactor.setOptionsMap(map);
    }

    private void initSchoolProtectionFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Безопасная школьная среда", 1);
        map.put("Дополнительные занятия", 2);
        map.put("Наличие НПА по политике защиты учащегося", 3);
        map.put("Наставничество", 4);
        map.put("Программы для родительского сообщества", 5);
        map.put("Инклюзивный подход", 6);
        map.put("Дополнительные творческие занятия/кружки", 7);
        map.put("Профилактические программы для детей", 8);
        schoolProtectionFactor.setOptionsMap(map);
    }

    private void calc(CheckBoxGroup<Integer> checkBoxGroup, Map<Integer, Double> map) {
        sumCoef = sumNum = 0;
        Collection<Integer> collection = checkBoxGroup.getValue();
        if (collection != null && !checkBoxGroup.isEmpty()) {
            for (Integer value : collection) {
                sumCoef += (value * 1.0 + map.get(value));
                sumNum += value;
            }
        }
        if (sumNum != 0) {
            sumA += (sumCoef / sumNum);
        }
    }

    private int takeSize(CheckBoxGroup<Integer> checkBoxGroup) {
        if (checkBoxGroup == null) return 0;
        Collection<Integer> collection = checkBoxGroup.getValue();
        if (collection == null) return 0;
        return collection.size();
    }

    @Subscribe("submitButton")
    public void onSubmitButtonClick(Button.ClickEvent event) {
        sumA = 0;
        calc(socialMedicalRiskFactorBox, socialMedicalRiskMap);
        calc(individualRiskFactor, individualRiskMap);
        calc(academicRiskFactor, academicRiskMap);
        calc(familyRiskFactor, familyRiskMap);
        double B = sumA / 4;
        int sumProtection = takeSize(individualProtectionFactor) + takeSize(familyProtectionFactor) + takeSize(environmentProtectionFactor) + takeSize(schoolProtectionFactor);
        String msg = "";
        if (0.9 <= B && B <= 1.1 || sumProtection > 0) {
            msg = "Высокий уровень";
        }
        else if (0.71 <= B && B <= 0.89) {
            msg = "Средний уровень";
        }
        else {
            msg = "Низкий уровень";
        }

        String xmlData = UiControllerUtils.getScreenData(this).toString();
//        byte[] pdfData = generatePdf(xmlData);
    }
}