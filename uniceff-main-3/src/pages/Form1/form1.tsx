// @flow
import * as React from 'react';
import styles from './form1.module.scss';
import {SubmitHandler, useForm} from "react-hook-form";
import {FormService} from '../../services/FormService';
import {useParams} from 'react-router-dom';
import {Alert, Card} from '@mui/material';

type Props = {
  currentStudentId: Number;
  currentCaseId: Number;
};

type Inputs = {
  actions: {
    caseManager: string,
    date: string,
    liveInDanger: true,
    needSupport: true,
    sign: string,
    signContract: true,
    supportNotNeeded: true
  },
  familyNeighbor: {
    address: string,
    age: string,
    dateOfBirth: string,
    familyStatus: string,
    nameOfParent: string,
    phoneNumber: string
  },
  legalRepresentative: {
    father: {
      address: string,
      dateOfBirth: string,
      familyStatus: string,
      nameOfParent: string,
      phoneNumber: string,
      realFather: true
    },
    mother: {
      address: string,
      dateOfBirth: string,
      familyStatus: string,
      nameOfParent: string,
      phoneNumber: string,
      realMother: true
    },
    otherPerson: {
      address: string,
      dateOfBirth: string,
      familyStatus: string,
      nameOfParent: string,
      phoneNumber: string,
      whoExactly: string,
      workplace: string
    }
  },
  reason: string,
  signDate: string,
  source: {
    connectionWithStudent: string,
    contact: string,
    dateOfMeeting: string,
    nameOfPerson: string,
    organization: string
  },
  studentInformationDto: {
    address: string,
    dateOfBirth: string,
    educationalNeeds: string,
    gender: string,
    grade: string,
    nameOfStudent: string,
    phoneNumber: string
  }
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
  individualSafeFactor: {
    academicSuccess: true,
    active: true,
    goodLifeSkills: true,
    selfConfident: true
  },
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
  environmentSafeFactor: {
    economicStability: true,
    educatedParent: true,
    employedParent: true,
    medicalAccess: true,
    normalLivingCondition: true,
    resourceCoordination: true,
    socialHelp: true
  },
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
  additionalComment: string,
};

