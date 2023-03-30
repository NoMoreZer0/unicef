import './Header.scss';
import {Link, useNavigate} from 'react-router-dom';
import {ROLES, ROUTES, SESSION_STORAGE} from '../../constants';
import SecondaryButton from '../SecondaryButton';

type Props = {};

export function Header(props: Props) {
  const navigate = useNavigate();
  const isPermission = sessionStorage.getItem(SESSION_STORAGE.ROLE) === "ROLE_CASE_MANAGER";
  console.log(sessionStorage.getItem(SESSION_STORAGE.ROLE))
  return (
    <header>
      <div className="head_top">
        <div className="container">
          <div className="head_flex">
            <div className="head_top_left">
              <Link to={'/' + ROUTES.ACCOUNT} className="logo">
                <img src="/images/logo.svg" alt="" />
                <span className="logo_text">Электронный методический центр для психологического сопровождения учащихся</span>
              </Link>
            </div>
            <div className="head_top_right">
              <Link to={ROUTES.ACCOUNT}
                className="eyes bvi-panel-open header-bvi">
                <img src="/images/icons/eyes.svg" alt="" />
                <span
                  className="eyes_text">версия сайта для слабовидящих</span>
              </Link>
              <div className="hotline">
                <img src="/images/icons/phone.svg" alt="" />
                <div className="hotline_info">
                  <span>горячая линия</span>
                  <a className="bold" href="tel:+7 (7172) 77-77-77">+7
                    (7172) 77-77-77</a>
                </div>
              </div>
              <Link className="green_btn" to={ROUTES.LOGIN}>ВЫЙТИ</Link>
            </div>
          </div>
        </div>
      </div>
      <div className="head_bottom">
        <div className="container">
          <div className="head_flex">
            <ul className="menu">
              <li><Link to={ROUTES.ACCOUNT}>ГЛАВНАЯ</Link></li>
              <li><Link to={ROUTES.INFO_PAGES + '/therapists'}>ПСИХОЛОГАМ</Link>
              </li>
              <li><Link to={ROUTES.INFO_PAGES + '/about'}>О ПОРТАЛЕ</Link></li>
              <li><Link to={ROUTES.CONTACTS}>КОНТАКТЫ</Link></li>
            </ul>
            <div className="head_bottom_right">
              <Link to={ROUTES.FIRSTFORM} className='form-btn'>Заполнить первичную форму</Link>
              <form id="language" className="lang">
                <label htmlFor="kz_lang" className="lang_item">
                  <input type="radio" name="kz" value="kz" id="kz_lang"
                    checked />
                  <span>КАЗ</span>
                </label>
                <label htmlFor="ru_lang" className="lang_item">
                  <input type="radio" name="ru" value="ru" id="ru_lang" />
                  <span>РУС</span>
                </label>
              </form>
              <Link to={ROUTES.SEARCH} className="search_link">
                <img src="/images/icons/search.svg" alt="" />
              </Link>

              {/* {
                isPermission &&
                <SecondaryButton onClick={() => navigate(ROUTES.CREATE_CASE)}>
                  Создать дело
                </SecondaryButton>
              } */}
            </div>
          </div>
        </div>
      </div>
    </header>
  );
};