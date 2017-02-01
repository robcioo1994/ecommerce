import React from 'react';
import ProductGridItem from './ProductGridItem';


class ProductGrid extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            windowHeight: window.innerHeight,
            windowWidth: window.innerWidth
        };
    }

    handleResize(e) {
        this.setState({
            windowHeight: window.innerHeight,
            windowWidth: window.innerWidth
        });
    }

    componentDidMount() {
        window.addEventListener('resize', this.handleResize.bind(this));
    }

    componentWillUnmount() {
        window.removeEventListener('resize', this.handleResize)
    }

    render() {
        return (
            <div className="row">
                {this.props.products.map((product, i) => <ProductGridItem key={i} nr={i} product={product}/>)}
            </div>
        );
    }
}

ProductGrid.propTypes = {
    products: React.PropTypes.array.isRequired
};

export default ProductGrid;