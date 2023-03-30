// @flow
import * as React from 'react';
import {SubmitHandler, useForm} from 'react-hook-form';
import styles from './Form2.module.scss';
import {FormService} from '../../services/FormService';
import {useParams} from 'react-router-dom';
import {Alert} from '@mui/material';
import {Card} from '@mui/material';

type Props = {
  currentStudentId: Number;
  currentCaseId: Number;
};

type Inputs = {
  aboutFamily: {
    greenAboutFamily: {
      noHaveOwnHouse: true
    },
    yellowAboutFamily: {
      avaryHome: true,
      currentHomeBad: true,
      familyNoTakeNeededAllowance: true,
      haveMaterialIssue: true,
      parentUnemployed: true
    }
  },
  educationSection: {
    greenEducationSection: {
      haveSchoolFriend: true,
      noBelovedSubject: true,
      noParticipatedInClub: true
    },
    redEducationSection: {
      noLikeAttend: true,
      oftenMiss: true,
      specialNeed: true,
      studyingTrouble: true
    },
    yellowEducationSection: {
      noComputer: true,
      noConcentration: true,
      noDiscipline: true,
      noHomeworkSpace: true,
      noKancellary: true,
      noMotivation: true,
      noUniform: true,
      partTime: true,
      teacherConflict: true
    }
  },
  emotionalIntelligence: {
    bloodyRedEmotionalIntelligence: {
      aggressor: true,
      anxiety: true,
      bullied: true,
      depression: true,
      suicidalAction: true,
      suicidalDream: true
    },
    redEmotionalIntelligence: {
      cantShareThoughtsWithAdult: true,
      defiantBehavior: true,
      goingHomeLate: true,
      isBully: true,
      leavedHome: true,
      seenConflict: true,
      selfHarm: true
      //isBully - CHECK____________________________
    },
    yellowEmotionalIntelligence: {
      easilyUpset: true,
      emotionalAlone: true,
      leftHome: true,
      noControlEmotion: true,
      noGoodBad: true,
      noSchoolFriends: true,
      noSocietyNorms: true,
      outsideHome: true,
      riskyBehaviour: true,
      robbery: true,
      selfHarm: true,
      uchet: true,
      witnessConflict: true,
      zadira: true
    }
  },
  familySection: {
    bloodyRedFamilySection: {
      abusiveBehaviorOfParents: true,
      notSecuredFromSexualAffection: true
    },
    greenFamilySection: {
      noSpareTime: true,
      parentsChanged: true
    },
    redFamilySection: {
      constantlySeeingConflicts: true
    },
    yellowFamilySection: {
      chronic: true,
      farAway: true,
      noAdultDepend: true,
      noBondingParentKid: true,
      noFriend: true,
      noLikeFamilyMember: true,
      noParentSkill: true,
      noPositiveWithParent: true,
      problemParentKid: true,
      sudimost: true,
      takeParentRole: true,
      traumaPast: true
    }
  },
  healthSection: {
    greenHealthSection: {
      notActive: true,
      notVaccinated: true
    },
    redHealthSection: {
      badCoordination: true,
      badHabits: true,
      incontinence: true,
      noGlasses: true,
      notEatWell: true,
      speechIssues: true
    },
    yellowHealthSection: {
      haveHealthIssues: true,
      healthIssues: "MULTIPLE_ISSUES",
      noChronicAttachment: true,
      noHeightWeightRatio: true,
      noPedSocMed: true,
      noPolyclinicAttachment: true,
      noRegularHealthCheck: true,
      noSleep: true,
      phobia: true,
      trauma: true
    }
  },
  identitySection: {
    greenIdentitySection: {
      noConfident: true,
      noCulture: true,
      noHappyLook: true,
      noIndependent: true
    },
    redIdentitySection: {
      discrimination: true,
      genderAcceptanceProblem: true
    },
    yellowIdentitySection: {
      certainGenderProblem: true,
      noDecisionMaker: true,
      noFamilyBelong: true,
      noHygiene: true,
      noPositiveIndividual: true
    }
  },
  securitySection: {
    greenSecuritySection: {
      noKnowProblem: true,
      noPraise: true,
      noSchedule: true
    },
    redSecuritySection: {
      parentNotAbleToProvideBasicThing: true,
      parentsNotGoesToDoctorWhenNeeded: true
    },
    yellowSecuritySection: {
      frequentSchoolChange: true,
      haveEducationEnv: true,
      noLawFamily: true,
      parentNoInterestWhere: true
    }
  },
  selfIndependence: {
    greenSelfIndependence: {
      noMoneySkill: true,
      noPoowrenie: true,
      noPracticalSkill: true
    },
    yellowSelfIndependence: {
      notAbleToCareHimself: true
    }
  }
}