export function Form1({currentStudentId, currentCaseId}: Props) {
  const formService = new FormService();
  const [role, setRole] = React.useState(String);
  const [formId, setFormId] = React.useState(Number);
  const [link, setLink] = React.useState(String);
  const studentId = currentStudentId;
  const caseId = currentCaseId;

  const {register, handleSubmit, formState: {errors}} = useForm<Inputs>({
    defaultValues: {
      familyNeighbor: {
        address: "test",
        age: "test",
        dateOfBirth: "test",
        familyStatus: "test",
        nameOfParent: "test",
        phoneNumber: "test"
      },
      actions: {
        caseManager: "string",
        date: "string",
        liveInDanger: true,
        needSupport: true,
        sign: "string",
        signContract: true,
        supportNotNeeded: true
      },
      additionalComment: "hello",
      // signDate: new Date().toLocaleString()

    },
  }
  );
  function getUserRole() {
    const role = sessionStorage.getItem("role");
    console.log('role', role)
    return role;
  }
  const onSubmit = async dataForm1 => {
    const response = await formService.sendForm(dataForm1, 4)
    console.log(response);
    if (response?.id) {
      setFormId(response?.id);
      alert("Первичная форма успешно создана");
    }
  };

  const handleSubmit2 = (e) => {
    e.preventDefault();
    alert("DFSDFSDFSD")
    console.log(e)
  }

  async function getForm1Doc() {
    const res = await formService.downloadForm1(formId);
    console.log(res)
    setLink(res.Link)
  }
  React.useEffect(() => {
    setRole(getUserRole());
  }, [])

  return (
    <div className={styles.container}>
      <Card sx={{minWidth: 275, paddingLeft: 15, paddingRight: 15}} variant="outlined">
        <form onSubmit={handleSubmit(onSubmit)}>
          <div className={styles.titleOut}>ПЕРВИЧНАЯ ОЦЕНКА</div>
          <div className={styles.formContainer} >
            {/* <div className={styles.formRow1}>
              <div className='formRowBtw'>
                <label >Дата проведения:</label>
                <input type="text" />
              </div>
              <div className='formRowBtw'>
                <label>Дата завершения:</label>
                <input type="text" />
              </div>
            </div> */}
            <div className={styles.title}>ИНФОРМАЦИЯ О РЕБЕНКЕ: </div>
            <div className={styles.formRow2}>
              <label>ФИО ребёнка</label>
              <input type="text" {...register("studentInformationDto.nameOfStudent")} />

              <label>Дата рождения</label>
              <input type="date" {...register("studentInformationDto.dateOfBirth")} />
              <label>Класс обучения</label>
              <input type="text" {...register("studentInformationDto.grade")} />
              <label>Пол</label>
              <select  {...register("studentInformationDto.gender")}
              >
                <option value='FEMALE' >Жен</option>
                <option value='MALE' >Муж</option>
              </select>
              <label>Особые образовательные потребности</label>
              <select   {...register("studentInformationDto.educationalNeeds")}>
                <option value='Нет'>Нет</option>
                <option value='Нет информации' >Нет информации</option>
                <option value='Да' >Да</option>
              </select>
              <label>Контакты</label>
              <input type="text" {...register("studentInformationDto.phoneNumber")} />
            </div>
            <div className={styles.title}>
              Адрес проживания ребенка
            </div>
            <div className={styles.formRow}>
              <label >Город</label>
              <input type="text" {...register("studentInformationDto.address")} />
              <label >Район</label>
              <input type="text" {...register("studentInformationDto.address")} />
              <label >Улица</label>
              <input type="text" {...register("studentInformationDto.address")} />
              <label >Дом</label>
              <input type="text" {...register("studentInformationDto.address")} />
              <label >Квартира</label>
              <input type="text" {...register("studentInformationDto.address")} />
            </div>
            <div>
              ИНФОРМАЦИЯ О РОДИТЕЛЯХ/ЗАКОННЫХ ПРЕДСТАВИТЕЛЕЙ РЕБЕНКА:         </div>
            <div className={styles.formRow}>
              <div>Папа</div>
              <div className={styles.formRowBtw}>
                <div className={styles.formRowBtw}>
                  <label >ФИО родителя/законного представителя</label>
                  <input type="text" {...register("legalRepresentative.father.nameOfParent")} />
                </div>
                <br></br>
                <div className={styles.formRowBtw}>
                  <label >Дата рождения </label>
                  <input type="date" {...register("legalRepresentative.father.dateOfBirth")} />
                </div>
                <br></br>
                <div className={styles.formRowBtw}>
                  <label >Полных лет</label>
                  <input />
                </div>
                <br></br>
                <div className={styles.formRowBtw}>
                  <label >Отчим/мачеха </label>
                  <input type="checkbox" {...register("legalRepresentative.father.realFather")} />
                </div>
                <div className={styles.formRowBtw}>
                  <label >Контакты </label>
                  <input type="text" {...register("legalRepresentative.father.phoneNumber")} />
                </div>
                <div className={styles.formRowBtw}>
                  <label>Семейное положение</label>
                  <select {...register("legalRepresentative.father.familyStatus")} >
                    <option >Выберите</option>
                    <option value='Офиц зарегистрированы в браке' >Офиц зарегистрированы в браке</option>
                    <option value='Развод/смерть одного из родителей/родитель-одиночка'>Развод/смерть одного из родителей/родитель-одиночка</option>
                    <option value='Совместное проживание без регистрации брака'>Совместное проживание без регистрации брака</option>
                  </select>
                </div>

              </div>
              <div>
                Адрес проживания
              </div>
              <div className={styles.formRow}>
                <label >Город</label>
                <input type="text" {...register("legalRepresentative.father.address")} />
                <label >Район</label>
                <input type="text" {...register("legalRepresentative.father.address")} />
                <label >Улица</label>
                <input type="text" {...register("legalRepresentative.father.address")} />
                <label >Дом</label>
                <input type="text" {...register("legalRepresentative.father.address")} />
                <label >Квартира</label>
                <input type="text" {...register("legalRepresentative.father.address")} />
              </div>
              <div>Мама</div>
              <div className={styles.formRowBtw}>
                <label >ФИО родителя/законного представителя</label>
                <input type="text" {...register("legalRepresentative.mother.nameOfParent")} />
                <label >Дата рождения</label>
                <input type="date" {...register("legalRepresentative.mother.dateOfBirth")} />

                <label>Семейное положение</label>
                <select {...register("legalRepresentative.mother.familyStatus")}  >
                  <option>Выберите </option>
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
                <input type="text" {...register("legalRepresentative.mother.address")} />
                <label >Район</label>
                <input type="text" {...register("legalRepresentative.mother.address")} />
                <label >Дом</label>
                <input type="text" {...register("legalRepresentative.mother.address")} />
                <label >Улица</label>
                <input type="text" {...register("legalRepresentative.mother.address")} />
                <label >Квартира</label>
                <input type="text" {...register("legalRepresentative.mother.address")} />
              </div>
              <div>Отчим/Мачеха</div>
              {/* <div className={styles.formRow}>
                <label>Проживающий с мачехой/отчимом</label>
                <input type="checkbox" />
              </div> */}
              <div className={styles.formRowBtw}>
                <label >Отчим/мачеха </label>
                <input type="checkbox" {...register("legalRepresentative.mother.realMother")} />
              </div>
              <div className={styles.formRowBtw}>
                <label >Контакты </label>
                <input type="text" {...register("legalRepresentative.mother.phoneNumber")} />
              </div>
            </div>
            <div className={styles.title}>ДАННЫЕ ДРУГИХ ЛИЦ, ПРОЖИВАЮЩИХ СОВМЕСТНО С СЕМЬЕЙ:</div>
            <div className={styles.formRow}>
              <label >ФИО</label>
              <input type="text" {...register("familyNeighbor.nameOfParent")} />
              <label >Возраст</label>
              <input type="text" {...register("familyNeighbor.age")} />
              <label >Степень родства</label>
              <input type="text" />
              <label >Место работы/обучения</label>
              <input type="text" {...register("familyNeighbor.phoneNumber")} />
            </div>
            <div className={styles.title}>
              Причины проведения Первичной оценки учащегося: </div>
            <div className={styles.formRowFull}>
              Вставить автоматически текст: На основании приказа № от ____ числа за подписью директора? На основании чего 100% учеников будут подвергнуты оценке.
            </div>
            <div className={styles.title}>
              ИСТОЧНИКИ ИНФОРМАЦИИ при проведении оценки: (указываем источники информации, где вы брали информацию о ребенке, например, психолог дал результаты диагностики, ПМПК дали заключение, кейс-менеджер провел несколько интервью с ребенком, беседы с родителем/ями). </div>
            <div className={styles.formRow}>
              <label >Дата встречи / интервью с ребенком, членами семьи, организациями и другими лицами:</label>
              <input type="date" {...register("source.dateOfMeeting")} />
              <label >ФИО лица, с которым проведена встреча / интервью</label>
              <input type="text" {...register("source.nameOfPerson")} />
              <label >Название организации/ должность лица </label>
              <input type="text" {...register("source.organization")} />
              <label >Кем приходится учащемуся (например, кл. руководитель, психолог школы, привлеченный специалист, родитель)</label>
              <input type="text" {...register("source.connectionWithStudent")} />
              <label >Контактный телефон</label>
              <input type="text" {...register("source.contact")} />

            </div>
          </div>
          <div className={styles.titleOut}>1.1</div>
          <div className={styles.formContainer}>
            <div className={styles.formRow}>
              <label >ИМЯ И ФАМИЛИЯ РЕБЕНКА:</label>
            </div>
            <div className={styles.formRowFull}>
              Факторы риска, связанные с потребностями ребенка в развитии
              Каждому специалисту доступны факторы риска согласно его компетенции и возможной информированности. Отмечая факторы риска необходимо поставить галочку в тех вариантах, которые соответствуют ситуации учащегося и основаны на доказательной базе (зафиксированы со слов ребенка/родителя/законного представителя, органов местного самоуправления, администрации школы и т.п.). В случае, если вам как специалисту известны факторы риска, отсутствующие в данном перечне, вам необходимо указать их в графе Другое.
              Данный перечень отображает основные факторы риска, которые возможно, могут повлиять на процесс обучения ребенка в общеобразовательном учреждении.
            </div>
            <div className={styles.title}>
              Факторы риска </div>
          </div>
          <div className={styles.container}>
            <Card>
              <div className={styles.formContainer}>
                <div>
                  <div className={styles.title}>
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
            </Card>
          </div >

          <div className={styles.container}>
            <Card>
              <div className={styles.formContainer}>
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
            </Card>
          </div>
          <div className={styles.container}>
            <Card>
              <div className={styles.formContainer}>
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


            </Card>

          </div >

          <div className={styles.container}>
            <Card>
              <div className={styles.formContainer}>
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

            </Card>


          </div >

          <div className={styles.formRowFull}>*Примечание: <span style={{color: 'red'}}>В СЛУЧАЕ СОВЕРШЕНИЯ НАСИЛИЯ ИЛИ ВОЗМОЖНОГО ПРИЧИНЕНИЯ ВРЕДА РЕБЕНКУ/ЧЛЕНУ СЕМЬИ, <br></br>СОТРУДНИК ДОЛЖЕН НЕЗАМЕДЛИТЕЛЬНО СООБЩИТЬ В СООТВЕТСТВУЮЩИЕ ИНСТАНЦИИ.</span></div>
          <div className={styles.title}>
            Факторы защиты </div>

          <div className={styles.formRowFull}>
            <Card>
              <div className={styles.formContainer}>
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
            </Card>
          </div >

          <div className={styles.formRowFull}>
            <Card>
              <div className={styles.formContainer}>
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
            </Card>

          </div >

          <div className={styles.formRowFull}>
            <Card>
              <div className={styles.formContainer}>
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
            </Card>

          </div >

          <div className={styles.formRowFull}>
            <Card>
              <div className={styles.formContainer}>
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
            </Card>

          </div >

          <div className={styles.formRowFull}>
            <label >Причина открытия кейса</label>
            <input type="text"  {...register("reason")} />
          </div>



          {/* <div className={styles.titleOut}>3. ДОПОЛНИТЕЛЬНЫЕ КОММЕНТАРИИ СПЕЦИАЛИСТОВ</div>
          <div className={styles.formContainer}>
            <div className={styles.formRowFull}>
              Здесь каждый специалист если это необходимо, указывает комментарии, примечания, о которых ему известно относительно ситуации ребенка, которые могут помочь в определении уровня риска.  </div>
            <div className={styles.formRow}>
              <div>Сотрудник школы/специалист</div>
              <div>Комментарии/примечания</div>
            </div>
            <div className={styles.formRow}>
              Психолог
              <label >Комментарии</label>
              <input type="text" />
            </div>
            <div className={styles.formRow}>
              <label >Комментарии</label>
              Социальный педагог
              <input type="text" />
            </div>
            <div className={styles.formRow}>

              Врач/мед.сестра
              <label >Комментарии</label>
              <input type="text" />
            </div>
            <div className={styles.formRow}>
              Другое _________
              <label >Комментарии</label>
              <input type="text" />
            </div>
          </div> */}
          {/* <div>
            <div className={styles.titleOut}>2. СЛУЧАИ ПРИЧИНЕНИЯ ВРЕДА ИЛИ ВОЗМОЖНОГО ПРИЧИНЕНИЯ ВРЕДА</div>
            <div className={styles.formContainer}>
              <div className={styles.formRowFull}>
                Если в какой-либо момент в ходе проведения этой оценки у вас возникло подозрение, что учащемуся был нанесен вред или он подвергся жестокому обращению, или существует риск причинения ему вреда, Вы должны следовать процедурам защиты ребенка местных органов власти (см. Факторы риска ниже).
              </div>
              <div className={styles.formRow}>
                <div className={styles.title}>Факторы риска</div>
              </div>
              <div className={styles.formRow}>
                <label >Ребенку наносится или похоже, что наносится физический или психологический вред, как результат домашнего насилия в семье.</label>
                <input type="checkbox" value="true"{...register("abuseSuspicionDto.domesticViolence")} />
                <label >Есть подозрение, что ребенок подвергается сексуальному насилию, а родитель/законный представитель не в состоянии или не желает предоставлять должную защиту ребенку</label>
                <input type="checkbox" value="true" {...register("abuseSuspicionDto.sexualAbuse")} />
                <label >Родитель/законный представитель создал угрозу нанесения серьезный физический вред ребенку (детям) или создал угрозу нанесения ребенку серьезного вреда. </label>
                <input type="checkbox" value="true" {...register("abuseSuspicionDto.parentMakeDangerousEnv")} />
                <label >Настоящее местонахождение ребенка (детей) не может быть установлено и/или есть основания полагать, что семья собирается убежать или отказывает в доступе к ребенку (детям) в случае подозрения у администрации образовательного учреждения факта жестокого обращения.</label>
                <input type="checkbox" value="true" {...register("abuseSuspicionDto.locationUnknown")} />

              </div>
              <div className={styles.formRowFull}>
                Примечание:
                Если присутствует хотя бы один из этих факторов риска, Вы должны предпринять незамедлительные действия!
              </div>
            </div>
          </div> */}
          {/* 
          <div>
            <div className={styles.titleOut}>4. ДАЛЬНЕЙШИЕ ДЕЙСТВИЯ И КОММЕНТАРИИ </div>
            <div className={styles.formContainer}>
              <div className={styles.formRowFull}>
                В этом разделе отмечаются все действия, которые были предприняты во время первичной оценки или должны быть предприняты по ее окончании. Можно отметить несколько действий.  </div>
              <div className={styles.formRowFull}>
                Действия
              </div>
              <div className={styles.formRowFull}>
                <label >Кейс менеджер</label>
                <input type="text"  {...register("actionsDto.caseManager")} />
              </div>
              <div className={styles.formRowFull}>
                <label >Ребенок / семья не нуждаются в дальнейшей поддержке.</label>
                <input type="checkbox" value="true" {...register("actionsDto.needSupport")} />
              </div>

              <div className={styles.formRowFull}>
                <label >Ребенок и/или член семьи находится в непосредственной опасности серьезного вреда, и необходимо немедленно предпринять действия для защиты (немедленные законные действия для защиты ребенка).</label>
                <input type="checkbox" value="true" {...register("actionsDto.liveInDanger")} />

              </div>
              <div className={styles.formRowFull}>
                <label >Контракт о дальнейшей поддержке ребенка / семьи со стороны образовательного учреждения будет подписан с родителем(ями) / законным представителем (ями), будет проведена глубинная оценка.</label>
                <input type="checkbox" value="true" {...register("actionsDto.signContract")} />
              </div>
              <div className={styles.formRowFull}>
                <label >Непосредственной опасности серьезного вреда или риска выбытия не существует, но ребенок/ семья нуждаются в дальнейшей поддержке в других областях социальной защиты.</label>
                <input type="checkbox" value="true" {...register("actionsDto.supportNotNeeded")} />
              </div>
              <div className={styles.formRowFull}>
                <label >Дата</label>
                <input type="date"  {...register("actionsDto.date")} />
              </div>
              <div className={styles.formRowFull}>
                <label >Подпись</label>
                <input type="checkbox" value="true" {...register("actionsDto.sign")} />
              </div>
              <div className={styles.formRowFull}>
                <label >Дата подписания</label>
                <input type="date"  {...register("signDate")} />
              </div>
              <div className={styles.formRowFull}>
                <label >Причина открытия кейса</label>
                <input type="text"  {...register("reason")} />
              </div>
              <div className={styles.formRow}>
              </div>
            </div>
            <div className={styles.formContainer}>
              <div className={styles.formRowFull}>
                В этом разделе отмечаются все действия, которые были предприняты во время первичной оценки или должны быть предприняты по ее окончании. Можно отметить несколько действий.  </div>
              <div className={styles.formRow3}>
                <div>ФИО кейс-менеджера</div>
                <div>Подпись</div>
                <div>Дата</div>
              </div>
              <div className={styles.formRow3}>
                <div>
                  Здесь будет ФИО
                </div>
              </div>

              <form />
            </div>
          </div> */}

          <input type="submit" className={styles.btnstyle} />
        </form>
        <div>
          <button onClick={() => getForm1Doc()} className={styles.btnstyle}>Получить первую форму</button><br></br>
          {/* <button className={styles.btnstyle}><a href={link} target="_blank" rel="noreferrer">Получить первую форму</a></button> */}
        </div>
      </Card>
    </div >
  );
};