// @flow
import * as React from 'react';
import {useState} from 'react';
import styles from './SelectWrapper.module.scss';

type Props = {
  label: string;
  data: unknown,
  handleChange: any
};


export function SelectWrapper({label, data, handleChange,  }: Props) {
  const [value, setValue] = useState('Default');
  const [isOpen, setIsOpen] = useState(false);
  return (
    <div>
      <label>{label}</label>
      <div className={styles.select}>
        <div className={styles.selected}
             onClick={() => setIsOpen((prevState) => !prevState)}>{value}</div>
        {isOpen && <div className={styles.list}>
          <div className={styles.option} onClick={handleChange}>Teacher 1</div>
        </div>}
      </div>
    </div>
  );
};