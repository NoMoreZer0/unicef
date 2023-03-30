// @flow
import * as React from 'react';
import {SubmitHandler, useForm} from 'react-hook-form';
import styles from './Form4.module.scss';
import {FormService} from '../../services/FormService';
import {useParams} from 'react-router-dom';
import {Alert} from '@mui/material';
import {Card} from '@mui/material';


type Props = {
  currentStudentId: Number;
  currentCaseId: Number;
};

type Inputs = {
  childDevelopmentNeeds: {
    educationForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    emotionalDevelopmentForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    familyForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    healthForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    identityForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    selfIndependenceForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    socialPresentationForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    }
  },
  date: string, //не отправляешь это поле
  educationalNeed: string,//не отправляешь это поле
  opinionOfInvolvedParties: {
    childComment: string,
    organizationComment: string,
    parentComment: string
  },
  otherPersonLivingWithFamilyList: [
    {
      birthDate: string,
      fio: string,
      relationLevel: string, //не отправляешь это поле
      workplace: string
    }
  ],
  outOfSchoolOrganizationEmployees: [
    {
      contact: string,
      fio: string,
      organization: string
    },
    {
      contact: string,
      fio: string,
      organization: string
    },
    {
      contact: string,
      fio: string,
      organization: string
    },
    {
      contact: string,
      fio: string,
      organization: string
    },
    {
      contact: string,
      fio: string,
      organization: string
    }
  ],
  parentSkills: {
    basicCareForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    directionBordersForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    emotionalHeatForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    extendedFamilyForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    familyHistoryForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    housingWorkIncomeForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    parentProblemsForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    resourcesForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    securityForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    socialIntegrationForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    stabilityForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    },
    stimulationForm4: {
      criteria: 0,
      discoveredRiskFactors: string,
      measures: string,
      measurePeriod: string,
      employee: string,
      ratingScale: "DONE_GET_BAD",
      indicator: 0
    }
  },
  planReviewDate: string
}

