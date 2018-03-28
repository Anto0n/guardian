import React, {Component} from "react";
import {UserModel} from "../model/UserModel";
import axios from "axios";
import 'react-day-picker/lib/style.css';

class SearchForm extends Component {


    constructor() {
        super();
        this.user = new UserModel();
        this.searchUser = this.searchUser.bind(this);
    }

    render() {
        return <div>
            <div>
                first name:
                <input type="text" ref={(firstNameInput) => this.firstName = firstNameInput } />
            </div>
            <div>
                last name:
                <input type="text" ref={(lastNameInput) => { this.lastName = lastNameInput; }} />
            </div>
            <div>
                inn:
                <input type="text" ref={(inn) => { this.inn = inn; }} />
            </div>
            <div>
                citizenship:
                <input type="text" ref={(citizenshipInput) => { this.citizenship = citizenshipInput; }} />
            </div>
            <div>
                department:
                <input type="text" ref={(departmentInput) => { this.department = departmentInput; }} />
            </div>
            <div>
                birthDate DD/MM/YYYY:
                <input
                    ref={(birthDate) => { this.birthDate = birthDate; }}
                />
            </div>
            <div>
                city:
                <input type="text" ref={(cityInput) => { this.city = cityInput; }} />
            </div>
            <div>
                tel:
                <input type="text" ref={(telInput) => { this.tel = telInput; }} />
            </div>
            <div>
                <button onClick={this.searchUser}>Search!</button>
            </div>
        </div>
    }

  searchUser(){
    this.user.firstName=this.firstName.value;
    this.user.lastName=this.lastName.value;
    this.citizenship.value.toString() === ""
      ? this.user.citizenship=null
      : this.user.citizenship.citizenship=this.citizenship.value;
    this.department.value.toString() === ""
      ? this.user.department=null
      : this.user.department.department=this.department.value;
    this.city.value.toString() === ""
      ? this.user.city=null
      : this.user.city.city=this.city.value;
    this.user.inn=this.inn.value;
    this.user.birthDate=this.birthDate.value;
    this.user.tel=this.tel.value;
    axios({
      method: 'post',
      url:'http://localhost:8080/find',
      data: this.user,
      config: {headers: {'Content-Type': 'multipart/form-data'}}
    }).then(response => {
        this.users = response;

    })
      .catch(error => console.log(error));
  }


}
export default SearchForm;