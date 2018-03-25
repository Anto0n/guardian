import React, {Component} from 'react';


class UserList extends Component{
    render() {
    return this.props.users ? (
        <div>
            {this.props.users.map(user =>
                <span>{user.firstName}</span>
            )}
        </div>
    )
        : null;
    }
}
export default UserList;