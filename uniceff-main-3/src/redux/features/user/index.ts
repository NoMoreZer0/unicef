import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import {AuthService} from '../../../services/AuthService';
import {CaseService} from '../../../services/CaseService';
import {User} from '../../../types';
import {notification} from '../notification';

// First, create the thunk
export const fetchUser = createAsyncThunk(
  'users/fetchByIdStatus',
  async (data: any, thunkAPI) => {
    const caseService = new CaseService(data.role);
    const response = await caseService.getCurrentUser();
    console.log("1", response)
    return response;
  },
);

export const getRole = createAsyncThunk(
  'users/fetchUserRole',
  async (data: any, thunkAPI) => {
    const auth = new AuthService();
    const response = await auth.login(data);
    console.log("2", response)

    return response;
  },
);

interface UsersState {
  user: User
}

const initialState: UsersState = {
  user: null
}

// Then, handle actions in your reducers:
const usersSlice = createSlice({
  name: 'user',
  initialState,
  reducers: {
    // standard reducer logic, with auto-generated action types per reducer
  },
  extraReducers: (builder) => {
    // Add reducers for additional action types here, and handle loading state as needed
    builder.addCase(fetchUser.fulfilled, (state, action) => {
      // Add user to the state array
      state.user = action.payload
    });

    builder.addCase(getRole.fulfilled, (state, action) => {
      // Add user to the state array
      state.user = action.payload
    });
  },
});

export default usersSlice.reducer;