import React from 'react';
import { connect } from 'react-redux';
import { changeProductAmountInCart, removeFromCart } from '../../app/actions/cartActions';

import CartTable from './CartTable';

class CartPage extends React.Component {

    render() {
        const {cart} = this.props;
        return (
            <div className="cartPage container bg-white pr-0 pl-0">
                <CartTable cart={cart}/>
            </div>
        );
    }
}

CartPage.propTypes = {
    changeProductAmountInCart: React.PropTypes.func.isRequired,
    removeFromCart: React.PropTypes.func.isRequired,
};


let mapStateToProps = (state) => {
    return{
        cart: state.cart,
    }
};

export default connect(mapStateToProps, {changeProductAmountInCart, removeFromCart})(CartPage);