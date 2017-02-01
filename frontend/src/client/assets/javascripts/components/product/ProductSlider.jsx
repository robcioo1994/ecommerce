import React from 'react';

class ProductSlider extends React.Component {

    render() {
        return (
            <div className="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xl-6 ">
                <div className="slider">
                    <img src="http://www.gigabyte.com/fileupload/product/3/5916/20160527235648_big.png"/>
                </div>
            </div>
        );
    }
}

ProductSlider.propTypes = {
};

export default ProductSlider;