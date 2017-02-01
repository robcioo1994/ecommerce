import React from 'react';

class Navbar extends React.Component {

    constructor() {
        super();
        this.state = {collapseIn: false}
    }

    renderChildren = () => {
        const {children} = this.props;
        return React.Children.map(children, (child) => {
            return React.cloneElement(child,
                {
                    navbarToggle: this.navbarToggle,
                    collapseIn: this.state.collapseIn
                }
            );
        });
    };

    navbarToggle = () => {
        console.log('navbarToggle from navBar');
        this.setState({collapseIn: !this.state.collapseIn});
    };

    render() {
        return (
            <section>
                <header>
                    <nav ref="navbar" className="myNavBar">
                        {this.renderChildren()}
                    </nav>
                </header>
            </section>
        );
    }
}

Navbar.propTypes = {

};

export default Navbar;