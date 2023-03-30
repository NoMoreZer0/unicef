import {CASE_STATUS, GENDER, ROLES, STUDENT_STATUS} from '../constants';

export type ID = number;

export interface LoginData {
  username: string,
  password: string
}

export interface RegisterData {
  username: string,
  password: string
}

export interface FormData {
  studentId: string,
  caseId: string,
  formContent: {}
}

export interface RequestConfig {
  method?: string;
  body?: string | URLSearchParams;
  headers?: Headers;
}

export interface CaseBasicInfo {
  closingDate: string,
  openingDate: string,
  id: ID,
  whoStated: string,
  users: User[],
}

export interface CreateCase extends CaseBasicInfo {
  reason: string,
  studentId: ID,
}

export interface CaseFullInfo extends CaseBasicInfo {
  closingReason: string,
  caseStatus: CASE_STATUS,
  openingReason: string,
  student: StudentType,
  curator: Curator
  users: [
    {
      accountNonExpired: true,
      accountNonLocked: true,
      authorities: [
        {
          authority: string
        }
      ],
      credentialsNonExpired: true,
      email: string,
      fio: string,
      id: 0,
      isCurator: true,
      notifications: [
        {
          message: string,
          users: [
            null
          ]
        }
      ],
      phoneNumber: string,
      position: string,
      role: string,
      school: string,
      username: string
    }
  ],
}

export interface CloseCase {
  caseId: ID,
  closingReason: string
}

export interface User {
  email: string,
  fio: string,
  phoneNumber: string,
  position: string,
  school: string,
  username: string,
  id?: ID
}

export interface ChangeStatus {
  studentId: ID,
  status: STUDENT_STATUS
}

export interface Post {
  caseId?: ID,
  postId?: ID,
  date: string,
  meetingHolderId: ID,
  post?: string,
  rating?: string,
  id?: ID,
  meetingHolder?: User,
}

export interface Emergency {
  formAgreement: string,
  formAlgorithm: string
  formRejection: string,
  informedAdministrationFIO: string,
  informedParentFIO: string,
  isStudentIsolated: string,
  isStudentTransferred: string
}

export interface Curator {
  accountNonExpired: boolean,
  accountNonLocked: boolean,
  authorities: Array<{ authority: string }>,
  credentialsNonExpired: boolean,
  email: string,
  enabled: boolean,
  fio: string,
  id: ID,
  phoneNumber: string,
  position: string,
  role: ROLES,
  school: string
}

export interface StudentType {
  nameOfStudent: string,
  gender: GENDER,
  grade: string,
  id: ID,
  language: string,
  parents: Array<Parents>
  phoneNumber: string,
  school: string,
  studentStatus: STUDENT_STATUS
}

export interface Parents {
  nameOfParent: string,
  id: ID,
  phoneNumber: string
}

export interface CreatePost {
  caseId: number,
  date: string,
  meetingHolderId: number
}

export interface UpdatePost extends CreatePost {
  post: string,
  rating: string
}

export interface PostContent {
  id: number,
  label: string,
  timestamp: string,
  topic: string
}

export interface StudentAnalytics {
  CLOSED: number,
  DEEP_FORM: number,
  PLAN_FORM: number,
  OPEN: number
}

export interface CaseAnalytics {
  YELLOW: number,
  RED: number,
  GREY: number,
  GREEN: number
}
