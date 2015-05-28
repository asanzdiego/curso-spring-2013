define([
  'jquery',
  'underscore',
  'backbone',
  'text!templates/person/detail.html'
], function($, _, Backbone, personDetailTemplate) {

  var PersonDetailView = Backbone.View.extend({

    el : $('#content'),

    render : function(data) {

      this.model = data;
      var compiledTemplate = _.template(personDetailTemplate, data);
      this.$el.append(compiledTemplate);
    },

    events : {
      "click .save" : "savePerson",
      "click .delete" : "deletePerson"
    },

    savePerson : function() {

      this.model.set({
        name : $('#name').val(),
        age : $('#age').val(),
      });
      this.model.save();
    },

    deletePerson : function() {

      this.model.destroy();
    }

  });

  // Our module now returns our view
  return PersonDetailView;
});
