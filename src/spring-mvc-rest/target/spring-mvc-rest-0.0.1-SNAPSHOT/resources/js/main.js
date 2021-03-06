Backbone.View.prototype.close = function() {
	console.log('Closing view ' + this);
	if (this.beforeClose) {
		this.beforeClose();
	}
	this.remove();
	this.unbind();
};

var AppRouter = Backbone.Router.extend({

	initialize : function() {
		$('#header').html(new HeaderView().render().el);
	},

	routes : {
		"" : "list",
		"person/new" : "newPerson",
		"person/:id" : "personDetails"
	},

	list : function() {
		this.before();
	},

	personDetails : function(id) {
		this.before(function() {
			var person = app.personList.get(id);
			app.showView('#content', new PersonView({
				model : person
			}));
		});
	},

	newPerson : function() {
		this.before(function() {
			app.showView('#content', new PersonView({
				model : new Person()
			}));
		});
	},

	showView : function(selector, view) {
		if (this.currentView)
			this.currentView.close();
		$(selector).html(view.render().el);
		this.currentView = view;
		return view;
	},

	before : function(callback) {
		if (this.personList) {
			if (callback)
				callback();
		} else {
			this.personList = new PersonCollection();
			this.personList.fetch({
				success : function() {
					$('#sidebar').html(new PersonListView({
						model : app.personList
					}).render().el);
					if (callback)
						callback();
				}
			});
		}
	}

});

tpl.loadTemplates([ 'header', 'person-details', 'person-list-item' ], function() {
	app = new AppRouter();
	Backbone.history.start();
});