import * as types from '../constants/ActionTypes';

export default function (state = [], action) {
    switch (action.type) {
        case types.REQUEST_PRODUCT_SUCCESS: {
            return {product: action.product}
        }
        case types.CLEAN_VISIBLE_PRODUCT_IN_STORE: {
            return {}
        }
        default:
            return state;

    }
}