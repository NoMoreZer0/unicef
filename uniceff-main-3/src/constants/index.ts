export enum   ROUTES {
  MAIN = '/',
  LOGIN = '/',
  REGISTER = 'register',
  ADMIN = 'admin',
  PROFILE = 'profile',
  // INIT_TEST = 'profile/tests',
  SETTINGS = 'settings',
  NOTIFICATIONS = 'notifications',
  STUDENTS = 'students',
  TESTS = 'tests',
  EDU_BASE = 'edu-base',
  REPORTS = 'reports',
  SEARCH = 'search',
  INFO_PAGES = 'info-pages',
  CONTACTS = 'contacts',
  ACCOUNT = 'account',
  CREATE_CASE = 'create-case',
  CASES = 'cases',
  ADMIN_CASES = 'admin-cases',
  ADMIN_STUDENTS = 'admin-students',
  ADMIN_SPECIALISTS = 'admin-specialists',
  ANALYTICS= 'analytics',
  FEED='feed',
  FIRSTFORM= 'first-form'
}

export enum PERMISSIONS {
  ADMIN,
  THERAPIST,
}

export enum ROLES {
  THERAPIST = 'ROLE_THERAPIST',
  MEDICAL_WORKER = 'ROLE_MED',
  // SOCIAL_TEACHER = '',
  // CURATOR = '',
  HEAD_TEACHER = '',
  SUBJECT_TEACHER = 'ROLE_TEACHER'
}

export enum ROLE_ENDPOINTS {
  THERAPIST = '/role_therapist',
  MEDICAL_WORKER = '/role_med',
  HEAD_TEACHER = '/role_principle',
  SUBJECT_TEACHER = '/role_teacher'
}

export enum COLORS {
  YELLOW = '#F7A325',
  OCEAN_BLUE = '#BCD7DA',
  RED = '#ef233c',
  BLACK = '#151E27',
  GRAY = '#f0f0f5',
  DARK_GRAY = '#9DA2A5',
  LIGHT_GRAY = '#E2E8F0',
  GREEN = '#80C342'
}

export enum INPUT_FIELD {
  NAME = 'name',
  SURNAME = 'surname',
  USERNAME = 'username',
  EMAIL = 'email',
  PHONE = 'phone',
  PASSWORD = 'password',
  TEXT = 'text',
  WORD = 'word',
  IIN = 'iin'
}

export enum SESSION_STORAGE {
  ACCESS_TOKEN = 'access_token',
  ROLE = 'role'
}

export enum STUDENT_STATUS {
  GREEN = 'GREEN',
  YELLOW = 'YELLOW',
  RED = 'RED',
  GREY = 'GREY'
}

export enum CASE_STATUS {
  CLOSED = 'CLOSED',
  OPEN = 'OPEN'
}

export enum GENDER {
  FEMALE = 'female',
  MALE = 'male'

}

export enum NOTIFICATION {
  DEFAULT = '',
  SUCCESS = 'success',
  WARNING = 'warning',
  ERROR = 'error',
  INFO = 'info'
}