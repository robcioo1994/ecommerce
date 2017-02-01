export default class Account{
    constructor(_firstName, _lastName, _username, _password, _email, _roles ) {
        this.id = undefined;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.username = _username;
        this.password = _password;
        this.enabled = true;
        this.email = _email;
        this.roles = _roles;
    }

    setId(_id) {
        this.id = _id;
    }
}