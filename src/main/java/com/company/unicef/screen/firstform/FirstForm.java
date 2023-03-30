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

import io.jmix.ui.Notifications;
import io.jmix.ui.component.Button;
import io.jmix.ui.component.CheckBoxGroup;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@UiController("FirstForm")
@UiDescriptor("first-form.xml")
public class FirstForm extends Screen {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(FirstForm.class);
    @Autowired
    private CheckBoxGroup<Integer> socialMedicalRiskFactorBox;

    private Map<Integer, Double> socialMedicalRiskMap;

    @Autowired
    private CheckBoxGroup<Integer> individualRiskFactor;

    private Map<Integer, Double> individualRiskMap;
    @Autowired
    private CheckBoxGroup<Integer> academicRiskFactor;
    @Autowired
    private CheckBoxGroup<Integer> familyRiskFactor;
    @Autowired
    private CheckBoxGroup<Integer> individualProtectionFactor;
    @Autowired
    private CheckBoxGroup<Integer> familyProtectionFactor;
    @Autowired
    private CheckBoxGroup<Integer> environmentProtectionFactor;
    @Autowired
    private CheckBoxGroup<Integer> schoolProtectionFactor;

    @Autowired
    private Notifications notifications;

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
        map.put("Несуицидальное самоповреждающее поведение (самопорезы, самоудары, самоожоги и др.)", 2);
        map.put("Риск самоубийства/история попыток совершения суицида", 3);
        map.put("Переживание горя утраты", 4);
        map.put("Дети, испытавшие стресс/ травму", 5);
        map.put("Нарушения физического и умственного развития", 6);
        map.put("Слабые навыки самообслуживания", 7);
        map.put("Психоэмоциональные проблемы у ребенка (тревожность, агрессивность, страхи и др)", 8);
        map.put("Ребенок подвергается буллингу в школе", 9);
        individualRiskFactor.setOptionsMap(map);
    }

    private void initAcademicRiskFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Частые попуски уроков без уважительной причины (10 и более дней в четверть)", 1);
        map.put("Неудовлетворительные оценки по нескольким предметам (есть риск быть неаттестованным по ряду предметов и остаться на второй год обучения)", 2);
        map.put("Частые попуски уроков по состоянию здоровья (стационарные/амбулаторные лечения из-за хронического заболевания, инвалидности)", 3);
        map.put("Ребенок не обеспечен всем необходимым для школьного образования (школьной формой, обувью, школьными канцелярским товарами)", 4);
        map.put("Низкая учебная мотивация ребенка по разным причинам", 5);
        map.put("Конфликтные отношения между учениками", 6);
        map.put("Отсутствие родительского контроля. Ребенок отдан на воспитание бабушке/дедушке и др.", 7);
        map.put("Школой не предоставляются дополнительные занятиям/консультации", 8);
        map.put("Ученик не посещает (не желает/отказывается) от предлагаемых дополнительных занятий/консультаций в школе", 9);
        map.put("Дополнительные занятия/консультации в школе предоставляются не качественно (отсутствует график/ученик и его родитель не ознакомлены с графиком доп. занятий; частые замены учителя/отсутствие учителя и др.)", 10);
        map.put("Конфликтные отношения между учителем-родителем", 11);
        map.put("Конфликтные отношения между учеником-учителем", 12);
        academicRiskFactor.setOptionsMap(map);
    }

    private void initFamilyRiskFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Многодетная семья (4 детей/молодежь и более совместно проживающие)", 1);
        map.put("Родители в трудовой миграции", 2);
        map.put("Семьи, где член(ы) семьи имеют алкогольную или наркотическую зависимость", 3);
        map.put("Родители или члены семьи вышедшие из мест заключения", 4);
        map.put("Родители относятся к людям без определенного места жительства", 5);
        map.put("Низкий образовательный уровень родителей", 6);
        map.put("Слабые родительские компетенции", 7);
        map.put("Нарушенная привязанность в детско-родительских отношениях", 8);
        map.put("Развод/хронический развод (многожёнство, сожительство, живут раздельно без развода и др.)", 9);
        map.put("Отсутствие жилья или плохие условия проживания", 10);
        map.put("Отсутствие медикаментов и медицинского лечения у родителей", 11);
        map.put("Отсутствие транспорт (напр., для посещения медицинских услуг человеком с инвалидностью)", 12);
        map.put("Временные финансовые трудности в семье", 13);
        map.put("Культурные нормы в семье, которые поддерживают насилие или неравенство", 14);
        map.put("Психическое заболевание родителя/члена семьи", 15);
        map.put("Семейные конфликты (конфликты между супругами, детьми и родителями, между невесткой и свекровью)", 16);
        map.put("Малоимущая семья (среднедушевой доход ниже прожиточного минимума (37389 тысяч тенге) за последние 12 месяцев)", 17);
        map.put("Престарелые и пожилые родители", 18);
        map.put("Беременные мамы с маленькими детьми", 19);
        map.put("Семья с детьми с одним родителем", 20);
        map.put("Опыт родителя пребывания в институциональном учреждении (детский дом, интернаты, приюты и др)", 21);
        map.put("Отсутствие социальной поддержки семьи (несмотря на то что он имеет право на АСП)", 22);
        map.put("Социальная изоляция (семья не общается ни с кем)", 23);
        map.put("Недостаточный доступ к услугам в местном сообществе (например, в сельской местности)", 24);
        map.put("Дискриминация семьи или членов семьи в обществе", 25);
        map.put("Безработный член семьи/самозанятый сезонный рабочий с низким доходом (стоит на бирже труда/сокращение/банкротство и др)", 26);
        map.put("Живущие с ВИЧ родитель/член семьи", 27);
        map.put("Инвалидность родителя/члена семьи", 28);
        map.put("Семьи, вернувшиеся из зон вооруженных конфликтов", 29);
        map.put("Религиозная радикализация (экстремизм) родителя/члена семьи*", 30);
        familyRiskFactor.setOptionsMap(map);
    }

    private void initIndividualProtectionFactor() {
        Map<String, Integer> map = new LinkedHashMap<>();
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

    @Subscribe("submitButton")
    public void onSubmitButtonClick(Button.ClickEvent event) {
        Collection<Integer> socialMedicalRiskFactorValues = socialMedicalRiskFactorBox.getValue();
        if (socialMedicalRiskFactorValues != null && !socialMedicalRiskFactorValues.isEmpty()) {
            for (Integer value : socialMedicalRiskFactorValues) {
                log.info(String.valueOf(value));
            }
        }
        notifications.create()
                .withCaption("kek")
                .show();
    }
}