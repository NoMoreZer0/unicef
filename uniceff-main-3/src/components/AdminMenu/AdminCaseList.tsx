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
    field: 'openingDate',
    headerName: 'Начало срока',
    width: 130,

  },
  {
    field: 'closingDate',
    headerName: 'Конец срока',
    width: 130,

  },
  {
    field: 'openingReason',
    headerName: 'Причина открытия',
    width: 130,

  },
  {
    field: 'closingReason',
    headerName: 'Причина закрытия',
    width: 130,
  },
  {
    field: 'whoStated',
    headerName: 'Кто доложил',
    width: 130,

  },
  {
    field: 'caseStatus',
    headerName: 'Статус',
    width: 130,
    hideable: false,
    renderCell({row}) {
      return <div className={'status-cell'}
        style={{backgroundColor: getBgColorByCaseStatus(row.caseStatus)}}>{row.caseStatus}</div>;
    },
  },
];

export function AdminCaseList(props: Props) {
  const [caseList, setCaseList] = useState([]);
  const navigate = useNavigate();
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoints = getRoleEndpoints(role);
  const caseService = new CaseService(roleEndpoints);

  async function getCaseList() {
    const res = await caseService.getAllCases();
    if (res) {
      setCaseList(res);
    }
  }

  useEffect(() => {
    getCaseList();

  }, []);
  return (
    <div className={'container'}>
      <div style={{height: 600, width: '100%', margin: '10px 0'}}>
        <DataGrid
          rows={caseList}
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