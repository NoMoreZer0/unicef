// @flow
import * as React from 'react';
import {Link, useNavigate} from 'react-router-dom';
import {ROUTES} from '../../constants';
import {AuthService} from '../../services/AuthService';
import {useForm} from 'react-hook-form';

type Props = {
  
};

export function Register(props: Props) {
  const authService = new AuthService();
  const navigate = useNavigate();
  const {register, handleSubmit, watch, formState: {errors}} = useForm();
  const onSubmit = async data => {
    const response = await authService.register(data);
    navigate('/login')
  };
  return (
    <div className="login_page">
      <div className="login_block">
        <img src="/images/white_logo.svg" alt="" className="white_logo"/>
        <div className="white log_title centered mb20">Зарегистировать пользователя</div>
        <div className="white log_text">Еще не зарегистрированны? <a
          href="src/pages/Login/Login#"
          className="bold">Регистрация</a>
        </div>
        <form id="auth" className="auth_form" onSubmit={handleSubmit(onSubmit)}>
          <label htmlFor="mail_field" className="gray_field w60">
            <input {...register('username', {required: true})} type="text"
                   id="mail_field" name="username"
                   placeholder="Username" required/>
          </label>
          <label htmlFor="pass_field" className="gray_field pass_field w40">
            <input  {...register('password', {required: true})}
                    type="password"
                    name="password" id="pass_field"
                    placeholder="Пароль" required/>
            <span className="vis_pass">
                  <img
                    src="/images/icons/password.svg" alt=""/>
                </span>
          </label>
          <input type="submit" value="Войти в систему"
                 className="green_btn green_green w100"/>
        </form>
        <Link to={ROUTES.LOGIN}  className="white centered forgot_pass">Забыли
          пароль?</Link>
      </div>
    </div>
  );
};