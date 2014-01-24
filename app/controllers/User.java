package controllers;

import java.util.List;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;


public class User extends Controller {
	private static Form<models.User> userForm = Form.form(models.User.class);
	
	public static Result all(){
		List<models.User> userList = models.User.all();
		return ok(views.html.userlist.render(userList)); 
	}
	
	public static Result save(){
		Form<models.User> filledForm = userForm.bindFromRequest();
		if(filledForm.hasErrors()){
			return badRequest (
				views.html.registration.render(filledForm)
					);
		}
		else{
			models.User.save(filledForm.get());
			return redirect(routes.User.all());
			
		}
		
	}
	public static Result create(){
		return ok(views.html.registration.render(userForm));
	
}
		public static Result delete(Long id){
			
			System.out.println("delete");
			
			models.User.delete(id);
			
						
			return redirect(routes.User.all());
			
			
			
	
}
	
		public static Result update(Long id){
			Form<models.User> form = Form.form(models.User.class);
			
			//System.out.println("update");
			
			//models.User.update(id);
			//find.ref(id).update();
			models.User user = models.User.find.byId(id);	
			
			return ok (views.html.update.render(form.fill(user),user));
}	
		public static Result modify(Long id){
			Form<models.User> filledForm = userForm.bindFromRequest();
			models.User.modify(filledForm.get(), id);
			return redirect(routes.User.all());
			
			
		}
}
