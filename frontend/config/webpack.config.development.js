import merge from 'webpack-merge';
import webpack from 'webpack';
import config from './webpack.config.base';
import path from 'path';


const GLOBALS = {
    'process.env': {
        'NODE_ENV': JSON.stringify('development')
    },
    __DEV__: JSON.stringify(JSON.parse(process.env.DEBUG || 'true'))
};

export default merge(config, {
    debug: true,
    cache: true,
    devtools: 'cheap-module-eval-source-map',
    entry: {
        application: [
            'webpack-hot-middleware/client',
            'development'
        ],
        vendor: ['react', 'react-dom', 'react-redux', 'react-router', 'react-router-redux', 'redux']
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin(),
        new webpack.optimize.OccurrenceOrderPlugin(),
        new webpack.DefinePlugin(GLOBALS)
    ],
    module: {
        loaders: [
            // Sass
            {
                test: /\.scss$/,
                include: [
                    path.resolve(__dirname, '../src/client/assets/javascripts'),
                    path.resolve(__dirname, '../src/client/assets/styles'),
                    path.resolve(__dirname, '../src/client/scripts')
                ],
                loaders: [
                    'style',
                    'css',
                    'postcss',
                    { loader: 'sass', query: { outputStyle: 'expanded' } }
                ]
            },
            {
                test: /\.css$/,
                loader: 'style!css!postcss'
            }
        ]
    }
});