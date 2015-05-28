// Require.js allows us to configure shortcut alias
// There usage will become more apparent further along in the tutorial.
require.config({
  paths : {
    jquery : 'lib/jquery',
    underscore : 'lib/underscore',
    backbone : 'lib/backbone',
    templates: 'templates'
  }
});

// Load our app module and pass it to our definition function
require([ 'app' ], function(App) {

  alert(App);
  
  // The "app" dependency is passed in as "App"
  App.initialize();

});