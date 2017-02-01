import * as types from '../constants/ActionTypes';
import axios from 'axios';

// - INPUT OUTPUT TYPE -------------------------------------------------------------------------------------------------
const newInputOutput= () => ({
    type: types.ADD_NEW_INPUT_OUTPUT_TYPE,
});

export function addInputOutputType(component) {
    return dispatch=>{
        dispatch(newInputOutput);
        return axios.post('/api/all/inputsOutput', component)
            .then(response => {
                dispatch(inputOutputTypeAddWithSuccess(response.data));
            });
    }
}

export function inputOutputTypeAddWithSuccess(products){
    return {
        type: types.ADD_NEW_INPUT_OUTPUT_TYPE_SUCCESS
    };
}

const newInputOutputTypeRequest= () => ({
    type: types.ADD_NEW_INPUT_OUTPUT_TYPE_REQUEST,
});

export function receiveInputOutputTypesFromServer() {
    return dispatch=>{
        dispatch(newInputOutputTypeRequest);
        return axios.get('/api/all/inputsOutput')
            .then(response => {
                dispatch(setReceivedInputOutputTypes(response.data));
            });
    }
}

export function setReceivedInputOutputTypes(product){
    return {
        type: types.REQUEST_INPUT_OUTPUT_TYPE_SUCCESS,
        product
    };
}

// - MEMORY ------------------------------------------------------------------------------------------------------------
const newMemory= () => ({
    type: types.ADD_MEMORY,
});

export function addMemory(component) {
    return dispatch=>{
        dispatch(newMemory);
        return axios.post('/api/all/memory', component)
            .then(response => {
                dispatch(memoryAddWithSuccess(response.data));
            });
    }
}

export function memoryAddWithSuccess(products){
    return {
        type: types.ADD_MEMORY_SUCCESS
    };
}

const newMemoryRequest= () => ({
    type: types.ADD_NEW_MEMORY_REQUEST,
});

export function receiveMemoryFromServer() {
    return dispatch=>{
        dispatch(newMemoryRequest);
        return axios.get('/api/all/memory')
            .then(response => {
                dispatch(setReceivedMemorySystem(response.data));
            });
    }
}

export function setReceivedMemorySystem(product){
    return {
        type: types.REQUEST_MEMORY_SUCCESS,
        product
    };
}



// - DISC --------------------------------------------------------------------------------------------------------------
const newDisc= () => ({
    type: types.ADD_NEW_DISC,
});

export function addDisc(component) {
    return dispatch=>{
        dispatch(newDisc);
        return axios.post('/api/all/hardDisc', component)
            .then(response => {
                dispatch(newDiscSuccess(response.data));
            });
    }
}

export function newDiscSuccess(products){
    return {
        type: types.ADD_NEW_DISC_SUCCESS
    };
}

const newDiscRequest= () => ({
    type: types.ADD_NEW_DISC_REQUEST,
});

export function receiveDiscFromServer() {
    return dispatch=>{
        dispatch(newDiscRequest);
        return axios.get('/api/all/hardDisc')
            .then(response => {
                dispatch(setDiscProcessor(response.data));
            });
    }
}

export function setDiscProcessor(product){
    return {
        type: types.REQUEST_DISC_SUCCESS,
        product
    };
}


// - GRAPHICS CARD -----------------------------------------------------------------------------------------------------
const newGraphicsCard= () => ({
    type: types.ADD_NEW_GRAPHICS_CARD,
});

export function addGraphicsCard(component) {
    return dispatch=>{
        dispatch(newGraphicsCard);
        return axios.post('/api/all/graphicsCard', component)
            .then(response => {
                dispatch(newGraphicsCardSuccess(response.data));
            });
    }
}

export function newGraphicsCardSuccess(products){
    return {
        type: types.ADD_NEW_GRAPHICS_CARD_SUCCESS
    };
}

const newGraphicsCardRequest= () => ({
    type: types.ADD_NEW_GRAPHICS_CARD_REQUEST
});

export function receiveGraphicsCardFromServer() {
    return dispatch=>{
        dispatch(newGraphicsCardRequest);
        return axios.get('/api/all/graphicsCard')
            .then(response => {
                dispatch(setReceivedGraphicsCard(response.data));
            });
    }
}

export function setReceivedGraphicsCard(product){
    return {
        type: types.REQUEST_GRAPHICS_CARD_SUCCESS,
        product
    };
}





// - OPERATION SYSTEM --------------------------------------------------------------------------------------------------
const newOperationSystem= () => ({
    type: types.ADD_OPERATION_SYSTEM,
});

export function addOperationSystem(component) {
    return dispatch=>{
        dispatch(newOperationSystem);
        return axios.post('/api/all/operationSystem', component)
            .then(response => {
                dispatch(newOperationSystemSuccess(response.data));
            });
    }
}

export function newOperationSystemSuccess(products){
    return {
        type: types.ADD_OPERATION_SYSTEM_SUCCESS
    };
}

const newOperationSystemRequest= () => ({
    type: types.ADD_NEW_OPERATION_SYSTEM_REQUEST,
});

export function receiveOperationSystemFromServer() {
    return dispatch=>{
        dispatch(newOperationSystemRequest);
        return axios.get('/api/all/operationSystem')
            .then(response => {
                dispatch(setReceivedOperationSystem(response.data));
            });
    }
}

export function setReceivedOperationSystem(product){
    return {
        type: types.REQUEST_OPERATION_SYSTEM_SUCCESS,
        product
    };
}



