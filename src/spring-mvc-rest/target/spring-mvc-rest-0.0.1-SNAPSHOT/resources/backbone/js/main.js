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

    newPerson : function() {
        console.log('newPerson function called');
        this.before(function() {
            app.showView('#content', new PersonView({
                model : new Person()
            }));
        }); 
    },
    
	personDetails : function(id) {
	    console.log('personDetails function called');
		this.before(function() {
			var person = app.personList.get(id);
			app.showView('#content', new PersonView({
				model : person
			}));
		});
	},

    showView : function(selector, view) {
        if (this.currentView) {            
            this.currentView.close();
        }
        $(selector).html(view.render().el);
        this.currentView = view;
        return view;
    },
	
	before : function(callback) {
	    console.log('before function called');
		this.personList = new PersonCollection();
		this.personList.fetch({
			success : function() {
			    $('#sidebar').html(new PersonListView({
                    model : app.personList
                }).render().el);
				if (callback) {
				    callback();    
				}
			}
		});
	}

});

templates.loadTemplates([ 'header', 'person-details', 'person-list-item' ], function() {
	app = new AppRouter();
	Backbone.history.start();
});