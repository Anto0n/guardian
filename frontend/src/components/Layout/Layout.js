import React from 'react';
import Aux from '../../hoc/ReactAux';


// import UserList from "../User/UserList";
import UserListPageBuilder from "../../containers/UserListPageBuilder";

// const users = [
//     { id: 1, firstName: "Leanne Graham" },
//     { id: 2, firstName: "Ervin Howell" },
//     { id: 3, firstName: "Clementine Bauch" },
//     { id: 4, firstName: "Patricia Lebsack" }
// ];


const layout = (props) => (
    <Aux>
        <main>
            {props.children}
        </main>
        {/*<UserList users={users}/>*/}
        <UserListPageBuilder/>
        <div>Toolbar</div>
    </Aux>
);

export default layout;