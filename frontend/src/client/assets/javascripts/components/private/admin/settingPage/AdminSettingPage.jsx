import React from 'react';
import {connect} from 'react-redux';
import {lodash} from 'lodash';
import Container from './../../sharedElems/common/Container';
import {receiveAccountFromServer, updateAccount, updatePassword} from '../../../../app/actions/accountAction';
import UpdatePassword from '../../sharedElems/UpdatePassword';
import UpdateAccount from '../../sharedElems/UpdateAccount';
import ChangePassword from "../../../../models/ChangePassword";


class AdminSettingPage extends React.Component {

    constructor(props) {
        super(props);

        this.updatePassword = this.updatePassword.bind(this);
        this.updateAccount = this.updateAccount.bind(this);
    }

    componentWillMount() {
        this.props.receiveAccountFromServer('jan.kowalski@o2.pl');
    }

    updatePassword(newPassword) {
        this.props.updatePassword(newPassword);
    }

    updateAccount(account) {
        console.log(account);
        this.props.updateAccount(account);
    }

    render() {
        const {isCollapsed, account} =this.props;
        let elemt;
        if(!_.isEmpty(account)){
            elemt =
                <div className="row">
                    <UpdateAccount account={account} updateAccount={this.updateAccount}/>
                    <UpdatePassword account={account} updatePassword={this.updatePassword}/>
                </div>
        }
        else {
            elemt= <div></div>
        }


        return (
            <Container isCollapsed={isCollapsed}>
                {elemt}
            </Container>
        );
    }
}

AdminSettingPage.propTypes = {
    receiveAccountFromServer: React.PropTypes.func.isRequired,
    updateAccount: React.PropTypes.func.isRequired,
    updatePassword: React.PropTypes.func.isRequired
};

let mapStateToProps = (state) => {
    return{
        account: state.account,
    }
};

export default connect(mapStateToProps, { receiveAccountFromServer, updateAccount, updatePassword })(AdminSettingPage);