import React from 'react';
import TextFieldGroup from '../../commons/TextFieldGroup';
import ChangePassword from "../../../models/ChangePassword";

class UpdatePassword extends React.Component {

    constructor() {
        super();
        this.state ={
            oldPassword:'',
            newPassword:'',
            confirmPassword:'',
            errors: {}
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit(e){
        e.preventDefault();
        const {newPassword, oldPassword, confirmPassword} = this.state;
        if (newPassword !== confirmPassword){
            this.setState({errors: {newPassword: 'Paassword incorect', confirmPassword:'Paassword incorect'}});
        }
        else {
           let changePassword = new ChangePassword('jan.kowalski@o2.pl', oldPassword, newPassword);
           this.props.updatePassword(changePassword);
        }
    }

    render() {
        const {errors} = this.state;
        return (
            <div className="col-md-6">
                <div className="panel panel-default">
                    <div className="panel__heading ">
                        <h3 className="panel__title ">Update Password</h3>
                    </div>
                    <div className="panel__body">
                        <form onSubmit={this.onSubmit}>
                            <div className="row">

                                <div className="col-md-12">
                                    <TextFieldGroup
                                        error={errors.oldPassword}
                                        label="Old password"
                                        type="password"
                                        onChange={this.onChange}
                                        value={this.state.oldPassword}
                                        field="oldPassword"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-md-12">
                                    <TextFieldGroup
                                        error={errors.newPassword}
                                        label="New password"
                                        type="password"
                                        onChange={this.onChange}
                                        value={this.state.newPassword}
                                        field="newPassword"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-md-12">
                                    <TextFieldGroup
                                        error={errors.confirmPassword}
                                        label="Confirm Password"
                                        type="password"
                                        onChange={this.onChange}
                                        value={this.state.confirmPassword}
                                        field="confirmPassword"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-12 col-md-12">
                                    <div className="singUpPage__button mr-3 ml-3 mt-0 mb-0">
                                        <button className="btn btn-outline-primary">Update Password</button>
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

UpdatePassword.propTypes = {
    account: React.PropTypes.object.isRequired,
    updatePassword: React.PropTypes.func.isRequired
};

export default UpdatePassword;