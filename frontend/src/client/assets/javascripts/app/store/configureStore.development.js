import { createStore, applyMiddleware, compose } from 'redux';
import promiseMiddleware from 'redux-promise';
import thunkMiddleware from 'redux-thunk';
import rootReducer from '../reducers/reducers'

const middlewares = [promiseMiddleware, thunkMiddleware, require('redux-immutable-state-invariant')()];

const enhancer = compose(applyMiddleware(...middlewares), window.devToolsExtension ? window.devToolsExtension() : f => f);

export default function configureStore(initialState) {
    const store = createStore(rootReducer, initialState, enhancer);

    // Enable hot module replacement for reducers (requires Webpack or Browserify HMR to be enabled)
    if (module.hot) {
        module.hot.accept('../reducers/reducers', () => {
            const nextReducer = require('../reducers/reducers').default;
            store.replaceReducer(nextReducer);
        });
    }

    return store;
}