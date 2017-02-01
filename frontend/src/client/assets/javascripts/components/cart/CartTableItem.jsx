import React from 'react';
import { connect } from 'react-redux';
import { removeFromCart } from '../../app/actions/cartActions';

class CartTableItem extends React.Component {

    render() {
        const {product, amount} = this.props.cartItem;
        return (
            <div className="product">

                <div className="product-image">
                    <img src={product.frontImage}/>
                </div>

                <div className="product-details">
                    <h5 className="product-title">{product.name}</h5>
                </div>

                <div className="product-price">{product.price}</div>

                <div className="product-quantity">
                    <input type="number" value="2" min="1"/>
                </div>

                <div className="product-subtotal">{(product.price * amount).toFixed(2)}</div>

                <div className="product-removal">
                    <div onClick={() => this.props.removeFromCart(product.id)}>
                        <i className="btn fa fa-times"/>
                    </div>
                </div>

            </div>
        );
    }
}

CartTableItem.propTypes = {
    cartItem: React.PropTypes.object.isRequired
};

export default connect(null, { removeFromCart })(CartTableItem);