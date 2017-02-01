import React from 'react';
import classnames from 'classnames';

class NavbarItems extends React.Component {

    constructor() {
        super();
        this.state={
            activeIndex: 0
        };
    }
    onClickHandler = (activeIndex) => {
        this.setState({
            activeIndex: activeIndex
        });
    };

    renderChildren = () => {
        const {children} = this.props;
        const {activeIndex} = this.state;
        return React.Children.map(children, (child, index) => {
            return React.cloneElement(child,
                {
                    index: index,
                    activeIndex: activeIndex,
                    parentCallBack: this.onClickHandler
                }
            );
        });
    };



    render() {
        const {collapseIn} = this.props;
        const style = classnames('collapses',{'collapsed':collapseIn});
        return (
            <div ref="collapses" className={style}>
                <ul ref="navItems" className="navItems">
                    {this.renderChildren()}
                </ul>
            </div>
        );
    }
}

NavbarItems.propTypes = {
};

export default NavbarItems;