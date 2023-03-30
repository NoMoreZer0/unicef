// @flow
import * as React from 'react';
import {useEffect, useState} from 'react';
import Meeting from '../../components/Report';
import {CaseService} from '../../services/CaseService';
import {SESSION_STORAGE} from '../../constants';
import {getRoleEndpoints} from '../../utils';
import {useParams} from 'react-router-dom';
import styles from './CaseMeetings.module.scss';

type Props = {};

export function CasePosts(props: Props) {
  const {caseId} = useParams();
  const [postList, setPostList] = useState([]);
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoints = getRoleEndpoints(role);
  const caseService = new CaseService(roleEndpoints);

  async function getPostList() {
    const res = await caseService.getMeetingsByCaseId(caseId);
    setPostList(res);
  }

  useEffect(() => {
    getPostList();
  }, []);
  return (
    <div className={'container'}>
      <div className={styles.caseMeeting}>
        <div className={styles.title}>Все отчеты по делу</div>
        {postList?.map((el, i) => (
          <Meeting data={el} key={i}/>
        ))}
      </div>
    </div>
  );
};