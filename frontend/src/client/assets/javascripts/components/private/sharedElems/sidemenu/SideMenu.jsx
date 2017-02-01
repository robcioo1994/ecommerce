import React from 'react';
import SideBarItem from './SideBarItem';
import classnames from 'classnames';

class SideMenu extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            menuItems: props.menuItems
        };
    }
    generateMenuItems(){
        return this.state.menuItems.map((x, i)  =>
            <SideBarItem label={x.label} key={i} href={x.href} iconName={x.iconName} selected={x.selected} backColor={x.backColor}/>)
    }

    render() {
        const {isCollapsed} = this.props;
        const items = this.generateMenuItems();
        const sideStyle = classnames('sidebar', {'nav-min' : isCollapsed});
        return (
            <aside className={sideStyle}>
                <ul>
                    {items}
                </ul>
            </aside>
        );
    }
}

SideMenu.propTypes = {
    menuItems: React.PropTypes.array.isRequired,
    isCollapsed: React.PropTypes.bool.isRequired
};

export default SideMenu;