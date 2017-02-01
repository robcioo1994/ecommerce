import * as types from '../constants/ActionTypes';
import axios from 'axios';

const getAccountRequest= () => ({
    type: types.ACCOUNT_REQUEST,
});

const updatePasswordRequest= () => ({
    type: types.UPDATE_PASSWORD_REQUEST,
});

const getAccountRequestSuccess= (account) => ({
    type: types.REQUEST_ACCOUNT_SUCCESS,
    account
});

const updateAccountRequest= () => ({
    type: types.UPDATE_ACCOUNT_REQUEST,
});

const updateAccountRequestSuccess= (account) => ({
    type: types.UPDATE_ACCOUNT_REQUEST_SUCCESS,
    account
});

export function receiveAccountFromServer(email) {
    return dispatch=>{
        dispatch(getAccountRequest());
        return axios.get('/api/account/accountDetails?email=' + email)
            .then(response => {
                dispatch(getAccountRequestSuccess(response.data))
            });
    }
}

export function updateAccount(account) {
    return dispatch=>{
        dispatch(updateAccountRequest());
        return axios.post('/api/account/updateAccount',account)
            .then(response => {
                dispatch(updateAccountRequestSuccess(response.data))
            });
    }
}

export function updatePassword(passwordUpdate) {
    return dispatch=>{
        dispatch(updatePasswordRequest());
            return axios.post('/api/account/updateAccountPassword', passwordUpdate)
                .then(response => {

                });
    }
}

