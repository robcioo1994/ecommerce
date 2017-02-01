import { SET_CURRENT_USER } from '../constants/ActionTypes';
import isEmpty from 'lodash/isEmpty';

const initialState = {
    isAuthenticated: false,
    role: 'admin',
    user: {}
};

export default (state = initialState, action = {}) =>{
    switch (action.type) {
        case SET_CURRENT_USER:
            return {
                isAuthenticated: !isEmpty(action.user),
                role: 'admin',
                user: action.user
            };
        default: return state;
    }
}