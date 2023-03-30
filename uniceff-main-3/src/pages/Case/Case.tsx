import styles from './Case.module.scss';
import {CaseFullInfo} from '../../types';
import {
  CASE_STATUS,
  GENDER,
  NOTIFICATION,
  ROLES,
  SESSION_STORAGE,
  STUDENT_STATUS,
} from '../../constants';
import {useEffect, useState} from 'react';
import {useNavigate, useParams} from 'react-router-dom';
import {CaseService} from '../../services/CaseService';
import {getRoleEndpoints} from '../../utils';
import Modal from '../../components/Modal';
import {SelectUser} from '../CreateCase/SelectUser';
import InputWrapper from '../../components/InputWrapper';
import {useAppDispatch, useAppSelector} from '../../hooks/useRedux';
import {notify} from '../../redux/features/notification';
import Tests from '../Tests';
import {Alert} from '@mui/material';



const initialInfo: CaseFullInfo = {
  closingDate: '',
  openingDate: '',
  openingReason: '',
  // users: [
  //   {
  //     email: '',
  //     fio: '',
  //     phoneNumber: '',
  //     position: ROLES.THERAPIST,
  //     school: '',
  //     username: '',
  //   },
  // ],
  whoStated: '',
  id: 0,
  closingReason: '',
  caseStatus: CASE_STATUS.OPEN,
  student: {
    phoneNumber: '',
    nameOfStudent: '',
    gender: GENDER.FEMALE,
    grade: '',
    id: 0,
    language: '',
    parents: [
      {
        nameOfParent: '',
        id: 0,
        phoneNumber: '',
      },
    ],
    school: '',
    studentStatus: STUDENT_STATUS.GREEN,
  },
  users: [
    {
      accountNonExpired: true,
      accountNonLocked: true,
      authorities: [
        {
          authority: ''
        }
      ],
      credentialsNonExpired: true,
      email: '',
      fio: '',
      id: 0,
      isCurator: true,
      notifications: [
        {
          message: '',
          users: [
            null
          ]
        }
      ],
      phoneNumber: '',
      position: '',
      role: '',
      school: '',
      username: ''
    }
  ],
  curator: {
    accountNonExpired: true,
    accountNonLocked: true,
    authorities: [],
    credentialsNonExpired: true,
    email: '',
    enabled: true,
    fio: '',
    id: 0,
    phoneNumber: '',
    position: '',
    role: ROLES.SUBJECT_TEACHER,
    school: '',
  },
};

