window.Person = Backbone.Model.extend({
    idAttribute : "id",
    defaults : {
        id : "",
        name : "default",
        age : "20"
    }
});

window.PersonCollection = Backbone.Collection.extend({
    model : Person,
    url : "/spring-mvc-rest/person"
});