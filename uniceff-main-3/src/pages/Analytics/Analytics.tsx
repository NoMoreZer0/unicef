import {useAppSelector} from '../../hooks/useRedux';
import {ROLES, ROUTES, SESSION_STORAGE} from '../../constants';

import {DataGrid, GridColDef} from '@mui/x-data-grid';
import {Box, Divider, Typography} from '@mui/material';
import {useEffect, useState} from 'react';
import {AnalyticsService} from '../../services/AnalyticsService';
// import {StudentAnalytics, CaseAnalytics} from '../../types';

type Props = {};

const columns: GridColDef[] = [
  {field: 'id', headerName: 'ID', width: 70, hideable: false},
  {field: 'status', headerName: 'Статус ученика', width: 290, hideable: false},
  {field: 'number', headerName: 'Количество учеников', width: 180}
];

const columnsCase: GridColDef[] = [
  {field: 'id', headerName: 'ID', width: 70, hideable: false},
  {field: 'status', headerName: 'Статус ', width: 290, hideable: false},
  {field: 'number', headerName: 'Количество', width: 180}
];

interface StudentAnalytics {
  YELLOW: number,
  RED: number,
  GREY: number,
  GREEN: number
}
interface CaseAnalytics {
  CLOSED: number,
  DEEP_FORM: number,
  PLAN_FORM: number,
  OPEN: number
}
export function Analytics(props: Props) {
  const [caseAnalytics, setCaseAnalytics] = useState<CaseAnalytics>({
    CLOSED: 0,
    DEEP_FORM: 0,
    PLAN_FORM: 0,
    OPEN: 0
  });
  const [studentAnalytics, setStudentAnalytics] = useState<StudentAnalytics>({
    YELLOW: 0,
    RED: 0,
    GREY: 0,
    GREEN: 0
  });

  const analyticsService = new AnalyticsService();

  async function getCaseAnalytics() {
    const res = await analyticsService.getCaseAnalytics();
    if (res) {
      setCaseAnalytics(res);
    }
  }

  async function getStudentAnalytics() {
    const res = await analyticsService.getStudentAnalytics();
    if (res) {
      setStudentAnalytics(res);
    }
  }

  const rows = [
    {id: '1', status: 'Красный', number: `${studentAnalytics.RED}`},
    {id: '2', status: 'Желтый', number: `${studentAnalytics.YELLOW}`},
    {id: '3', status: 'Зеленый', number: `${studentAnalytics.GREEN}`},
    {id: '4', status: 'Серый', number: `${studentAnalytics.GREY}`},
  ];

  const rowsCases = [
    {id: '1', status: 'Количество открытых дел', number: `${caseAnalytics.OPEN}`},
    {id: '2', status: 'Количество закрытых дел', number: `${caseAnalytics.CLOSED}`},
    {id: '3', status: 'Количество заполненных форм "Глубинная оценка"', number: `${caseAnalytics.DEEP_FORM}`},
    {id: '4', status: 'Количество заполненных форм "План развития"', number: `${caseAnalytics.PLAN_FORM}`},
  ];


  useEffect(() => {
    getCaseAnalytics();
    getStudentAnalytics();
  }, []);



  return (
    <>
      <div className="pt60 pb90">
        <div className="container">
          <div className="zagol mb20">Аналитика</div>
          <div className="podzag mb50">Страница для отображения данных об учениках и кейсах
          </div>
          <Typography variant="h3" component="h3">
            Количество учеников по статусам
          </Typography>
          <div style={{height: 320, width: '100%', margin: '10px 0'}}>
            <DataGrid
              rows={rows}
              columns={columns}
              pageSize={10}
              rowsPerPageOptions={[4]}
            />
          </div>
          <Box sx={{marginTop: '3rem', color: '#fff'}}>.</Box>
          <Typography variant="h3" component="h3">
            Количество кейсов по статусам
          </Typography>
          <div style={{height: 320, width: '100%', margin: '10px 0'}}>
            <DataGrid
              rows={rowsCases}
              columns={columnsCase}
              pageSize={10}
              rowsPerPageOptions={[4]}
            />
          </div>
        </div>
      </div>
    </>
  );
};