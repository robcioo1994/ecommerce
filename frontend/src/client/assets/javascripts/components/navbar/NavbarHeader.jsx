import React from 'react';
import { Link } from 'react-router';

class NavbarHeader extends React.Component {

    render() {
        const {label, href}  =this.props;
        return (
            <div key="header" className="header">
                <Link to={href} className="header__label">{label}</Link>
                <div onClick={this.props.navbarToggle} className="header__toggle-btn float-md-right">
                    <i className="fa fa-bars"/>
                </div>
            </div>
        );
    }
}

NavbarHeader.propTypes = {
};

export default NavbarHeader;