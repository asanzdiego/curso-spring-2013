define([
  'jquery',
  'underscore',
  'backbone',
  'models/person'
], function($, _, Backbone,  PersonModel) {

  var ProjectCollection = Backbone.Collection.extend({
    model : PersonModel,
    url : "../person"
  });

  return ProjectCollection;

});