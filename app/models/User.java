package models;

import java.util.List;

import javax.persistence.*;

import play.data.validation.Constraints.Required;
import play.db.ebean.*;

@Entity
@Table(name= "user_table")
public class User extends Model {

@Required
private String fullName;

@Required
private String company;

@Required
private String email;

@Required
private String password;

@Id
private Long id;

public static Finder<Long,User> find = new Finder(
		Long.class, User.class );


public Long getId() {
	return id;
}


public void setId(Long id) {
	this.id = id;
}

public String getFullName() {
	return fullName;
}
public void setFullName(String fullName) {
	this.fullName = fullName;
}
public String getCompany() {
	return company;
}
public void setCompany(String company) {
	this.company = company;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

public static void save(User user){
	user.save();
}

public static void delete(Long id){
	//User user = User.find.byId(id);
	find.ref(id).delete();
	//user.delete();
}

public static void update(Long id){
	
//	find.ref(id).update();
}

public static void modify(User label, Long id){
	User user = User.find.byId(id);
	  user.setFullName(label.getFullName());
	  user.setCompany(label.getCompany());
	  user.setEmail(label.getEmail());
	  user.setPassword(label.getPassword());
	  user.update();
//	find.ref(id).update();
}

public static List<User> all() {
	return find.all();
}


}



