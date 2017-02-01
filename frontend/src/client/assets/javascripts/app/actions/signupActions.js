import * as types from '../constants/ActionTypes';
import axios from 'axios';

export function userSignUpRequest(userData) {
    console.log(userData);
    return dispatch=>{
        dispatch(newUserSignUpRequest());
        return axios.post('/api/accounts', userData);
            // .then(response=>dispatch(signUpRequestSuccess()))
            // .catch(response=>dispatch(signUpRequestError()));
    }
}

const newUserSignUpRequest= () => ({
    type: types.SIGNUP_REQUEST,
});

const signUpRequestSuccess= () => ({
    type: types.SIGNUP_REQUEST_SUCCESS,
});

const signUpRequestError= () => ({
    type: types.SIGNUP_REQUEST_ERROR
});

