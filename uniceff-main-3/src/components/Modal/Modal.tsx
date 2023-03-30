import ModalMui from '@mui/material/Modal';
import {Box} from '@mui/material';
import {ReactNode} from 'react';

type Props = {
  children: ReactNode,
  open: boolean,
  handleClose: () => void
};

const style = {
  position: 'absolute' as 'absolute',
  top: '50%',
  left: '50%',
  transform: 'translate(-50%, -50%)',
  width: 400,
  bgcolor: 'background.paper',
  boxShadow: 24,
  pt: 2,
  px: 4,
  pb: 3,
};

export function Modal({open, handleClose, children}: Props) {
  return (
    <ModalMui
      open={open}
      onClose={handleClose}
      aria-labelledby="parent-modal-title"
      aria-describedby="parent-modal-description"
    >
      <Box sx={style}>
        {children}
      </Box>
    </ModalMui>
  );
};