define([
  'jquery',
  'underscore',
  'backbone',
  'models/person'
], function($, _, Backbone,  PersonModel) {

  var PersonModel = Backbone.Model.extend({
    idAttribute : "name",
    urlRoot : "../person",
    defaults : {
      name : "",
      age : "20"
    }
  });
  
  return PersonModel;
});