import React from 'react';
import {Link} from 'react-router';
import classnames from 'classnames';
import {connect} from 'react-redux';


class CartNavItem extends React.Component {


    render() {
        const {link, title, rightPos, onclick, cartSize} = this.props;
        const style = classnames( 'navItem' , {'navItem__right': rightPos}, {'navItem__left': !rightPos});
        return (
            <li ref="list" className={style}>
                <Link ref="link" to={link} className="link textBadge" onClick={onclick}><i className="fa fa-shopping-cart" aria-hidden="true"></i><span className="myBadhge">{cartSize}</span></Link>
            </li>
        );
    }
}
CartNavItem.propTypes = {
    onclick : React.PropTypes.func
};

let mapStateToProps = (state) => {
    return{
        cartSize: state.cart.length,
    }
};

export default connect(mapStateToProps, null)(CartNavItem);