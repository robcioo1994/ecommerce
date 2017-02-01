import React from 'react';
import TextFieldGroup from '../commons/TextFieldGroup';
import { connect } from 'react-redux';
import { login } from '../../app/actions/authActions';

class LoginForm extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            identifier: '',
            password: '',
            errors: {},
            isLoading: false
        };
        this.onSubmit = this.onSubmit.bind(this);
        this.onChange = this.onChange.bind(this);
    }

    isValid() {

        return true;
    }

    onSubmit(e) {
        e.preventDefault();
        if (this.isValid()) {
            this.setState({ errors: {}, isLoading: true });
            this.props.login(this.state).then(
                (res) => this.context.router.push('/'),
                (err) => this.setState(
                    { errors: {
                        identifier: 'login is incorrect',
                        password: 'password is incorrect'
                }, isLoading: false })
            );
        }
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    render() {
        const { errors, identifier, password, isLoading } = this.state;

        return (
            <div className="loginPage__card">
                <div className="loginPage__title">log into your account</div>
                <form  onSubmit={this.onSubmit}>
                    { errors.form && <div className="alert alert-danger">{errors.form}</div> }

                    <TextFieldGroup
                        field="identifier"
                        label="Username / Email"
                        value={identifier}
                        error={errors.identifier}
                        onChange={this.onChange}
                        style_label="loginPage__input_label"
                        style_input="loginPage__input"
                    />

                    <TextFieldGroup
                        field="password"
                        label="Password"
                        value={password}
                        error={errors.password}
                        onChange={this.onChange}
                        type="password"
                        style_label="loginPage__input_label"
                        style_input="loginPage__input"
                    />

                    <div className="loginPage__button">
                        <button className="btn btn-lg" disabled={isLoading}>Login</button>
                    </div>
                </form>
            </div>
        );
    }
}

LoginForm.propTypes = {
    login: React.PropTypes.func.isRequired
};

LoginForm.contextTypes = {
    router: React.PropTypes.object.isRequired
};

export default connect(null, { login })(LoginForm);