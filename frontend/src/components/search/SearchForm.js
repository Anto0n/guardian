import React, {Component} from "react";
import {UserModel} from "../model/UserModel";
import styles from '../../index.css';
import axios from "axios";
import 'react-day-picker/lib/style.css';
import UserList from "./UserList";
import {Button, Card, Icon, Input, Row} from "react-materialize";

class SearchForm extends Component {

    state = {
        resultPresent: null,
        userList: null,
        mandatoryFieldsMissing: false
    };

    renderNoResult() {
        return this.state.resultPresent === false ? <Card className={styles.errorMessage}>{
            this.state.mandatoryFieldsMissing ? "Поля обов’язковi для заповнення *" : "Пошук не дав результатiв"}</Card> : null;
    }

    constructor(props) {
        super(props);

        this.user = new UserModel();
        this.searchUser = this.searchUser.bind(this);
    }

    render() {
        return this.state.resultPresent
            ? <UserList userList={this.state.userList}/>
            : <div className="container">  {this.renderNoResult()}
                <Row>
                    <Input label="Iм’я*" s={6}
                           ref={(firstNameInput) => this.firstName = firstNameInput}><Icon>account_circle</Icon></Input>
                    <Input label="Прiзвище*" s={6} ref={(lastNameInput) => {
                        this.lastName = lastNameInput;
                    }}/>
                    <Input label="IНН" s={12} ref={(inn) => {
                        this.inn = inn;
                    }}><Icon>contacts</Icon></Input>
                    <Input label="Громадянство" s={12} ref={(citizenshipInput) => {
                        this.citizenship = citizenshipInput;
                    }}><Icon>account_balance</Icon></Input>
                    <Input label="Дата народження*" s={12} ref={(birthDate) => {
                        this.birthDate = birthDate;
                    }}><Icon>today</Icon></Input>
                    <Input label="Мiсто" s={12} ref={(cityInput) => {
                        this.city = cityInput;
                    }}><Icon>location_on</Icon></Input>
                    <Input label="Телефон" s={12} ref={(telInput) => {
                        this.tel = telInput;
                    }}><Icon>phone</Icon></Input>
                </Row>
                <Button onClick={this.searchUser}>Пошук<Icon right>search</Icon></Button>
            </div>
    }

    searchUser() {
        this.user.firstName = this.firstName.state.value == ""
            ? this.user.firstName = null
            : this.firstName.state.value;
        this.user.lastName = this.lastName.state.value == ""
            ? this.user.lastName = null
            : this.lastName.state.value;
        this.citizenship.value == ""
            ? this.user.citizenship = null
            : this.user.citizenship.citizenship = this.citizenship.state.value;

        this.city.value == ""
            ? this.user.city = null
            : this.user.city.city = this.city.state.value;
        this.user.inn = this.inn.value;
        this.user.birthDate = this.birthDate.state.value;
        this.user.tel = this.tel.state.value;

        axios({
            method: 'post',
            url: 'http://localhost:8080/find',
            data: this.user,
            config: {headers: {'Content-Type': 'multipart/form-data'}}
        }).then(response => {
            if (response.data.length > 0) {
                const newState = Object.assign({}, this.state, {
                    userList: response.data,
                    resultPresent: true,
                    mandatoryFieldsMissing: false
                });
                this.setState(newState);
            } else {
                const newState = Object.assign({}, this.state, {
                    resultPresent: false,
                    mandatoryFieldsMissing: false
                });
                this.setState(newState);
            }
        })
            .catch(error => {
                console.log(error);
                const newState = Object.assign({}, this.state, {
                    resultPresent: false,
                    mandatoryFieldsMissing: true
                });
                this.setState(newState);
            });
    }


}
export default SearchForm;