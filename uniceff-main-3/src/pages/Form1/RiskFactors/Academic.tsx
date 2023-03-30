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
  academicRiskFactor: {
    greenAcademicRiskFactor: {
      absenceHealth: true,
      lowQualitySchoolSession: true,
      noSchoolSessions: true,
      notProvided: true,
      refuseSchoolSession: true
    },
    yellowAcademicRiskFactor: {
      absenceWithoutExcuse: true,
      lowMotivation: true,
      noParentalControl: true,
      s2sConflict: true,
      s2tConflict: true,
      t2pConflict: true,
      unsatisfactoryGrades: true
    }
  },
};

export function DoctorPart({currentStudentId, currentCaseId}: Props) {
  const formService = new FormService();
  const [role, setRole] = React.useState(String);
  const [formId, setFormId] = React.useState(Number);
  const [link, setLink] = React.useState(String);

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
                АКАДЕМИЧЕСКИЕ ТРУДНОСТИ (информация собирается  и заполняется классным руководителем/куратором ) </div>
              <div className={styles.formRow8to2}>
                <label >1. Частые попуски уроков без уважительной причины (10  и более дней в четверть) 	</label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.yellowAcademicRiskFactor.absenceWithoutExcuse")} />
                <label >2.	Неудовлетворительные оценки по нескольким предметам (есть риск быть неаттестованным по ряду предметов и остаться на второй год обучения)  </label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.yellowAcademicRiskFactor.unsatisfactoryGrades")} />
                <label >3.	Частые попуски уроков по состоянию здоровья (стационарные/амбулаторные  лечения из-за хронического заболевания, инвалидности)</label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.greenAcademicRiskFactor.absenceHealth")} />
                <label >4.	Ребенок не обеспечен всем необходимым для школьного образования (школьной формой, обувью, школьными канцелярским товарами)    </label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.greenAcademicRiskFactor.notProvided")} />
                <label >5.	Низкая учебная мотивация ребенка  по разным причинам </label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.yellowAcademicRiskFactor.lowMotivation")} />
                <label >6.	Конфликтные отношения между учениками</label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.yellowAcademicRiskFactor.s2sConflict")} />
                <label >7.	Отсутствие  родительского контроля. Ребенок отдан на воспитание бабушке/дедушке  и др.</label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.yellowAcademicRiskFactor.noParentalControl")} />
                <label >8.	Школой не предоставляются дополнительные занятиям/консультации  </label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.greenAcademicRiskFactor.noSchoolSessions")} />
                <label >9. Ученик не посещает (не желает/отказывается) от предлагаемых  дополнительных занятий/консультаций в школе</label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.greenAcademicRiskFactor.refuseSchoolSession")} />
                <label >10. Дополнительные занятия/консультации в школе предоставляются не качественно (отсутствует график/ученик  и его родитель не ознакомлены с графиком доп. занятий; частые замены учителя/отсутствие учителя и др.)</label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.greenAcademicRiskFactor.lowQualitySchoolSession")} />
                <label >11. Конфликтные отношения между учителем-родителем</label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.yellowAcademicRiskFactor.t2pConflict")} />
                <label >12. Конфликтные отношения между учеником-учителем</label>
                <input type="checkbox" value="true" {...register("academicRiskFactor.yellowAcademicRiskFactor.s2tConflict")} />
              </div>
            </div>
          </div>
          <input type="submit" />
        </form>

      </Card>

    </div >
  );
};