import * as types from '../constants/ActionTypes';

export function logProduct(id, time) {
    return {
        type: types.LOG_PRODUCT,
        id,
        time
    }
}
