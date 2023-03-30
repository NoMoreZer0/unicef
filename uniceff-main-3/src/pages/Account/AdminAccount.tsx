import {useAppSelector} from '../../hooks/useRedux';
import {ROUTES, SESSION_STORAGE} from '../../constants';
import {Link} from 'react-router-dom';
import styles from './Account.scss'

import Button from '@mui/material/Button';
import Dialog from '@mui/material/Dialog';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import CloseIcon from '@mui/icons-material/Close';
import Slide from '@mui/material/Slide';
import {TransitionProps} from '@mui/material/transitions';
import React, {useEffect, useState} from 'react';
import {Card, DialogTitle, DialogContent, DialogContentText, TextField, DialogActions} from '@mui/material';
import {CenterFocusStrong} from '@mui/icons-material';
import {CaseService} from '../../services/CaseService';
import {getRoleEndpoints} from '../../utils';
import {mediaService} from '../../services/mediaService';
import {useForm} from 'react-hook-form';

type Props = {};

interface FormData {
  file: FileList;
}

const Transition = React.forwardRef(function Transition(
  props: TransitionProps & {
    children: React.ReactElement;
  },
  ref: React.Ref<unknown>,
) {
  return <Slide direction="up" ref={ref} {...props} />;
});

export function AdminAccount(props: Props) {
  const [caseList, setCaseList] = useState([]);
  const [studentList, setStudentList] = useState([]);
  const [workersList, setWorkersList] = useState([]);

  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoints = getRoleEndpoints(role);
  const caseService = new CaseService(roleEndpoints);


  const user = useAppSelector((state) => state.user.user);

  const [open, setOpen] = React.useState(false);
  const [openFileUpload, setOpenFileUpload] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleClickOpenFile = () => {
    setOpenFileUpload(true);
  };

  const handleCloseFile = () => {
    setOpenFileUpload(false);
  };

  async function getCaseList() {
    const res = await caseService.getAllCases();
    if (res) {
      setCaseList(res)
    }
  };

  async function getStudentList() {
    const res = await caseService.getAllStudents();
    if (res) {
      setStudentList(res)
    }
  };

  async function getWorkersList() {
    const res = await caseService.getAllUsers();
    if (res) {
      setWorkersList(res)
    }
  };
  // const MyForm = () => {
  //   const {
  //     register,
  //     handleSubmit,
  //     reset,
  //   } = useForm<FormData>();
  // }

  const {register, handleSubmit, formState: {errors}} = useForm<FormData>({
  }
  );
  const onSubmit = async (data: FormData) => {
    const formData = new FormData();
    formData.append('file', data.file[0]);

    try {
      console.log(sessionStorage.getItem('access_token'))
      const response = await fetch('https://pdpcm.kz/api/media/file', {
        method: 'POST',
        body: formData,
        headers: {
          'Authorization': `${sessionStorage.getItem('access_token')}`
          // 'Authorization': `eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9sb2NhbGhvc3Q6ODA4NVwvYXBpXC9hdXRoZW50aWNhdGUiLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY3NzUwMTk4OSwiaWF0IjoxNjc3NDAxOTg5LCJyb2xlcyI6WyJST0xFX0FETUlOIl19.p0F6t2hcNgUp8f2oJl0oDoSZ8z1rUdslWLQKCDgMeow`,
          // token: "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9sb2NhbGhvc3Q6ODA4NVwvYXBpXC9hdXRoZW50aWNhdGUiLCJzdWIiOiJhZG1pbiIsImV4cCI6MTY3NzUwMTk4OSwiaWF0IjoxNjc3NDAxOTg5LCJyb2xlcyI6WyJST0xFX0FETUlOIl19.p0F6t2hcNgUp8f2oJl0oDoSZ8z1rUdslWLQKCDgMeow"
        }
      });

      if (response.ok) {
        console.log('File uploaded successfully');
      } else {
        console.log('Failed to upload file');
      }
    } catch (error) {
      console.error('Error uploading file', error);
    }
  };


  useEffect(() => {
    getCaseList();
    getStudentList();
    getWorkersList();
  }, []);



  // const onSubmit = async formData => {
  //   const response = await mediaService.uploadFile(formData)
  //   console.log(response);
  //   // if (response?.id) {
  //   //   alert("Первичная форма успешно создана");
  //   // }
  // };



  return (
    <>
      <div className="pt60 pb90">
        <div className="container">
          <div className="zagol mb20">Личный кабинет администратора</div>
          <div className="podzag mb50">Личный кабинет администратора, здесь собрана
            вся информация<br /> необходимая для работы.
            <button className='green_btn_admin' onClick={handleClickOpenFile}>Выложить файл на общий доступ</button>

          </div>
          <div className="account_page flex just_flex">
            <div className="acc_col acc_col1">
              <div className="acc_photo">
                <img src="/images/no_photo.png" alt="" />
              </div>
              <div className="acc_info">
                <div className="acc_title mb20">{user?.fio}</div>
                <div className="info_line"><span
                  className="gray_par">Email:</span> <a
                    href="mailto:example@mail.com">{user?.email}</a></div>
                <div className="info_line"><span
                  className="gray_par">Роль:</span> <a
                    href="mailto:example@mail.com">{user?.username}</a></div>
                <div className="info_line"><span
                  className="gray_par">Позиция:</span> <a
                    href="mailto:example@mail.com">{user?.position}</a></div>
              </div>
            </div>
            {
              <>
                <div className="acc_col acc_col2">
                  <div className="acc_title mb20">Все кейсы</div>
                  <div className="info_line">Количество кейсов: {caseList.length}</div>
                  <Link to={`/${ROUTES.ACCOUNT}/${ROUTES.ADMIN_CASES}`} className="green_link">Посмотреть кейсы в системе</Link>
                </div>
                <div className="acc_col acc_col3">
                  <div className="acc_title mb20">Все ученики</div>
                  <div className="info_line">количество учеников {studentList.length}</div>
                  <div className="info_line">На особом учете (0)</div>
                  <Link to={`/${ROUTES.ACCOUNT}/${ROUTES.ADMIN_STUDENTS}`} className="green_link">Посмотреть всех учеников в системе</Link>
                </div>
                <div className="acc_col acc_col2">
                  <div className="acc_title mb20">Все сотрудники</div>
                  <div className="info_line">количество сотрудников {workersList.length}</div>
                  <Link to={`/${ROUTES.ACCOUNT}/${ROUTES.ADMIN_SPECIALISTS}`} className="green_link">Посмотреть
                    всех специалистов</Link>
                  <button className='green_btn_admin' onClick={handleClickOpen}>Добавить сотрудника</button>
                </div>
              </>
            }
          </div>
        </div>

        <Dialog open={open} onClose={handleClose} maxWidth='xl'>
          <DialogTitle sx={
            {
              fontSize: '2rem',
              color: '#80C342'
            }
          }>Добавить сотрудника</DialogTitle>
          <DialogContent sx={{
            width: 700,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center'
          }
          }>
            <div className={styles.center}>
              <form>
                <div>
                  <label>ФИО сотрудника:</label><br></br>
                  <input type="text" className={styles.w500} />
                </div>
                <div>
                  <label>Должность:</label><br></br>
                  <input type="text" className={styles.w500} />
                </div>
                <div>
                  <label>Электронная почта:</label><br></br>
                  <input type="text" className={styles.w500} />
                </div>
                <div>
                  <label>Роль:</label><br></br>
                  <select   >
                    <option>Выберите:</option>
                    <option value=''>Медицинский работник</option>
                    <option value=''>Куратор</option>
                    <option value=''>Кейс-менеджер</option>
                    <option value=''>Социальный работник</option>
                    <option value=''>Инспектор</option>
                    <option value=''>Психолог</option>
                  </select>
                </div>
                <div>
                  <label>Школа:</label><br></br>
                  <input type="text" className={styles.w500} />
                </div>
                <div>
                  <input type="submit" className="green_btn_admin" />
                </div>
              </form>
            </div>
          </DialogContent>
          <DialogActions>
            {/* <Button onClick={handleClose} sx={
              {
                fontSize: '2rem',
                color: '#80C342'
              }
            }>Отмена</Button> */}
            <DialogTitle onClick={handleClose} sx={
              {
                fontSize: '2rem',
                color: '#80C342'
              }
            }>Отмена</DialogTitle>
            {/* <Button onClick={handleClose}>Subscribe</Button> */}
          </DialogActions>
        </Dialog>

        <Dialog open={openFileUpload} onClose={handleCloseFile} maxWidth='xl'>
          <DialogTitle sx={
            {
              fontSize: '2rem',
              color: '#80C342'
            }
          }>Выложить файл</DialogTitle>
          <DialogContent sx={{
            width: 700,
            display: 'flex',
            flexDirection: 'column',
            alignItems: 'center',
            justifyContent: 'center'
          }
          }>
            <div className={styles.center}>
              <form onSubmit={handleSubmit(onSubmit)}>
                {/* <div>
                  <label>Название файла:</label><br></br>
                  <input type="text" className={styles.w500} />
                </div> */}
                <div>
                  <label>Прикрепить файл:</label><br></br>
                  <input
                    type="file" className={styles.w500}
                    {...register('file', {required: true})}
                  />
                </div>
                <div>
                  <input type="submit" className="green_btn_admin" />
                </div>
              </form>
            </div>
          </DialogContent>
          <DialogActions>
            {/* <Button onClick={handleClose} sx={
              {
                fontSize: '2rem',
                color: '#80C342'
              }
            }>Отмена</Button> */}
            <DialogTitle onClick={handleCloseFile} sx={
              {
                fontSize: '2rem',
                color: '#80C342'
              }
            }>Отмена</DialogTitle>
          </DialogActions>
        </Dialog>
      </div>
    </>
  );

};