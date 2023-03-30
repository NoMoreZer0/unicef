import {
  CASE_STATUS,
  ROLE_ENDPOINTS,
  ROLES,
  SESSION_STORAGE,
  STUDENT_STATUS,
} from '../constants';

export function getTextByStatus(status: STUDENT_STATUS) {
  switch (status) {
    case STUDENT_STATUS.GREEN:
      return 'green';
    case STUDENT_STATUS.YELLOW:
      return 'yellow';
    case STUDENT_STATUS.RED:
      return 'red';
      case STUDENT_STATUS.GREY:
        return '#808080';
  }
}

export function getBgColorByStatus(status: STUDENT_STATUS) {
  switch (status) {
    case STUDENT_STATUS.GREEN:
      return '#81C342';
    case STUDENT_STATUS.YELLOW:
      return '#ffcd29';
    case STUDENT_STATUS.RED:
      return '#F24822';
    case STUDENT_STATUS.GREY:
        return '#808080';

  }
}

export function getBgColorByCaseStatus(status: CASE_STATUS) {
  switch (status) {
    case CASE_STATUS.OPEN:
      return '#81C342';
    case CASE_STATUS.CLOSED:
      return '#F24822';
  }
}


export function getRoleEndpoints(role) {
  switch (role) {
    case ROLES.THERAPIST:
      return ROLE_ENDPOINTS.THERAPIST;
    case ROLES.MEDICAL_WORKER:
      return ROLE_ENDPOINTS.MEDICAL_WORKER;
    case ROLES.HEAD_TEACHER:
      return ROLE_ENDPOINTS.HEAD_TEACHER;
    case ROLES.SUBJECT_TEACHER:
      return ROLE_ENDPOINTS.SUBJECT_TEACHER;
    default:
      return null;
  }
}

export function isPathActive(route) {
  const pathname = window.location.pathname;
  return pathname.includes(route);
}

export function isTherapist() {
  return sessionStorage.getItem(SESSION_STORAGE.ROLE) === ROLES.THERAPIST;
}