define([ 'text!templates/person/detail.html' ], function(personDetailTemplate) {

    var PersonDetailView = Backbone.View.extend({

        id : 'person',

        initialize : function() {

            this.model.on('destroy', this.remove, this);
        },

        render : function() {

            console.log("PersonDetailView.render function called");
            var compiledTemplate = _.template(personDetailTemplate, {
                person : this.model
            });
            // console.log(compiledTemplate);
            this.$el.html(compiledTemplate);
            $("#detail").html(this.$el);
        },

        remove : function() {

            console.log("PersonDetailView.remove function called");
            this.$el.remove();
        },

        events : {
            "click .save" : "savePerson",
            "click .delete" : "deletePerson"
        },

        savePerson : function() {

            console.log("PersonDetailView.savePerson function called");
            this.model.set({
                name : $('#name').val(),
                age : $('#age').val()
            });
            this.model.log();
            this.model.save(this.model, {
                success : function() {

                    console.log("person saved");
                    $("#detail").html("Person saved");
                },
                error : function() {

                    $("#detail").html("Error saving person");
                }
            });
            if (this.model.isNew()) {
                appRouter.navigate("", {
                    trigger : true
                });
            } else {
                appRouter.navigate("");
            }
        },

        deletePerson : function() {

            console.log("PersonDetailView.deletePerson function called");
            this.model.log();
            this.model.destroy({
                success : function() {

                    console.log("person deleted");
                    $("#detail").html("Person deleted");
                },
                error : function() {

                    $("#detail").html("Error deleting person");
                }
            });
        }

    });

    return PersonDetailView;
});
