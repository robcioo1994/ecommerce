import React from 'react';
import TextFieldGroup from '../commons/TextFieldGroup';
import Account from '../../models/Account'

class SignUpForm extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            name: '',
            surname: '',
            email: '',
            password: '',
            passwordConfirmation: '',
            errors: {},
            isLoading: false,
            invalid: false
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit(e) {
        e.preventDefault();
        const {name,surname, username, password, email} = this.state;
        let newAccount = new Account(name,surname, username, password, email, ["CLIENT"]);
        this.props.userSignUpRequest(newAccount).then(
            () => {this.context.router.push('/');},
            (err) => this.setState({ errors: err.response.data, isLoading: false })
        );
    }


    render() {
        const { errors } = this.state;

        return (
            <div className="singUpPage__card">
                <div className="singUpPage__title">Join our shop!</div>
                <form onSubmit={this.onSubmit}>

                    <TextFieldGroup
                        error={errors.username}
                        label="Username"
                        onChange={this.onChange}
         //               checkUserExists={this.checkUserExists}
                        value={this.state.username}
                        field="username"
                        style_label="singUpPage__input_label"
                        style_input="singUpPage__input"
                    />

                    <TextFieldGroup
                        error={errors.name}
                        label="Name"
                        onChange={this.onChange}
                        value={this.state.name}
                        field="name"
                        style_label="singUpPage__input_label"
                        style_input="singUpPage__input"
                    />

                    <TextFieldGroup
                        error={errors.surname}
                        label="Surname"
                        onChange={this.onChange}
                        value={this.state.surname}
                        field="surname"
                        style_label="singUpPage__input_label"
                        style_input="singUpPage__input"
                    />

                    <TextFieldGroup
                        error={errors.email}
                        label="Email"
                        onChange={this.onChange}
            //            checkUserExists={this.checkUserExists}
                        value={this.state.email}
                        field="email"
                        style_label="singUpPage__input_label"
                        style_input="singUpPage__input"
                    />

                    <TextFieldGroup
                        error={errors.password}
                        label="Password"
                        onChange={this.onChange}
                        value={this.state.password}
                        field="password"
                        type="password"
                        style_label="singUpPage__input_label"
                        style_input="singUpPage__input"
                    />

                    <TextFieldGroup
                        error={errors.passwordConfirmation}
                        label="Password Confirmation"
                        onChange={this.onChange}
                        value={this.state.passwordConfirmation}
                        field="passwordConfirmation"
                        type="password"
                        style_label="singUpPage__input_label"
                        style_input="singUpPage__input"
                    />


                    <div className="singUpPage__button">
                        <button className="btn btn-primary btn-lg">Sign Up</button>
                    </div>
                </form>
            </div>
        );
    }
}
//disabled={this.state.isLoading || this.state.invalid}

SignUpForm.propTypes = {
    userSignUpRequest: React.PropTypes.func.isRequired,
    // // addFlashMessage: React.PropTypes.func.isRequired,
    // isUserExists: React.PropTypes.func.isRequired
}

SignUpForm.contextTypes = {
    router: React.PropTypes.object.isRequired
}

export default SignUpForm;