// @flow
import * as React from 'react';
import {useEffect, useState} from 'react';
import {DataGrid, GridColDef} from '@mui/x-data-grid';
import {useNavigate} from 'react-router-dom';
import {SESSION_STORAGE} from '../../constants';
import {getBgColorByCaseStatus, getRoleEndpoints} from '../../utils';
import {CaseService} from '../../services/CaseService';

type Props = {};

export function usefulDocuments(props: Props) {
  return (
    <div className={'container'}>

    </div>
  );
};