import React from 'react';
import Container from './../../sharedElems/common/Container';


class MyOrdersPage extends React.Component {

    render() {
        const {isCollapsed} =this.props;

        return (
            <Container isCollapsed={isCollapsed}>

            </Container>
        );
    }
}

MyOrdersPage.propTypes = {

};

export default MyOrdersPage;