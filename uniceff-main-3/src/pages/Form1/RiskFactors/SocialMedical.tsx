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

  socMedRiskFactor: {
    greenSocMedRiskFactor: {
      legalIssues: true,
      liveOutsideFamily: true,
      noOutfit: true
    },
    redSocMedRiskFactor: {
      childLabour: true,
      domesticViolence: true,
      exploitation: true,
      withoutCareRisk: true
    },
    yellowSocMedRiskFactor: {
      badEating: true,
      earlyPregnancy: true,
      fosterCareExperience: true,
      hasHiv: true,
      invalid: true,
      lawConflict: true,
      psychicalIssue: true,
      religious: true,
      violentApproach: true,
      warRefugee: true
    }
  },
};


export function OutreachWorkerPart({currentStudentId, currentCaseId}: Props) {
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
              {/* <label >ИМЯ И ФАМИЛИЯ РЕБЕНКА:</label> */}
            </div>
            <div><div className={styles.title}>
              СОЦИАЛЬНО-МЕДИЦИНСКИЕ (информация собирается и заполняется социальным педагогом/классным руководителем/ куратором) </div>
              <div className={styles.formRow8to2}>
                <label >1. Юридические проблемы (например, отсутствие свидетельства о рождении ребенка, паспорта, прописки)</label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.greenSocMedRiskFactor.legalIssues")} />
                <label >2.	Ребенок не посещает школу (родители не заинтересованы в школьном образовании ребенка)</label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.redSocMedRiskFactor.withoutCareRisk")} />
                <label >3.	Дети/молодежь в риске (антисоциальное поведение) и конфликте с законом </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.lawConflict")} />
                <label >4.	Ранняя беременность/ Несовершеннолетние родители </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.earlyPregnancy")} />
                <label >5.	Инвалидность/наличие хронических заболеваний ребенка </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.invalid")} />
                <label >6.	Живущие с ВИЧ ребенок </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.hasHiv")} />
                <label >7.	Недостаточное и/или несбалансированное питание </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.badEating")} />
                <label >8.	Нет сезонной одежды </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.greenSocMedRiskFactor.noOutfit")} />
                <label >9.	Дети, находящиеся в риске остаться без опеки родителей или лиц их заменяющих </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.redSocMedRiskFactor.withoutCareRisk")} />
                <label >10.	Детский труд (ребенок подрабатывает, выполняет родительские обязанности в семье)  </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.redSocMedRiskFactor.childLabour")} />
                <label >11.	Домашнее насилие* </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.redSocMedRiskFactor.domesticViolence")} />
                <label >12.	Жестокое и небрежное обращения с ребенком*</label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.violentApproach")} />
                <label >13.	Опыт пребывания в институциональном учреждении (детский дом, интернаты, приюты, спец интернаты и др.) </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.fosterCareExperience")} />
                <label >14.	Психическое заболевание ребенка </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.psychicalIssue")} />
                <label >15.	Эксплуатация и траффик (сексуальное рабство, продажа органов, торговля детей) * </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.redSocMedRiskFactor.exploitation")} />
                <label >16.	Вовлечение ребенка в религиозный радикализм (экстремизм) ребенка (имеется информация от гос организации о вовлечении ребенка в данные религиозные направления)* </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.religious")} />
                <label >17.	Ребенок, вернувшийся из зон вооруженных конфликтов </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.yellowSocMedRiskFactor.warRefugee")} />
                <label >18.	Ребенок проживает вне семьи (в интернате, у родственников, знакомых или проживает один) </label>
                <input type="checkbox" value="true" {...register("socMedRiskFactor.greenSocMedRiskFactor.liveOutsideFamily")} />
              </div>
            </div>
          </div>
          <input type="submit" />
        </form>

      </Card>

    </div >
  );
};