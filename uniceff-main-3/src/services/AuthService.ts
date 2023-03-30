import {Requests} from './Requests';
import {LoginData, RegisterData} from '../types';
import {SESSION_STORAGE} from '../constants';

export class AuthService extends Requests {
  async login(data: LoginData) {
    const path = '/authenticate';
    const response = await this.post(path, data);
    if (response.token) {
      sessionStorage.setItem(SESSION_STORAGE.ACCESS_TOKEN, response.token);
      sessionStorage.setItem(SESSION_STORAGE.ROLE, response.role);
      console.log(sessionStorage.getItem(SESSION_STORAGE.ACCESS_TOKEN));
    }
    return response;
  }

  register(data: RegisterData) {
    const path = '/register';
    return this.post(path, data);
  }

  logout() {
    const path = '/logout';
    sessionStorage.removeItem(SESSION_STORAGE.ACCESS_TOKEN);
    sessionStorage.removeItem(SESSION_STORAGE.ROLE);
    return this.get(path);
  }
}