import React from 'react';
import TextFieldGroup from '../../../../commons/TextFieldGroup';
import { connect } from 'react-redux';
import {addProcessor} from '../../../../../app/actions/componentsActions';
import Processor from '../../../../../models/Processor';

class AddProcessor extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            producer: '',
            processorFamily: '',
            model: '',
            cores: '',
            threads: '',
            processorBaseFrequency: '',
            maxTurboFrequency: '',
            cache: '',
            lithography: '',
            processorGraphics: '',
            TDP: '',
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
        const {producer, processorFamily,model, cores,threads,processorBaseFrequency,maxTurboFrequency,
            cache, lithography, processorGraphics, TDP} = this.state;
        let newProcessor = new Processor(producer, processorFamily,model, cores,threads,processorBaseFrequency,maxTurboFrequency,
            cache, lithography, processorGraphics, TDP);

        this.props.addProcessor(newProcessor).then(
            (err) => this.setState({ errors: err.response.data, isLoading: false })
        );
    }


    render() {
        const { errors } = this.state;

        return (
            <div className="col-md-12">
                <div className="panel panel-default">
                    <div className="panel__heading ">
                        <h3 className="panel__title ">Add new processor</h3>
                    </div>
                    <div className="panel__body">
                        <form onSubmit={this.onSubmit}>
                            <div className="row">
                                <div className="col-sm-12 col-md-12 col-lg-6">
                                    <TextFieldGroup
                                        error={errors.producer}
                                        label="Producer"
                                        onChange={this.onChange}
                                        value={this.state.producer}
                                        field="producer"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-12 col-md-12 col-lg-6">
                                    <TextFieldGroup
                                        error={errors.processorFamily}
                                        label="Processor Family"
                                        onChange={this.onChange}
                                        value={this.state.processorFamily}
                                        field="processorFamily"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-12 col-md-12 col-lg-6">
                                    <TextFieldGroup
                                        error={errors.model}
                                        label="Model"
                                        onChange={this.onChange}
                                        value={this.state.model}
                                        field="model"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-6 col-md-6 col-lg-3">
                                    <TextFieldGroup
                                        error={errors.cores}
                                        label="Cores"
                                        onChange={this.onChange}
                                        value={this.state.cores}
                                        field="cores"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-6 col-md-6 col-lg-3">
                                    <TextFieldGroup
                                        error={errors.threads}
                                        label="Threads"
                                        onChange={this.onChange}
                                        value={this.state.threads}
                                        field="threads"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-6 col-md-6 col-lg-3">
                                    <TextFieldGroup
                                        error={errors.processorBaseFrequency}
                                        label="Processor Base Frequency"
                                        onChange={this.onChange}
                                        value={this.state.processorBaseFrequency}
                                        field="processorBaseFrequency"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-6 col-md-6 col-lg-3">
                                    <TextFieldGroup
                                        error={errors.maxTurboFrequency}
                                        label="Max Turbo Frequency"
                                        onChange={this.onChange}
                                        value={this.state.maxTurboFrequency}
                                        field="maxTurboFrequency"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-6 col-md-6 col-lg-3">
                                    <TextFieldGroup
                                        error={errors.cache}
                                        label="Cache"
                                        onChange={this.onChange}
                                        value={this.state.cache}
                                        field="cache"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-6 col-md-6 col-lg-3">
                                    <TextFieldGroup
                                        error={errors.lithography}
                                        label="Lithography"
                                        onChange={this.onChange}
                                        value={this.state.lithography}
                                        field="lithography"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-6 col-md-6 col-lg-3">
                                    <TextFieldGroup
                                        error={errors.processorGraphics}
                                        label="Processor Graphics"
                                        onChange={this.onChange}
                                        value={this.state.processorGraphics}
                                        field="processorGraphics"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-6 col-md-6 col-lg-3">
                                    <TextFieldGroup
                                        error={errors.TDP}
                                        label="TDP"
                                        onChange={this.onChange}
                                        value={this.state.TDP}
                                        field="TDP"
                                        style_label="singUpPage__input_label"
                                        style_input="singUpPage__input"
                                    />
                                </div>

                                <div className="col-sm-12 col-md-12">
                                    <div className="singUpPage__button pr-3 pl-3 mr-3 ml-3">
                                        <button className="btn btn-primary btn-lg">Add new processor</button>
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

AddProcessor.propTypes = {
    addProcessor: React.PropTypes.func.isRequired
};

export default connect(null, { addProcessor })(AddProcessor);