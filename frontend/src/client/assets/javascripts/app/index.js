import 'styles/main.scss';

import React from 'react';
import ReactDOM from 'react-dom';
import { browserHistory } from 'react-router';
import { syncHistoryWithStore } from 'react-router-redux';
import configureStore  from './store/configureStore';
import Root from './Root';
import setAuthorizationToken from './utils/setAuthorizationToken'
import jwtDecode from 'jwt-decode';
import {setCurrentUser} from './actions/authActions'

const store = configureStore();
const history = syncHistoryWithStore(browserHistory, store);

const rootElement = document.getElementById('app');

if (localStorage.jwtToken) {
    setAuthorizationToken(localStorage.jwtToken);
    store.dispatch(setCurrentUser(jwtDecode(localStorage.jwtToken)));
}

ReactDOM.render(
    <Root store={store} history={history} />,
    rootElement
);