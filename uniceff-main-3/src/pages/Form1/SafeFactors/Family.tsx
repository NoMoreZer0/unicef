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
  familySafeFactor: {
    basicNeed: true,
    caringParent: true,
    familyRuleSet: true,
    goodParentSkills: true,
    positivePractice: true,
    roleModel: true,
    safeBonding: true,
    stability: true,
    supportingEnvironment: true,
    sustainableRelation: true
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
                СЕМЕЙНЫЕ ФАКТОРЫ ЗАЩИТЫ</div>
              <div className={styles.formRow8to2}>
                <label >1. Безопасная привязанность</label>
                <input type="checkbox" value="true" {...register("familySafeFactor.safeBonding")} />
                <label >2. Заботливый родитель/взрослый член семьи</label>
                <input type="checkbox" value="true" {...register("familySafeFactor.caringParent")} />
                <label >3. Стабильность в семье</label>
                <input type="checkbox" value="true" {...register("familySafeFactor.stability")} />
                <label >4. Хорошие родительские навыки воспитания </label>
                <input type="checkbox" value="true" {...register("familySafeFactor.goodParentSkills")} />
                <label >5. Позитивная родительская практика</label>
                <input type="checkbox" value="true" {...register("familySafeFactor.positivePractice")} />
                <label >6. Поддержка базовых потребностей</label>
                <input type="checkbox" value="true" {...register("familySafeFactor.basicNeed")} />
                <label >7. Устойчивые семейные отношения  </label>
                <input type="checkbox" value="true" {...register("familySafeFactor.sustainableRelation")} />
                <label >8. Установленные семейные правила и уход за детьми</label>
                <input type="checkbox" value="true" {...register("familySafeFactor.familyRuleSet")} />
                <label >9. Заботливые взрослые вне семьи, кто служит в качестве ролевых моделей или наставников</label>
                <input type="checkbox" value="true" {...register("familySafeFactor.roleModel")} />
                <label >10. Поддерживающее семейное окружение и социальные сети</label>
                <input type="checkbox" value="true" {...register("familySafeFactor.supportingEnvironment")} />
              </div>
            </div>
          </div>
          <input type="submit" />
        </form>

      </Card>

    </div >
  );
};