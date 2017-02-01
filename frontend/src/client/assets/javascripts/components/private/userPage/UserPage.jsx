import React from 'react';
import SideMenu from '../sharedElems/sidemenu/SideMenu'
import TopMenu from '../sharedElems/topMenu/TopMenu'
import menuItems from './menuItems'


class UserPage extends React.Component {

    constructor() {
        super();
        this.state = {
            isCollapsed: false
        }
    }

    componentWillMount() {
        if(window.innerWidth < 850){
            this.setState({isCollapsed : true});
        }
    }

    toggleSideBar() {
        this.setState({isCollapsed : !this.state.isCollapsed})
    }

    render() {
        return (
            <div>
                <TopMenu toggleSideBar={this.toggleSideBar.bind(this)}/>
                <SideMenu isCollapsed={this.state.isCollapsed} menuItems={menuItems}/>
                {React.cloneElement(this.props.children, { isCollapsed: this.state.isCollapsed })}
            </div>
        );
    }
}

UserPage.propTypes = {
};

export default UserPage;