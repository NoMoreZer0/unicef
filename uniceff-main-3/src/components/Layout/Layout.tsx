// @flow
import * as React from 'react';
import {useEffect} from 'react';
import Footer from '../Footer';
import Header from '../Header';
import {Outlet} from 'react-router-dom';
import {SESSION_STORAGE} from '../../constants';
import {getRoleEndpoints} from '../../utils';
import {useAppDispatch} from '../../hooks/useRedux';
import {fetchUser} from '../../redux/features/user';

type Props = {};

export function Layout(props: Props) {
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoint = getRoleEndpoints(role);
  const dispatch = useAppDispatch();

  useEffect(() => {
    dispatch(fetchUser({role: roleEndpoint}));
  }, []);
  return (
    <>
      <Header/>
      <Outlet/>
      <Footer/>
    </>
  );
};