

export class UserModel {
    firstName;
    lastName;
    inn;
    citizenship = new Citizenship();
    birthDate;
    city= new City();
    tel;
    department = new Department();
}
class Citizenship{
    citizenship
}

class Department{
    department
}

class City{
    city
}