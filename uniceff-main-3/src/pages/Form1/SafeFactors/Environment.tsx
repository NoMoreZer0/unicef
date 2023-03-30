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
  environmentSafeFactor: {
    economicStability: true,
    educatedParent: true,
    employedParent: true,
    medicalAccess: true,
    normalLivingCondition: true,
    resourceCoordination: true,
    socialHelp: true
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
    // const response = await formService.sendFormPart(dataForm1, Number(caseId))
    // console.log(response);

    // if (response?.id) {
    //   setFormId(response?.id);
    //   alert("Первичная форма успешно создана");
    // }
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
                СЕМЕЙНЫЕ ФАКТОРЫ ЗАЩИТЫ</div>
              <div className={styles.formRow8to2}>
                <label >1. Экономическая стабильность</label>
                <input type="checkbox" value="true" {...register("environmentSafeFactor.economicStability")} />
                <label >2. Трудоустройство родителей</label>
                <input type="checkbox" value="true" {...register("environmentSafeFactor.employedParent")} />
                <label >3. Образование у родителей</label>
                <input type="checkbox" value="true" {...register("environmentSafeFactor.educatedParent")} />
                <label >4. Нормальные жилищные условия</label>
                <input type="checkbox" value="true" {...register("environmentSafeFactor.normalLivingCondition")} />
                <label >5. Социальная поддержка</label>
                <input type="checkbox" value="true" {...register("environmentSafeFactor.socialHelp")} />
                <label >6. Доступ к медицинским, образовательным и социальным услугам для взрослых и детей</label>
                <input type="checkbox" value="true" {...register("environmentSafeFactor.medicalAccess")} />
                <label >7. Координация ресурсов и услуг</label>
                <input type="checkbox" value="true" {...register("environmentSafeFactor.resourceCoordination")} />
              </div>
            </div>
          </div>
          <input type="submit" />
        </form>

      </Card>

    </div >
  );
};