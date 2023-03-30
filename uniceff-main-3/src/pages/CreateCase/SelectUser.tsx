// @flow
import * as React from 'react';
import {useState} from 'react';
import styles from './CreateCase.module.scss';
import DefaultButton from '../../components/DefaultButton';

type Props = {
  data: any,
  handleChange: any,
};


export function SelectUser({data, handleChange}: Props) {
  const [user, setUser] = useState<any>();
  const [isOpen, setIsOpen] = useState(false);
  const selectUser = () => {
    handleChange(user);
  };
  return (
    <div>
      <label>Add User</label>
      <div className={styles.select}>
        <div className={styles.selected}
          onClick={() => setIsOpen((prevState) => !prevState)}>{user?.fio || ''}</div>
        {isOpen && <div className={styles.list}>
          {data.map((el, i) => (
            <div className={styles.option}
              onClick={() => setUser(el)}><span>{el.fio} </span><span>{el.position}</span></div>
          ))}
        </div>}
        <DefaultButton onClick={selectUser}>Add Stuff</DefaultButton>
      </div>
    </div>
  );
};