import * as types from '../constants/ActionTypes';

export default function (state = [], action) {
    // switch (action.type) {
    //     case types.LOG_PRODUCT: {
    //         const i = state.findIndex( (elem) => elem.id === action.id );
    //
    //         if(i !== -1){
    //             return [
    //                 ...state.slice(0,i),
    //                 {...state[i], time:state[i].time +  action.time},
    //                 ...state.slice(i+1),
    //             ]
    //         }
    //         else
    //             return [...state, {id:action.id, time:action.time}]
    //
    //     }
    //
    //     default:
    //         return state;
    //
    // }
    return state;
}