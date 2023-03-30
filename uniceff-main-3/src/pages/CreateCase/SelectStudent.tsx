// @flow
import * as React from 'react';
import {useState} from 'react';
import styles from './CreateCase.module.scss';

type Props = {
  handleSearch: any,
  searchText: string,
  selectStudent: any,
  data: any
};


export function SelectStudent({
  searchText,
  handleSearch,
  selectStudent,
  data,
}: Props) {
  return (
    <div className={styles.search}>
      <input className={styles.searchInput} value={searchText}
        onChange={handleSearch}
        placeholder={'Найти студента'} />
      {searchText && <div className={styles.studentList}>
        {data.map((el, i) => (
          <div onClick={() => selectStudent(el)}>{el.fio}</div>
        ))}
      </div>}
    </div>
  );
};