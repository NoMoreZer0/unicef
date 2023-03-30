import styles from './MyReports.module.scss';
import {useEffect, useState} from 'react';
import {CaseService} from '../../services/CaseService';
import {SESSION_STORAGE} from '../../constants';
import {getRoleEndpoints} from '../../utils';
import {useAppSelector} from '../../hooks/useRedux';
import Report from '../../components/Report';
import {mediaService} from '../../services/mediaService';

type Props = {};

export function MyReports(props: Props) {
  const user = useAppSelector((state) => state.user.user);
  const [reportList, setFileList] = useState([]);
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoint = getRoleEndpoints(role);
  const media = new mediaService();

  async function getReportList() {
    if (user?.id) {
      const result = await media.getAllFiles();
      if (result) {
        setFileList(result);
      }
    }
  }

  useEffect(() => {
    getReportList();
  }, [user]);

  return (
    <div className={'container'}>
      <div className={styles.myMeetings}>
        <div className={styles.title}>Доступные файлы</div>
        {/* <div className={styles.subtitle}>[]</div> */}
        <div className={styles.list}>
          {reportList?.map((el, i) => (
            // <Report isEditable data={el} key={i} />
            <a href={el}> Файл № {i + 1}</a>
          ))}
        </div>
      </div>
    </div>
  );
};