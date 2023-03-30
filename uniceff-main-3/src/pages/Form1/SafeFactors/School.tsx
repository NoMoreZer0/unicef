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
  schoolSafeFactor: {
    additionalClass: true,
    additionalCreativeClass: true,
    hasNpa: true,
    inclusive: true,
    mentorship: true,
    parentProgram: true,
    prophylactic: true,
    safeSchool: true
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
                ШКОЛЬНЫЕ ФАКТОРЫ ЗАЩИТЫ</div>
              <div className={styles.formRow8to2}>
                <label >1. Безопасная школьная среда </label>
                <input type="checkbox" value="true" {...register("schoolSafeFactor.safeSchool")} />
                <label >2. Дополнительные занятия</label>
                <input type="checkbox" value="true" {...register("schoolSafeFactor.additionalClass")} />
                <label >3. Наличие НПА по политике защиты учащегося</label>
                <input type="checkbox" value="true" {...register("schoolSafeFactor.hasNpa")} />
                <label >4. Наставничество</label>
                <input type="checkbox" value="true" {...register("schoolSafeFactor.mentorship")} />
                <label >5. Программы для родительского сообщества</label>
                <input type="checkbox" value="true" {...register("schoolSafeFactor.parentProgram")} />
                <label >6. Инклюзивный подход</label>
                <input type="checkbox" value="true" {...register("schoolSafeFactor.inclusive")} />
                <label >7. Дополнительные творческие занятия/кружки</label>
                <input type="checkbox" value="true" {...register("schoolSafeFactor.additionalCreativeClass")} />
                <label >8. Профилактические программы для детей</label>
                <input type="checkbox" value="true" {...register("schoolSafeFactor.prophylactic")} />
              </div>
            </div>
          </div>
          <input type="submit" />
        </form>

      </Card>

    </div >
  );
};