export function Form4({currentStudentId, currentCaseId}: Props) {
  const formService = new FormService();
  const [formId, setFormId] = React.useState(Number);
  const [link, setLink] = React.useState(String);

  const {register, handleSubmit, formState: {errors}} = useForm<Inputs>({
    defaultValues: {
      planReviewDate: new Date().toLocaleDateString(),
      date: new Date().toLocaleDateString(),
      educationalNeed: ""
    },
  });

  const onSubmit = async dataForm4 => {
    const response = await formService.sendFourthForm(dataForm4, Number(currentStudentId), Number(currentCaseId));
    console.log("student id:", currentStudentId)
    console.log("case id:", currentCaseId)

    if (response) {
      console.log(response !== null);
      setFormId(response?.id);
      alert("Четвертая форма успешно создана");
    }
  };

  async function getForm4Doc() {
    const res = await formService.downloadForm4(formId);
    console.log(res.Link)
    setLink(res.Link)
  }

  return (
    <div className={styles.container}>
      <Card sx={{minWidth: 275, padding: 5}} variant="outlined">
        <form onSubmit={handleSubmit(onSubmit)}>
          <div className={styles.titleOut}>Форма 4. Индивидуальный план развития учащегося </div>
          <div className={styles.formContainer}>
            <div className={styles.formContainer} >
              <div className={styles.formRow1}>
                <div>Дата проведения:</div>
                <div>Дата завершения: </div>
              </div>
              <div className={styles.title}>ИНФОРМАЦИЯ О РЕБЕНКЕ: </div>
              <div className={styles.formRow2}>
                <label>ФИО ребёнка</label>
                <input type="text" />

                <label>Дата рождения</label>
                <input type="date" />
                {/* <label>Полных лет</label> */}
                {/* <input type="text" {...register("studentInformationDto.dateOfBirth")} /> */}
                <label>Класс обучения</label>
                <input type="text" />
                <label>Пол</label>
                <select
                >
                  <option value='FEMALE' >Жен</option>
                  <option value='MALE' >Муж</option>
                </select>
                <label>Особые образовательные потребности</label>
                <select   >
                  <option value='Нет'>Нет</option>
                  <option value='Нет информации' >Нет информации</option>
                  <option value='Да' >Да</option>
                </select>
                <label>Контакты</label>
                <input type="text" />


              </div>
              <div className={styles.title}>
                Адрес проживания ребенка
              </div>
              <div className={styles.formRow}>
                <label >Город</label>
                <input type="text" />
                <label >Район</label>
                <input type="text" />
                <label >Улица</label>
                <input type="text" />
                <label >Дом</label>
                <input type="text" />
                <label >Квартира</label>
                <input type="text" />
                <label >Мобильный телефон</label>
                <input type="text" />
              </div>
              <div>
                ИНФОРМАЦИЯ О РОДИТЕЛЯХ/ЗАКОННЫХ ПРЕДСТАВИТЕЛЕЙ РЕБЕНКА:         </div>
              <div className={styles.formRow}>
                <div>Папа</div>
                <div>
                  <label >ФИО родителя/законного представителя</label>
                  <input type="text" />
                  <label >Дата рождения </label>
                  <input type="date" />
                  <label >Полных лет</label>
                  <label>Семейное положение</label>
                  <select  >
                    <option >Семейное положение </option>
                    <option value='Офиц зарегистрированы в браке' >Офиц зарегистрированы в браке</option>
                    <option value='Развод/смерть одного из родителей/родитель-одиночка'>Развод/смерть одного из родителей/родитель-одиночка</option>
                    <option value='Совместное проживание без регистрации брака'>Совместное проживание без регистрации брака</option>
                  </select>
                </div>
                <div>
                  Адрес проживания
                </div>
                <div className={styles.formRow}>
                  <label >Город</label>
                  <input type="text" />
                  <label >Район</label>
                  <input type="text" />
                  <label >Улица</label>
                  <input type="text" />
                  <label >Дом</label>
                  <input type="text" />
                  <label >Квартира</label>
                  <input type="text" />
                </div>
                <div>Мама</div>
                <div>
                  <label >ФИО родителя/законного представителя</label>
                  <input type="text" />
                  <label >Дата рождения</label>
                  <input type="date" />
                  {/* <label >Полных лет</label> */}

                  <label>Семейное положение</label>
                  <select   >
                    <option>Семейное положение </option>
                    <option value='Офиц зарегистрированы в браке'>Офиц зарегистрированы в браке</option>
                    <option value='Развод/смерть одного из родителей/родитель-одиночка'>Развод/смерть одного из родителей/родитель-одиночка</option>
                    <option value='Совместное проживание без регистрации брака'>Совместное проживание без регистрации брака</option>
                  </select>
                </div>
                <div>
                  Адрес проживания
                </div>
                <div className={styles.formRow}>
                  <label >Город</label>
                  <input type="text" />
                  <label >Район</label>
                  <input type="text" />
                  <label >Дом</label>

                  <input type="text" />
                  <label >Улица</label>
                  <input type="text" />
                  <label >Квартира</label>
                  <input type="text" />
                </div>
              </div>
              <div className={styles.title}>ДАННЫЕ ДРУГИХ ЛИЦ, ПРОЖИВАЮЩИХ СОВМЕСТНО С СЕМЬЕЙ:</div>
              <div className={styles.formRow}>
                <label >ФИО</label>
                <input type="text" {...register("otherPersonLivingWithFamilyList.0.fio")} />

                <label >Дата рождения</label>
                <input type="date" {...register("otherPersonLivingWithFamilyList.0.birthDate")} />
                <label >Степень родства</label>
                <input type="text"  {...register("otherPersonLivingWithFamilyList.0.relationLevel")} />

                <label >Место работы / обучения</label>
                <input type="text" {...register("otherPersonLivingWithFamilyList.0.workplace")} />
              </div>

            </div>
          </div>
          <div className={styles.formContainer}>
            <div className={styles.formRowFull}>
              Сотрудники образовательного учреждения, присутствующие/ вовлечённые в процесс планирования развития учащегося: (психолог, кл. рук-ль, врач/мед.сестра, зав.уч.частью, директор и пр.)
            </div>
            <div className={styles.formRow4}>
              <div>ФИО </div>
              <div>Должность </div>
              <div>Причастность к учащемуся</div>
              <div>Контактная информация:</div>
            </div>
            <div className={styles.formRow4}>
              <div>
                <input type="text" />
              </div>
              <select >
                <option value='психолог' >психолог</option>
                <option value='кл. руководство' >кл. руководство</option>
                <option value='врач/мед.сестра' >врач/мед.сестра</option>
                <option value='зав.уч.частью' >зав.уч.частью</option>
                <option value='директор' >директор</option>
              </select>
              <div>
                <select >
                  <option value='ведет уроки' >ведет уроки</option>
                  <option value='кл. руководство' >кл. руководство</option>
                  <option value='нет контакта' >нет контакта</option>
                </select>
              </div>
              <div>
                <input type="text" />
              </div>
            </div>
            <div className={styles.formRow4}>
              <div>
                <input type="text" />
              </div>
              <select >
                <option value='психолог' >психолог</option>
                <option value='кл. руководство' >кл. руководство</option>
                <option value='врач/мед.сестра' >врач/мед.сестра</option>
                <option value='зав.уч.частью' >зав.уч.частью</option>
                <option value='директор' >директор</option>
              </select>
              <div>
                <select >
                  <option value='ведет уроки' >ведет уроки</option>
                  <option value='кл. руководство' >кл. руководство</option>
                  <option value='нет контакта' >нет контакта</option>
                </select>
              </div>
              <div>
                <input type="text" />
              </div>
            </div>
            <div className={styles.formRow4}>
              <div>
                <input type="text" />
              </div>
              <select >
                <option value='психолог' >психолог</option>
                <option value='кл. руководство' >кл. руководство</option>
                <option value='врач/мед.сестра' >врач/мед.сестра</option>
                <option value='зав.уч.частью' >зав.уч.частью</option>
                <option value='директор' >директор</option>
              </select>
              <div>
                <select >
                  <option value='ведет уроки' >ведет уроки</option>
                  <option value='кл. руководство' >кл. руководство</option>
                  <option value='нет контакта' >нет контакта</option>
                </select>
              </div>
              <div>
                <input type="text" />
              </div>
            </div>

            <div className={styles.formRowFull}>
              Представители внешкольных организаций, вовлечённых в процесс составления Плана Развития Учащегося:
            </div>
            <div className={styles.formRow3}>
              <div>ФИО представителя </div>
              <div>Организация</div>
              <div>Контактная информация:</div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text" {...register("outOfSchoolOrganizationEmployees.0.fio")} />
              </div>
              <div>
                <input type="text" {...register("outOfSchoolOrganizationEmployees.0.organization")} />
              </div>
              <div>
                <input type="text" {...register("outOfSchoolOrganizationEmployees.0.contact")} />
              </div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.1.fio")} />
              </div>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.1.organization")} />
              </div>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.1.contact")} />
              </div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.2.fio")} />
              </div>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.2.organization")} />
              </div>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.2.contact")} />
              </div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.3.fio")} />
              </div>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.3.organization")} />
              </div>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.3.contact")} />
              </div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.4.fio")} />
              </div>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.4.organization")} />
              </div>
              <div>
                <input type="text"  {...register("outOfSchoolOrganizationEmployees.4.contact")} />
              </div>
            </div>

            <hr />
            <div className={styles.formRow6}>
              <div><strong>Критерии оценки</strong>
                <br></br>
                (потреб. ребёнка / родит. возможн./ семья и факторы окружения)</div>
              <div>Выявленные факторы риска обсужденные с ребёнком/ семьёй</div>
              <div><strong>Мероприятия</strong>
                <br></br>
                Что будет сделано для достижения поставленных целей:
                мероприятия и/или услуги, которые должны быть предоставлены
              </div>
              <div> <strong>Период реализации мероприятия</strong> </div>
              <div><strong>Cотрудник / организация/член семьи, ответственный за данное мероприятие</strong><br></br> (внутри школы или извне)</div>
              <div><strong>Фактический результат</strong><br></br>
                (Результат на момент обзора плана через 2 месяца)
              </div>
            </div>
            <div className={styles.formRow7}>
              <div>
                <div>1. Здоровье</div>
                <select {...register("childDevelopmentNeeds.healthForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.healthForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.healthForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.healthForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.healthForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("childDevelopmentNeeds.healthForm4.ratingScale")} >
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("childDevelopmentNeeds.healthForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>1.2. Образование</div>
                <select {...register("childDevelopmentNeeds.educationForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.educationForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.educationForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.educationForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.educationForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("childDevelopmentNeeds.educationForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("childDevelopmentNeeds.educationForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>1.3. Эмоц. развитие и поведение</div>
                <select {...register("childDevelopmentNeeds.emotionalDevelopmentForm4.criteria")} >
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.emotionalDevelopmentForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.emotionalDevelopmentForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.emotionalDevelopmentForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.emotionalDevelopmentForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("childDevelopmentNeeds.emotionalDevelopmentForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("childDevelopmentNeeds.emotionalDevelopmentForm4.indicator")} >
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>1.4. Идентичность </div>
                <select {...register("childDevelopmentNeeds.identityForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.identityForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.identityForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.identityForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.identityForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("childDevelopmentNeeds.identityForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("childDevelopmentNeeds.identityForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>1.5. Социальная презентация</div>
                <select {...register("childDevelopmentNeeds.socialPresentationForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.socialPresentationForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.socialPresentationForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.socialPresentationForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.socialPresentationForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("childDevelopmentNeeds.socialPresentationForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("childDevelopmentNeeds.socialPresentationForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>1.6. Семья и социальные отношения</div>
                <select {...register("childDevelopmentNeeds.familyForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.familyForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.familyForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.familyForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("childDevelopmentNeeds.familyForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("childDevelopmentNeeds.familyForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("childDevelopmentNeeds.familyForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>1.7. Навыки самообслуживания</div>
                <select {...register("childDevelopmentNeeds.selfIndependenceForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea  {...register("childDevelopmentNeeds.selfIndependenceForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea  {...register("childDevelopmentNeeds.selfIndependenceForm4.measures")}></textarea>
              </div>
              <div>
                <textarea  {...register("childDevelopmentNeeds.selfIndependenceForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea  {...register("childDevelopmentNeeds.selfIndependenceForm4.employee")}></textarea>
              </div>
              <div>
                <select  {...register("childDevelopmentNeeds.selfIndependenceForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("childDevelopmentNeeds.selfIndependenceForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />

            <div className={styles.formRowFull}>Возможности родителей</div>
            <div className={styles.formRow7}>
              <div>
                <div>2.1. Базовый уход</div>
                <select  {...register("parentSkills.basicCareForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.basicCareForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.basicCareForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.basicCareForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.basicCareForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.basicCareForm4.ratingScale")} >
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select  {...register("parentSkills.basicCareForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>2.2. Обеспечение безопасности и защита</div>
                <select {...register("parentSkills.securityForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.securityForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.securityForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.securityForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.securityForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.securityForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.securityForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>2.3. Эмоциональное тепло</div>
                <select {...register("parentSkills.emotionalHeatForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.emotionalHeatForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.emotionalHeatForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.emotionalHeatForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.emotionalHeatForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.emotionalHeatForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.emotionalHeatForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>2.4. Стабильность</div>
                <select {...register("parentSkills.stabilityForm4.criteria")} >
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.stabilityForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.stabilityForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.stabilityForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.stabilityForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.stabilityForm4.ratingScale")} >
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.stabilityForm4.indicator")} >
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>2.5.Направление, установление границ</div>
                <select {...register("parentSkills.directionBordersForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.directionBordersForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.directionBordersForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.directionBordersForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.directionBordersForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.directionBordersForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.directionBordersForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>2.6. Стимулирование </div>
                <select {...register("parentSkills.stimulationForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.stimulationForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.stimulationForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.stimulationForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.stimulationForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.stimulationForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.stimulationForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>2.7.Проблемы родителей, влияющие на их способность по уходу за детьми</div>
                <select {...register("parentSkills.parentProblemsForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.parentProblemsForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.parentProblemsForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.parentProblemsForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.parentProblemsForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.parentProblemsForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.parentProblemsForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>3.1. Жильё, работа и доход</div>
                <select {...register("parentSkills.housingWorkIncomeForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.housingWorkIncomeForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.housingWorkIncomeForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.housingWorkIncomeForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.housingWorkIncomeForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.housingWorkIncomeForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.housingWorkIncomeForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>3.2. Семейная история и функционир-е семьи</div>
                <select {...register("parentSkills.familyHistoryForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.familyHistoryForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.familyHistoryForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.familyHistoryForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.familyHistoryForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.familyHistoryForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.familyHistoryForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>3.3. Расширенная семья</div>
                <select {...register("parentSkills.extendedFamilyForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.extendedFamilyForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.extendedFamilyForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.extendedFamilyForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.extendedFamilyForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.extendedFamilyForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.extendedFamilyForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>3.4. Ресурсы общества </div>
                <select {...register("parentSkills.resourcesForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.resourcesForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.resourcesForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.resourcesForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.resourcesForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.resourcesForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.resourcesForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />
            <div className={styles.formRow7}>
              <div>
                <div>3.5. Социальная интеграция </div>
                <select {...register("parentSkills.socialIntegrationForm4.criteria")}>
                  <option value='1' >1</option>
                  <option value='2' >2</option>
                  <option value='3' >3</option>
                </select>
              </div>
              <div>
                <textarea {...register("parentSkills.socialIntegrationForm4.discoveredRiskFactors")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.socialIntegrationForm4.measures")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.socialIntegrationForm4.measurePeriod")}></textarea>
              </div>
              <div>
                <textarea {...register("parentSkills.socialIntegrationForm4.employee")}></textarea>
              </div>
              <div>
                <select {...register("parentSkills.socialIntegrationForm4.ratingScale")}>
                  <option value='DONE_GET_BAD' >Выберите</option>
                  <option value='3' >Мероприятие выполнено с прогрессом сверх нормы </option>
                  <option value='2' >Мероприятие выполнено, есть значительный сдвиг в сторону успешности </option>
                  <option value='2' >Мероприятие выполнено, но результат на том же месте</option>
                  <option value='1' >Мероприятие выполнено, но результат стал хуже</option>
                  <option value='1' >Мероприятие не выполнено </option>
                </select>
              </div>
              <select {...register("parentSkills.socialIntegrationForm4.indicator")}>
                <option value='1' >1</option>
                <option value='2' >2</option>
                <option value='3' >3</option>
              </select>
            </div>
            <hr />



          </div>
          <div className={styles.title}>
            МНЕНИЕ КАЖДОЙ ИЗ ВОВЛЕЧЁННЫХ СТОРОН
          </div>
          <div className={styles.title}>Задачи, определённые в плане, и порядок их выполнения должны быть обсуждены со всеми заинтересованными сторонами и организациями. </div>
          <div className={styles.formContainer}>
            <div className={styles.formRowFull}>
              Замечания ребёнка по поводу плана. Отметьте все моменты, с которыми ребёнок не согласен. По желанию ребёнка, эти моменты могут быть записаны отдельно.
            </div>
            <div className={styles.formRowFull}>
              <input type='textfield' {...register("opinionOfInvolvedParties.childComment")}></input>
            </div>
            <div className={styles.formRowFull}>
              Замечания по поводу плана родителей или лиц, их заменяющих. Отметьте все моменты, с которыми они не согласны.
            </div>
            <div className={styles.formRowFull}>
              <input type='textfield' {...register("opinionOfInvolvedParties.parentComment")}></input>
            </div>
            <div className={styles.formRowFull}>
              Замечания организаций и специалистов, задействованных в разработке и реализации Плана развития.
            </div>
            <div className={styles.formRowFull}>
              <input type='textfield' {...register("opinionOfInvolvedParties.organizationComment")}></input>
            </div>
          </div>
          <div className={styles.title}>ПОДПИСИ: </div>
          <div className={styles.formContainer}>
            <div className={styles.formRow3}>
              <div>ФИО родителей или лиц, их заменяющих</div>
              <div>Подпись</div>
              <div>Дата </div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text" />
              </div>
              <div>
                <input type="checkbox" />
              </div>
              <div>
                <input type="date" />
              </div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text" />
              </div>
              <div>
                <input type="checkbox" />
              </div>
              <div>
                <input type="date" />
              </div>
            </div>

            <div className={styles.formRow3}>
              <div>Имя (имена) ребёнка (детей)</div>
              <div>Подпись</div>
              <div>Дата </div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text" />
              </div>
              <div>
                <input type="checkbox" />
              </div>
              <div>
                <input type="date" />
              </div>
            </div>

            <div className={styles.formRow3}>
              <div>ФИО кейс-менеджера</div>
              <div>Подпись</div>
              <div>Дата </div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text" />
              </div>
              <div>
                <input type="checkbox" />
              </div>
              <div>
                <input type="date" />
              </div>
            </div>

            <div className={styles.formRow3}>
              <div>Руководитель какой-то нужен тут?</div>
              <div>Подпись</div>
              <div>Дата </div>
            </div>
            <div className={styles.formRow3}>
              <div>
                <input type="text" />
              </div>
              <div>
                <input type="checkbox" />
              </div>
              <div>
                <input type="date" />
              </div>
            </div>
          </div>

          <input type="submit" className={styles.btnstyle}></input>
        </form >
        <button onClick={() => getForm4Doc()} className={styles.btnstyle}>Получить форму</button><br></br>
        <button className={styles.btnstyle}><a href={link ? link : ''} >Скачать форму</a></button>
      </Card>
    </div >
  );
};
