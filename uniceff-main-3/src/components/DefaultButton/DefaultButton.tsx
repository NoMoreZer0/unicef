// @flow
import * as React from 'react';
import {ReactNode} from 'react';

type Props = {
  onClick?: () => void,
  children: ReactNode,
  bgColor?: string,
  maxWidth?: string,
  type?: 'button' | 'submit' | 'reset',
  filled?: boolean,
};

export function DefaultButton({
                                onClick,
                                children,
                                maxWidth = '100%',
                                type,
                                filled,
                              }: Props) {
  return (
    <button type={type}
            onClick={onClick}
            style={{maxWidth}}
            className={`green_btn ${filled ? 'green_green' : ''}`}>
      {children}
    </button>
  );
};