import * as types from '../constants/ActionTypes';

const initData = {
    inputOutputTypes: [],
    operationSystem:[],
    producers: [],
    memory:[],
    processors: [],
    hardDisc: [],
    displayResolution: [],
    displaySize: [],
    displayType: [],
    graphicsCard:[]
};
export default function (state = initData, action) {
    let inputOutputTypes = state.inputOutputTypes;
    let operationSystem = state.operationSystem;
    let producers = state.producers;
    let memory = state.memory;
    let processors = state.processors;
    let hardDisc = state.hardDisc;
    let displayResolution = state.displayResolution;
    let displaySize = state.displaySize;
    let displayType = state.displayType;
    let graphicsCard = state.graphicsCard;

    switch (action.type) {
        case types.REQUEST_INPUT_OUTPUT_TYPE_SUCCESS: {
            return  {inputOutputTypes: action.product, operationSystem, producers, memory, processors, hardDisc, displayResolution, displaySize, displayType, graphicsCard}
        }
        case types.REQUEST_OPERATION_SYSTEM_SUCCESS: {
            return  {inputOutputTypes,producers, operationSystem: action.product, memory, processors, hardDisc, displayResolution, displaySize, displayType, graphicsCard}
        }
        case types.REQUEST_PRODUCER_SUCCESS: {
            return  {inputOutputTypes,operationSystem, producers: action.product, memory, processors, hardDisc, displayResolution, displaySize, displayType, graphicsCard}
        }
        case types.REQUEST_MEMORY_SUCCESS: {
            return  {inputOutputTypes,operationSystem, producers, memory: action.product, processors, hardDisc, displayResolution, displaySize, displayType, graphicsCard}
        }
        case types.REQUEST_PROCESSOR_SUCCESS: {
            return  {inputOutputTypes,operationSystem, producers, processors: action.product,memory, hardDisc, displayResolution, displaySize, displayType, graphicsCard}
        }
        case types.REQUEST_DISC_SUCCESS: {
            return  {inputOutputTypes,operationSystem, producers, hardDisc: action.product,memory, processors, displayResolution, displaySize, displayType, graphicsCard}
        }
        case types.REQUEST_DISPLAY_RESOLUTION_SUCCESS: {
            return  {inputOutputTypes,operationSystem, producers, hardDisc, displayResolution: action.product,memory, processors, displaySize, displayType, graphicsCard}
        }
        case types.REQUEST_DISPLAY_SIZE_SUCCESS: {
            return  {inputOutputTypes,operationSystem, producers, hardDisc, displaySize: action.product,memory, processors, displayResolution,displayType, graphicsCard}
        }
        case types.REQUEST_DISPLAY_TYPE_SUCCESS: {
            return  {inputOutputTypes,operationSystem, producers, hardDisc, displayType: action.product,memory, processors, displayResolution, displaySize, graphicsCard}
        }
        case types.REQUEST_GRAPHICS_CARD_SUCCESS: {
            return  {inputOutputTypes,operationSystem, producers, hardDisc, graphicsCard: action.product,memory, processors, displayResolution, displaySize, displayType}
        }
        // case types.ADD_NEW_INPUT_OUTPUT_TYPE: {
        //     return [action.product]
        // }

        default:
            return state;

    }
}