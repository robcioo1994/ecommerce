import React from 'react';
import {SimpleSelect} from 'react-selectize'
import classnames from 'classnames';

const SingleSelectGroup = ({error, label, placeholder, onValueChange, data,dataConverterFunction, style_label, style_input }) => {
    const label_style = classnames('form-control-label ', style_label);
    const select_style = classnames('form-control ', style_input, ' ', { 'form-control-danger': error });
    const div_style = classnames('form-group ', { 'has-danger': error });
    const values = data.map(dataConverterFunction);
    return (
        <div className={div_style}>
            <label className={label_style}>{label}</label>
            <SimpleSelect
                className={select_style}
                placeholder = {placeholder}
                onValueChange = {onValueChange}
                options={values}
            />


        </div>
    );
};

SingleSelectGroup.propTypes = {
    label: React.PropTypes.string.isRequired,
    placeholder: React.PropTypes.string.isRequired,
    onValueChange: React.PropTypes.func.isRequired,
    error: React.PropTypes.string,
    data: React.PropTypes.array.isRequired,
    dataConverterFunction: React.PropTypes.func.isRequired
};

export default SingleSelectGroup;