import React from 'react';

export default class Counter extends React.Component {

    constructor(props) {
        super(props);
        this.state = {count: props.startValue};
        this.increment = this.increment.bind(this);
        this.decrement = this.decrement.bind(this);
    }

    increment(){

        this.setState({
            count: this.state.count + 1
        });

        this.props.changeNumberFunction(this.state.count +1);
    }

    decrement(){
        this.setState({
            count: this.state.count - 1
        })
        this.props.changeNumberFunction(this.state.count - 1);
    }

    render() {
        const {minValue} = this.props;
        let min;
        if(minValue === undefined)
            min = 1;
        else
            min = minValue;


        return(
            <div className="counterComponent">
                <button type="button" className="sub" disabled={this.state.count <= min} onClick={this.decrement}>&ndash;</button>
                <h1>{this.state.count}</h1>
                <button type="button" className="add" onClick={this.increment}>+</button>
            </div>
        );
    }
}
