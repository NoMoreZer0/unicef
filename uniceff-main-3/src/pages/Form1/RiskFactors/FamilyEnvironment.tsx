// @flow
import * as React from 'react';
import styles from './form1.module.scss';
import {SubmitHandler, useForm} from "react-hook-form";
import {FormService} from '../../../services/FormService';
import {Card} from '@mui/material';

type Props = {
  currentStudentId: Number;
  currentCaseId: Number;
};

type Inputs = {
  familyRiskFactor: {
    greenFamilyRiskFactor: {
      financialProblem: true,
      instituteParent: true,
      invalidParent: true,
      littleAccessService: true,
      manyKids: true,
      migrantParents: true,
      noSocialHelp: true,
      noTransport: true,
      oldParent: true,
      partialFamily: true,
      pregnantWithKids: true,
      uneducatedParents: true,
      unemployedMember: true,
      weakParents: true
    },
    yellowFamilyRiskFactor: {
      alcoNarco: true,
      badHousing: true,
      badMedicals: true,
      culturalNorms: true,
      discriminated: true,
      divorcedParents: true,
      failedBonding: true,
      familyConflicts: true,
      hivParents: true,
      homelessParents: true,
      imprisonedParents: true,
      lowIncome: true,
      psychoParents: true,
      religiousParent: true,
      socialIsolation: true,
      warRefugee: true
    }
  },
};

export function InspectorPart({currentStudentId, currentCaseId}: Props) {
  const formService = new FormService();
  const [role, setRole] = React.useState(String);
  const [formId, setFormId] = React.useState(Number);
  const [link, setLink] = React.useState(String);

  const studentId = currentStudentId;
  const caseId = currentCaseId;

  const {register, handleSubmit, formState: {errors}} = useForm<Inputs>({
  });

  const onSubmit = async dataForm1 => {
    // const response = await formService.sendForm(dataForm1, Number(studentId), Number(caseId))
    // console.log(response);

    // if (response?.id) {
    //   setFormId(response?.id);
    //   alert("Первичная форма успешно создана");
    // }
  };

  async function getForm1Doc() {
    const res = await formService.downloadForm1(formId);
    console.log(res)
    setLink(res.Link)
  }

  return (
    <div className={styles.container}>
      <Card>
        <form onSubmit={handleSubmit(onSubmit)}>
          <div className={styles.formContainer}>
            <div className={styles.formRow}>
              <label >ИМЯ И ФАМИЛИЯ РЕБЕНКА:</label>
            </div>
            <div>
              <div className={styles.title}>
                СЕМЬЯ И ОКРУЖЕНИЕ(информация собирается  и заполняется социальным педагогом/  классным руководителем/куратором) </div>
              <div className={styles.formRow8to2}>
                <label >1.	Многодетная семья (4 детей/молодежь и более совместно проживающие) </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.manyKids")} />
                <label >2.	Родители в трудовой миграции </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.migrantParents")} />
                <label >3.	Семьи, где член(ы) семьи имеют алкогольную или наркотическую зависимость </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.alcoNarco")} />
                <label >4.	Родители или члены семьи вышедшие из мест заключения </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.imprisonedParents")} />
                <label >5.	Родители относятся к людям без определенного места жительства </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.homelessParents")} />
                <label >6.	Низкий образовательный уровень родителей </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.uneducatedParents")} />
                <label >7.	Слабые родительские компетенции</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.weakParents")} />
                <label >8.	Нарушенная привязанность в детско-родительских отношениях </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.failedBonding")} />
                <label >9.	Развод/хронический развод (многожёнство, сожительство, живут раздельно без развода и др.) </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.partialFamily")} />
                <label >10. Отсутствие жилья или плохие условия проживания </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.badHousing")} />
                <label >11.	Отсутствие медикаментов и медицинского лечения у родителей</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.badMedicals")} />
                <label >12.	Отсутствие транспорт (напр., для посещения медицинских услуг человеком с инвалидностью) </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.noTransport")} />
                <label >13.	Временные финансовые трудности в семье</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.financialProblem")} />
                <label >14.	Культурные нормы в семье, которые поддерживают насилие или неравенство </label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.culturalNorms")} />
                <label >15.	Психическое заболевание родителя/члена семьи</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.psychoParents")} />
                <label >16.	Семейные конфликты (конфликты между супругами, детьми и родителями, между невесткой и свекровью)</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.familyConflicts")} />
                <label >17.	Малоимущая семья (среднедушевой доход ниже прожиточного минимума  (37389 тысяч тенге) за последние 12 месяцев)</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.lowIncome")} />
                <label >18.	Престарелые и пожилые родители</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.oldParent")} />
                <label >19.	Беременные мамы с маленькими детьми</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.pregnantWithKids")} />
                <label >20.	Семья с детьми с одним родителем</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.divorcedParents")} />
                <label >21.	Опыт родителя  пребывания в институциональном учреждении (детский дом, интернаты, приюты и др)</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.instituteParent")} />
                <label >22.	Отсутствие  социальной поддержки семьи (несмотря на то что он имеет право на АСП)</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.noSocialHelp")} />
                <label >23.	Социальная изоляция (семья не общается ни с кем)</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.socialIsolation")} />
                <label >24. Недостаточный доступ к услугам в местном сообществе (например, в сельской местности)</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.littleAccessService")} />
                <label >25.	Дискриминация семьи или членов семьи в обществе</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.discriminated")} />
                <label >26.	Безработный член семьи/самозанятый сезонный рабочий с низким доходом   (стоит на бирже труда/сокращение/банкротство и др)</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.unemployedMember")} />
                <label >27.	Живущие с ВИЧ родитель/член семьи</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.hivParents")} />
                <label >28.	Инвалидность родителя/члена семьи</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.greenFamilyRiskFactor.invalidParent")} />
                <label >29.Семьи, вернувшиеся из зон вооруженных конфликтов</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.warRefugee")} />
                <label >30.	Религиозная радикализация (экстремизм) родителя/члена семьи*</label>
                <input type="checkbox" value="true" {...register("familyRiskFactor.yellowFamilyRiskFactor.religiousParent")} />
              </div>
            </div>
          </div>
          <input type="submit" />
        </form>
      </Card>


    </div >
  );
};