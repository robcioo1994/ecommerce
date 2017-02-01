import React from 'react';
import DescriptionBox from './DescriptionBox';

class AdditionalDescription extends React.Component {

    constructor(){
        super();
        this.renderDescriptionBoxes = this.renderDescriptionBoxes.bind(this);
    }
    renderDescriptionBoxes(){
        return this.props.descriptions.map((item, i)=> <DescriptionBox description={item} key={i} nr={i}/>)
    }

    render() {
        let elems = this.renderDescriptionBoxes();
        return (
            <div>
                {elems}
            </div>
        );
    }
}

AdditionalDescription.propTypes = {
    descriptions: React.PropTypes.array.isRequired
};

export default AdditionalDescription;