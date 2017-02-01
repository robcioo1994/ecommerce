import React from 'react';
import { connect } from 'react-redux';
import { logout } from '../../app/actions/authActions';

import Navbar from './Navbar';
import NavbarHeader from './NavbarHeader';
import NavbarItems from './NavbarItems';
import NavbarDropdown from './NavbarDropdown';
import DropdownMenu from './DropdownMenu';
import NavItem from './NavItem';
import CartNavItem from './CartNavItem';

class NavigationBar extends React.Component {

    constructor() {
        super();
        this.renderNavItems = this.renderNavItems.bind(this);
    }

    logout(e) {
        console.log('logout');
        e.preventDefault();
        this.props.logout();
    }

    renderNavItems(items){
        return items.map(item => {return <NavItem key={items.indexOf(item)} link={item.link} icon={item.icon} title={item.title} rightPos={true}/>});
    }

    render() {
        const { isAuthenticated, role } = this.props.auth;

        const dropdownItems = [
            {href: '/pl/graphicsCart', name: 'Graphics Cart'},
            {href: '#', name: 'Setup'},
            {href: '#', name: 'Usage'},
            {href: '#', name: 'Advanced'}
        ];

        const guestLinks = [
            {link: '/signup', title: 'Sign up', icon:'fa fa-sign-in'},
            {link: '/login', title: 'Login', icon: 'fa fa-sign-in'}
        ];

        // const userLinks = [
        //     {link: '/user', title: 'User'}
        // ];

        let elem = [];
        if(isAuthenticated){
            // elem = this.renderNavItems(userLinks);
            if(role==='admin'){
                elem.unshift(<NavItem key={elem.length+1} link="/admin" title="Admin Panel" icon="fa fa-cogs"  rightPos={true}/>);
            }
            else {
                elem.unshift(<NavItem key={elem.length+1} link="/user" title="User" icon="fa fa-cogs"  rightPos={true}/>);
            }
            elem.unshift(<NavItem key={elem.length+1} link="/" title="Logout" icon="fa fa-sign-out" onclick={this.logout.bind(this)} rightPos={true}/>);
        }
        else {
            elem = this.renderNavItems(guestLinks);
        }


        return (
            <Navbar>
                <NavbarHeader href="/" label="IT-Shop"/>
                <NavbarItems>
                    <NavItem link="/pl/notebooks" title="Notebooks" rightPos={false}/>
                    <NavItem link="/p/1" title="ASUS" rightPos={false}/>
                    <NavbarDropdown title="Podzespoły komputerowy">
                        <DropdownMenu menuItems={dropdownItems}/>
                    </NavbarDropdown>
                    <CartNavItem link="/cart" title="Cart" rightPos={true}/>
                    {elem}

                </NavbarItems>
            </Navbar>
        );
    }
}

NavigationBar.propTypes = {
    auth: React.PropTypes.object.isRequired,
    logout: React.PropTypes.func.isRequired
};

function mapStateToProps(state) {
    return {
        auth: state.auth
    };
}

export default connect(mapStateToProps, { logout })(NavigationBar);