import React, { Component } from 'react';

import UserList from './components/User/UserList'
import Layout from './components/Layout/Layout';
import axios from "axios";

class App extends Component {
    state = {
        users: []
    };

    componentDidMount() {
        axios
            .get("http://localhost:8080/all/")
            .then(response => {

                // create an array of users only with relevant data
                const newUsers = response.data.map(user => {
                    return {
                        id: user.id,
                        firstName: user.firstName
                    };
                });

                // create a new "State" object without mutating
                // the original State object.
                const newState = Object.assign({}, this.state, {
                    users: newUsers
                });

                // store the new state object in the component's state
                this.setState(newState);
            })
            .catch(error => console.log(error));
    }
  render() {
    return (
      <div >
        <Layout>
            <p>Test</p>
        </Layout>
          <UserList users={this.state.users}/>
      </div>
    );
  }
}

export default App;
