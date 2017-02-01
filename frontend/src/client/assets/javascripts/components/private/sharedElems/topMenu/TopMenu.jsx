import React from 'react';
import HeaderTopBar from './HeaderTopBar';
import { connect } from 'react-redux';
import { logout } from '../../../../app/actions/authActions';

class TopMenu extends React.Component {

    logout(e) {
        console.log('logout');
        e.preventDefault();
        this.props.logout();
        this.context.router.push('/');
    }


    render() {
        const {toggleSideBar} = this.props;
        return (
            <section>
                <header>
                    <nav className="topNavigation">
                        <HeaderTopBar toggleSideBar={toggleSideBar}/>
                        <div className="logout_panel" onClick={this.logout.bind(this)}>
                            <a>logout <i className="fa fa-sign-out" aria-hidden="true "/></a>
                        </div>
                    </nav>
                </header>
            </section>
        );
    }
}
TopMenu.propTypes = {
    toggleSideBar: React.PropTypes.func.isRequired,
    auth: React.PropTypes.object.isRequired,
    logout: React.PropTypes.func.isRequired
};

TopMenu.contextTypes = {
    router: React.PropTypes.object.isRequired
};

function mapStateToProps(state) {
    return {
        auth: state.auth
    };
}

export default connect(mapStateToProps, { logout })(TopMenu);