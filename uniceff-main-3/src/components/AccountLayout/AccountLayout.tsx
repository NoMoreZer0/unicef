// @flow
import * as React from 'react';
import AdminMenu from '../AdminMenu';
import {Outlet} from 'react-router-dom';

type Props = {
  
};

export function AccountLayout(props: Props) {
  return (
    <div>
      <AdminMenu/>
      <Outlet/>
    </div>
  );
};