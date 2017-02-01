export default class Producer{
    constructor(_producer, _processorFamily,_model, _cores,_threads,_processorBaseFrequency,_maxTurboFrequency,
                _cache, _lithography, _processorGraphics, _TDP) {
        this.id = undefined;
        this.producer = _producer;
        this.processorFamily = _processorFamily;
        this.model = _model;
        this.cores = _cores;
        this.threads = _threads;
        this.processorBaseFrequency = _processorBaseFrequency;
        this.maxTurboFrequency = _maxTurboFrequency;
        this.cache = _cache;
        this.lithography = _lithography;
        this.processorGraphics = _processorGraphics;
        this.TDP = _TDP;
    }
}