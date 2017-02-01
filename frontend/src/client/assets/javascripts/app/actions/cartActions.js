import * as types from '../constants/ActionTypes';

export function addToCart(product, amount) {
    return {
        type: types.ADD_TO_CARD,
        product,
        amount
    }
}

export function removeFromCart(id) {
    return {
        type: types.REMOVE_FROM_CARD,
        id
    }
}

export function changeProductAmountInCart(id, amount) {
    return {
        type: types.CHANGE_PRODUCT_AMOUNT_IN_CART,
        id,
        amount
    }
}

