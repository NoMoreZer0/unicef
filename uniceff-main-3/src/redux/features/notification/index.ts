import {createSlice} from '@reduxjs/toolkit';
import {NOTIFICATION} from '../../../constants';

// Define a type for the slice state
interface Notification {
  type: NOTIFICATION,
  message: string
}

// Define the initial state using that type
const initialState: Notification = {
  type: NOTIFICATION.DEFAULT,
  message: '',
};

export const notification = createSlice({
  name: 'notification',
  initialState,
  reducers: {
    notify: (state, action) => {
      state.type = action.payload.type;
      state.message = action.payload.message;
    },
  },
});

// Action creators are generated for each case reducer function
export const {notify} = notification.actions;

export default notification.reducer;