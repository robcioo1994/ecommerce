import React from 'react';
import Container from '../../../sharedElems/common/Container'
import AddFrontImage from './AddFrontImage';
import AddTitlePrice from './AddTitlePrice';
import AddDescription from './AddDescription';
import AddImages from './AddImages';

class AddProductPage extends React.Component {

    constructor() {
        super();
        this.state = {
            frontImage:null,
            productName: '',
            price: ''

        };
        this.addFrontImage = this.addFrontImage.bind(this);
        this.addTitlePrice = this.addTitlePrice.bind(this);
        this.addDescription = this.addDescription.bind(this);
        this.addOtherImages = this.addOtherImages.bind(this);
    }

    addFrontImage(file) {
        console.log('siema');
        console.log(file);
        this.setState({frontImage: file});
    }

    addTitlePrice(nameAndPrice) {
        this.setState({
            productName: nameAndPrice.productName,
            price: nameAndPrice.price,
        })
    }

    addDescription() {

    }

    addOtherImages() {

    }

    render() {
        const {isCollapsed} = this.props;
        return (
            <Container isCollapsed={isCollapsed}>
                <div className="row">
                    <AddTitlePrice addTitlePrice={this.addTitlePrice}/>
                    <AddFrontImage addFrontImage={this.addFrontImage} />
                    <AddDescription addDescription={this.addDescription} />
                    <AddImages addOtherImages={this.addOtherImages} />
                </div>
            </Container>
        );
    }
}

AddProductPage.propTypes = {
};

export default AddProductPage;