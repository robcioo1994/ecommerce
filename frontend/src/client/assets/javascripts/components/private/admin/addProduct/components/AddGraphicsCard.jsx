import React from 'react';
import TextFieldGroup from '../../../../commons/TextFieldGroup';
import { connect } from 'react-redux';
import {addGraphicsCard} from '../../../../../app/actions/componentsActions';
import GraphicsCard from '../../../../../models/GraphicsCard';

class AddGraphicsCard extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name: '',
            errors: {},
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit(e) {
        e.preventDefault();
        const {name} = this.state;
        let graphicsCard = new GraphicsCard(name);
        this.props.addGraphicsCard(graphicsCard).catch(
            (err) => this.setState({ errors: err.response.data, isLoading: false })
        );
    }

    render() {
        const { errors } = this.state;

        return (
            <div className="col-md-3">
                <div className="panel panel-default">
                    <div className="panel__heading ">
                        <h3 className="panel__title ">Add new Graphics Card</h3>
                    </div>
                    <div className="panel__body">
                        <form onSubmit={this.onSubmit}>
                            <div className="row">

                                <div className="col-sm-12 col-md-12 col-lg-12">
                                    {}
                                </div>

                                <div className="col-sm-12 col-md-12 col-lg-12">
                                    <TextFieldGroup
                                        error={errors.name}
                                        label="NAME"
                                        onChange={this.onChange}
                                        value={this.state.name}
                                        field="name"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-12 col-md-12">
                                    <div className="singUpPage__button mr-3 ml-3 mt-0 mb-0">
                                        <button className="btn btn-outline-primary">Add New Graphics Card</button>
                                    </div>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
            </div>
        );
    }
}

AddGraphicsCard.propTypes = {
    addGraphicsCard: React.PropTypes.func.isRequired
};

export default connect(null, { addGraphicsCard })(AddGraphicsCard);