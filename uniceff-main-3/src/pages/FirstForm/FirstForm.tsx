import {Form1} from "../Form1/form1"
import "./FirstForm.module.scss"
export function FirstForm() {
  console.log("hello")
  return (<>
    <Form1 currentCaseId={1} currentStudentId={1}></Form1>
  </>)
}
