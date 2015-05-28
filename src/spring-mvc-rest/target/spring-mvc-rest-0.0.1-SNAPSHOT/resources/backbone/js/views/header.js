window.HeaderView = Backbone.View.extend({

    initialize: function() {
        this.template = _.template(templates.get('header'));
    },

    render: function(eventName) {
        console.log('rendering header');
		$(this.el).html(this.template());
		return this;
    },

    events: {
		"click .new" : "newPerson"
    },

	newPerson: function(event) { 
		app.navigate("person/new", true);
		return false;
	}

});