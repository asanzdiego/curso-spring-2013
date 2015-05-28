define([ 'models/person', 'collections/persons', 'views/person/list',
        'views/person/detail' ], function(PersonModel, PersonCollection,
        PersonListView, PersonDetailView) {

    var AppRouter = Backbone.Router.extend({

        personCollection : new PersonCollection(),

        routes : {
            "" : "personList",
            "person/new" : "newPerson",
            "person/:id" : "personDetails"
        },

        personList : function() {

            console.log("personList function called");
            this.personCollection.fetch({
                success : function(personCollection) {

                    personListView = new PersonListView({
                        collection : personCollection
                    });
                    personListView.render();
                },
                error : function() {

                    $("#list").html("Error retrieving persons list");
                }
            });
        },

        newPerson : function() {

            console.log("newPerson function called");
            personDetailView = new PersonDetailView({
                model : new PersonModel()
            });
            personDetailView.render();
        },

        personDetails : function(id) {

            console.log("personDetails function called");
            personDetailView = new PersonDetailView({
                model : this.personCollection.get(id)
            });
            personDetailView.render();
        }
    });

    var initialize = function() {

        appRouter = new AppRouter();
        Backbone.history.start();
    };

    return {
        initialize : initialize
    };
});