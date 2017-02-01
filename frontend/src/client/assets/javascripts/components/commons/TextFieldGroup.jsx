import React from 'react';
import classnames from 'classnames';

const TextFieldGroup = ({ field, value, label, error, type, onChange, checkUserExists, style_label, style_input }) => {
    const label_style = classnames('form-control-label ', style_label);
    const input_style = classnames('form-control ', style_input, ' ', { 'form-control-danger': error });
    const div_style = classnames('form-group ', { 'has-danger': error });
    return (
        <div className={div_style}>
            <label className={label_style}>{label}</label>
            <input
                onChange={onChange}
                onBlur={checkUserExists}
                value={value}
                type={type}
                name={field}
                className={input_style}
            />
            <span className="form-control-feedback">{error}</span>
        </div>  );
}

TextFieldGroup.propTypes = {
    field: React.PropTypes.string.isRequired,
    value: React.PropTypes.string.isRequired,
    label: React.PropTypes.string.isRequired,
    error: React.PropTypes.string,
    type: React.PropTypes.string.isRequired,
    onChange: React.PropTypes.func.isRequired,
    checkUserExists: React.PropTypes.func
}

TextFieldGroup.defaultProps = {
    type: 'text'
}

export default TextFieldGroup;