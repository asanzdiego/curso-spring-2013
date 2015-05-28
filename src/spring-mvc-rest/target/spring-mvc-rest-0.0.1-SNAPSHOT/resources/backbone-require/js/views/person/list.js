define([ 'views/person/list-item' ], function(PersonListItemView) {

    var PersonListView = Backbone.View.extend({

        tagName : "ul",

        initialize : function() {

            this.collection.on("add", this.addOne, this);
            this.collection.on("reset", this.render, this);
        },

        render : function() {

            console.log("PersonListView.render function called");
            this.collection.forEach(this.addOne, this);
            $("#list").html(this.$el);
        },

        addOne : function(personListItem) {

            console.log("PersonListView.addOne function called");
            var personListItemView = new PersonListItemView({
                model : personListItem
            });
            personListItemView.render();
            this.$el.append(personListItemView.el);
        }

    });

    return PersonListView;
});