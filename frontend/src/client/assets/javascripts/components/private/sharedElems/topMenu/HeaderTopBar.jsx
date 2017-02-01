import React from 'react';
import {Link} from 'react-router';

class HeaderTopBar extends React.Component {


    render() {
        const {toggleSideBar} = this.props;
        return (
            <div className="headerTopNavbar">
                <Link to="#" className="headerTopNavbar__header">IT-Shop</Link>
                <div onClick={toggleSideBar} className="headerTopNavbar__toggle-btn float-md-right"><i className="fa fa-bars"/></div>
            </div>
        );
    }
}

 HeaderTopBar.propTypes = {
     toggleSideBar: React.PropTypes.func.isRequired
};

export default  HeaderTopBar;