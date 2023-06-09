import {configureStore} from '@reduxjs/toolkit';
import notificationReducer from './features/notification';
import userReducer from './features/user';


const store = configureStore({
  reducer: {
    notification: notificationReducer,
    user: userReducer,
  },
});

export default store;

// Infer the `RootState` and `AppDispatch` types from the store itself
export type RootState = ReturnType<typeof store.getState>
// Inferred type: {posts: PostsState, comments: CommentsState, users: UsersState}
export type AppDispatch = typeof store.dispatch