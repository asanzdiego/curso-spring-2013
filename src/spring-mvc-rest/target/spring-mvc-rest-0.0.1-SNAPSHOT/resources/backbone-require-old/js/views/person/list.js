define([
  'jquery',
  'underscore',
  'backbone',
  'router',
  'collections/persons',
  'text!templates/person/list.html'
], function($, _, Backbone, AppRouter, ProjectsCollection, projectsListTemplate) {

  var ProjectListView = Backbone.View.extend({
    
    el : $("#content"),
    
    render : function() {
      this.collection = new ProjectsCollection();
      var compiledTemplate = _.template(projectsListTemplate, {
        persons : this.collection.models
      });
      this.$el.html(compiledTemplate);
    },
    
    events : {
      "click .new" : "newPerson"
    },

    newPerson : function(event) {

      var appRouter = new AppRouter();
      appRouter.navigate("person/new", true);
      return false;
    }
  });

  return ProjectListView;
});