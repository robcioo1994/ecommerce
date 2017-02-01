import React from 'react';
import DropzoneComponent from 'react-dropzone-component';

class AddFrontImage extends React.Component {

    constructor(props) {
        super(props);

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

    // handleFileAdded(file) {
    //     console.log(file);
    // }

    render() {
        const {addFrontImage} = this.props;
        const config = this.componentConfig;
        const djsConfig = this.djsConfig;

        // For a list of all possible events (there are many), see README.md!
        const eventHandlers = {
            addedfile: addFrontImage
        };

        return (
            <div className="col-md-6">
                <div className="panel">
                    <div className="panel__heading">
                        <h3 className="panel__title">Front image (add only one)</h3>
                    </div>
                    <div className="panel__body">
                        <DropzoneComponent config={config} eventHandlers={eventHandlers} djsConfig={djsConfig} />
                    </div>
                </div>
            </div>
        )
    }
}

AddFrontImage.propTypes = {
    addFrontImage: React.PropTypes.func.isRequired
};

export default AddFrontImage;