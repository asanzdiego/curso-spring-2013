define([], function() {

    var PersonModel = Backbone.Model.extend({
        idAttribute : "id",
        urlRoot : "../../person",
        defaults : {
            name : "default",
            age : "20"
        },
        log : function() {

            console.log("isNew=" + this.isNew() + ", id=" + this.id + ", name="
                    + this.name + ", age=" + this.age);
        }
    });

    return PersonModel;
});