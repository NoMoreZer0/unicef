import styles from './Report.module.scss';
import DefaultButton from '../DefaultButton';
import {getRoleEndpoints, isTherapist} from '../../utils';
import {useState} from 'react';
import Modal from '../Modal';
import InputWrapper from '../InputWrapper';
import {SESSION_STORAGE} from '../../constants';
import {CaseService} from '../../services/CaseService';
import {useAppSelector} from '../../hooks/useRedux';
import RadioGroupRating from '../Rating';

type Props = {
  data: any,
  isEditable?: boolean
};

export function Report({data, isEditable}: Props) {
  const [rating, setRating] = useState('0')
  const user = useAppSelector(state => state.user.user);
  const [post, setPost] = useState('');
  const [isOpen, setIsOpen] = useState(false);
  const isPermission = isTherapist();
  const role = sessionStorage.getItem(SESSION_STORAGE.ROLE);
  const roleEndpoints = getRoleEndpoints(role);
  const caseService = new CaseService(roleEndpoints);
  const createReport = async () => {
    const res = await caseService.updatePost({
      caseId: data.studentCase.id,
      date: data.date,
      meetingHolderId: user.id,
      post,
      rating,
    });
  };

  const onRatingChange = (e) => {
    setRating(e.target.value);
  };
  return (
    <div className={styles.post}>
      <div className={styles.row}>
        <div>Case Id:</div>
        <div>{data?.studentCase?.id}</div>
      </div>
      <div className={styles.row}>
        <div>Student Full Name:</div>
        <div>{data?.studentCase?.student?.fio}</div>
      </div>
      <div className={styles.row}>
        <div>Student Status:</div>
        <div>{data?.studentCase?.student?.studentStatus}</div>
      </div>
      <div className={styles.row}>
        <div>Date:</div>
        <div>{data?.date}</div>
      </div>
      <div className={styles.row}>
        <div>Holder Full Name:</div>
        <div>{data?.meetingHolder?.fio}</div>
      </div>
      {data?.post && <div className={styles.row}>
        <div>Post:</div>
        <div>{data?.post}</div>
      </div>}
      {data?.rating && <div className={styles.row}>
        <div>Rating:</div>
        <div>{data?.rating}</div>
      </div>}
      {isEditable &&
        <DefaultButton onClick={() => setIsOpen(true)}>Добавить
          отчет</DefaultButton>}
      <Modal open={isOpen} handleClose={() => setIsOpen(false)}>
        <div className={styles.title}>Добавить отчет</div>
        <div>
          <InputWrapper label={'Отчет'} error={''}
                        errText={''}>
            <input placeholder={'Добавить отчет'} type={'text'} value={post}
                   onChange={(e) => setPost(e.target.value)}/>
          </InputWrapper>

          <RadioGroupRating value={rating} onChange={onRatingChange}/>
          <button className={styles.buttonCenter}
                  onClick={createReport}>Добавить отчет
          </button>
        </div>
      </Modal>
    </div>
  );
};