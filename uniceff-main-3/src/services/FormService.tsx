import {Requests} from './Requests';
import {FormData} from '../types';

export class FormService extends Requests {

  sendForm(dataForm1, studentId: number) {
    const path = `/form/first_phase/${studentId}`;
    return this.post(path, dataForm1);
    ;
  }

  sendSecondForm(dataForm2, studentId: number, caseId: number) {
    const path = `/form/second_phase/${studentId}?caseId=${caseId}`;
    return this.post(path, dataForm2);
    ;
  }

  sendFourthForm(dataForm4, studentId: number, caseId: number) {
    const path = `/form/fourth_phase/${studentId}?caseId=${caseId}`;
    return this.post(path, dataForm4);
    ;
  }

  downloadForm2(formId) {
    const path = `/form/second_phase/download-link/${formId}`;
    return this.get(path);
  }

  downloadForm4(formId) {
    const path = `/form/fourth_phase/download-link/${formId}`;
    return this.get(path);
  }


  downloadForm1(formId) {
    const path = `/form/first_phase/download-link/${formId}`;
    return this.get(path);
  }

  sendFormPart(data, formId) {
    const path = `/form/first_phase/add-part/${formId}`;
    return this.put(path, data);
  }
}