export function Case() {
  const user = useAppSelector((state) => state.user.user);
  const {caseId} = useParams();
  const [isOpenTwo, setIsOpenTwo] = useState(false);
  const [isOpen, setIsOpen] = useState(false);
  const [date, setDate] = useState('');
  const [closingReason, setClosingReason] = useState('');
  const [selectedUser, setSelectedUser] = useState(null);
  const [userList, setUserList] = useState([]);
  const [caseFullInfo, setCaseFullInfo] = useState(initialInfo);
  const navigate = useNavigate();
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoints = getRoleEndpoints(role);
  const caseService = new CaseService(roleEndpoints);
  const dispatch = useAppDispatch();
  const currentCaseId = caseFullInfo.id;
  const currentStudentId = caseFullInfo.student.id;
  const isPermission = sessionStorage.getItem(SESSION_STORAGE.ROLE) === ROLES.THERAPIST;
  const handleSelect = async (user) => {
    if (date.length && user) {
      const res = await caseService.createPost({
        date,
        meetingHolderId: user.id,
        caseId: Number(caseId),
      });

      if (res) {
        // dispatch(notify({
        //   type: NOTIFICATION.SUCCESS,
        //   message: 'Встреча создана',
        // }));
        <Alert severity="success" color="success">
          Встреча успешно создана
        </Alert>
      }
    }
  };

  const closeCase = async () => {
    const res = await caseService.closeCase({
      caseId: Number(caseId),
      closingReason,
    });

    setIsOpenTwo(false);
  };

  const createReport = async () => {
    const res = await caseService.createPost({
      caseId: Number(caseId),
      date,
      meetingHolderId: user.id,
    });
    if (res) {
      setUserList(res);
    }
  };

  async function getUserList() {
    const res = await caseService.getAllUsers();
    if (res) {
      setUserList(res);
    }
  }

  async function getCaseInfo() {
    const response = await caseService.getCase(Number(caseId));
    if (response) {
      setCaseFullInfo(response);
      console.log(caseFullInfo)
    }
  }

  useEffect(() => {
    getCaseInfo();
    getUserList();
  }, []);
  return (
    <div className={'container'}>
      <div className={styles.case}>
        <div className={styles.row}>
          <div className={styles.mainTitle}>Case Info</div>
          <div className={styles.row}>
            {isPermission && <button onClick={() => navigate('posts')}
              className={styles.button}>
              Все отчеты по делу
            </button>}
            <button onClick={() => {
              setIsOpen(true);
            }} className={styles.button}>
              Создать встречу
            </button>
          </div>
        </div>
        <div className={styles.header}>
          <div>ID: {caseFullInfo?.id}</div>
          <div>Статус: {caseFullInfo?.caseStatus}</div>
          <div>Дата открытия: {caseFullInfo?.openingDate}</div>
          <div>Дата закрытия: {caseFullInfo?.closingDate}</div>
        </div>
        <div>
          <div className={styles.section}><span className={styles.title}>Причины открытия:</span> {caseFullInfo?.openingReason}</div>
          <div className={styles.section}>
            <div className={styles.title}>Информация об ученике:</div>
            <div className={styles.spec}>
              <span>Полное имя: </span><span>{caseFullInfo?.student?.nameOfStudent}</span>
            </div>
            <div className={styles.spec}>
              <span>Пол: </span><span>{caseFullInfo?.student?.gender}</span>
            </div>
            <div className={styles.spec}>
              <span>Школа: </span><span>{caseFullInfo?.student?.school}</span>
            </div>
            <div className={styles.spec}>
              <span>Класс: </span><span>{caseFullInfo?.student?.grade}</span>
            </div>
            <div className={styles.spec}>
              <span>Телефон ученика: </span>
              <span>{caseFullInfo?.student?.phoneNumber}</span>
            </div>
            <div className={styles.spec}>
              <span>Язык обучения: </span>
              <span>{caseFullInfo?.student?.language}</span>
            </div>
            <div className={styles.spec}>
              <span>Источник информации: </span>
              <span>{caseFullInfo?.whoStated}</span>
            </div>
            {caseFullInfo?.student?.parents?.map((el, i) => (
              <div key={i}>
                <div className={styles.spec}>
                  <span>Полное имя родителя: </span>
                  <span>{el.nameOfParent}</span>
                </div>
                <div className={styles.spec}>
                  <span>Телефон родителя: </span>
                  <span>{el.phoneNumber}</span>
                </div>
              </div>
            ))}
          </div>

          <div className={styles.section}>
            {caseFullInfo?.users?.map((el, i) => (
              <div key={i}>
                <div className={styles.title}>{el?.position ? el?.position : 'not available'}</div>
                <div className={styles.spec}>
                  <span>Полное имя: </span><span>{el.fio ? el.fio : '-'}</span>
                </div>
                <div className={styles.spec}>
                  <span>Позиция: </span><span>{el.position ? el.position : '-'}</span>
                </div>
                <div className={styles.spec}>
                  <span>Email: </span><span>{el.email ? el.email : '-'}</span>
                </div>
                <div className={styles.spec}>
                  <span>Телефон: </span><span>{el.phoneNumber ? el.phoneNumber : '-'}</span>
                </div>
              </div>
            ))}
            {/*  */}
          </div>
        </div>
        <div><Tests currentStudentId={currentStudentId} currentCaseId={currentCaseId} /></div>
        {isPermission && <button onClick={() => setIsOpenTwo(true)}
          className={'green_btn green_green'}>
          Закрыть дело
        </button>}
        <Modal open={isOpen} handleClose={() => setIsOpen(false)}>
          <div>
            <div className={styles.title}>Add Meeting</div>
            <div>
              <InputWrapper label={'Дата встречи'} error={''}
                errText={''}>
                <input type={'date'} value={date}
                  onChange={(e) => setDate(e.target.value)} />
              </InputWrapper>
              {isPermission &&
                <SelectUser handleChange={handleSelect} data={userList} />}
              {!isPermission &&
                <button className={styles.buttonCenter} onClick={createReport}>Назначить встречу</button>}
            </div>
          </div>
        </Modal>

        <Modal open={isOpenTwo} handleClose={() => setIsOpenTwo(false)}>
          <div>
            <div className={styles.title}>Причина закрытия</div>
            <input className={styles.input} placeholder={'Причина закрытия'}
              type={'text'}
              value={closingReason}
              onChange={(e) => setClosingReason(e.target.value)} />

            <button onClick={closeCase} className={styles.buttonCenter}>Закрыть
              дело
            </button>
          </div>
        </Modal>
      </div>
    </div>
  );
}
