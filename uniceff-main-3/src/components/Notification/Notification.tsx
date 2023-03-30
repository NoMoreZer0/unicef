import {useEffect} from 'react';
import {toast, ToastContainer} from 'react-toastify';
import {useAppDispatch, useAppSelector} from '../../hooks/useRedux';
import {NOTIFICATION} from '../../constants';
import 'react-toastify/dist/ReactToastify.css';
import {notify} from '../../redux/features/notification';

export function Notification() {
  const {type, message} = useAppSelector(state => state.notification);
  const dispatch = useAppDispatch();

  function reset() {
    dispatch(notify({type: NOTIFICATION.DEFAULT, message: ''}));
  }

  useEffect(() => {
    if (type !== NOTIFICATION.DEFAULT) {
      toast[type](message, {
        position: 'top-center',
        autoClose: 5000,
        hideProgressBar: false,
        closeOnClick: true,
        pauseOnHover: true,
        draggable: true,
        progress: undefined,
      });
      reset();
    }
  }, [type, message]);
  return (
    <ToastContainer
      position="top-center"
      autoClose={5000}
      hideProgressBar={false}
      newestOnTop={false}
      closeOnClick
      rtl={false}
      pauseOnFocusLoss
      draggable
      pauseOnHover
    />
  );
}