// - DISPLAY RESOLUTION ------------------------------------------------------------------------------------------------
const newDisplayResolution= () => ({
    type: types.ADD_NEW_DISPLAY_RESOLUTION,
});

export function addDisplayResolution(component) {
    return dispatch=>{
        dispatch(newDisplayResolution);
        return axios.post('/api/all/displayResolution', component)
            .then(response => {
                dispatch(newDisplayResolutionSuccess(response.data));
            });
    }
}

export function newDisplayResolutionSuccess(products){
    return {
        type: types.ADD_NEW_DISPLAY_RESOLUTION_SUCCESS
    };
}

const newDisplayResolutionRequest= () => ({
    type: types.ADD_NEW_DISPLAY_RESOLUTION_REQUEST,
});

export function receiveDisplayResolutionFromServer() {
    return dispatch=>{
        dispatch(newDisplayResolutionRequest);
        return axios.get('/api/all/displayResolution')
            .then(response => {
                dispatch(setReceivedDisplayResolution(response.data));
            });
    }
}

export function setReceivedDisplayResolution(product){
    return {
        type: types.REQUEST_DISPLAY_RESOLUTION_SUCCESS,
        product
    };
}


// - DISPLAY SIZE ------------------------------------------------------------------------------------------------------
const newDisplaySize= () => ({
    type: types.ADD_NEW_DISPLAY_SIZE,
});

export function addDisplaySize(component) {
    return dispatch=>{
        dispatch(newDisplaySize);
        return axios.post('/api/all/displaySize', component)
            .then(response => {
                dispatch(newDisplaySizeSuccess(response.data));
            });
    }
}

export function newDisplaySizeSuccess(products){
    return {
        type: types.ADD_NEW_DISPLAY_SIZE_SUCCESS
    };
}

const newDisplaySizeRequest= () => ({
    type: types.ADD_NEW_DISPLAY_SIZE_REQUEST,
});

export function receiveDisplaySizeFromServer() {
    return dispatch=>{
        dispatch(newDisplaySizeRequest);
        return axios.get('/api/all/displaySize')
            .then(response => {
                dispatch(setReceivedDisplaySize(response.data));
            });
    }
}

export function setReceivedDisplaySize(product){
    return {
        type: types.REQUEST_DISPLAY_SIZE_SUCCESS,
        product
    };
}


// - DISPLAY TYPE ------------------------------------------------------------------------------------------------------
const newDisplayType= () => ({
    type: types.ADD_NEW_DISPLAY_TYPE,
});

export function addDisplayType(component) {
    return dispatch=>{
        dispatch(newDisplayType);
        return axios.post('/api/all/displayType', component)
            .then(response => {
                dispatch(newDisplayTypeSuccess(response.data));
            });
    }
}

export function newDisplayTypeSuccess(products){
    return {
        type: types.ADD_NEW_DISPLAY_TYPE_SUCCESS
    };
}

const newDisplayTypeRequest= () => ({
    type: types.ADD_NEW_DISPLAY_TYPE_REQUEST,
});

export function receiveDisplayTypeFromServer() {
    return dispatch=>{
        dispatch(newDisplayTypeRequest);
        return axios.get('/api/all/displayType')
            .then(response => {
                dispatch(setReceivedDisplayType(response.data));
            });
    }
}

export function setReceivedDisplayType(product){
    return {
        type: types.REQUEST_DISPLAY_TYPE_SUCCESS,
        product
    };
}


// - PRODUCER ---------------------------------------------------------------------------------------------------------
const newProducer= () => ({
    type: types.ADD_NEW_PRODUCER,
});

export function addProducer(component) {
    return dispatch=>{
        dispatch(newProducer);
        return axios.post('/api/all/producer', component)
            .then(response => {
                dispatch(newProducerSuccess(response.data));
            });
    }
}

export function newProducerSuccess(products){
    return {
        type: types.ADD_NEW_PRODUCER_SUCCESS
    };
}

const newProducerRequest= () => ({
    type: types.ADD_NEW_PRODUCER_REQUEST,
});

export function receiveProducerFromServer() {
    return dispatch=>{
        dispatch(newProducerRequest);
        return axios.get('/api/all/producer')
            .then(response => {
                dispatch(setReceivedProducerSystem(response.data));
            });
    }
}

export function setReceivedProducerSystem(product){
    return {
        type: types.REQUEST_PRODUCER_SUCCESS,
        product
    };
}


// - PROCESSOR ---------------------------------------------------------------------------------------------------------
const newProcessor= () => ({
    type: types.ADD_NEW_PROCESSOR,
});

export function addProcessor(component) {
    return dispatch=>{
        dispatch(newProcessor);
        return axios.post('/api/all/processor', component)
            .then(response => {
                dispatch(newProcessorSuccess(response.data));
            });
    }
}

export function newProcessorSuccess(products){
    return {
        type: types.ADD_NEW_PROCESSOR_SUCCESS
    };
}

const newProcessorRequest= () => ({
    type: types.ADD_NEW_PROCESSOR_REQUEST,
});

export function receiveProcessorFromServer() {
    return dispatch=>{
        dispatch(newProcessorRequest);
        return axios.get('/api/all/processor')
            .then(response => {
                dispatch(setReceivedProcessor(response.data));
            });
    }
}

export function setReceivedProcessor(product){
    return {
        type: types.REQUEST_PROCESSOR_SUCCESS,
        product
    };
}
