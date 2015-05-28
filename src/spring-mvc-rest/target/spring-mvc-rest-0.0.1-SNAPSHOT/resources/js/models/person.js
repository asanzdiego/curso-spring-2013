window.Person = Backbone.Model.extend({
    idAttribute: "name",
	urlRoot: "../person",
	defaults: {
	    name: "",
	    age: ""
	}
});

window.PersonCollection = Backbone.Collection.extend({
	model: Person,
	url: "../person"
});