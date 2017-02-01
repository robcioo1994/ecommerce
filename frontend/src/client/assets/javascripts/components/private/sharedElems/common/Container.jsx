import React from 'react';
import classnames from 'classnames';

class Container extends React.Component {

    render() {
        const {isCollapsed} = this.props;
        const containerStyle = classnames('body-wrapper', {'nav-min' : isCollapsed});
        return (
            <main>
                <section>
                    <div className={containerStyle}>
                        <div className="container-fluid">
                            {this.props.children}
                        </div>
                    </div>
                </section>
            </main>
        );
    }
}

Container.propTypes = {
    isCollapsed: React.PropTypes.bool.isRequired
};

export default Container;