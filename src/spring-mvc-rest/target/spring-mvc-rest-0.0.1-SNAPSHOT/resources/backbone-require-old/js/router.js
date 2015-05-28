define([ 
  'jquery', 
  'underscore', 
  'backbone', 
  'views/person/list', 
  'views/person/detail'
], function($, _, Backbone, Session, PersonListView, PersonDetailView) {

  var AppRouter = Backbone.Router.extend({
    routes : {
      "person/new" : "newPerson",
      "person/:id" : "personDetails"
    }
  });

  var initialize = function() {

    var appRouter = new AppRouter;

    var personListView = new PersonListView();
    personListView.render();

    appRouter.on('newPerson', function() {

      var personListView = new PersonDetailView({model : new Person()});
      personListView.render();
    });

    appRouter.on('personDetails', function() {

      var personCollection = new PersonCollection();
      var person = personCollection.get(id);
      
      var personListView = new PersonListView({model : person});
      personListView.render();
    });

    Backbone.history.start();
  };

  return {
    initialize : initialize
  };
});