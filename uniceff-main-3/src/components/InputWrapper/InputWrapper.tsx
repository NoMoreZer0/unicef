import * as React from 'react';
import {ReactNode} from 'react';
import styles from './InputWrapper.module.scss';

type Props = {
  label?: string,
  children: ReactNode,
  error?: unknown,
  errText?: string,
}

export function InputWrapper({
                               children,
                               label,
                               error,
                               errText,
                             }: Props) {
  return (
    <div className={styles.inputContainer}>
      {label && <label>{label}</label>}
      {children}
      {error && <span>{errText}</span>}
    </div>
  );
}