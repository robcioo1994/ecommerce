import React from 'react';

class SpecificationsBox extends React.Component {

    render() {
        const {cpu,memory,maxMemory, hardDisc,displayType, displaySize,displayResolution,gpu,
            inputOutputTypes,operatingSystem,height,width,depth, weight,color,guarantee,producer} = this.props.product;
        return (
            <div className="bg-white">
                <div className="container pt-3 pb-3">
                    <h2 className="pb-2">Specifications</h2>
                    <table className="table table-hover table-striped">
                        <tbody>
                            <tr>
                                <td>Producent</td>
                                <td>{producer.producer}</td>
                            </tr>

                            <tr>
                                <td>Procesor</td>
                                <td>{(cpu.producer + ' ' + cpu.model + ' (' + cpu.cores +
                                'rdzenie, od ' + cpu.processorBaseFrequency.toFixed(2) + ' GHz do ' + cpu.maxTurboFrequency.toFixed(2) +
                                ' GHz, '+ cpu.cache + ' MB cache)')}</td>
                            </tr>
                            <tr>
                                <td>Pamięć RAM</td>
                                <td>{(memory.amount + 'GB ('+memory.type+', ' + memory.frequency+ 'MHz)')}</td>
                            </tr>
                            <tr>
                                <td>Maksymalna ilosc pamieci</td>
                                <td>{maxMemory} GB</td>
                            </tr>
                            <tr>
                                <td>Karta Graficzna</td>
                                <td>{cpu.processorGraphics} /{gpu.name}</td>
                            </tr>
                            <tr>
                                <td>Dysk twardy	</td>
                                <td>{hardDisc.size} GB, {hardDisc.type}, {hardDisc.input}</td>
                            </tr>
                            <tr>
                                <td>Rozdzielczosc ekranu</td>
                                <td>{displayResolution.width} x {displayResolution.height}</td>
                            </tr>
                            <tr>
                                <td>Matryca</td>
                                <td>{displaySize.size},  {displayType.type}</td>
                            </tr>

                            <tr>
                                <td>System operacyjny</td>
                                <td>{operatingSystem.name}</td>
                            </tr>
                            <tr>
                                <td>Wysokość</td>
                                <td>{height} mm</td>
                            </tr>
                            <tr>
                                <td>Szerokość</td>
                                <td>{width} mm</td>
                            </tr>
                            <tr>
                                <td>Głębokość</td>
                                <td>{depth} mm</td>
                            </tr>
                            <tr>
                                <td>Waga</td>
                                <td>{weight} Kg</td>
                            </tr>
                            <tr>
                                <td>Gwarancja</td>
                                <td>{guarantee} miesiecy</td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}

SpecificationsBox.propTypes = {
};

export default SpecificationsBox;