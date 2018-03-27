import React from 'react';
import Aux from '../../hoc/ReactAux';

import UserSearch from "../search/UserSearch";


const layout = (props) => (
    <Aux>
        <main>
            {props.children}
        </main>
        <UserSearch/>
        <div>Toolbar</div>
    </Aux>
);

export default layout;