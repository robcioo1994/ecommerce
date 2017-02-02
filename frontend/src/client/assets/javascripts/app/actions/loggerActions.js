import * as types from '../constants/ActionTypes';
import axios from 'axios';


export function logProduct(logger) {
    console.log(logger);
    return dispatch=>{
        dispatch(newLogRequest);
        return axios.post('/api/all/log', logger)
            .then(response => {
                console.log('logger ok');
                dispatch(newLogRequestSuccess);
            });
    }
}

const newLogRequest= () => ({
    type: types.LOG_PRODUCT
});

const newLogRequestSuccess= () => ({
    type: types.LOG_PRODUCT
});