export function Form2({currentStudentId, currentCaseId}: Props) {
  const {register, handleSubmit, watch, formState: {errors}} = useForm<Inputs>({
    defaultValues: {
      emotionalIntelligence: {
        bloodyRedEmotionalIntelligence: {
          anxiety: true,
        },
        redEmotionalIntelligence: {
          cantShareThoughtsWithAdult: true,
          isBully: true,
        },
        yellowEmotionalIntelligence: {
          easilyUpset: true,
          emotionalAlone: true,
          leftHome: true,
          noControlEmotion: true,
          noGoodBad: true,
          noSchoolFriends: true,
          noSocietyNorms: true,
          outsideHome: true,
          riskyBehaviour: true,
          robbery: true,
          selfHarm: true,
          uchet: true,
          witnessConflict: true,
          zadira: true
        }
      },
    }
  }
  );
  const formService = new FormService();
  const [formId, setFormId] = React.useState(Number);
  const [link, setLink] = React.useState(String);

  const onSubmit = async dataForm2 => {
    const response = await formService.sendSecondForm(dataForm2, 3, 2)
    console.log(dataForm2)
    if (response) {
      console.log(response !== null);
      setFormId(response?.id);
      alert("Вторичная форма успешно создана");
      // <Alert severity="success" color="success">
      //   Вторичная форма успешно создана
      // </Alert>
    }
  };
  async function getForm2Doc() {
    const res = await formService.downloadForm2(formId);
    console.log(res.Link)
    setLink(res.Link)
  }

  return (
    <div className={styles.container}>
      <Card sx={{minWidth: 275, padding: 5}} variant="outlined">
        <form onSubmit={handleSubmit(onSubmit)}>
          <div className={styles.title}>1.	ПОТРЕБНОСТИ РЕБЕНКА В РАЗВИТИИ </div>
          <div className={styles.title}>1.1.	Общие с ведения: </div>
          <div className={styles.formContainer}>
            <div className={styles.formRow}>
              <label>ФИО ребёнка</label>
              <input type="text" />
              <label>Телефон</label>
              <input type="text" />
              <label>Кейс №:"</label>
              <input type="text" />
              <label>Пол</label>
              <select>
                <option >Выберите:</option>
                <option value='FEMALE' >Женский</option>
                <option value="MALE" >Мужской</option>
              </select>
              <label>Кейс-менеджер: </label>
              <input type="text" />
              <label>Контактная информация</label>
              <input type="text" />
            </div>
          </div>
          <div className={styles.title}>1.2.	ЗДОРОВЬЕ  </div>
          <div className={styles.formContainer}>
            <div className={styles.formRow8to2}>
              <div>Вопросы:</div>
              <div>Ответы:</div>
            </div>
            <div className={styles.formRow8to2}>
              <div>Есть ли у ребенка какие-либо особые проблемы со здоровьем (хронические заболевания либо специальные потребности)?</div>
              <select  {...register("healthSection.yellowHealthSection.haveHealthIssues")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребенка есть особые проблемы со здоровьем (хронические заболевания либо специальные потребности)</div>
              <select  {...register("healthSection.yellowHealthSection.healthIssues")}>
                <option value="PSYCHO_DISORDER">психическое нарушение</option>
                <option value="PHYSICAL_DISORDER">физическое нарушение </option>
                <option value="MULTIPLE_ISSUES">множественные нарушения</option>
                <option value="SENSORIAL_DISORDER">сенсорные нарушения </option>
                <option value="NONE">нет</option>
                <option value="OTHER">другое </option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок  НЕ состоит на учете  у каких-либо специалистов, имея хроническое заболевание</div>
              <select  {...register("healthSection.yellowHealthSection.noChronicAttachment")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок НЕ получил необходимые прививки в соответствии с национальными стандартами (прививки для защиты от кори и т. д.)?</div>
              <select  {...register("healthSection.greenHealthSection.notVaccinated")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок с ограниченными возможностями здоровья НЕ получает необходимую педагогическую/социальную/медицинскую поддержку</div>
              <select {...register("healthSection.yellowHealthSection.noPedSocMed")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок НЕ прикреплен к государственной поликлинике по месту жительства или обслуживается в частной организации здравоохранения</div>
              <select  {...register("healthSection.yellowHealthSection.noPolyclinicAttachment")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок НЕ проходит обследование или медицинский осмотр у семейного врача/стоматолога и др. специалистов?</div>
              <select  {...register("healthSection.yellowHealthSection.noRegularHealthCheck")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок  НЕ получает соответствующую питательную, полезную еду/ или отказывается принимать школьную пищу /дома, со  слов ребенка, тоже ограничивает прием пищи</div>
              <select {...register("healthSection.redHealthSection.notEatWell")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок  НЕ занимается активными видами деятельности, такими как спорт, танцы и т.д.</div>
              <select {...register("healthSection.greenHealthSection.notActive")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> <div className={styles.formRow8to2}>
              <div>Ребенок с проблемами здоровья  (плохим зрением/слухом, физическим недостатком) НЕ  имеет  очки/ слуховой аппарат и др. оборудование, которые ему необходимы по медицинским показаниям</div>
              <select {...register("healthSection.redHealthSection.noGlasses")} >
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> <div className={styles.formRow8to2}>
              <div>Координация  ребенка нарушена при выполнении таких действий, как ходьба, бег и т. д.</div>
              <select {...register("healthSection.redHealthSection.badCoordination")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            {/* <div className={styles.formRow8to2}>
              <div>Хорошо ли координируется ребенок, когда пишет, рисует, играет в конструкторе «Лего» и т.д.?</div>
              <select {...register("healthSection.redHealthSection.fineMotorSkills")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>  */}
            <div className={styles.formRow8to2}>
              <div>Рост и вес  ребенка НЕ  соответствуют его/её возрасту</div>
              <select {...register("healthSection.yellowHealthSection.noHeightWeightRatio")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребенка   есть необычные фобии или страхи</div>
              <select  {...register("healthSection.yellowHealthSection.phobia")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div >Ребенок имеет вредные привычки (курит/ электронные сигареты/ употребляет алкоголь, наркотики и т. д.)</div>
              <select {...register("healthSection.redHealthSection.badHabits")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            {/* <div className={styles.formRow8to2}>
              <div>Соблюдает ли ребенок личную гигиену? (чистит зубы, умывается, следит за интимной гигиеной, одежда опрятная и т.д.)</div>
              <select {...register("healthSection.yellowHealthSection.isNeat")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> */}
            <div className={styles.formRow8to2}>
              <div>Ребенок часто мочится в постель или испражняется без физических причин</div>
              <select  {...register("healthSection.redHealthSection.incontinence")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок НЕ соблюдает  режим бодрствования и сна, количество сна менее 8 часов</div>
              <select  {...register("healthSection.yellowHealthSection.noSleep")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            <div className={styles.formRow8to2}>
              <div>Ребенок часто получает непреднамеренные повреждения и травмы ( в течение года от 2 и более раз)</div>
              <select  {...register("healthSection.yellowHealthSection.trauma")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            <div className={styles.formRow8to2}>
              <div>Ребенок  имеет сложности в способах общения  (заикание,  задержка речевого развития и т.п)</div>
              <select  {...register("healthSection.redHealthSection.speechIssues")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            {/* <div className={styles.formRow8to2}>
              <div>Есть ли у ребенка трудности с артикуляцией или звуками речи (заикание, ЗРР и т.п.)</div>
              <select  {...register("healthSection.redHealthSection.noVoiceIssues")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Есть ли у ребенка хороший круг друзей? (Например, приходят ли друзья в дом и играют и/или приглашают ли ребенка, друзья не замечены в девиантном поведении?)</div>
              <select {...register("healthSection.yellowHealthSection.haveFriends")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> */}
          </div>
          <div className={styles.title}>1.3.	ОБРАЗОВАНИЕ  </div>
          <div className={styles.formContainer}>
            <div className={styles.formRow8to2}>
              <div>Вопросы:</div>
              <div>Ответы:</div>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенку НЕ  нравится   ходить в школу</div>
              <select {...register("educationSection.redEducationSection.noLikeAttend")} >
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> <div className={styles.formRow8to2}>
              <div>У ребенка НЕТ  любимых предметов в школе</div>
              <select  {...register("educationSection.greenEducationSection.noBelovedSubject")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> <div className={styles.formRow8to2}>
              <div>Ребенок работает (подрабатывает) в свободное от учебы времени</div>
              <select  {...register("educationSection.yellowEducationSection.partTime")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> <div className={styles.formRow8to2}>
              <div>Ребенок ведёт вызывающе и нарушает дисциплину в школе</div>
              <select  {...register("educationSection.yellowEducationSection.noDiscipline")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> <div className={styles.formRow8to2}>
              <div>У ребёнка есть  школьный друг</div>
              <select  {...register("educationSection.greenEducationSection.haveSchoolFriend")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> <div className={styles.formRow8to2}>
              <div>У ребенка  есть специальные образовательные  потребности (занимается по индивидуальному плану) </div>
              <select  {...register("educationSection.redEducationSection.specialNeed")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            <div className={styles.formRow8to2}>
              <div>У ребенка  есть трудности в усвоении школьной программы</div>
              <select  {...register("educationSection.redEducationSection.studyingTrouble")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            <div className={styles.formRow8to2}>
              <div>Ребёнок  часто ли пропускает школу/отдельные уроки без уважительной причины (больше трех дней подряд без справок и объяснительных)</div>
              <select  {...register("educationSection.redEducationSection.oftenMiss")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            <div className={styles.formRow8to2}>
              <div>У ребенка наблюдается недостаток концентрации внимания, который мешает учёбе</div>
              <select  {...register("educationSection.yellowEducationSection.noConcentration")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребенок НЕ  посещает  какие-либо кружки, клубы в школе или других местах </div>
              <select  {...register("educationSection.greenEducationSection.noParticipatedInClub")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребенок НЕ  имеет  необходимые канцелярские принадлежности для обучения</div>
              <select  {...register("educationSection.yellowEducationSection.noKancellary")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>У  ребёнка НЕТ  компьютера, планшета/телефона, необходимые для школьного образования </div>
              <select  {...register("educationSection.yellowEducationSection.noComputer")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребенок  НЕ оснащен необходимой школьной формой и сезонной одеждой для посещения образовательного учреждения</div>
              <select  {...register("educationSection.yellowEducationSection.noUniform")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребёнка  конфликт с учителем/сотрудником школы (например, открытая конфронтация, занижение оценок и т. д.)</div>
              <select  {...register("educationSection.yellowEducationSection.teacherConflict")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок  НЕ имеет в доме оборудованное место для выполнения домашних заданий (стол, стул, никто не отвлекает)</div>
              <select  {...register("educationSection.yellowEducationSection.noHomeworkSpace")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок НЕ  посещает школу из-за  проблем в  поведении (бродяжничество, асоциальное /оппозиционное/аморальное поведение). СРОЧНЫЕ МЕРЫ !!!</div>
              <select  {...register("educationSection.yellowEducationSection.noMotivation")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Низкая учебная мотивация ребенка из-за психологического давления   со стороны родителей</div>
              <select  {...register("educationSection.yellowEducationSection.noMotivation")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
          </div>
          <div className={styles.title}>1.4.	ЭМОЦИОНАЛЬНОЕ РАЗВИТИЕ И ПОВЕДЕНИЕ</div>
          <div className={styles.formContainer}>
            <div className={styles.formRow8to2}>
              <div>Вопросы</div>
              <div>Ответы</div>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок легко расстраивается, эмоционально не стабилен?</div>
              <select  {...register("emotionalIntelligence.yellowEmotionalIntelligence.easilyUpset")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребёнок  НЕ может  заводить и поддерживать дружбу со сверстниками</div>
              <select {...register("emotionalIntelligence.yellowEmotionalIntelligence.noSchoolFriends")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            <div className={styles.formRow8to2}>
              <div>В течение последнего месяца испытывал (а):
                симптомы депрессии (грусть, апатия, потеря интереса к окружающему и др.)  СРОЧНЫЕ МЕРЫ!!!!
              </div>
              <select {...register("emotionalIntelligence.bloodyRedEmotionalIntelligence.depression")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            {/* <div className={styles.formRow8to2}>
              <div>Есть ли у ребенка необычные фобии или страхи?</div>
              <select {...register("emotionalIntelligence.greenEmotionalIntelligence.havePhobia")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div> */}
            <div className={styles.formRow8to2}>
              <div>Ребенок подвергается буллингу в школе?</div>
              <select {...register("emotionalIntelligence.bloodyRedEmotionalIntelligence.bullied")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            <div className={styles.formRow8to2}>
              <div>Ребенок часто находится вне дома допоздна без разрешения родителей.</div>
              <select {...register("emotionalIntelligence.redEmotionalIntelligence.goingHomeLate")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребенок часто эмоционально отстраняется / много времени проводит в одиночестве?</div>
              <select {...register("emotionalIntelligence.yellowEmotionalIntelligence.emotionalAlone")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребёнок когда-либо сознательно наносил себе самоповреждения  (самопорезы, самоожоги, самоудары,  кроме пирсинга и татуировок)</div>
              <select {...register("emotionalIntelligence.redEmotionalIntelligence.selfHarm")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребенок имеет случаи, когда он сбегал из дома</div>
              <select {...register("emotionalIntelligence.redEmotionalIntelligence.leavedHome")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребенок задирает детей в классе или школе</div>
              <select {...register("emotionalIntelligence.yellowEmotionalIntelligence.zadira")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребенок демонстрирует вызывающее поведение, которое угрожает его безопасности</div>
              <select {...register("emotionalIntelligence.redEmotionalIntelligence.defiantBehavior")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            <div className={styles.formRow8to2}>
              <div>Ребенок является свидетелем конфликтов, приводящих к небезопасному поведению взрослых</div>
              <select {...register("emotionalIntelligence.redEmotionalIntelligence.seenConflict")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок НЕ умеет контролировать собственные эмоции</div>
              <select {...register("emotionalIntelligence.yellowEmotionalIntelligence.noControlEmotion")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок  высказывает суицидальные мысли/намерения.
                СРОЧНЫЕ МЕРЫ!!!!
              </div>
              <select {...register("emotionalIntelligence.bloodyRedEmotionalIntelligence.suicidalDream")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок в течение года совершил попытку суицида. СРОЧНЫЕ МЕРЫ!!!!</div>
              <select {...register("emotionalIntelligence.bloodyRedEmotionalIntelligence.suicidalAction")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок совершал/совершает кражи</div>
              <select {...register("emotionalIntelligence.yellowEmotionalIntelligence.robbery")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок состоит на учете по правонарушениям (в инспекции по делам несовершеннолетних)</div>
              <select {...register("emotionalIntelligence.yellowEmotionalIntelligence.uchet")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок в школе  является агрессором (буллером) (издевательства, вымогательства, запугивание детей и др.).   СРОЧНЫЕ МЕРЫ!!!!</div>
              <select {...register("emotionalIntelligence.bloodyRedEmotionalIntelligence.aggressor")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>  <div className={styles.formRow8to2}>
              <div>Ребенок  НЕ различает хорошее и плохое </div>
              <select {...register("emotionalIntelligence.yellowEmotionalIntelligence.noGoodBad")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>  <div className={styles.formRow8to2}>
              <div>В общественных местах ребенок  НЕ ведет себя в соответствии с общественными нормами</div>
              <select {...register("emotionalIntelligence.yellowEmotionalIntelligence.noSocietyNorms")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
          </div>

          <div className={styles.title}>1.5.	ИДЕНТИЧНОСТЬ И СОЦИАЛЬНАЯ ПРЕЗЕНТАЦИЯ</div>
          <div className={styles.formContainer}>
            <div className={styles.formRow8to2}>
              <div>Вопросы</div>
              <div>Ответы</div>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок  испытывает дискриминацию по признаку расы, пола, сексуальной ориентации, инвалидности или религиозных убеждений и т. д.</div>
              <select  {...register("identitySection.redIdentitySection.discrimination")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребенка  НЕТ  ощущения принадлежности к семье и того, что семья его принимает</div>
              <select {...register("identitySection.yellowIdentitySection.noFamilyBelong")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребёнок  испытывает трудности при общении  с людьми определенного пола ( мальчик/ девочка общается только с девочками или только с мальчиками, и/или испытывает трудности при общении с людьми его же пола) </div>
              <select {...register("identitySection.yellowIdentitySection.certainGenderProblem")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребёнока  есть трудности восприятия своего пола (мальчик/девочка)</div>
              <select {...register("identitySection.redIdentitySection.genderAcceptanceProblem")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребенка   НЕ  развито  позитивное ощущение собственной индивидуальности.</div>
              <select {...register("identitySection.yellowIdentitySection.noPositiveIndividual")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребёнок НЕ способен принимать решения по необходимым вопросам в соответствии своего возраста (рассказать о себе, ориентироваться в расписании уроков, знать время, дорогу до школы и обратно, адрес проживания, самостоятельно собрать школьный рюкзак и т. д.)</div>
              <select {...register("identitySection.yellowIdentitySection.noDecisionMaker")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок не уверен в себе и испытывает   трудности в отношениях со сверстниками и обществом в целом (например, коммуникативные и др.) </div>
              <select {...register("identitySection.greenIdentitySection.noConfident")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок  НЕ удовлетворен своим внешним видом.   Ребенок   провоцирует и бросает вызов своим внешним видом (одевается не в соответствии со своим полом, цветной, яркий окрас волос, яркий, вызывающий  макияж, эпатажнность в одежде и др).</div>
              <select {...register("identitySection.greenIdentitySection.noHappyLook")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребенка  НЕ развито/ развивается ощущение культурной и этнической принадлежности  (не знает традиции своей культуры, язык  и т. д.).</div>
              <select {...register("identitySection.greenIdentitySection.noCulture")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок НЕ самостоятелен  для своего возраста</div>
              <select {...register("identitySection.greenIdentitySection.noIndependent")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребёнок  НЕ ухожен, не опрятен. Не соблюдает гигиену</div>
              <select {...register("identitySection.yellowIdentitySection.noHygiene")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
          </div>


          <div className={styles.title}>1.6.	СЕМЬЯ И СОЦИАЛЬНЫЕ ОТНОШЕНИЯ</div>
          <div className={styles.formContainer}>
            <div className={styles.formRow8to2}>
              <div>Вопросы</div>
              <div>Ответы</div>
            </div>
            <div className={styles.formRow8to2}>
              <div></div>
              <select >
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребёнка НЕТ прочных и позитивных отношений с родителями/родителем </div>
              <select {...register("familySection.yellowFamilySection.noPositiveWithParent")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребёнка  НЕТ взрослого (родителя/ родственника), которому он может довериться</div>
              <select {...register("familySection.yellowFamilySection.noAdultDepend")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Жестокое и небрежное обращение с детьми. Домашнее насилие  (все виды насилия). Физическое и эмоциональное небрежное обращение. Экономическое насилие и принуждение. Детский труд и эксплуатация. СРОЧНЫЕ МЕРЫ!!!!</div>
              <select {...register("familySection.bloodyRedFamilySection.abusiveBehaviorOfParents")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>В отношениях между родителями и детьми НЕТ  привязанности</div>
              <select {...register("familySection.yellowFamilySection.noBondingParentKid")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>В семейном окружении, ребенка есть люди, которые не нравятся ребенку.  Ребенок о них плохо отзывается</div>
              <select {...register("familySection.yellowFamilySection.noLikeFamilyMember")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребенка  НЕТ   хорошего круга друзей (например,  к ребенку   не приходят в дом сверстники  и  не играют, не дружат с  с ним, не  приглашают ребенка к себе домой и /или не проводят с ним досуг,   в окружении ребенка  замечены дети  с девиантным поведением)</div>
              <select {...register("familySection.yellowFamilySection.noFriend")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У родителей ребенка НЕ  развиты  навыки (уход и забота, эмоциональное тепло, выстраивание границ, стимулирование и др.)</div>
              <select {...register("familySection.yellowFamilySection.noParentSkill")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенку часто приходится присматривать за родителями и выполнять роль взрослых/ родителей </div>
              <select {...register("familySection.yellowFamilySection.takeParentRole")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Родители/опекуны менялись в течении жизни ребенка</div>
              <select {...register("familySection.greenFamilySection.parentsChanged")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок на постоянной основе является свидетелем конфликтов в семье между взрослыми/взрослыми и детьми</div>
              <select {...register("familySection.redFamilySection.constantlySeeingConflicts")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Ребенок  НЕ имеет время для общения  с друзьями за пределами школы</div>
              <select {...register("familySection.greenFamilySection.noSpareTime")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Отдалённость проживания родителей и /опекунов и отсутствие ресурсов затрудняют организацию и осуществление контактов с ребенком (ребенок проживает в интернате, общежитии, у родственников/знакомых и т. д.)</div>
              <select {...register("familySection.yellowFamilySection.farAway")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребенок НЕ  защищен от того, чтобы видеть или быть вовлеченным во взрослое сексуальное поведение. СРОЧНЫЕ МЕРЫ!!!!</div>
              <select {...register("familySection.bloodyRedFamilySection.notSecuredFromSexualAffection")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Проблемы в  детско-родительских отношениях. Ребенок  НЕ доволен контактами, его чувствами по поводу родителей  (братьев и сестер).  </div>
              <select {...register("familySection.yellowFamilySection.problemParentKid")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У членов семьи есть какие-либо хронические заболевания(в том числе алкогольная/наркотическая зависимость, психическое расстройство/болезнь).</div>
              <select {...register("familySection.yellowFamilySection.chronic")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Имеет ли кто-то из членов семьи, проживающих в единой жилой площади с ребенком, судимость в прошлом или находится в тюремном заключении</div>
              <select {...register("familySection.yellowFamilySection.sudimost")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Семья пережила травмирующее событие или кризис, который так и не разрешился (например, потеря близкого родственника).</div>
              <select {...register("familySection.yellowFamilySection.traumaPast")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
          </div>

          <div className={styles.title}>1.7.	НАВЫКИ САМООБСЛУЖИВАНИЯ/ УХОД ЗА СОБОЙ</div>
          <div className={styles.formContainer}>
            <div className={styles.formRow8to2}>
              <div>Вопросы</div>
              <div>Ответы</div>
            </div>
            <div className={styles.formRow8to2}>
              <div>Родители ребёнка  НЕ  поощряют/поощряли физически заботиться о себе в соответствии с возрастом и стадией развития и НЕ  прививают/ прививали  навыки работы по дому, также независимой социальной активности под присмотром взрослых и с проверкой безопасности</div>
              <select {...register("selfIndependence.yellowSelfIndependence.notAbleToCareHimself")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребенка НЕ  привиты ранние практические навыки, такие как умение самостоятельно одеваться и есть, возможности и приобретение уверенности для различных занятий вне дома, а для более старших  (молодых ) людей  НЕ  приобретены практические и иные навыки, необходимых для отдельного  независимого проживания.</div>
              <select {...register("selfIndependence.greenSelfIndependence.noPracticalSkill")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребёнок  Не научился  обращаться с деньгами. Родитель/опекун  НЕ работает с ребёнком по навыкам самопомощи и безопасности в доме и за его пределами (безопасность на дороге, возможная опасность от незнакомых прохожих и т. д.). </div>
              <select {...register("selfIndependence.greenSelfIndependence.noMoneySkill")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>У ребенка  с уязвимостью  (инвалидность и др.)  НЕ  развиты навыков самопомощи. </div>
              <select {...register("selfIndependence.greenSelfIndependence.noPoowrenie")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

          </div>

          <div className={styles.title}>2.	ВОЗМОЖНОСТИ РОДИТЕЛЕЙ</div>
          <div className={styles.title}>2.1.	 БАЗОВЫЙ УХОД И ОБЕСПЕЧЕНИЕ БЕЗОПАСНОСТИ</div>

          <div className={styles.formContainer}>
            <div className={styles.formRow8to2}>
              <div>Вопросы</div>
              <div>Ответы</div>
            </div>
            <div className={styles.formRow8to2}>
              <div>Родители  НЕ способны обеспечить базовые потребности ребенка (еда, одежда, жилье, школьные принадлежности и т. д.)</div>
              <select {...register("securitySection.redSecuritySection.parentNotAbleToProvideBasicThing")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>У ребенка НЕТ  четкого распорядок дня (режим сна, приема пищи, прогулки, досуга и т.д.)</div>
              <select {...register("securitySection.greenSecuritySection.noSchedule")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>У ребенка НЕТ своего  пространство в доме (комната,кровать, место для выполнения домашних заданий)</div>
              <select {...register("securitySection.yellowSecuritySection.haveEducationEnv")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Родители  НЕ следят за здоровьем ребенка, вовремя не обращаются к врачу когда возникает в этом необходимость</div>
              <select {...register("securitySection.redSecuritySection.parentsNotGoesToDoctorWhenNeeded")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Родитель/опекун   НЕ хвалят , не поощряют ребенка за  его успехи (нет поддержки позитивной деятельности в обучении, в домашних делах и т.п.)</div>
              <select {...register("securitySection.greenSecuritySection.noPraise")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Ребенок часто менял/меняет школу/место жительство (из-за развода родителей, переезда родителей,   недовольства родителя школой и др. причины)</div>
              <select {...register("securitySection.yellowSecuritySection.frequentSchoolChange")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Родитель/опекун НЕ  знают о проблемах/ трудностях ребенка в школе</div>
              <select {...register("securitySection.greenSecuritySection.noKnowProblem")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>Родители,  не ищут, не интересуются, когда ребенок задерживается поздно  и не приходит домой вовремя после школы/досуга  и др.</div>
              <select {...register("securitySection.yellowSecuritySection.parentNoInterestWhere")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div><div className={styles.formRow8to2}>
              <div>В семье  НЕТ правил, поддержание надлежащей дисциплины, моделирование  родителями позитивного поведения</div>
              <select {...register("securitySection.yellowSecuritySection.noLawFamily")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
          </div>

          <div className={styles.title}>3.	СЕМЕЙНЫЕ ФАКТОРЫ И ОКРУЖЕНИЕ</div>

          <div className={styles.title} > 3.2 ЖИЛЬЕ.РАБОТА.ДОХОД СЕМЬИ</div >
          <div className={styles.formContainer}>
            <div className={styles.formRow8to2}>
              <div>Вопросы</div>
              <div>Ответы</div>
            </div>
            <div className={styles.formRow8to2}>
              <div>Семья  НЕ имеет собственное жилье  (проживают в арендном/съёмном жилье)</div>
              <select {...register("aboutFamily.greenAboutFamily.noHaveOwnHouse")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Семья подвергается выселению или сейчас проживает в аварийном жилье</div>
              <select {...register("aboutFamily.yellowAboutFamily.avaryHome")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Нынешнее жилье и его окружение безопасны для ребёнка</div>
              <select {...register("aboutFamily.yellowAboutFamily.currentHomeBad")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>

            <div className={styles.formRow8to2}>
              <div>Родители ребенка безработные или работают сезонно или в  рабочей миграции. </div>
              <select {...register("aboutFamily.yellowAboutFamily.parentUnemployed")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Семья НЕ получает положенные льготы и пособия</div>
              <select {...register("aboutFamily.yellowAboutFamily.familyNoTakeNeededAllowance")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
            <div className={styles.formRow8to2}>
              <div>Семья имеет определенные трудности в материальном обеспечении развития детей (оплата за обучение детей, спортивные секции, кружки для детей, возможные кредиты и т.д.)</div>
              <select {...register("aboutFamily.yellowAboutFamily.haveMaterialIssue")}>
                <option value="true">Да</option>
                <option value="false">Нет</option>
              </select>
            </div>
          </div>

          <input type="submit" className={styles.btnstyle}></input>
        </form >
        <button onClick={() => getForm2Doc()} className={styles.btnstyle} >Получить форму</button><br></br>
        <button className={styles.btnstyle}><a href={link ? link : ''}>Скачать</a></button>
      </Card >
    </div >
  );
};
