import React from 'react';
import classnames from 'classnames';

class Dropdown extends React.Component {

    constructor(){
        super();
        this.state={
            listVisible: false
        };
        this.select = this.select.bind(this);
        this.show = this.show.bind(this);
        this.hide = this.hide.bind(this);
        this.renderListItems = this.renderListItems.bind(this);
    }

    select(item) {
        this.props.selected = item;
    }

    show() {
        this.setState({ listVisible: true });
        document.addEventListener("click", this.hide);
    }

    hide() {
        this.setState({ listVisible: false });
        document.removeEventListener("click", this.hide);
    }

    renderListItems(){
        const items = [];
        for (let i = 0; i < this.props.list.length; i++) {
            let item = this.props.list[i];
            items.push(<div key={i} onClick={this.select}>
                <span style={{ color: item.hex }}>{item.name}</span>
            </div>);
        }
        return items;
    }

    render() {
        var self = this;
        var options = self.props.options.map(function(option) {
            return (
                <option key={option[self.props.valueField]} value={option[self.props.valueField]}>
                    {option[self.props.labelField]}
                </option>
            )
        });
        return (
            <select id={this.props.id}
                    className='form-control'
                    value={this.state.selected}
                    onChange={this.handleChange}>
                {options}
            </select>
        );
    }
}

Dropdown.propTypes = {
    list: React.PropTypes.array.isRequired
};

export default Dropdown;