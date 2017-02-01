import * as types from '../constants/ActionTypes';
import axios from 'axios';

const newProductRequest= () => ({
    type: types.REQUEST_PRODUCTS,
});

export function clearStore() {
    return {
        type: types.CLEAN_VISIBLE_PRODUCT_IN_STORE,
    }
}

export function receiveProductFromServer(id) {
    console.log('single');
    return dispatch=>{
        dispatch(newProductRequest);
        return axios.get('/api/all/notebook/'+id)
            .then(response => {
                dispatch(setReceivedProduct(response.data));
            });
    }
}

export function setReceivedProduct(product){
    return {
        type: types.REQUEST_PRODUCT_SUCCESS,
        product
    };
}