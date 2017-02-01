import React from 'react';
import {connect} from 'react-redux';
import DropzoneComponent from 'react-dropzone-component';
import AddDescriptionBoxs from './components/AddDescriptionBoxes';

import Container from '../../sharedElems/common/Container'
import TextFieldGroup from '../../../commons/TextFieldGroup';
import TextAreaGroup from '../../../commons/TextAreaGroup';
import SingleSelectGroup from '../../../commons/SingleSelectGroup';
import MultiSelectGroup from '../../../commons/MultiSelectGroup';
import {receiveInputOutputTypesFromServer, receiveOperationSystemFromServer, receiveProducerFromServer,
    receiveMemoryFromServer, receiveProcessorFromServer, receiveDiscFromServer, receiveDisplayResolutionFromServer,
    receiveDisplaySizeFromServer, receiveDisplayTypeFromServer, receiveGraphicsCardFromServer} from '../../../../app/actions/componentsActions';

import {addNewNotebook} from '../../../../app/actions/productActions';

import Notebook from '../../../../models/Notebook';



class AddNewNotebook extends React.Component {

    constructor() {
        super();
        this.state = {
            productName: '',
            price: '',
            cpu: undefined,
            memory: undefined,
            maxMemory: '',
            hardDisc: undefined,
            hasDvdRecorder: false,
            displayType: undefined,
            displaySize: undefined,
            displayResolution: undefined,
            gpu: undefined,
            inputOutputTypes: [],
            operatingSystem: undefined,
            height: '',
            width: '',
            depth: '',
            weight: '',
            color: '',
            guarantee: '',
            frontImage: undefined,
            images: [],
            addDescription: [],
            producer: undefined,
            errors: {}
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.addSliderImages = this.addSliderImages.bind(this);
        this.addFrontImage = this.addFrontImage.bind(this);
        this.addAdditionalDescription = this.addAdditionalDescription.bind(this);

        this.djsConfig = {
            addRemoveLinks: true,
            acceptedFiles: "image/jpeg,image/png,image/gif",
            autoProcessQueue: false
        };

        this.componentConfig = {
            iconFiletypes: ['.jpg', '.png', '.gif'],
            showFiletypeIcon: true,
            uploadMultiple: false,
            postUrl: 'no-url'
        };
    }
    componentWillMount(){
        console.log('componentWillMount');
        this.props.receiveOperationSystemFromServer();
        this.props.receiveInputOutputTypesFromServer();
        this.props.receiveProducerFromServer();
        this.props.receiveMemoryFromServer();
        this.props.receiveProcessorFromServer();
        this.props.receiveDiscFromServer();
        this.props.receiveDisplayResolutionFromServer();
        this.props.receiveDisplaySizeFromServer();
        this.props.receiveDisplayTypeFromServer();
        this.props.receiveGraphicsCardFromServer();
    }

    onChange(e) {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit(e) {
        e.preventDefault();
        const {productName,price,cpu,memory,maxMemory, hardDisc,hasDvdRecorder,displayType, displaySize,displayResolution,gpu,
            inputOutputTypes,operatingSystem,height,width,depth, weight,color,guarantee,frontImage, images, addDescription,producer} = this.state;

        let notebook = new Notebook(productName, price, producer, cpu, gpu, memory, maxMemory, hardDisc, hasDvdRecorder,
            displayType, displaySize, displayResolution, undefined, false, inputOutputTypes, operatingSystem,
            height, width, depth, weight, color, guarantee, frontImage,images, addDescription);
        console.log(notebook);
        this.props.addNewNotebook(notebook, frontImage);
    }

    addFrontImage(file) {
        const context = this;
        if (file) {
            let reader = new FileReader();

            reader.onload = function(readerEvt) {
                let binaryString = readerEvt.target.result;
                context.setState({ frontImage: btoa(binaryString) });
            };
            reader.readAsBinaryString(file);
        }
    }

    addSliderImages(files) {
        console.log(files);
        // const context = this;
        // if (file) {
        //     let reader = new FileReader();
        //
        //     reader.onload = function(readerEvt) {
        //         let binaryString = readerEvt.target.result;
        //         context.setState({ frontImage: btoa(binaryString) });
        //         console.log(btoa(binaryString));
        //     };
        //     reader.readAsBinaryString(file);
        // }
    }

    addAdditionalDescription(elems) {
        this.setState({addDescription: elems})
    }

    render() {
        const {isCollapsed, inputsOutputs, operationSystem, producers, memory, processors, hardDisc, displayResolution,displaySize,displayType, graphicsCard} = this.props;
        const { errors } = this.state;

        const config = this.componentConfig;
        const djsConfig = this.djsConfig;
        // For a list of all possible events (there are many), see README.md!
        const eventHandlersFrontImage = {
            addedfile: this.addFrontImage
        };

        const eventHandlersSliderImage = {
            addedfile: this.addSliderImages
        };

        return (
            <Container isCollapsed={isCollapsed}>
                <form onSubmit={this.onSubmit}>
                    <div className="row">
                        <div className="col-md-12">
                            <div className="panel panel-default">
                                <div className="panel__heading ">
                                    <h3 className="panel__title ">Add new notebook</h3>
                                </div>
                                <div className="panel__body">
                                    <div className="row">

                                        <div className="col-md-4">
                                            <SingleSelectGroup
                                                error={""}
                                                label="Producer"
                                                placeholder="Choose producer"
                                                onValueChange={(item=> {let pro =producers.find(x => x.id===item.value);  this.setState({producer: pro})})}
                                                data={producers}
                                                dataConverterFunction={(item)=>{return {label: item.producer, value: item.id}}}
                                                style_label="selection_label"
                                            />
                                        </div>

                                        <div className="col-md-4">
                                            <TextFieldGroup
                                                error={errors.productName}
                                                label="Product Name"
                                                onChange={this.onChange}
                                                value={this.state.productName}
                                                field="productName"
                                                style_label="singUpPage__input_label"
                                                style_input="singUpPage__input"
                                            />
                                        </div>

                                        <div className="col-md-4">
                                            <TextFieldGroup
                                                error={errors.price}
                                                label="Price"
                                                type="number"
                                                onChange={this.onChange}
                                                value={this.state.price}
                                                field="price"
                                                style_label="singUpPage__input_label"
                                                style_input="singUpPage__input"
                                            />
                                        </div>
                                    </div>

                                    <hr/>
                                    <br/>

                                    <div className="row">

                                        <div className="col-md-3">
                                            <TextFieldGroup
                                                error={errors.width}
                                                label="Width (mm)"
                                                type="number"
                                                onChange={this.onChange}
                                                value={this.state.width}
                                                field="width"
                                                style_label="singUpPage__input_label"
                                                style_input="singUpPage__input"
                                            />
                                        </div>

                                        <div className="col-md-3">
                                            <TextFieldGroup
                                                error={errors.height}
                                                label="Height (mm)"
                                                type="number"
                                                onChange={this.onChange}
                                                value={this.state.height}
                                                field="height"
                                                style_label="singUpPage__input_label"
                                                style_input="singUpPage__input"
                                            />
                                        </div>

                                        <div className="col-md-3">
                                            <TextFieldGroup
                                                error={errors.depth}
                                                label="Depth (mm)"
                                                type="number"
                                                onChange={this.onChange}
                                                value={this.state.depth}
                                                field="depth"
                                                style_label="singUpPage__input_label"
                                                style_input="singUpPage__input"
                                            />
                                        </div>

                                        <div className="col-md-3">
                                            <TextFieldGroup
                                                error={errors.weight}
                                                label="Weight (Kg)"
                                                type="number"
                                                onChange={this.onChange}
                                                value={this.state.weight}
                                                field="weight"
                                                style_label="singUpPage__input_label"
                                                style_input="singUpPage__input"
                                            />
                                        </div>

                                    </div>

                                    <hr/>
                                    <br/>

                                    <div className="row">
                                        <div className="col-md-6">
                                            <SingleSelectGroup
                                                error={""}
                                                label="CPU"
                                                placeholder="Choose Cpu"
                                                onValueChange={(item=> {let pro =processors.find(x => x.id===item.value);  this.setState({cpu: pro})})}
                                                data={processors}
                                                dataConverterFunction={(item)=>{return {label: (item.producer + ' ' + item.model + ' (' + item.cores +
                                                'rdzenie, od ' + item.processorBaseFrequency.toFixed(2) + ' GHz do ' + item.maxTurboFrequency.toFixed(2) +
                                                ' GHz, '+ item.cache + ' MB cache)'), value: item.id}}}
                                            />
                                        </div>

                                    </div>

                                    <div className="row">
                                        <div className="col-md-6">
                                            <SingleSelectGroup
                                                error={""}
                                                label="Memory"
                                                placeholder="Choose memory"
                                                onValueChange={(item=> {let mem =memory.find(x => x.id===item.value);  this.setState({memory: mem})})}
                                                data={memory}
                                                dataConverterFunction={(item)=>{return {label: (item.amount + 'GB ('+item.type+', ' + item.frequency+ 'MHz)'), value: item.id}}}
                                            />
                                        </div>

                                        <div className="col-md-3">
                                            <TextFieldGroup
                                                error={errors.maxMemory}
                                                label="Max memory"
                                                type="number"
                                                onChange={this.onChange}
                                                value={this.state.maxMemory}
                                                field="maxMemory"
                                                style_label="singUpPage__input_label"
                                                style_input="singUpPage__input"
                                            />
                                        </div>

                                    </div>


                                    <div className="row">

                                        <div className="col-md-4">
                                            <SingleSelectGroup
                                                error={""}
                                                label="Hard Disc"
                                                placeholder="Choose hard disc"
                                                onValueChange={(item=> {let disc =hardDisc.find(x => x.id===item.value);  this.setState({hardDisc: disc})})}
                                                data={hardDisc}
                                                dataConverterFunction={(item)=>{return {label: (item.size + 'GB ' + item.type + ' ' + item.input ), value: item.id}}}
                                            />
                                        </div>
                                    </div>

                                    <div className="row">

                                        <div className="col-md-4">
                                            <SingleSelectGroup
                                                error={""}
                                                label="Graphics Card"
                                                placeholder="Choose graphics Card"
                                                onValueChange={(item=> {let gpu = graphicsCard.find(x => x.id===item.value);  this.setState({gpu})})}
                                                data={graphicsCard}
                                                dataConverterFunction={(item)=>{return {label: item.name, value: item.id}}}
                                            />
                                        </div>
                                    </div>


                                    <hr/>
                                    <br/>
                                    <div className="row">

                                        <div className="col-md-4">
                                            <SingleSelectGroup
                                                error={""}
                                                label="Display Resolution"
                                                placeholder="Choose Display Resolution"
                                                onValueChange={(item=> {let resolution =displayResolution.find(x => x.id===item.value);  this.setState({displayResolution: resolution})})}
                                                data={displayResolution}
                                                dataConverterFunction={(item)=>{return {label: (item.width + ' x ' + item.height), value: item.id}}}
                                            />
                                        </div>

                                        <div className="col-md-4">
                                            <SingleSelectGroup
                                                error={""}
                                                label="Display Size"
                                                placeholder="Choose Display Size"
                                                onValueChange={(item=> {let size =displaySize.find(x => x.id===item.value);  this.setState({displaySize: size})})}
                                                data={displaySize}
                                                dataConverterFunction={(item)=>{return {label: (item.size + ' cali'), value: item.id}}}
                                            />
                                        </div>

                                        <div className="col-md-4">
                                            <SingleSelectGroup
                                                error={""}
                                                label="Display Type"
                                                placeholder="Choose Display Type"
                                                onValueChange={(item=> {let type =displayType.find(x => x.id===item.value);  this.setState({displayType: type})})}
                                                data={displayType}
                                                dataConverterFunction={(item)=>{return {label: item.type, value: item.id}}}
                                            />
                                        </div>

                                    </div>



                                    <hr/>
                                    <br/>
                                    <div className="row">

                                        <div className="col-md-12">
                                            <MultiSelectGroup
                                                error={""}
                                                label="Inputs/Outputs"
                                                placeholder="Choose Inputs/Outputs"
                                                onValuesChange={(items=> {this.setState({inputOutputTypes: items.map(item=>item.value)})})}
                                                data={inputsOutputs}
                                                dataConverterFunction={(item)=>{return {label: item.inputOutput, value: {id: item.id, inputOutput:item.inputOutput}}}}
                                            />
                                        </div>
                                    </div>

                                    <hr/>
                                    <br/>
                                    <div className="row">
                                        <div className="col-md-6">
                                            <SingleSelectGroup
                                                error={""}
                                                label="Operating System"
                                                placeholder="Choose Operating System"
                                                onValueChange={(item=> {let sys =operationSystem.find(x => x.id===item.value);  this.setState({operatingSystem: sys})})}
                                                data={operationSystem}
                                                dataConverterFunction={(item)=>{return {label: item.name, value: item.id}}}
                                            />
                                        </div>
                                    </div>


                                    <hr/>
                                    <br/>
                                    <div className="row">

                                        <div className="col-md-3">
                                            <TextFieldGroup
                                                error={errors.color}
                                                label="Color"
                                                onChange={this.onChange}
                                                value={this.state.color}
                                                field="color"
                                                style_label="singUpPage__input_label"
                                                style_input="singUpPage__input"
                                            />
                                        </div>

                                        <div className="col-md-1">
                                            <TextFieldGroup
                                                error={errors.guarantee}
                                                label="Quarantine"
                                                type="number"
                                                onChange={this.onChange}
                                                value={this.state.guarantee}
                                                field="guarantee"
                                                style_label="singUpPage__input_label"
                                                style_input="singUpPage__input"
                                            />
                                        </div>
                                    </div>

                                    <hr/>
                                    <br/>
                                    <div className="row">
                                        <div className="col-md-3">
                                            <label>Front Image</label>
                                            <DropzoneComponent config={config} eventHandlers={eventHandlersFrontImage} djsConfig={djsConfig} />
                                        </div>
                                        <div className="col-md-9">
                                            <label>Slider labels</label>
                                            <DropzoneComponent config={config} eventHandlers={eventHandlersSliderImage} djsConfig={djsConfig} />
                                        </div>
                                    </div>

                                    <br/>
                                    <hr/>
                                    <br/>
                                    <div className="row">
                                        <AddDescriptionBoxs addAdditionalDescription={this.addAdditionalDescription} />
                                    </div>

                                    <hr/>
                                    <br/>
                                    <div className="row">
                                        <div className="col-sm-12 col-md-12">
                                            <div className="singUpPage__button mr-3 ml-3 mt-0 mb-0">
                                                <button  type="submit" className="btn btn-outline-primary">Add new Notebook</button>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                    </div>
                </form>
            </Container>
        );
    }
}

AddNewNotebook.propTypes = {
    receiveInputOutputTypesFromServer: React.PropTypes.func.isRequired,
    receiveOperationSystemFromServer: React.PropTypes.func.isRequired,
    receiveProducerFromServer: React.PropTypes.func.isRequired,
    receiveProcessorFromServer: React.PropTypes.func.isRequired,
    receiveDiscFromServer: React.PropTypes.func.isRequired,
    receiveDisplayResolutionFromServer: React.PropTypes.func.isRequired,
    receiveDisplaySizeFromServer: React.PropTypes.func.isRequired,
    receiveDisplayTypeFromServer: React.PropTypes.func.isRequired,
    receiveGraphicsCardFromServer: React.PropTypes.func.isRequired,
    addNewNotebook: React.PropTypes.func.isRequired
};

let mapStateToProps = (state) => {
    return{
        inputsOutputs: state.components.inputOutputTypes,
        operationSystem: state.components.operationSystem,
        producers: state.components.producers,
        memory: state.components.memory,
        processors: state.components.processors,
        hardDisc:  state.components.hardDisc,
        displayResolution:  state.components.displayResolution,
        displaySize:  state.components.displaySize,
        displayType:  state.components.displayType,
        graphicsCard:  state.components.graphicsCard,
    }
};


export default connect(mapStateToProps, { receiveInputOutputTypesFromServer, receiveOperationSystemFromServer,
    receiveMemoryFromServer, receiveProducerFromServer ,receiveProcessorFromServer, receiveDiscFromServer,
    receiveDisplayResolutionFromServer, receiveDisplaySizeFromServer, receiveDisplayTypeFromServer, receiveGraphicsCardFromServer, addNewNotebook})(AddNewNotebook);