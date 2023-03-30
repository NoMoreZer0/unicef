import {Requests} from './Requests';
import {
  ChangeStatus,
  CloseCase,
  CreateCase,
  Emergency,
  ID,
  Post,
} from '../types';
import {ROLE_ENDPOINTS, STUDENT_STATUS} from '../constants';

export class CaseService extends Requests {
  private readonly role: ROLE_ENDPOINTS;

  constructor(role) {
    super();
    this.role = role;
  }

  createCase(data: CreateCase) {
    const path = '/create_new_case';
    return this.post(path, data);
  }

  closeCase(data: CloseCase) {
    const path = this.role + '/close_case';
    return this.post(path, data);
  }

  changeStatus(data: ChangeStatus) {
    const path = this.role + '/change_student_status/{studentId}';
    return this.post(path, data);
  }

  createPost(data: Post) {
    const path = this.role + '/create_new_post';
    return this.post(path, data);
  }

  updatePost(data: Post) {
    const path = this.role + '/update_post';
    return this.post(path, data);
  }

  createEmergency(data: Emergency) {
    const path = this.role + '/emergency';
    return this.post(path, data);
  }

  getFilter() {
    const path = this.role + '/filter';
    return this.get(path);
  }

  getAllCases() {
    const path = '/get_all_cases';
    return this.get(path);
  }

  getAllPosts() {
    const path = this.role + '/get_all_posts';
    return this.get(path);
  }

  getAllSpecialists() {
    const path = this.role + '/get_all_users';
    return this.get(path);
  }

  getAllStudents() {
    const path = '/student';
    return this.get(path);
  }

  getAllUsers() {
    const path = '/get_all_users';
    return this.get(path);
  }

  getCase(caseId: ID) {
    const path = `/get_case/${caseId}`;
    return this.get(path);
  }

  getPost(id: ID) {
    const path = this.role + `/get_post/${id}`;
    return this.get(path);
  }

  getSpecialistPosts(userId: ID) {
    const path = this.role + `/get_posts_by_specialist/${userId}`;
    return this.get(path);
  }
  getStudent(id: ID) {
    const path = `/student/${id}`;
    return this.get(path);
  }

  getStudentByStatus(status: STUDENT_STATUS) {
    const path = this.role + `/get_students_by_status/${status}`;
    return this.get(path);
  }

  getUser(id: ID) {
    const path = this.role + `/get_user/${id}`;
    return this.get(path);
  }

  changeStudentStatus(data) {
    const path = `/student/change_student_status/${data.studentId}?status=${data.status}`;
    return this.post(path, {});
  }

  getMyCaseMeetings(userId) {
    const path = this.role + `/get_posts_by_specialist/${userId}`;
    return this.get(path);
  }

  getMeetingsByCaseId(caseId) {
    const path = this.role + `/get_posts_by_case/${caseId}`;
    return this.get(path);
  }

  createCaseMeeting(data) {
    const path = this.role + `/`;
    return this.post(path, data);
  }

  getCurrentUser() {
    const path = '/currentUser'
    return this.get(path);
  }
}
