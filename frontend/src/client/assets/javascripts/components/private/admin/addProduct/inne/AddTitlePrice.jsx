import React from 'react';
import TextFieldGroup from '../../../../commons/TextFieldGroup';

class AddTitlePrice extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            productName: '',
            price: ''
        };
        this.onChange = this.onChange.bind(this);
        // this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
        this.props.addTitlePrice(this.state);
    }

    render() {
        return (
                <div className="col-md-6">
                    <div className="panel panel-default">
                        <div className="panel__heading">
                            <h3 className="panel__title">Add Product name and price</h3>
                        </div>
                        <div className="panel__body">
                            <TextFieldGroup
                                label="Product name"
                                onChange={this.onChange}
                                //               checkUserExists={this.checkUserExists}
                                value={this.state.productName}
                                field="productName"
                                style_label="singUpPage__input_label"
                                style_input="singUpPage__input"
                            />

                            <TextFieldGroup
                                label="Price"
                                onChange={this.onChange}
                                //               checkUserExists={this.checkUserExists}
                                value={this.state.price}
                                field="price"
                                type="number"
                                style_label="singUpPage__input_label"
                                style_input="singUpPage__input"
                            />

                        </div>
                    </div>
                </div>
        );
    }
}

AddTitlePrice.propTypes = {
    addTitlePrice: React.PropTypes.func.isRequired
};

export default AddTitlePrice;