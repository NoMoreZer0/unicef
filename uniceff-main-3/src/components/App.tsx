import React from 'react';
import './App.css';
import Login from '../pages/Login';
import {Account} from '../pages/Account/Account';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import Layout from './Layout';
import Contacts from '../pages/contacts';
import Register from '../pages/Register';
import StudentList from '../pages/StudentList';
import Notifications from '../pages/Notifications';
import InfoPages from '../pages/InfoPages';
import AccountLayout from './AccountLayout';
import CreateCase from '../pages/CreateCase';
import Student from '../pages/Student';
import {ROLES, ROUTES, SESSION_STORAGE} from '../constants';
import CaseList from '../pages/CaseList';
import Case from '../pages/Case';
import CasePosts from '../pages/CasePosts';
import MyReports from '../pages/MyReports';
import MyCases from './MyCases';
import Tests from '../pages/Tests'
import Form1 from '../pages/Form1';
import {AdminAccount} from '../pages/Account/AdminAccount';
import {AdminCaseList} from './AdminMenu/AdminCaseList';
import {AdminStudentList} from './AdminMenu/AdminStudentList';
import {AdminSpecialistsList} from './AdminMenu/AdminSpecialistsList';
import {Analytics} from '../pages/Analytics/Analytics';
import {NewsFeed} from '../pages/NewsFeed/NewsFeed';
import {FirstForm} from "../pages/FirstForm/FirstForm"
import {NewForm1} from "../pages/NewForm1/NewForm1"


function App() {
  const currentStudentId = 0;
  const currentCaseId = 0;
  const isPermission = sessionStorage.getItem(SESSION_STORAGE.ROLE) === 'ROLE_ADMIN';
  // todo handle permissions to make paths accessible or not
  const isLogged = sessionStorage.getItem(SESSION_STORAGE.ACCESS_TOKEN);
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path={ROUTES.REGISTER} element={<Register />} />
        <Route path="/" element={<Layout />}>
          <Route path={ROUTES.ACCOUNT} element={<AccountLayout />}>
            <Route path={ROUTES.PROFILE} element={isPermission ? <AdminAccount /> : <Account />} />
            <Route path={ROUTES.TESTS} element={<Tests currentStudentId={currentStudentId} currentCaseId={currentCaseId} />} />
            <Route path={ROUTES.REPORTS} element={<MyReports />} />
            <Route path={ROUTES.REPORTS} element={<MyCases />} />
            <Route path={ROUTES.NOTIFICATIONS} element={<Notifications />} />
            <Route path={ROUTES.STUDENTS} element={<StudentList />} />
            <Route path={ROUTES.STUDENTS + '/:studentId'} element={<Student />} />
            <Route path={ROUTES.CASES} element={<CaseList />} />
            <Route path={ROUTES.CASES + '/:caseId'} element={<Case />} />
            <Route path={ROUTES.CASES + '/:caseId/posts'} element={<CasePosts />} />
            <Route path={ROUTES.ADMIN_CASES} element={<AdminCaseList />} />
            <Route path={ROUTES.ADMIN_STUDENTS} element={<AdminStudentList />} />
            <Route path={ROUTES.ADMIN_SPECIALISTS} element={<AdminSpecialistsList />} />
            <Route path={ROUTES.ANALYTICS} element={<Analytics />} />
            <Route path={ROUTES.FEED} element={<NewsFeed />} />

          </Route>
          <Route path={ROUTES.CONTACTS} element={<Contacts />} />
          <Route path={ROUTES.SETTINGS} element={<Notifications />} />
          <Route path={ROUTES.INFO_PAGES + '/:slug'} element={<InfoPages />} />
          <Route path={ROUTES.SEARCH} element={<Notifications />} />
          {/* <Route path={ROUTES.FIRSTFORM} element={<FirstForm />} /> */}
          <Route path={ROUTES.FIRSTFORM} element={<Tests currentStudentId={0} currentCaseId={0} />} />
          {/* <Route path={ROUTES.CREATE_CASE} element={<CreateCase />} /> */}
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
