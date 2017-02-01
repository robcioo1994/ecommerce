import * as types from '../constants/ActionTypes';
import axios from 'axios';
import setAuthorizationToken from '../utils/setAuthorizationToken'
import jwtDecode from 'jwt-decode';

export function setCurrentUser(user){
    return {
        type: types.SET_CURRENT_USER,
        user
    };
}

export function logout() {
    return dispatch => {
        // dispatch(logoutRequest()) // TODO
        localStorage.removeItem('jwtToken');
        setAuthorizationToken(false);
        dispatch(setCurrentUser({}));
    }
}

export function login(loginData) {
    console.log(loginData);
    return dispatch=>{
        dispatch(newUserLoginRequest());
        return axios.post('/api/auth', loginData)
            .then(response => {
                const token = response.data.token;
                localStorage.setItem('jwtToken',token);
                setAuthorizationToken(token);
                console.log(jwtDecode(token));
                dispatch(setCurrentUser(jwtDecode(token)));
            });
    }
}

const newUserLoginRequest= () => ({
    type: types.LOGIN_REQUEST,
});

const logoutRequest= () => ({
    type: types.LOGOUT_REQUEST,
});


