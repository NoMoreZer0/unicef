// @flow
import * as React from 'react';
import styles from '../MyReports/MyReports.module.scss';

type Props = {

};

export function Notifications(props: Props) {
  return (
    <div className={'container'}>
      <div className={styles.myMeetings}>
        <div className={styles.title}>Мои уведомления</div>
        <div className={styles.subtitle}>[Страница находится на стадии разработки]</div>

      </div>
    </div>
  );
};