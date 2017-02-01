import React from 'react';
import classnames from 'classnames';

class DropdownMenu extends React.Component {

    getStyle(){
        const{active, open} = this.props;
        if (active) {
            return open ? 'dropdow_submenu_block' : 'dropdow_submenu_none';
        } else {
            return 'dropdow_submenu_none';
        }
    }
    render() {
        const {menuItems} = this.props;
        const style = classnames('dropdow_submenu', this.getStyle());
        return (
            <ul className={style}>
                {menuItems.map(item => {
                    return (
                        <li key={menuItems.indexOf(item)} >
                            <a key={item.name} className="link_submenu"
                               href={item.href}>{item.name}
                            </a>
                        </li>
                    );
                })}
            </ul>
        );
    }
}

DropdownMenu.propTypes = {
};

export default DropdownMenu;