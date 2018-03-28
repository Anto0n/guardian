import React, {Component} from 'react';
import Aux from '../../hoc/ReactAux';
import styles from '../../index.css';

import {Icon, Navbar, NavItem} from "react-materialize";
import SearchForm from "../search/SearchForm";

class Layout extends Component {
    state = {
        formActive: true
    };

    render() {
        return <Aux>
            <Navbar className={styles.GuardianHeader} brand="GUARDIAN" right><NavItem href="/"><Icon>search</Icon></NavItem></Navbar>
            <SearchForm isActive={this.state.formActive}/>
        </Aux>
    }
}
export default Layout;