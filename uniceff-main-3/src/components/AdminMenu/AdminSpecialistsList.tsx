// @flow
import * as React from 'react';
import {useEffect, useState} from 'react';
import {DataGrid, GridColDef} from '@mui/x-data-grid';
import {useNavigate} from 'react-router-dom';
import {SESSION_STORAGE} from '../../constants';
import {getBgColorByCaseStatus, getRoleEndpoints} from '../../utils';
import {CaseService} from '../../services/CaseService';

type Props = {};

const columns: GridColDef[] = [
  {field: 'id', headerName: 'ID', width: 70, hideable: false},
  {
    field: 'fio',
    headerName: 'ФИО',
    width: 130,

  },
  {
    field: 'email',
    headerName: 'Почта',
    width: 130,

  },
  {
    field: 'phoneNumber',
    headerName: 'Телефон',
    width: 130,

  },
  {
    field: 'position',
    headerName: 'Должность',
    width: 130,
  },
  {
    field: 'id',
    headerName: 'ID',
    width: 130,

  },
  {
    field: 'role',
    headerName: 'Роль',
    width: 130,
  },
];

export function AdminSpecialistsList(props: Props) {
  const [specialist, setSpecialist] = useState([]);
  const navigate = useNavigate();
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoints = getRoleEndpoints(role);
  const caseService = new CaseService(roleEndpoints);

  async function getAllSpecialists() {
    const res = await caseService.getAllUsers();
    if (res) {
      setSpecialist(res);
    }
  }

  useEffect(() => {
    getAllSpecialists();
  }, []);
  return (
    <div className={'container'}>
      <div style={{height: 600, width: '100%', margin: '10px 0'}}>
        <DataGrid
          rows={specialist}
          columns={columns}
          pageSize={10}
          rowsPerPageOptions={[10]}
          onSelectionModelChange={(ids) => {
            navigate(`${ids[0]}`);
          }}
        />
      </div>
    </div>
  );
};