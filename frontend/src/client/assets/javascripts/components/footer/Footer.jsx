import React from 'react';

class Footer extends React.Component {

    render() {
        return (
            <footer className="myFooter">
                <p>Posted by: Hege Refsnes</p>
                <p>Contact information: <a href="mailto:someone@example.com">
                    someone@example.com</a>.</p>
            </footer>
        );
    }
}

Footer.propTypes = {
};

export default Footer;