import * as types from '../constants/ActionTypes';
import axios from 'axios';

const newNotebookRequest= () => ({
    type: types.ADD_NEW_NOTEBOOK
});

export function addNewNotebook(notebook, image) {
    return dispatch=>{
        dispatch(newNotebookRequest);
        return axios.post('/api/all/notebook', notebook)
            .then(response => {
                console.log('done');
                // dispatch(setReceivedGraphicsCard(response.data));
            });
    }
}

export function setReceivedGraphicsCard(product){
    return {
        type: types.REQUEST_GRAPHICS_CARD_SUCCESS,
        product
    };
}


export function receiveProductsFromServer(page, size) {
    console.log(page +'     ' + size);
    return dispatch=>{
        dispatch(newProductsRequest);
        return axios.get('/api/all/notebooks', {params: { page, size}})
            .then(response => {
            dispatch(setReceivedProducts(response.data));
        });
    }
}



export function setReceivedProducts(products){
    return {
        type: types.REQUEST_PRODUCTS_SUCCESS,
        products
    };
}

const newProductsRequest= () => ({
    type: types.REQUEST_PRODUCT,
});