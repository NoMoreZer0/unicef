// @flow
import * as React from 'react';
import {useEffect, useState} from 'react';
import './Student.scss';
import {CaseService} from '../../services/CaseService';
import {ROUTES, SESSION_STORAGE} from '../../constants';
import {useNavigate, useParams} from 'react-router-dom';
import {StudentType} from '../../types';
import {getRoleEndpoints} from '../../utils';
import DefaultButton from '../../components/DefaultButton';
import Modal from '../../components/Modal';
import {SelectStatus} from '../Case/SelectStatus';
import CreateCase from '../CreateCase';

type Props = {};

export function Student(props: Props) {
  const navigate = useNavigate();
  const [isOpen, setIsOpen] = useState(false);
  const {studentId} = useParams();
  const [studentInfo, setStudentInfo] = useState<StudentType>();
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoints = getRoleEndpoints(role);
  const caseService = new CaseService(roleEndpoints);

  const onSelect = async (status) => {
    const response = await caseService.changeStudentStatus({
      studentId: studentId,
      status,
    });
    setIsOpen(false);
    getStudentInfo()
  };

  async function getStudentInfo() {
    const response = await caseService.getStudent(Number(studentId));
    setStudentInfo(response);
    console.log(studentInfo)
  }

  useEffect(() => {
    getStudentInfo();
  }, []);

  return (
    <div className="container pt60 pb90">
      <div className="studentProfileHeader"> Профиль ученика</div>
      <div className="table">
        <div className="row">
          <div className="column1">ФИО:</div>
          <div className="column2">{studentInfo?.nameOfStudent ? studentInfo.nameOfStudent : 'blank'}</div>
        </div>
        <div className="row">
          <div className="column1">Пол:</div>
          <div className="column2">{studentInfo?.gender}</div>
        </div>
        <div className="row">
          <div className="column1">Год обучения:</div>
          <div className="column2">{studentInfo?.grade}</div>
        </div>
        <div className="row">
          <div className="column1">ID:</div>
          <div className="column2">{studentInfo?.id}</div>
        </div>
        <div className="row">
          <div className="column1">Язык обучения:</div>
          <div className="column2">{studentInfo?.language}</div>
        </div>
        {/* <div className='row'>
          <div className='column1'>Родители:</div>
          <div className='column2'>{studentInfo?.parents.map((el, i) => (studentInfo?.parents[i]))}</div>
        </div> */}
        <div className="row">
          <div className="column1">Номер телефона:</div>
          <div className="column2">{studentInfo?.phoneNumber}</div>
        </div>
        <div className="row">
          <div className="column1">Школа:</div>
          <div className="column2">{studentInfo?.school}</div>
        </div>
        <div className="row">
          <div className="column1">Статус:</div>
          <div className="column2">{studentInfo?.studentStatus}</div>
        </div>
      </div>
      <DefaultButton onClick={() => setIsOpen(true)}>
        Change Status
      </DefaultButton>
      {/* <DefaultButton onClick={() => navigate(ROUTES.CREATE_CASE)}>
        Создать дело
      </DefaultButton> */}

      <CreateCase studentId={studentInfo?.id}></CreateCase>

      <Modal open={isOpen} handleClose={() => setIsOpen(false)}>
        {studentInfo?.studentStatus && <SelectStatus onSelect={onSelect}
          initialStatus={studentInfo.studentStatus} />}
      </Modal>
    </div>
  );
};
