define([ 'text!templates/person/list-item.html' ], function(
        personListItemTemplate) {

    var PersonListItemView = Backbone.View.extend({

        tagName : "li",

        initialize : function() {

            this.model.on("change", this.render, this);
            this.model.on("destroy", this.close, this);
        },

        render : function() {

            console.log("PersonListItemView.render function called");
            var compiledTemplate = _.template(personListItemTemplate, {
                person : this.model,
                _ : _
            });
            // console.log(compiledTemplate);
            this.$el.html(compiledTemplate);
        },

        close : function() {

            console.log("PersonListItemView.close function called");
            this.remove();
            this.unbind();
        }
    });

    return PersonListItemView;
});