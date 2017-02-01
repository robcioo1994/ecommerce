import * as types from '../constants/ActionTypes';
import product from '../drydata/products';

const initData = [{product: product[0], amount: 1} ,{product: product[1], amount: 5}];

export default function (state = initData, action) {
    switch (action.type) {
        case types.ADD_TO_CARD: {
            const i = state.findIndex( (elem) => elem.product.id === action.product.id );

            if(i !== -1){
                return [
                    ...state.slice(0,i),
                    {...state[i], amount:state[i].amount +  action.amount},
                    ...state.slice(i+1),
                ]
            }
            else
                return [...state, {product:action.product, amount:action.amount}]

        }

        case types.REMOVE_FROM_CARD: {
            const i = state.findIndex( (elem) => elem.product.id === action.id );
            if(i !== -1){
                return [
                    ...state.slice(0,i),
                    ...state.slice(i+1),
                ]
            }
            else
                return [...state]
        }

        case types.CHANGE_PRODUCT_AMOUNT_IN_CART: {
            const i = state.findIndex( (elem) => elem.product.id === action.id );
            if(i !== -1){
                return [
                    ...state.slice(0,i),
                    {...state[i], amount: action.amount},
                    ...state.slice(i+1),
                ]
            }
            else
                return [...state]
        }

        case types.CHECKOUT_REQUEST: {
            return state;
        }

        default:
            return state;

    }
}