import React from 'react';
import { connect } from 'react-redux';
import { receiveProductsFromServer } from '../app/actions/productActions';
import ProductGrid from './productsList/ProductGrid';
import Jumbotron from './jumbotron/Jumbotron';

class MainPageView extends React.Component {

    componentWillMount() {
        this.props.receiveProductsFromServer(0, 8);
    }


    render() {
        const {products} = this.props;
        return (
            <div>
                <Jumbotron/>
                <div className="container-fluid">
                    <ProductGrid products={products} />
                </div>
            </div>
        );
    }
}

MainPageView.propTypes = {
};

let mapStateToProps = (state) => {
    return{
        products: state.products,
    }
};

export default connect(mapStateToProps, { receiveProductsFromServer })(MainPageView);