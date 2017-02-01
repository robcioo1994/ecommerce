import React from 'react';
import { connect } from 'react-redux';
import { addToCart } from '../../app/actions/cartActions';
import Counter from './Counter';

class ProductDescription extends React.Component {

    constructor() {
        super();
        this.state = {amount: 1};
    }

    addToCart() {
        this.props.addToCart(this.props.product, this.state.amount);
        this.context.router.push('/cart')
    }

    changeProductAmount(a){
        this.setState({ amount : a});
    }

    render() {
        const {product} = this.props;

        return (
            <div className="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6">
                <div className="productPage__descriptionBox">
                    <h3>{product.producer.producer + ' ' +product.productName}</h3>
                    <hr/>

                    <br/>
                    <br/>
                    <center>
                        <h2>cena: {product.price} zł</h2>
                    </center>

                    <br/>
                    <br/>
                    <center>
                        <h3>Amount: </h3><Counter changeNumberFunction={this.changeProductAmount.bind(this)} startValue = {this.state.amount}/>
                    </center>

                    <br/>
                    <br/>
                    <center>
                        <button className="btn btn-outline-danger btn-lg" onClick={this.addToCart.bind(this)}>Add to Cart</button>
                    </center>
                </div>
            </div>
        );
    }
}

ProductDescription.propTypes = {
    addToCart: React.PropTypes.func.isRequired
};

ProductDescription.contextTypes = {
    router: React.PropTypes.object.isRequired
};

export default connect(null, { addToCart })(ProductDescription);