import React from 'react';
import DropzoneComponent from 'react-dropzone-component';
import TextFieldGroup from './../../../../commons/TextFieldGroup';
import TextAreaGroup from './../../../../commons/TextAreaGroup';

class DescriptionBox extends React.Component {

    constructor() {
        super();
        this.state = {
            title:'',
            description:'',
            errors:{}
        };

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

        this.onChange = this.onChange.bind(this);
        this.addImage = this.addImage.bind(this);
    }

    onChange(e) {
        // this.setState({ [e.target.name]: e.target.value });
        this.props.onChangeDesc(this.props.id, e.target.name, e.target.value )
    }

    addImage(file){
        const context = this.props;
        if (file) {
            let reader = new FileReader();

            reader.onload = function(readerEvt) {
                let binaryString = readerEvt.target.result;
                context.onChangeDesc(context.id, 'image', btoa(binaryString) );
            };
            reader.readAsBinaryString(file);
        }

    }

    render() {
        const { errors } = this.state;
        const config = this.componentConfig;
        const djsConfig = this.djsConfig;
        // For a list of all possible events (there are many), see README.md!
        const eventHandlersImage = {
            addedfile: this.addImage
        };

        return (
            <div className="col-md-12 mt-2">

               <div className="row">
                   <div className="col-md-3">
                       <label>Front Image</label>
                       <DropzoneComponent config={config} eventHandlers={eventHandlersImage} djsConfig={djsConfig} />
                   </div>
                   <div className="col-md-9">
                       <hr/>
                       <TextFieldGroup
                           error={errors.title}
                           label="Title"
                           onChange={this.onChange}
                           value={this.props.values.title}
                           field="title"
                           style_label="singUpPage__input_label"
                           style_input="singUpPage__input"
                       />
                       <TextAreaGroup
                           error={errors.description}
                           label="Title"
                           onChange={this.onChange}
                           value={this.props.values.description}
                           field="description"
                           rows={4}
                           cols={50}
                           style_label="singUpPage__input_label"
                           style_input="singUpPage__input"
                       />

                   </div>
               </div>
            </div>
        );
    }
}

DescriptionBox.propTypes = {
    onChangeDesc: React.PropTypes.func.isRequired
};

export default DescriptionBox;