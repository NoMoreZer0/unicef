import {Link, useNavigate} from 'react-router-dom';
import '../../Auth.scss';
import {AuthService} from '../../services/AuthService';
import {useForm} from 'react-hook-form';
import {ROUTES} from '../../constants';

type Props = {};

export function Login(props: Props) {
  const authService = new AuthService();
  const navigate = useNavigate();
  const {register, handleSubmit, watch, formState: {errors}} = useForm();
  const onSubmit = async data => {
    const response = await authService.login(data);
    if (response) {
      navigate(`/${ROUTES.ACCOUNT}/${ROUTES.PROFILE}`);
    }
  };

  return (
    <div className="login_page">
      <div className="login_block">
        <img src="/images/white_logo.svg" alt="" className="white_logo" />
        <div className="white log_title centered mb20">войти в систему</div>
        {/* <div className="white log_text">Еще не зарегистрированы? <a
          href="src/pages/Login/Login#"
          className="bold">Регистрация</a>
        </div> */}
        <form id="auth" className="auth_form" onSubmit={handleSubmit(onSubmit)}>
          <label htmlFor="mail_field" className="gray_field ">
            <input {...register('username', {required: true})} type="text"
              id="mail_field" name="username"
              placeholder="Username" required />
          </label>
          <label htmlFor="pass_field" className="gray_field pass_field ">
            <input  {...register('password', {required: true})}
              type="password"
              name="password" id="pass_field"
              placeholder="Пароль" required />
            <span className="vis_pass">
              <img
                src="/images/icons/password.svg" alt="" />
            </span>
          </label>
          <input type="submit" value="Войти в систему"
            className="green_btn green_green w100" />
        </form>
        {/* <Link to={ROUTES.LOGIN} className="white centered forgot_pass">Забыли
          пароль?</Link> */}
      </div>
    </div>
  );
};