import React from 'react';
import {Link} from 'react-router';
import classnames from 'classnames';

class SideBarItem extends React.Component {

    render() {
        const {label, iconName, backColor, href} = this.props;
        const iconStyle = classnames('icon-bg ', backColor);
        return (
            <li className="sidebar__item">
                <Link to={href}>
                    <i className={iconName} aria-hidden="true"><span className={iconStyle}/></i>
                    <span className="sidebar__label">{label}</span>
                </Link>
            </li>
        );
    }
}

SideBarItem.propTypes = {
    label: React.PropTypes.string.isRequired,
    iconName: React.PropTypes.string.isRequired,
    backColor: React.PropTypes.string.isRequired
};

export default SideBarItem;