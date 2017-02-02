import React from 'react';
import classname from 'classnames';

class DescriptionBox extends React.Component {

    render() {
        const {description, nr} = this.props;

        const style = classname({'bg-white': nr % 2 !== 0});
        return (
            <div className={style}>
                <div className="productPage-additionalDesc">
                    <hr/>
                    <h1>{description.title}</h1>
                    <h5>{description.description}</h5>
                    <center className="productPage-additionalDesc-image">
                        <img src={`data:image/png;base64,${description.image}`}/>
                    </center>
                </div>
            </div>
        );
    }
}

DescriptionBox.propTypes = {
    nr: React.PropTypes.number.isRequired
};

export default DescriptionBox;