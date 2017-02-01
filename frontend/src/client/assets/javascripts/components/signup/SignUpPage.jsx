import React from 'react';
import SignUpForm from './SignUpForm'
import { connect } from 'react-redux';
import { userSignUpRequest } from '../../app/actions/signupActions';

class SignUpPage extends React.Component {

    render() {
        const {userSignUpRequest} = this.props;
        return (
            <div className="singUpPage">
                <SignUpForm
                    userSignUpRequest={userSignUpRequest} />
                    {/*isUserExists={isUserExists}*/}
                    {/*addFlashMessage={addFlashMessage} />*/}
            </div>
        );
    }
}

SignUpPage.propTypes = {
    userSignUpRequest: React.PropTypes.func.isRequired,
    // // addFlashMessage: React.PropTypes.func.isRequired,
    // isUserExists: React.PropTypes.func.isRequired
};

export default connect(null, { userSignUpRequest })(SignUpPage);