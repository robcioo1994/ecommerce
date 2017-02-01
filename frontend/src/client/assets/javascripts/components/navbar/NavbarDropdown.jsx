import React from 'react';
import classnames from 'classnames';
import {Link} from 'react-router';

class NavbarDropdown extends React.Component {

    constructor() {
        super();
        this.state={open:false}
    }

    renderChildren = () => {
        const {children, index, activeIndex} = this.props;
        let active = false;
        // this particular dropdown is clicked
        if (index === activeIndex) {
            active = true;
        }
        const newChildren = React.Children.map(children, (child) => {
            return React.cloneElement(child,
                {
                    open: this.state.open,
                    active: active
                });
        });
        return newChildren;
    }

    handleDocumentClick = () => {
        if (this.state.open) {
            this.setState({open: false});
            // when all the dropdowns are closed, activeIndex is set to -1
            this.props.parentCallBack(-1);
        }
    }

    handleDropdownClick = (e) => {
        const {index, parentCallBack} = this.props;
        e.preventDefault();
        e.nativeEvent.stopImmediatePropagation();
        parentCallBack(index);
    }

    componentDidMount() {
        document.addEventListener('click', this.handleDocumentClick);
    }

    componentWillUnmount() {
        document.removeEventListener('click', this.handleDocumentClick);
    }

    componentWillReceiveProps(nextProps) {
        const {index, activeIndex} = nextProps;
        if (index === activeIndex) {
            if (this.state.open) {
                this.setState({open: false});
                // when all the dropdowns are closed, activeIndex is set to -1
                this.props.parentCallBack(-1);
            }else {
                this.setState({open: true});
            }
        } else {
            this.setState({open: false});
        }
    }

    render() {
        const {title} = this.props;
        return (
            <li ref="dropdown" className="myDropdown">
                <Link ref="link" to="#" className="link" onClick={this.handleDropdownClick} >
                    {title}{' '}
                    <b className="caret" />
                </Link>
                {this.renderChildren()}
            </li>
        );
    }
}

NavbarDropdown.propTypes = {
};

export default NavbarDropdown;