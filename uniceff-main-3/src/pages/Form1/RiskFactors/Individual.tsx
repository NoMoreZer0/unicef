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
  individualRiskFactor: {
    redIndividualRiskFactor: {
      riskyBehaviour: true,
      suicideRisk: true
    },
    yellowIndividualRiskFactor: {
      bullied: true,
      grief: true,
      physMentalDisorder: true,
      psychoemotional: true,
      selfHarm: true,
      stressTrauma: true,
      weakSelfService: true
    }
  },
};

export function CuratorPart({currentStudentId, currentCaseId}: Props) {
  const formService = new FormService();
  const [formId, setFormId] = React.useState(Number);
  const studentId = currentStudentId;
  const caseId = currentCaseId;

  const {register, handleSubmit, formState: {errors}} = useForm<Inputs>({

  });

  const onSubmit = async dataForm1 => {
    const response = await formService.sendFormPart(dataForm1, Number(caseId))
    console.log(response);

    if (response?.id) {
      setFormId(response?.id);
      alert("Первичная форма успешно создана");
    }
  };


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
                ИНДИВИДУАЛЬНЫЕ ФАКТОРЫ  (заполняется  педагогом-психологом/классным руководителем/куратором ) </div>
              <div className={styles.formRow8to2}>
                <label >1.	Несуицидальное самоповреждающее поведение (самопорезы, самоудары, самоожоги и др.) </label>
                <input type="checkbox" value="true" {...register("individualRiskFactor.yellowIndividualRiskFactor.selfHarm")} />
                <label >2.	Рискованное поведение (ранние половые отношения,употребление психоактивных веществ, алкоголя, табака, вандализм, вождение автомобиля без прав, участник буллинга/кибербуллинг)</label>
                <input type="checkbox" value="true" {...register("individualRiskFactor.redIndividualRiskFactor.riskyBehaviour")} />
                <label >3.	Риск самоубийства/история попыток совершения суицида</label>
                <input type="checkbox" value="true" {...register("individualRiskFactor.redIndividualRiskFactor.suicideRisk")} />
                <label >4.	Переживание горя утраты  </label>
                <input type="checkbox" value="true" {...register("individualRiskFactor.yellowIndividualRiskFactor.grief")} />
                <label >5.	Ребенок подвергается буллингу в школе </label>
                <input type="checkbox" value="true" {...register("individualRiskFactor.yellowIndividualRiskFactor.bullied")} />
                <label >6.	Дети, испытавшие стресс/ травму</label>
                <input type="checkbox" value="true" {...register("individualRiskFactor.yellowIndividualRiskFactor.stressTrauma")} />
                <label >7.	Нарушения физического и умственного развития </label>
                <input type="checkbox" value="true" {...register("individualRiskFactor.yellowIndividualRiskFactor.physMentalDisorder")} />
                <label >8.	Слабые навыки самообслуживания </label>
                <input type="checkbox" value="true" {...register("individualRiskFactor.yellowIndividualRiskFactor.weakSelfService")} />
                <label >9.	Психоэмоциональные проблемы у ребенка  (тревожность, агрессивность, страхи и др)</label>
                <input type="checkbox" value="true" {...register("individualRiskFactor.yellowIndividualRiskFactor.psychoemotional")} />


              </div>
            </div>
          </div>
          <input type="submit" />
        </form>
      </Card>
    </div >
  );
};