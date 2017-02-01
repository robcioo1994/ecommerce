import React from 'react';
import TextFieldGroup from '../../../../commons/TextFieldGroup';
import { connect } from 'react-redux';
import {addMemory} from '../../../../../app/actions/componentsActions';
import Memory from '../../../../../models/Memory';

class AddMemory extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            amount: '',
            type: '',
            frequency: '',
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
        const {amount, type, frequency} = this.state;
        let memory = new Memory(amount, type, frequency);
        this.props.addMemory(memory).catch(
            (err) => this.setState({ errors: err.response.data, isLoading: false })
        );
    }

    render() {
        const { errors } = this.state;

        return (
            <div className="col-md-4">
                <div className="panel panel-default">
                    <div className="panel__heading ">
                        <h3 className="panel__title ">Add new Memory</h3>
                    </div>
                    <div className="panel__body">
                        <form onSubmit={this.onSubmit}>
                            <div className="row">

                                <div className="col-sm-4 col-md-4 col-lg-4">
                                    <TextFieldGroup
                                        error={errors.amount}
                                        label="Amount"
                                        type="number"
                                        onChange={this.onChange}
                                        value={this.state.amount}
                                        field="amount"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-4 col-md-4 col-lg-4">
                                    <TextFieldGroup
                                        error={errors.type}
                                        label="Type"
                                        onChange={this.onChange}
                                        value={this.state.type}
                                        field="type"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-4 col-md-4 col-lg-4">
                                    <TextFieldGroup
                                        error={errors.frequency}
                                        label="Frequency"
                                        type="number"
                                        onChange={this.onChange}
                                        value={this.state.frequency}
                                        field="frequency"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-12 col-md-12">
                                    <div className="singUpPage__button pr-3 pl-3 mr-3 ml-3 mt-0 mb-0">
                                        <button className="btn btn-outline-primary">Add new Memory</button>
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

AddMemory.propTypes = {
    addMemory: React.PropTypes.func.isRequired
};

export default connect(null, { addMemory })(AddMemory);