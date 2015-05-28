define([ 'router' ], function(Router) {

    var initialize = function() {

        console.log("initializing router");
        Router.initialize();
        console.log("router initialized");
    };

    return {
        initialize : initialize
    };

});