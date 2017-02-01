import React from 'react';
import Footer from './footer/Footer';
import NavigationBar from './navbar/NavigationBar';

class App extends React.Component {

    render() {
        return (
            <div className="">
                <NavigationBar/>
                {this.props.children}
                {/*<Footer/>*/}
            </div>
        );
    }
}
export default App;