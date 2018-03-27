import React, {Component} from 'react';

import axios from "axios";
import UserList from "./UserList";
import SearchForm from "./SearchForm";

class UserSearch extends Component {
    state = {

        users: [],
        formActive: true
    };

    constructor() {
        super();
        // axios
        //     .get("http://localhost:8080/all")
        //     .then(response => {
        //
        //         // create an array of users only with relevant data
        //         const newUsers = response.data.map(user => {
        //             return {
        //                 id: user.id,
        //                 firstName: user.firstName
        //             };
        //         });
        //
        //         // create a new "State" object without mutating
        //         // the original State object.
        //         const newState = Object.assign({}, this.state, {
        //             users: newUsers
        //         });
        //
        //         // store the new state object in the component's state
        //         this.setState(newState);
        //     })
        //     .catch(error => console.log(error));
    }

    render() {
        return (
            <div>
                <SearchForm isActive={this.state.formActive}/>
                <UserList isActive={!this.state.formActive}/>
            </div>
        );
    }
}
export default UserSearch;