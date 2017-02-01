import React from 'react';
import {MultiSelect} from 'react-selectize'
import classnames from 'classnames';

const MultiSelectGroup = ({error, label, placeholder, onValuesChange, data, dataConverterFunction, style_label, style_input }) => {
    const label_style = classnames('form-control-label ', style_label);
    const select_style = classnames('form-control ', style_input, ' ', { 'form-control-danger': error });
    const div_style = classnames('form-group ', { 'has-danger': error });
    const values = data.map(dataConverterFunction);
    return (
        <div className={div_style}>
            <label className={label_style}>{label}</label>
            <MultiSelect
                className={select_style}
                placeholder = {placeholder}
                onValuesChange = {onValuesChange}
                options={values}
            />
        </div>
    );
};

MultiSelectGroup.propTypes = {
    label: React.PropTypes.string.isRequired,
    placeholder: React.PropTypes.string.isRequired,
    onValuesChange: React.PropTypes.func.isRequired,
    error: React.PropTypes.string,
    data: React.PropTypes.array.isRequired,
    dataConverterFunction: React.PropTypes.func.isRequired
};

export default MultiSelectGroup;