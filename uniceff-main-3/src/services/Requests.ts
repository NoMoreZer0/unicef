import {RequestConfig} from '../types';
import {SESSION_STORAGE} from '../constants';

export const BASE_URL = 'https://pdpcm.kz/api'
export class Requests {
  baseUrl: string;

  constructor() {
    this.baseUrl = BASE_URL;
  }

  async get(path: string, config = {}) {
    const url = this.baseUrl + path;
    return await this.#makeRequest(url, config);
  }

  async delete(path: string) {
    const url = this.baseUrl + path;
    const headers = new Headers({'Content-Type': 'application/json'});
    const config = {
      method: 'DELETE',
      headers,
    };
    return await this.#makeRequest(url, config);
  }

  async post<T>(path: string, data: T) {
    const url = this.baseUrl + path;
    const headers = new Headers({'Content-Type': 'application/json'});
    const config = {
      method: 'POST',
      headers,
      body: JSON.stringify(data),
    };
    return await this.#makeRequest(url, config);
  }

  async put<T>(path: string, data: T) {
    const url = this.baseUrl + path;
    const headers = new Headers({'Content-Type': 'application/json'});
    const config = {
      method: 'PUT',
      headers,
      body: JSON.stringify(data),
    };
    return await this.#makeRequest(url, config);
  }

  async getFile(path, config = {}) {
    const url = this.baseUrl + path;
    return await this.#makeFileRequest(url, config);
  }

  async postFile(path, formData) {
    const url = this.baseUrl + path;
    const config = {
      method: 'POST',
      body: formData,
    };
    return await this.#makeFileRequest(url, config);
  }

  async #makeFileRequest(url: string, config: RequestConfig = {}) {
    try {
      this.#handleToken(config);
      const response = await fetch(url, config);
      return await response.blob();
    } catch (e) {
      console.log({error: e.message});
    }
  }

  async #makeRequest(url: string, config: RequestConfig = {}) {
    try {
      this.#handleToken(config);
      const response = await fetch(url, config);
      if (response.ok) {
        const contentType = response.headers.get('content-type');
        if (contentType && contentType.indexOf('application/json') !== -1) {
          return response.json();
        } else {
          return response.text();
        }
      } else if (response.status === 401) {
        // sessionStorage.removeItem('access_token');
        // sessionStorage.removeItem('role');
        // window.location.replace('/login');
      } else console.log({error: response.statusText});
    } catch (e) {
      console.log({error: e.message});
    }
  }

  #handleToken(config: RequestConfig) {
    const token = sessionStorage.getItem(SESSION_STORAGE.ACCESS_TOKEN);
    if (!token) return;
    if (config.headers) {
      config.headers.append('Authorization', `${token}`);
    } else {
      config.headers = new Headers({Authorization: `${token}`});
    }
  }
}