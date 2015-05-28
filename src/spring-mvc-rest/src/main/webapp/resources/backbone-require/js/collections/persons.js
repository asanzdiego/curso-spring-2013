define([ 'models/person' ], function(PersonModel) {

    var PersonCollection = Backbone.Collection.extend({
        model : PersonModel,
        url : "../../person"
    });

    return PersonCollection;

});