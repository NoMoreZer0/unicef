import {Requests} from './Requests';
import {FormData} from '../types';

export class mediaService extends Requests {

  uploadFile(formData) {
    const path = `/media/file`;
    return this.postFile(path, formData);
    ;
  }


  getAllFiles() {
    const path = `/media/file-link`;
    return this.get(path);
  }

}