package controllers;

import play.*;
import play.mvc.*;
import play.data.Form;
import views.html.*;
import models.User;
import play.data.validation.Constraints;

public class Application extends Controller {
    final static Form<User> userForm = Form.form(User.class);
    public static Result index()
    {
        return ok(index.render(userForm));
    }
    public static Result submit()
    {
        Form<User> filledForm = userForm.bindFromRequest();
        User created = filledForm.get();
        return ok(submit.render(created));
    }

}
