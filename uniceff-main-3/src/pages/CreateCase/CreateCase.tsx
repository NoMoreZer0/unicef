import {useForm} from 'react-hook-form';
import styles from './CreateCase.module.scss';
import InputWrapper from '../../components/InputWrapper';
import DefaultButton from '../../components/DefaultButton';
import {useEffect, useState} from 'react';
import Modal from '../../components/Modal';
import AddIcon from '@mui/icons-material/Add';
import {CaseService} from '../../services/CaseService';
import {NOTIFICATION, ROUTES, SESSION_STORAGE} from '../../constants';
import {getRoleEndpoints} from '../../utils';
import {User} from '../../types';
import {SelectUser} from './SelectUser';
import {SelectStudent} from './SelectStudent';
import {UserList} from './UserList';
import {useAppDispatch} from '../../hooks/useRedux';
import {notify} from '../../redux/features/notification';
import {useNavigate, useParams} from 'react-router-dom';
// import {Autocomplete, Stack, TextField} from '@mui/material';

import * as React from 'react';
import TextField from '@mui/material/TextField';
import Stack from '@mui/material/Stack';
import Autocomplete from '@mui/material/Autocomplete';
import {Alert} from '@mui/material';

type Props = {
  studentId: Number
};

export function CreateCase({studentId}: Props) {
  const [selectedUsers, setSelectedUsers] = useState([]);
  const [searchText, setSearchText] = useState('');
  const [student, setStudent] = useState(null);
  const [users, setUsers] = useState<User[]>([]);
  const [students, setStudents] = useState([]);
  const [isOpen, setIsOpen] = useState(false);
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoints = getRoleEndpoints(role);
  const caseService = new CaseService(roleEndpoints);
  const navigate = useNavigate();
  const dispatch = useAppDispatch();

  const {register, handleSubmit, formState: {errors}} = useForm();
  const onSubmit = async data => {
    const ids = []
    selectedUsers.map((el) => {
      ids.push(el.id)
    })
    console.log('jif', student)
    const finalData = {
      ...data,
      // usersIds: [2, 3, 7, 4, 6, 5],
      usersIds: ids,
      studentId,
      caseManagerId: 3,
      firstPhaseId: 108
    };
    const res = await caseService.createCase(finalData);
    console.log(res);
    console.log('hello');
    if (res) {
      alert("Кейс успешно создан");
      // <Alert severity="success" color="success">
      //   Кейс успешно создан
      // </Alert>
    }

    // dispatch(notify({type: NOTIFICATION.SUCCESS, message: 'Дело создано'}));
    // navigate(`/${ROUTES.ACCOUNT}/${ROUTES.CASES}`);
  };

  console.log('users', users);
  const specialistIds = [];

  const handleUserSelect = (user) => {
    const userList = selectedUsers;
    userList.push(user);
    setSelectedUsers(userList);
    setIsOpen(false);
    specialistIds.push(user.id);
  };


  // console.log('selected ids', specialistIds)

  // const handleChange = (e, val) => {
  //   console.log(val)
  // }

  async function getUsers() {
    const users = await caseService.getAllUsers();
    if (users) {
      setUsers(users);
    }
  }

  async function getStudents() {
    const students = await caseService.getAllStudents();
    console.log(students)
    setStudents(students);
  }

  useEffect(() => {
    getUsers();
    getStudents();
  }, []);


  return (
    <div className={'container'}>
      <div className={styles.title}>
        Создать дело
      </div>
      <form id="auth" className={styles.form}
        onSubmit={handleSubmit(onSubmit)} >
        <label htmlFor="">Id студента</label>
        <input placeholder={'ID студента'} disabled value={String(studentId)} />
        {/*<InputWrapper label={'Case title'} error={errors.title} errText={''}>*/}
        {/*  <input {...register('title', )} />*/}
        {/*</InputWrapper>*/}
        <InputWrapper label={'Причина'} error={errors.reason} errText={''}>
          <textarea  {...register('reason')} />
        </InputWrapper>
        {/*<SelectStudent data={studentId} handleChange={handleStudentSelect} label={'Status'}/>*/}

        <InputWrapper label={'Начало срока'} errText={''}
          error={errors.openingDate}>
          <input type="date" name="openingDate"
            id="openingDate" {...register('openingDate')} />
        </InputWrapper>

        <label>Статус кейса:</label>
        <select {...register('caseStatus')}>
          <option value='OPEN'>Открыто</option>
          <option value='CLOSED'>Закрыто</option>
        </select>
        <InputWrapper label={'Кто иницировал'}>
          <input type="text" name="whoStated"
            placeholder="Кто иницировал дело"
            id="whoStated" {...register('whoStated',)} />
        </InputWrapper>
        {!!users && <UserList users={selectedUsers} />}
        <button type={'button'} className={styles.add}
          onClick={() => setIsOpen(true)}>
          <AddIcon />Добавить специалиста
        </button>
        <Modal open={isOpen} handleClose={() => setIsOpen(false)}>
          <SelectUser handleChange={handleUserSelect}
            data={users} />
        </Modal>
        <input type="submit" value='submit' />
      </form>
    </div >
  );
};