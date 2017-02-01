import React from 'react';

class CartTableSubmit extends React.Component {

    constructor(){
        super();
        this.continueShopping = this.continueShopping.bind(this);
    }
    continueShopping() {
        this.context.router.push('/')
    }

    render() {
        const total = this.props.cart.reduce((prevVal, elem)=>{
            return prevVal+elem.product.price * elem.amount;
        }, 0);
        return (
            <div className="cartSubmit">
                <br className="bg-deepBlue120"/>
                <div className="totals-item">
                    <label>Subtotal</label>
                    <div className="totals-value" id="cart-subtotal"><h3>{total.toFixed(2)}</h3></div>
                </div>
                <div className="totals-item">
                    <button onClick={this.continueShopping } className="checkoutButton">dalej</button>
                    <button className="continueButton">submit</button>
                </div>
            </div>
        );
    }
}

CartTableSubmit.propTypes = {
    cart: React.PropTypes.array.isRequired
};

CartTableSubmit.contextTypes = {
    router: React.PropTypes.object.isRequired
};

export default CartTableSubmit;