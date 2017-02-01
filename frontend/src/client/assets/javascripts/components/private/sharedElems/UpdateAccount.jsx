import React from 'react';
import TextFieldGroup from '../../commons/TextFieldGroup';
import Account from "../../../models/Account";

class UpdateAccount extends React.Component {

    constructor(props) {
        super();

        this.state ={
            firstName: '',
            lastName: '',
            email: '',
            errors: {}
        };

        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    componentWillMount() {
        // const {username, name, surname, email} = this.props.account;
        // this.setState({username, name, surname, email});
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit(e){
        e.preventDefault();
        const {firstName, lastName, email} = this.state;
        let account = new Account(firstName, lastName, undefined,undefined, email, undefined);
        account.setId(this.props.account.id);
        this.props.updateAccount(account);
    }

    render() {
        const {errors} = this.state;


        return (
            <div className="col-md-6">
                <div className="panel panel-default">
                    <div className="panel__heading ">
                        <h3 className="panel__title ">Update Account</h3>
                    </div>
                    <div className="panel__body">
                        <form onSubmit={this.onSubmit}>
                            <div className="row">

                                <div className="col-md-12">
                                    <TextFieldGroup
                                        error={errors.firstName}
                                        label="Name"
                                        onChange={this.onChange}
                                        value={this.state.firstName}
                                        field="firstName"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-md-12">
                                    <TextFieldGroup
                                        error={errors.lastName}
                                        label="Surname"
                                        onChange={this.onChange}
                                        value={this.state.lastName}
                                        field="lastName"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-md-12">
                                    <TextFieldGroup
                                        error={errors.email}
                                        label="Email"
                                        type="email"
                                        onChange={this.onChange}
                                        value={this.state.email}
                                        field="email"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-12 col-md-12">
                                    <div className="singUpPage__button mr-3 ml-3 mt-0 mb-0">
                                        <button className="btn btn-outline-primary">Update Account</button>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

UpdateAccount.propTypes = {
    updateAccount: React.PropTypes.func.isRequired
};

export default UpdateAccount;