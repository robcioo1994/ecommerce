import path from 'path';
import express from 'express';
import webpack from 'webpack';
import webpackDevMiddleware from 'webpack-dev-middleware';
import webpackHotMiddleware from 'webpack-hot-middleware';
import config from './config/webpack.config.development';
import history from 'connect-history-api-fallback';
import proxy from 'http-proxy-middleware';

const app = express();
const compiler = webpack(config);

const host = process.env.HOST || 'localhost';
const port = process.env.PORT || 3001;

function log() {
    arguments[0] = `\nWebpack: ${arguments[0]}`;
    console.log(...arguments);
}

app.use(webpackDevMiddleware(compiler, {
    noInfo: true,
    publicPath: config.output.publicPath,
    stats: {
        colors: true
    },
    historyApiFallback: true
}));

app.use(history());
app.use(proxy('/api', {target: 'http://localhost:8091', changeOrigin: true}));

app.use(webpackHotMiddleware(compiler));

app.get('*', (req, res) => {
    res.sendFile(path.join(__dirname, './src/client/assets/index.html'));
});

app.listen(port, host, (err) => {
    if (err) {
        log(err);
        return;
    }

    log('🚧  App is listening at http://%s:%s', host, port);
});
