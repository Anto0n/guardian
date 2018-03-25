import React from "react";

import User from "./User";

const UserList = (props) => {
    return (
        <div>
            {props.users.map(user =>
                <User key={user.id} firstName={user.firstName}/>
            )}
        </div>
    );
};
export default UserList;