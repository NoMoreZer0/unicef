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
  individualSafeFactor: {
    academicSuccess: true,
    active: true,
    goodLifeSkills: true,
    selfConfident: true
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
                ИНДИВИДУАЛЬНЫЕ ФАКТОРЫ ЗАЩИТЫ</div>
              <div className={styles.formRow8to2}>
                <label >1. Академические достижения/хорошая успеваемость в школе 	</label>
                <input type="checkbox" value="true" {...register("individualSafeFactor.academicSuccess")} />
                <label >2. Хорошие жизненные и социальные навыки, навыки решения проблем </label>
                <input type="checkbox" value="true" {...register("individualSafeFactor.goodLifeSkills")} />
                <label >3. Активность в решении собственных проблем</label>
                <input type="checkbox" value="true" {...register("individualSafeFactor.active")} />
                <label >4. Уверенность в себе, позитивное отношение</label>
                <input type="checkbox" value="true" {...register("individualSafeFactor.selfConfident")} />

              </div>
            </div>
          </div>
          <input type="submit" />
        </form>

      </Card>

    </div >
  );
};