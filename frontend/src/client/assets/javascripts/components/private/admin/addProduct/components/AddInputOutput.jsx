import React from 'react';
import TextFieldGroup from '../../../../commons/TextFieldGroup';
import { connect } from 'react-redux';
import {addInputOutputType} from '../../../../../app/actions/componentsActions';
import InputOutputType from '../../../../../models/InputOutputType';

class AddInputOutput extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            type: '',
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
        const {type} = this.state;
        let inputOutputType = new InputOutputType(type);
        this.props.addInputOutputType(inputOutputType).catch(
            (err) => this.setState({ errors: err.response.data, isLoading: false })
        );
    }

    render() {
        const { errors } = this.state;

        return (
            <div className="col-md-4">
                <div className="panel panel-default">
                    <div className="panel__heading ">
                        <h3 className="panel__title ">Add new Input-Output Type</h3>
                    </div>
                    <div className="panel__body">
                        <form onSubmit={this.onSubmit}>
                            <div className="row">

                                <div className="col-sm-12 col-md-12 col-lg-12">
                                    {}
                                </div>

                                <div className="col-sm-12 col-md-12 col-lg-12">
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

                                <div className="col-sm-12 col-md-12">
                                    <div className="singUpPage__button pr-3 pl-3 mr-3 ml-3 mt-0 mb-0">
                                        <button className="btn btn-outline-primary">Add new Input-Output Type</button>
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

AddInputOutput.propTypes = {
    addInputOutputType: React.PropTypes.func.isRequired
};

export default connect(null, { addInputOutputType })(AddInputOutput);