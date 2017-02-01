import * as types from '../constants/ActionTypes';

export default (state ={}, action = {}) =>{
    switch (action.type) {
        case types.REQUEST_ACCOUNT_SUCCESS:
            return  action.account;

        case types.UPDATE_ACCOUNT_REQUEST_SUCCESS:
            return  action.account;

        default: return state;
    }
}