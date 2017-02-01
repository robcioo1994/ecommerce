import React from 'react';
import { connect } from 'react-redux';
import { receiveProductsFromServer } from '../../app/actions/productActions';
import ProductGrid from './ProductGrid';
import ReactPaginate from 'react-paginate';

class ProductListPage extends React.Component {

    constructor() {
        super();
        this.state={
            activePage:0,
            pageCount: 10
        };

        this.handlePageChange = this.handlePageChange.bind(this);
    }

    componentWillMount() {
        console.log('componentWillMount');
        this.props.receiveProductsFromServer(0, 16);
        // this.props.receiveProductsFromServer(0, 16);
    }

    handlePageChange(data) {
        this.setState({activePage: data.selected});
        this.props.receiveProductsFromServer(data.selected, 16);
    }

    render() {
        const {products} = this.props;
        return (
            <div className="container-fluid productList">
                {/*<div className="row">*/}
                    {/*<div className="col-xs-12">*/}
                        {/*<div className="productList-content">*/}

                            <ProductGrid products={products} />
                            <center>
                                <ReactPaginate previousLabel={"previous"}
                                               nextLabel={"next"}
                                               breakLabel={<a href="">...</a>}
                                               pageCount={this.state.pageCount}
                                               marginPagesDisplayed={3}
                                               pageRangeDisplayed={1}
                                               onPageChange={this.handlePageChange}
                                               breakClassName="page-link "
                                               containerClassName="pagination"
                                               pageClassName="page-item"
                                               pageLinkClassName="page-link"
                                               activeClassName="page-item active"
                                               previousClassName="page-item"
                                               nextClassName="page-item"
                                               previousLinkClassName="page-link"
                                               nextLinkClassName="page-link"
                                               disabledClassName="page-item disabled"
                                                />
                            </center>
                        {/*</div>*/}
                    {/*</div>*/}
                {/*</div>*/}
            </div>
        );
    }
}

ProductListPage.propTypes = {
};

let mapStateToProps = (state) => {
    return{
        products: state.products,
    }
};

export default connect(mapStateToProps, { receiveProductsFromServer })(ProductListPage);