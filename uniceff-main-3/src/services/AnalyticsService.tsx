import {Requests} from './Requests';
import {FormData} from '../types';

export class AnalyticsService extends Requests {

  getCaseAnalytics() {
    const path = `/analytics/cases`;
    return this.get(path);
    ;
  }

  getStudentAnalytics() {
    const path = '/analytics/students';
    return this.get(path);
  }

}