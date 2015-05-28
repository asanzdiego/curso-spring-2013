window.PersonView = Backbone.View.extend({

    tagName : "div", // Not required since 'div' is the default if no el 
                     // or tagName specified

    initialize : function() {

        this.template = _.template(tpl.get('person-details'));
        this.model.bind("change", this.render, this);
    },

    render : function(eventName) {

        $(this.el).html(this.template(this.model.toJSON()));
        return this;
    },

    events : {
        "change input" : "change",
        "click .save" : "savePerson",
        "click .delete" : "deletePerson"
    },

    change : function(event) {

        var target = event.target;
        console.log('changing ' + target.id + 
                    ' from: ' + target.defaultValue + 
                    ' to: ' + target.value);
        // You could change your model on the spot, like this:
        // var change = {};
        // change[t.id.id] = target.value;
        // this.model.set(change);
    },

    savePerson : function() {

        this.model.set({
            name : $('#name').val(),
            age : $('#age').val()
        });
        if (this.model.isNew()) {
            var self = this;
            app.personList.create(this.model, {
                success : function() {
                    app.navigate('person/' + self.model.id, false);
                }
            });
        } else {
            this.model.save();
        }

        return false;
    },

    deletePerson : function() {

        this.model.destroy({
            success : function() {

                alert('Person deleted successfully');
                window.history.back();
            }
        });
        return false;
    }

});
