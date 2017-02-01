import React from 'react';
import TextFieldGroup from '../../../../commons/TextFieldGroup';
import { connect } from 'react-redux';
import {addDisplayResolution} from '../../../../../app/actions/componentsActions';
import DisplayResolution from '../../../../../models/DisplayResolution';

class AddDisplayResolution extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            width: '',
            height: '',
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
        const {width, height} = this.state;
        let displayResolution = new DisplayResolution(width, height);
        this.props.addDisplayResolution(displayResolution).catch(
            (err) => this.setState({ errors: err.response.data, isLoading: false })
        );
    }

    render() {
        const { errors } = this.state;

        return (
            <div className="col-md-3">
                <div className="panel panel-default">
                    <div className="panel__heading ">
                        <h3 className="panel__title ">Add new Display Resolution</h3>
                    </div>
                    <div className="panel__body">
                        <form onSubmit={this.onSubmit}>
                            <div className="row">

                                <div className="col-sm-6 col-md-6 col-lg-6">
                                    <TextFieldGroup
                                        error={errors.width}
                                        label="Width"
                                        type="number"
                                        onChange={this.onChange}
                                        value={this.state.width}
                                        field="width"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-6 col-md-6 col-lg-6">
                                    <TextFieldGroup
                                        error={errors.height}
                                        label="Height"
                                        type="number"
                                        onChange={this.onChange}
                                        value={this.state.height}
                                        field="height"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-12 col-md-12">
                                    <div className="singUpPage__button pr-3 mt-0 mb-0">
                                        <button className="btn btn-outline-primary">Add new Display Resolution</button>
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

AddDisplayResolution.propTypes = {
    addDisplayResolution: React.PropTypes.func.isRequired
};

export default connect(null, { addDisplayResolution })(AddDisplayResolution);