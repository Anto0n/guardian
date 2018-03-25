import React, { Component } from 'react';

import UserList from './components/User/UserList'
import Layout from './components/Layout/Layout';
import axios from "axios";

class App extends Component {
    state = {
        users: []
    };


    componentDidMount() {
        // $.ajax("http://localhost:8080/all/")
        //     .success(alert("asd")).error(alert("qwe"));
        axios
            .get()
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
    createCORSRequest(method, url) {
        let xhr = new XMLHttpRequest();
        if ("withCredentials" in xhr) {

            // Check if the XMLHttpRequest object has a "withCredentials" property.
            // "withCredentials" only exists on XMLHTTPRequest2 objects.
            xhr.open(method, url, true);

        } else if (typeof XDomainRequest !== "undefined") {

            // Otherwise, check if XDomainRequest.
            // XDomainRequest only exists in IE, and is IE's way of making CORS requests.
            xhr = new XDomainRequest();
            xhr.open(method, url);

        } else {

            // Otherwise, CORS is not supported by the browser.
            xhr = null;

        }
        return xhr;
    }
}

export default App;
