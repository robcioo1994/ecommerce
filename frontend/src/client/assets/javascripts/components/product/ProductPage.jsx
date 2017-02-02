import React from 'react';
import { connect } from 'react-redux';
import { receiveProductFromServer , clearStore} from '../../app/actions/actualProductActions';
import { logProduct } from '../../app/actions/loggerActions';
import ProductSlider from './ProductSlider';
import ProductDescription from './ProductDescription';
import SpecificationsBox from './SpecificationsBox';
import AdditionalDescription from './AdditionalDescription';
import Logger from './../../models/Logger';


class ProductPage extends React.Component {

    constructor(){
        super();
        this.state = {
            start: 0
        }
    }

    componentWillMount() {
        console.log('componentWillMount');
        this.setState({start: new Date().getTime()});
        this.props.receiveProductFromServer(this.props.params.id);
    }

    componentWillUnmount() {
        console.log('Component WILL UNMOUNT!');
        const {user} = this.props.auth;
        if(user !== undefined){
            const logger = new Logger(user.sub,this.props.params.id,(new Date().getTime() - this.state.start)/1000 );
            this.props.logProduct(logger);
        }
        this.props.clearStore()
    }

    render() {
        const product = this.props.product;
        let elem;
        if(product === undefined)
            elem = (<div></div>);
        else
            elem  =(
                <div>
                    <div className="container-fluid productPage">
                        <div className="row">
                            <ProductSlider/>
                            <ProductDescription product={product}/>
                        </div>
                    </div>

                    <AdditionalDescription descriptions={product.additionalDescription}/>

                    <SpecificationsBox product={product}/>

                    <div className="bg-danger">sss</div>
                </div>
            );

        return (
            <div>
                {elem}
            </div>
        );

    }
}

ProductPage.propTypes = {
    receiveProductFromServer: React.PropTypes.func.isRequired,
    logProduct: React.PropTypes.func.isRequired,
};

let mapStateToProps = (state) => {
    return{
        product: state.actualProduct.product,
        auth: state.auth,
    }
};

export default connect(mapStateToProps, { receiveProductFromServer, logProduct, clearStore })(ProductPage);