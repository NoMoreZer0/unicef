// @flow
import * as React from 'react';
import {ReactNode} from 'react';
import {COLORS} from '../../constants';

type Props = {
  onClick?: () => void,
  children: ReactNode,
  bgColor?: string,
  maxWidth?: string,
  type?: 'button' | 'submit' | 'reset'
};

export function SecondaryButton({
                                onClick,
                                children,
                                bgColor = COLORS.BLACK,
                                maxWidth = '100%',
                                type,
                              }: Props) {
  return (
    <button type={type}
            onClick={onClick}
            className={'head_btn'}>
      {children}
    </button>
  );
};