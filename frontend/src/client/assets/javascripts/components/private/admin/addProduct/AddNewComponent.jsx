import React from 'react';
import Container from '../../sharedElems/common/Container'
import AddProcessor from './components/AddProcessor'
import AddInputOutput from './components/AddInputOutput'
import AddMemory from './components/AddMemory'
import AddDisc from './components/AddDisc'
import AddDisplayResolution from './components/AddDisplayResolution'
import AddDisplaySize from './components/AddDisplaySize'
import AddDisplayType from './components/AddDisplayType'
import AddGraphicsCard from './components/AddGraphicsCard'
import AddOperatingSystem from './components/AddOperatingSystem'
import AddProducer from './components/AddProducer'


class AddNewComponent extends React.Component {

    render() {
        const {isCollapsed} = this.props;
        return (
            <Container isCollapsed={isCollapsed}>
                <div className="row">
                    <AddDisplayResolution/>
                    <AddDisplaySize/>
                    <AddDisplayType/>
                    <AddOperatingSystem/>
                </div>

                <div className="row">
                    <AddInputOutput/>
                    <AddMemory/>
                    <AddDisc/>
                </div>

                <div className="row">
                    <AddGraphicsCard/>
                    <AddProducer />
                </div>
                <div className="row">
                    <AddProcessor />
                </div>


            </Container>
        );
    }
}

AddNewComponent.propTypes = {
};

export default AddNewComponent;