export default class Notebook{
    constructor(_productName,_price, _producer, _cpu,_gpu, _memory, _maxMemory,_hardDisc,_hasDvdRecorder,
                _displayType,_displaySize,_displayResolution, _sound,_microphone, _inputOutputTypes,_operatingSystem,
                _height, _width, _depth, _weight,_color,_guarantee,_frontImage,_images, _additionalDescription) {
        this.id = undefined;
        this.productName = _productName;
        this.price = _price;
        this.producer = _producer;
        this.cpu = _cpu;
        this.gpu = _gpu;
        this.memory = _memory;
        this.maxMemory = _maxMemory;
        this.hardDisc = _hardDisc;
        this.hasDvdRecorder = _hasDvdRecorder;
        this.displayType = _displayType;
        this.displaySize = _displaySize;
        this.displayResolution = _displayResolution;
        this.sound = _sound;
        this.microphone = _microphone;
        this.inputOutputTypes = _inputOutputTypes;
        this.operatingSystem = _operatingSystem;
        this.height = _height;
        this.width = _width;
        this.depth = _depth;
        this.weight = _weight;
        this.color = _color;
        this.guarantee = _guarantee;
        this.frontImage = _frontImage;
        this.additionalDescription = _additionalDescription;
        this.images = _images;
    }
}