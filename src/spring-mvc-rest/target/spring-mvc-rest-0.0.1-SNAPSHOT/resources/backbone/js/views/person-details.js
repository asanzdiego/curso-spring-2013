window.PersonView = Backbone.View.extend({

  tagName : "div", // Not required since 'div' is the default
  // if no el or tagName specified

  initialize : function() {

    this.template = _.template(templates.get('person-details'));
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
    console.log('changing ' + target.id + ' from: ' + target.defaultValue
        + ' to: ' + target.value);
  },

  savePerson : function() {

    console.log('saving person 4');
    this.model.set({
      id : $('#id').val(),
      name : $('#name').val(),
      age : $('#age').val()
    });
    console.log(this.model.toJSON());

    if (this.model.isNew()) {
      var self = this;
      console.log("is new");
      app.personList.create(this.model, {
        success : function() {
          alert("person saved");
        },
        error : function() {
          alert("error saving person");
        }
      });
    } else {
      console.log("is not new");
      this.model.save({
        success : function() {
          alert("person saved");
        },
        error : function() {
          alert("error saving person");
        }
      });
    }

    app.personList.create(this.model, {
      success : function() {

        app.navigate('person/' + self.model.id, false);
      }
    });
    this.model.save({
      success : function() {

        alert("person saved");
      },
      error : function() {

        alert("error saving person");
      }
    });

    return false;
  },

  deletePerson : function() {

    this.model.destroy({
      success : function() {

        window.history.back();
      },
      error : function() {

        alert("error deleting person");
      }
    });
    return false;
  }

});
