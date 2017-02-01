import React from 'react';
import classnames from 'classnames';

const TextAreaGroup = ({ field, value,cols, rows, label, error, type, onChange, style_label, style_input }) => {
    const label_style = classnames('form-control-label ', style_label);
    const input_style = classnames('form-control ', style_input, ' ', { 'form-control-danger': error });
    const div_style = classnames('form-group ', { 'has-danger': error });
    return (
        <div className={div_style}>
            {/*<label className={label_style}>{label}</label>*/}
            <textarea
                onChange={onChange}
                value={value}
                type={type}
                name={field}
                className={input_style}
                rows={rows}
                cols={cols}
            />
            <span className="form-control-feedback">{error}</span>
        </div>  );
}

TextAreaGroup.propTypes = {
    field: React.PropTypes.string.isRequired,
    value: React.PropTypes.string.isRequired,
    label: React.PropTypes.string.isRequired,
    error: React.PropTypes.string,
    type: React.PropTypes.string.isRequired,
    rows: React.PropTypes.number.isRequired,
    cols: React.PropTypes.number.isRequired,
    onChange: React.PropTypes.func.isRequired,
    checkUserExists: React.PropTypes.func
};

TextAreaGroup.defaultProps = {
    type: 'text'
};

export default TextAreaGroup;