import React from 'react';
import {Link} from 'react-router';
import classnames from 'classnames';

class ProductGridItem extends React.Component {

    render() {
        const {product, nr, isWhite} = this.props;
        const style = classnames('col-xs-12 col-sm-6 col-md-4 col-lg-3 col-xl-2 pr-0 pl-0', {'bg-white':isWhite});
        let component;
        if(product !== undefined){
            component =
                <Link to={`/p/${product.id}`}>
                    <div className="productGridItem_inner">
                        <div className="productGridItem_inner-image">
                            <img src={`data:image/png;base64,${product.frontImage}`}/>
                        </div>
                        <div className="productGridItem_inner-desc">
                            <h5 className="PGL-label">{product.productName}</h5>
                            <h5 className="PGL-price">{product.price} zł</h5>
                        </div>
                    </div>
                </Link>
        }
        else{
            component = <div></div>
        }

        return (
            <div className="col-xs-12 col-sm-6 col-md-4 col-lg-3 col-xl-3 pr-0 pl-0 bg-white productGridItem">{/* * pr-0 pl-0*/}
                {component}
            </div>
        );
    }
}

ProductGridItem.propTypes = {
};

export default ProductGridItem;