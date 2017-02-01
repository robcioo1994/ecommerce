import * as types from '../constants/ActionTypes';

export default function (state = [], action) {
    switch (action.type) {
        case types.REQUEST_PRODUCTS_SUCCESS: {
            return [...action.products]
        }

        default:
            return state;

    }
}