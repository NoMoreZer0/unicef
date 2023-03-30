// @flow
import * as React from 'react';
import {User} from '../../types';

type Props = {
  users: User[]
};

export function UserList({users}: Props) {
  return (
    <div>
      <label>Stuff List</label>
      <div>
        {users.map((el, index) => (
          <div>
            <span>{el.fio}</span>
            <span> - </span>
            <span>{el.position}</span>
            {/* <span>{el.email}</span>
            <span>{el.username}</span>
            <span>{el.school}</span> */}
          </div>
        ))}
      </div>
    </div>
  );
};