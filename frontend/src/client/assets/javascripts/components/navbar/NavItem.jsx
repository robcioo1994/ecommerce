import React from 'react';
import {Link} from 'react-router';
import classnames from 'classnames';


class NavItem extends React.Component {

    render() {
        const {link, title, rightPos, onclick, icon} = this.props;
        const style = classnames( 'navItem' , {'navItem__right': rightPos}, {'navItem__left': !rightPos});
        return (
            <li ref="list" className={style}>
                <Link ref="link" to={link} className="link" onClick={onclick}>
                    {title}{' '}
                    {(icon !== '') ? <i className={icon} aria-hidden="true "/> : {}}
                </Link>
            </li>
        );
    }
}
NavItem.propTypes = {
    onclick : React.PropTypes.func
};

export default NavItem;