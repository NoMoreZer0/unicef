import {useAppSelector} from '../../hooks/useRedux';
import {ROLES, ROUTES, SESSION_STORAGE} from '../../constants';
import {Link} from 'react-router-dom';
import {Form1} from '../Form1/form1';
import {CuratorPart} from '../Form1/RiskFactors/Individual';

type Props = {};

export function Account(props: Props) {
  const user = useAppSelector((state) => state.user.user);
  const currentStudentId = 1;
  const currentCaseId = 1;
  // const isPermission = sessionStorage.getItem(SESSION_STORAGE.ROLE) !== ROLES.THERAPIST;
  return (
    <>
      <div className="pt60 pb90">
        <div className="container">
          <div className="zagol mb20">Ваш личный кабинет</div>
          <div className="podzag mb50">Личный кабинет пользователя, здесь собрана
            вся информация<br /> необходимая для работы.
          </div>
          <div className="account_page flex just_flex">
            <div className="acc_col acc_col1">
              <div className="acc_photo">
                <img src="/images/no_photo.png" alt="" />
              </div>
              <div className="acc_info">
                <div className="acc_title mb20">{user?.fio}</div>
                <div className="info_line"><span
                  className="gray_par">Email:</span> <a
                    href="mailto:example@mail.com">{user?.email}</a></div>
                <div className="info_line"><span
                  className="gray_par">Роль:</span> <a
                    href="mailto:example@mail.com">{user?.username}</a></div>
                <div className="info_line"><span
                  className="gray_par">Позиция:</span> <a
                    href="mailto:example@mail.com">{user?.position}</a></div>
              </div>
            </div>
            {
              // isPermission &&
              <>
                <div className="acc_col acc_col2">
                  <div className="acc_title mb20">Мои дела</div>
                  <div className="info_line">Смотреть результаты (1)</div>
                  <div className="info_line">Полученные сертификаты (0)</div>
                  <Link to={`/${ROUTES.ACCOUNT}/${ROUTES.CASES}`} className="green_link">Узнать
                    подробнее</Link>
                </div>
                <div className="acc_col acc_col3">
                  <div className="acc_title mb20">Мои ученики</div>
                  <div className="info_line">Закрепленные ученики (20)</div>
                  <div className="info_line">На особом учете (0)</div>
                  <Link to={`/${ROUTES.ACCOUNT}/${ROUTES.STUDENTS}`} className="green_link">Узнать
                    подробнее</Link>
                </div>
              </>
            }
          </div>
          {/* <TherapistPart currentStudentId={currentStudentId} currentCaseId={currentCaseId} /> */}
        </div>
      </div>
    </>
  );
};