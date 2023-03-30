// @flow
import * as React from 'react';
import {useState} from 'react';
import styles from '../CreateCase/CreateCase.module.scss';
import DefaultButton from '../../components/DefaultButton';
import {STUDENT_STATUS} from '../../constants';

type Props = {
  onSelect: any,
  initialStatus: STUDENT_STATUS
};

export function SelectStatus({initialStatus, onSelect}: Props) {
  const [status, setStatus] = useState<any>(initialStatus);
  const [isOpen, setIsOpen] = useState(false);
  const selectUser = () => {
    onSelect(status);
  };
  return (
    <div>
      <label>Change Status</label>
      <div className={styles.select}>
        <div className={styles.selected}
          onClick={() => setIsOpen((prevState) => !prevState)}>{status}</div>
        {isOpen && <div className={styles.list}>
          <div className={styles.option}
            onClick={() => setStatus(STUDENT_STATUS.GREEN)}>GREEN</div>
          <div className={styles.option}
            onClick={() => setStatus(STUDENT_STATUS.GREY)}>GREY</div>
          <div className={styles.option}
            onClick={() => setStatus(STUDENT_STATUS.YELLOW)}>YELLOW</div>
          <div className={styles.option}
            onClick={() => setStatus(STUDENT_STATUS.RED)}>RED</div>
        </div>}
        <DefaultButton onClick={selectUser}>Change Status</DefaultButton>
      </div>
    </div>
  );
};