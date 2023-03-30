// @flow
import * as React from 'react';
import {useEffect, useState} from 'react';
import {DataGrid, GridColDef} from '@mui/x-data-grid';
import './StudentList.scss';
import {
  getBgColorByStatus,
  getRoleEndpoints,
  getTextByStatus,
} from '../../utils';
import {useNavigate} from 'react-router-dom';
import {CaseService} from '../../services/CaseService';
import {SESSION_STORAGE} from '../../constants';
import {Autocomplete, TextField} from '@mui/material';

type Props = {};

const columns: GridColDef[] = [
  {field: 'id', headerName: 'ID', width: 70, hideable: false},
  {field: 'nameOfStudent', headerName: 'ФИО', width: 130},
  {
    field: 'language',
    headerName: 'Язык обучения',
    type: 'number',
    width: 90,
  },
  {
    field: 'grade',
    headerName: 'Класс',
    width: 90,
  },
  {
    field: 'Статус',
    headerName: 'Школа',
    width: 90,

  },
  {
    field: 'phoneNumber',
    headerName: 'Телефон',
    width: 130,

  },
  {
    field: 'studentStatus',
    headerName: 'Статус',
    width: 130,
    align: 'center',
    hideable: false,
    renderCell({row}) {
      return <div className={'status-cell'}
        style={{backgroundColor: getBgColorByStatus(row.studentStatus)}}>{getTextByStatus(row.studentStatus)}</div>;
    },
  },
];

const rows = [
  {id: 1, lastName: 'Snow', firstName: 'Jon', age: 35, status: 0},
  {id: 2, lastName: 'Lannister', firstName: 'Cersei', age: 42, status: 1},
  {id: 3, lastName: 'Lannister', firstName: 'Jaime', age: 45, status: 2},
  {id: 4, lastName: 'Stark', firstName: 'Arya', age: 16},
  {id: 5, lastName: 'Targaryen', firstName: 'Daenerys', age: null},
  {id: 6, lastName: 'Melisandre', firstName: null, age: 150},
  {id: 7, lastName: 'Clifford', firstName: 'Ferrara', age: 44},
  {id: 8, lastName: 'Frances', firstName: 'Rossini', age: 36},
  {id: 9, lastName: 'Roxie', firstName: 'Harvey', age: 65},
];

export function StudentList(props: Props) {
  const [studentList, setStudentList] = useState([]);
  const navigate = useNavigate();
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoints = getRoleEndpoints(role);
  const caseService = new CaseService(roleEndpoints);

  async function getStudentList() {
    const res = await caseService.getAllStudents();
    if (res) {
      setStudentList(res);
    }
  }

  useEffect(() => {
    getStudentList();
  }, []);
  return (
    <div className={'container'}>
      <Autocomplete
        id="free-solo-demo"
        freeSolo
        options={studentList.map((option) => option.nameOfStudent)}
        renderInput={(params) => <TextField {...params} label="Поиск студентов" />}
      />
      <div style={{height: 600, width: '100%', margin: '10px 0'}}>
        <DataGrid
          rows={studentList}
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
}
