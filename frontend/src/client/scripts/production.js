// Expose Raven
window.Raven = require('raven-js');

// Load CSS via Webpack to be able to require Bootstrap, Font Awesome, etc. from npm
require('styles/styles.css');

// JavaScript main file
require('javascripts/app');