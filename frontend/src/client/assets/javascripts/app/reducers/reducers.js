import { combineReducers } from 'redux';
import { routerReducer as routing } from 'react-router-redux';
import auth from './auth'
import cart from './cart'
import products from './product'
import actualProduct from './actualProduct'
import components from './components'
import account from './account'
import logR from './logR'

const rootReducer = combineReducers({
   routing, auth, cart,actualProduct, account, products, components, logR
});

export default rootReducer;