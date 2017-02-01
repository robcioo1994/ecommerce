import React from 'react';
import CartTableItem from './CartTableItem';
import CartTableSubmit from './CartTableSubmit'

class CartTable extends React.Component {

    constructor() {
        super();
        this.createCells = this.createCells.bind(this);
    }

    createCells(elem, i) {
        return (
            <CartTableItem key={i} cartItem={elem}/>
        )
    }

    render() {
        const cartItems = this.props.cart.map(this.createCells);

        return (
            <div className="shopping-cart">
                <div className="column-labels">
                    <label className="product-image">Item</label>
                    <label className="product-details"/>
                    <label className="product-price">Price</label>
                    <label className="product-quantity">Quantity</label>
                    <label className="product-subtotal">Total</label>
                    <label className="product-removal"/>
                </div>
                
                {cartItems}

                <CartTableSubmit cart={this.props.cart}/>

            </div>
        );
    }
}

CartTable.propTypes = {
    cart: React.PropTypes.array.isRequired
};

export default CartTable;