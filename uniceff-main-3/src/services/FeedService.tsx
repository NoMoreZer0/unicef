import {Requests} from './Requests';
import {FormData} from '../types';

export class FeedService extends Requests {

  sendPost(dataNews) {
    const path = `/news`;
    return this.post(path, dataNews);
    ;
  }

  getAllPosts() {
    const path = '/news';
    return this.get(path);
  }

}