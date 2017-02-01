import React from 'react';
import Counter from './../../../../product/Counter';
import DescriptionBox from './DescriptionBox';

class AddDescriptionBoxes extends React.Component {

    constructor() {
        super();
        this.state={
            descBoxesAmount: 0,
            boxes:[]
        };
        this.changeDescBoxesAmount = this.changeDescBoxesAmount.bind(this);
        this.renderDescriptionBoxes = this.renderDescriptionBoxes.bind(this);
        this.onChangeDesc = this.onChangeDesc.bind(this);

    }

    onChangeDesc(fieldId, field, value) {
        let els = this.state.boxes[fieldId];
        els[field] = value;
        let updatedList = this.state.boxes;
        updatedList[fieldId] = els;
        this.setState({boxes: updatedList});
        this.props.addAdditionalDescription(this.state.boxes);
    }

    changeDescBoxesAmount(a){
        this.setState({ descBoxesAmount : a});
        let components = this.state.boxes;
        let newComponents =[];
        for (let index = 0; index < a; index++) {
            if(components[index] !== undefined) {
                newComponents.push(this.state.boxes[index])
            }
            else{
                newComponents.push({title: '',description:'',image:undefined});
            }
        }
        this.setState({ boxes : newComponents});
    }

    renderDescriptionBoxes(){
        return this.state.boxes.map((elem,index)=>{
            return <DescriptionBox id={index} key={index} onChangeDesc={this.onChangeDesc} values = {elem}/>
        });
    }

    render() {
        let elems = this.renderDescriptionBoxes();
        return (
            <div className="col-md-12">
                <h3>Additional Description</h3>
                Description boxes <Counter changeNumberFunction={this.changeDescBoxesAmount} startValue = {this.state.descBoxesAmount} minValue={0} />
                <div className="row">
                    {elems}
                </div>
            </div>
        );
    }
}

AddDescriptionBoxes.propTypes = {
    addAdditionalDescription: React.PropTypes.func.isRequired
};

export default AddDescriptionBoxes;