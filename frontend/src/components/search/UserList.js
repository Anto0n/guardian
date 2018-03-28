import React, {Component} from 'react';
import styles from '../../index.css';
import {Card} from "react-materialize";

class UserList extends Component {

    constructor() {
        super();
        this.handleClick = this.handleClick.bind(this);
    }

    componentWillMount() {
        this.currentUser = this.props.userList[0];
    }


    handleClick(e) {
        let element = e.target.childNodes[1];

        if (element && element.tagName === "TABLE"){
            e.target.childNodes[1].hidden = !e.target.childNodes[1].hidden;
        }
    }

    render() {

        return this.props.userList ? (
                <div className={"container " + styles.userListHolder}>

                    {this.props.userList.map(user =>
                        <Card
                            onClick={this.handleClick}>{user.firstName + " " + user.lastName}
                            <table className={"striped " + styles.userDataTable} hidden>
                                <tbody>
                                <tr>
                                    <th>Поле</th>
                                    <th>Значення</th>
                                </tr>
                                <tr>
                                    <td>ПIБ</td>
                                    <td>{user.lastName + " " + user.firstName}</td>
                                </tr>
                                <tr>
                                    <td>IHH</td>
                                    <td>{user.inn}</td>
                                </tr>
                                <tr>
                                    <td>Громадянство</td>
                                    <td>{user.citizenship.citizenship}</td>
                                </tr>
                                <tr>
                                    <td>Дата народження</td>
                                    <td>{user.birthDate.substr(0,2).concat(".").concat(user.birthDate.substr(2,2)).concat(".").concat(user.birthDate.substr(4))}</td>
                                </tr>
                                <tr>
                                    <td>Мiсто</td>
                                    <td>{user.city.city}</td>
                                </tr>
                                <tr>
                                    <td>Номер телефону</td>
                                    <td>{user.tel}</td>
                                </tr>
                                <tr>
                                    <td>Наявнiсть фото</td>
                                    <td>{user.photos ? "Так" : "Нi"}</td>
                                </tr>
                                <tr>
                                    <td>Пiдроздiл</td>
                                    <td>{user.department.department}</td>
                                </tr>
                                </tbody>
                            </table>
                        </Card>
                        )}


                </div>

            )
            : null;
    }
}

export default UserList;